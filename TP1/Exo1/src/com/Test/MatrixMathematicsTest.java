package com.Test;
import com.exception.NoSquareException;
import com.model.Matrix;
import com.service.MatrixMathematics;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class MatrixMathematicsTest {

    @Test
    public
        //Test du calcule du determinant dans le cas ou n>2
    void determinant() throws NoSquareException {
        double[][] array = {{1, 1, 1}, {1, 2, 1}, {2, 2, 2}};
        Matrix a = new Matrix(array);
        assertEquals(MatrixMathematics.determinant(a), 0,0);
    }

    @Test
    public
        //Test du calcule du determinant dans le cas ou n=2
    void determinant2() throws NoSquareException {
        double[][] array = {{7, 5}, {7, 3}};
        Matrix a = new Matrix(array);
        assertEquals(MatrixMathematics.determinant(a),  -14,0);
    }

    @Test
    public
        //test du calcule du determinant dans le cas ou n=1
    void determinant3() throws NoSquareException {
        double[][] array = {{1}};
        Matrix a = new Matrix(array);
        assertEquals(MatrixMathematics.determinant(a), 1,0);
    }

    @Test
    public
        //Test de l'exception dans le cas ou la matrice n'est pas carrée
    void determinant4() throws NoSquareException {
        double[][] array = {{2, 2}, {3, 3}, {4, 4}, {5, 5}};
        Matrix a = new Matrix(array);
        NoSquareException exception = assertThrows(NoSquareException.class, () -> {
            MatrixMathematics.determinant(a);
        });
        String expectedMessage = "matrix need to be square.";
        String actualMessage = exception.getMessage();
        assertTrue(actualMessage.contains(expectedMessage));
    }
}