package org.example.lesson4;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static java.lang.Float.NaN;

public class TriangleTest extends Triangle{

    @Test
    void calcTriangle() {
        double result = countTriangle(2,3, 4);
        Assertions.assertEquals(2.9047375096555625, result);
        }

    @Test
    void unseccessfulCalcTriangle() {
        double result = countTriangle(2,3, 0);
        Assertions.assertEquals(NaN, result);
    }

}
