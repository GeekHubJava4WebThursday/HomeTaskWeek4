package com.geekhub.hw4.set;

import com.geekhub.hw4.Car;

import java.util.HashSet;
import java.util.Set;

public class SetOperationsTest {
    public static Set<Car> setA = new HashSet<>();
    public static Set<Car> setB = new HashSet<>();
    public static Set<Car> setC = new HashSet<>();
    public static SetOperationsUtility setOperationsUtility = new SetOperationsUtility();
    public static Set<Car> resultSet = null;

    public static void initSets() {
        setA.add(new Car("BMW"));
        setA.add(new Car("Lexus"));
        setA.add(new Car("Toyota"));
        System.out.println("A: " + setA.toString());

        setB.add(new Car("BMW"));
        setB.add(new Car("Subaru"));
        setB.add(new Car("Geely"));
        System.out.println("B: " + setB.toString());

        setC.add(new Car("BMW"));
        setC.add(new Car("Subaru"));
        setC.add(new Car("Geely"));
        System.out.println("C: " + setC.toString());
    }

    public static void test() {
        initSets();
        testEquals();
        testUnion();
        testSubtract();
        testIntersect();
        testSymmetricSubtract();
        /* check for set A changes */
        System.out.println("\nA: " + setA.toString());
    }

    public static void testEquals() {
        /* equals */
        System.out.println("\nA equals C: " + setOperationsUtility.equals(setA, setC));
        System.out.println("B equals C: " + setOperationsUtility.equals(setB, setC));
    }

    public static void testUnion() {
        /* union */
        try {
            resultSet = setOperationsUtility.union(setA, setB);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        }
        System.out.println("\nunion(A,B): " + resultSet.toString());
    }

    public static void testSubtract() {
        /* subtract */
        try {
            resultSet = setOperationsUtility.subtract(setA, setB);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        }
        System.out.println("\nsubtract(A,B): " + resultSet.toString());
    }

    public static void testIntersect() {
        /* intersect */
        try {
            resultSet = setOperationsUtility.intersect(setA, setB);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        }
        System.out.println("\nintersect(A,B): " + resultSet.toString());
    }

    public static void testSymmetricSubtract() {
        /* symmetricSubtract */
        try {
            resultSet = setOperationsUtility.symmetricSubtract(setA, setB);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        }
        System.out.println("\nsymmetric subtract(A,B): " + resultSet.toString());
    }
}
