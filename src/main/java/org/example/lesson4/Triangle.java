package org.example.lesson4;

public class Triangle {

        public static double countTriangle(double sideA, double sideB, double sideC) {
            double halfP = (sideA + sideB + sideC) / 2;
            double S = Math.sqrt(halfP * (halfP - sideA) * (halfP - sideB) * (halfP - sideC));
            return S;
        }

}
