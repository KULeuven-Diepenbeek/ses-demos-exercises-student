package org.example;

public class CordinateExample {
    public static void main(String[] args) {
        Coordinate c1 = new Coordinate(2, 3);
        Coordinate c2 = new Coordinate(10, 7);

        c1 = c1.withX(5);

        System.out.println(c1 == c2);
        System.out.println(c1.equals(c2));
        System.out.println(c1.distanceTo(c2));
    }
}