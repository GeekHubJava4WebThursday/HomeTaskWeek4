package com.company;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;


public class Main {

    public static void main(String[] args) {
        Set<Integer> setA = new HashSet<>();
        Set<Integer> setB = new HashSet<>();
        SetOperationsImplements operationsImpl = new SetOperationsImplements();
        int i;
        for (i = 0; i < 10; i++) {
            setA.add((int) (Math.random() * 50));
            setB.add((int) (Math.random() * 50));
        }

        System.out.println("Set A ");
        System.out.print(setA);
        System.out.println();
        System.out.println("Set B");
        System.out.print(setB);
        System.out.println();

        System.out.println("Select one of the operations on sets:");
        System.out.println("1. Equals!");
        System.out.println("2. Union!");
        System.out.println("3. Subtract!");
        System.out.println("4. Intersect!");
        System.out.println("5. Subtract Sets!");
        Scanner in = new Scanner(System.in);
        i = in.nextInt();
        switch (i) {
            case 1:
                if (operationsImpl.equals(setA, setB)) {
                    System.out.println("Sets equals!");
                } else {
                    System.out.println("Sets not equals!");
                }
                break;
            case 2:
                System.out.print(operationsImpl.union(setA, setB));
                break;
            case 3:
                System.out.print(operationsImpl.subtract(setA, setB));
                break;
            case 4:
                System.out.print(operationsImpl.intersect(setA, setB));
                break;
            case 5:
                System.out.print(operationsImpl.symmetricSubtract(setA, setB));
                break;
            default:
                System.out.println("Enter number from 1 to 5!");
        }
    }
}
