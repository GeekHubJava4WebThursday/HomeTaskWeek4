package com.geekhub.hw4.set;

import com.geekhub.hw4.taskmanager.TaskManagerImpl;

import java.util.HashSet;
import java.util.Set;


public class SetOperationsImpl implements SetOperations {

    @Override
    public boolean equals(Set a, Set b) {
        return a.equals(b);
    }

    @Override
    public Set union(Set a, Set b) {
        HashSet result = new HashSet(a);
        result.addAll(b);
        return result;
    }


    @Override
    public Set subtract(Set a, Set b) {
        Set result = new HashSet<>();
        for (Object obj : a) {
            if (!b.contains(obj)) {
                result.add(obj);
            }
        }
        return result;
    }

    @Override
    public Set intersect(Set a, Set b) {
        Set result = new HashSet<>(a);
        result.retainAll(b);
        return result;
    }

    @Override
    public Set symmetricSubtract(Set a, Set b) {
        return union(subtract(a, b), subtract(b, a));
    }

    public static void main (String[] args) {
       SetOperations setOperations = new SetOperationsImpl();
        Set a = new HashSet<>();
        Set b = new HashSet<>();

        a.add(1);
        a.add(2);
        a.add(3);
        a.add(4);

        b.add(3);
        b.add(4);
        b.add(5);
        b.add(6);

        System.out.println("Set a = " + a);
        System.out.println("Set b = " + b);
        System.out.println("Equals = " + setOperations.equals(a, b));
        System.out.println("Union = " + setOperations.union(a, b));
        System.out.println("Subtract = " + setOperations.subtract(a, b));
        System.out.println("Intersect = " + setOperations.intersect(a,b));
        System.out.println("Symmetric Subtract = " + setOperations.symmetricSubtract(a,b));
    }


}
