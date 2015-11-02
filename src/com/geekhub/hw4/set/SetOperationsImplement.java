package com.geekhub.hw4.set;

import java.util.HashSet;
import java.util.Set;


/**
 * Implement some methods from SetOperations interface
 */
public class SetOperationsImplement implements SetOperations {

    @Override
    public boolean equals(Set a, Set b) {
        return a.equals(b);
    }

    @Override
    public Set union(Set a, Set b) {
        HashSet setUnion = new HashSet(a);
        setUnion.addAll(b);
        return setUnion;
    }

    @Override
    public Set subtract(Set a, Set b) {
        Set setSubtruct = new HashSet<>();
        for (Object iterObject : a) {
            if (!b.contains(iterObject)) {
                setSubtruct.add(iterObject);
            }
        }
        return setSubtruct;
    }

    @Override
    public Set intersect(Set a, Set b) {
        Set intersectSet = new HashSet<>(a);
        intersectSet.retainAll(b);
        return intersectSet;
    }

    @Override
    public Set symmetricSubtract(Set a, Set b) {
        return union(subtract(a, b), subtract(b, a));
    }



    public static void main(String[] args){
        SetOperations setOperations = new SetOperationsImplement();

        //initial first sets
        Set a = new HashSet<>();
        Set b = new HashSet<>();

        a.add('a');
        a.add('b');
        a.add('c');

        b.add('a');
        b.add('x');
        b.add('y');
        b.add('z');


        System.out.println("First set(A): " + a);
        System.out.println("Second set(B): " + b);

        System.out.println("A equls B: " + setOperations.equals(a, b));
        System.out.println("Union: " + setOperations.union(a, b));
        System.out.println("Subtract: " + setOperations.subtract(a, b));
        System.out.println("Intersect:" + setOperations.intersect(a,b));
        System.out.println("Symmetric Subtract: " + setOperations.symmetricSubtract(a,b));
    }
}
