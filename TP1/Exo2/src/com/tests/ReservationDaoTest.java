package com.test;

import com.example.dao.*;
import com.example.entity.User;
import com.example.entity.Parking;
import com.example.entity.ParkingPlace;
import com.example.entity.PlaceStatus;
import com.example.entity.Reservation;
import com.example.entity.ReservationStatus;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import java.util.Date;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.when;

import org.mockito.Mockito;

import java.sql.Connection;
import java.util.Date;

public class ReservationDaoTest {
    private static DatabaseConnection DBconnection;
    private static Connection connection;
    private static ReservationDao reservationdao;
    private static Reservation Reservation1;

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


        Reservation1 = new Reservation();//créer une nouvelle reservation
        Reservation1.setReservationId(1);
        Reservation1.setStartTime(new Date(2023,10,13));
        Reservation1.setEndTime(new Date(2023,10,16));
        Reservation1.setParkingPlace(placeP);
        Reservation1.setUser(user1);
        ReservationStatus Rsta = ReservationStatus.values()[0];
        Reservation1.setStatus(Rsta);

        reservationdao = new ReservationDao();
        reservationdao.setConn(connection);
        reservationdao.insertReservation(Reservation1);

    }
    @Test
    void insertReservation() {
        assertEquals(reservationdao.getReservationById(1).getReservationId(),1);
    }
    @Test
    void updateReservationStatus(){
        reservationdao.updateReservationStatus(1,ReservationStatus.PENDING);
        assertEquals(reservationdao.getReservationById(1).getStatus(),ReservationStatus.PENDING);
    }
    @Test
    void getReservationById(){
        reservationdao = Mockito.mock(ReservationDao.class);
        //On doit configurer le mock reservationdao pour qu'il retourne une valeur spécifique lorsque la méthode getReservationById est appelée avec l'argument 1.
        when(reservationdao.getReservationById(1)).thenReturn(Reservation1);
        Reservation expected = reservationdao.getReservationById(1);
        assertNotNull(expected);
        assertEquals(1,expected.getReservationId());
    }
}