package com.tests;
import com.example.dao.*;
import com.example.entity.*;
import com.example.service.IParkingPlaceManager;
import com.example.service.ReservationManager;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.sql.Connection;
import java.util.Date;

import static org.mockito.Mockito.when;
public class ReservationManagerTest {

    private static DatabaseConnection DBconnection;
    private static Connection connection;
    private static ReservationDao reservationdao;
    private static Reservation Reservation1;
    private static IParkingPlaceManager iParkingPlaceManager;
    private static ReservationManager reservationManager;
    private static Date sd;
    private static Date ed;

    @BeforeAll
    //pour créer une connexion vers la base de données.
    public static void init() {
        DBconnection = new DatabaseConnection("sa", "", "org.h2.Driver", "jdbc:h2:mem:test");
        connection = DBconnection.connect();
        DBconnection.createDb(connection);

        User user1=new User() ;//créer un nouveau utilisateur
        user1.setUserId(1);
        user1.setEmail("");
        user1.setName("");
        user1.setPhone("");

        UserDao userDao = new UserDao();
        userDao.setConn(connection);
        userDao.insertUser(user1);


        Parking Park=new Parking(); //créer un nouveau parking
        Park.setName("");
        Park.setAddress("");
        Park.setParkingId(1);
        Park.setCapacity(10);

        ParkingDao parkingDao = new ParkingDao();
        parkingDao.setConn(connection);
        parkingDao.insertParking(Park);

        ParkingPlace placeP = new ParkingPlace();//créer une nouvelle place parking
        placeP.setIdPlace(1);
        placeP.setPlaceName("");
        PlaceStatus sta = PlaceStatus.values()[0];
        placeP.setPlaceStatus(sta);
        placeP.setParking(Park);


        ParkingPlaceDao parkingPlaceDao = new ParkingPlaceDao();
        parkingPlaceDao.setConn(connection);
        parkingPlaceDao.insertParkingPlace(placeP);


        //créer une nouvelle reservation avec la quelle on va faire nos testes
        Reservation1 = new Reservation();
        Reservation1.setReservationId(1);
        sd=new Date(2023,10,13);
        Reservation1.setStartTime(sd);
        ed=new Date(2023,10,16);
        Reservation1.setEndTime(ed);
        Reservation1.setParkingPlace(placeP);
        Reservation1.setUser(user1);
        ReservationStatus Rsta = ReservationStatus.values()[0];
        Reservation1.setStatus(Rsta);

        //creer un mock reservationdao
        reservationdao = Mockito.mock(ReservationDao.class);
        reservationdao.setConn(connection);
        //creer un mock parking place manager
        iParkingPlaceManager = Mockito.mock(IParkingPlaceManager.class);
        //creer un reservation manager ayant reservationdao et iParkingPlaceManager
        reservationManager = new ReservationManager();
        reservationManager.setReservationDao(reservationdao);
        reservationManager.setiPlaceManager(iParkingPlaceManager);
    }
    @Test
    public void createReservationTest(){
        when(iParkingPlaceManager.isAvailable(1,sd,ed)).thenReturn(true);
        reservationManager.createReservation(Reservation1);
        //on verifie si les methodes insertReservation(Reservation1) et "updateStatus(1, PlaceStatus.RESERVED)" ont ete appelee
        Mockito.verify(reservationdao).insertReservation(Reservation1);
        Mockito.verify(iParkingPlaceManager).updateStatus(1, PlaceStatus.RESERVED);
    }
    @Test
    public void cancelReservationTest() {
        when(reservationdao.getReservationById(1)).thenReturn(Reservation1);
        reservationManager.cancelReservation(1);
        Mockito.verify(reservationdao).updateReservationStatus(1, ReservationStatus.CANCELLED);

    }
}