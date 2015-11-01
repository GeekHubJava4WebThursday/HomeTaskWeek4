package com.geekhub.hw4.set;

import java.util.HashSet;
import java.util.Objects;
import java.util.Random;
import java.util.Set;

/**
 * Created by COMRADE on 01.11.2015.
 */
public class SetOperationsImpl implements SetOperations {
    public static SetOperations setOperations = new SetOperationsImpl();
    @Override
    public boolean equals(Set a, Set b) {

        return a.equals(b);
    }

    @Override
    public Set union(Set a, Set b) {
        Set unionSet = new HashSet<>(a);
        unionSet.addAll(b);
        return unionSet;
    }

    @Override
    public Set subtract(Set a, Set b) {
        Set substact = new HashSet<>();
        for(Object object : a){
            if(!b.contains(object)){
                substact.add(object);
            }
        }
        return substact;
    }

    @Override
    public Set intersect(Set a, Set b) {
        Set intersect = new HashSet<>();
        for(Object object : a){
            if(b.contains(object)){
                intersect.add(object);
            }
        }
        return intersect;
    }

    @Override
    public Set symmetricSubtract(Set a, Set b) {
        Set symetricSybstaract = union(subtract(a,b), subtract(b,a));
        return symetricSybstaract;
    }

    public static void main(String[] args){
        Set a = new HashSet<>();
        Set b = new HashSet<>();
        Random random = new Random();
        for(int i = 0; i < 10; i++){
            a.add(random.nextInt(10));
            b.add(random.nextInt(10));
        }
        System.out.println("a = " + a + "\n" + "b = " + b);
        System.out.println("A equals B: " + setOperations.equals(a,b));
        Set res = setOperations.union(a, b);
        System.out.println("Set union: " + res);
        res = setOperations.subtract(a, b);
        System.out.println("Set substract: " + res);
        res = setOperations.intersect(a, b);
        System.out.println("Set ontersect: " + res);
        res = setOperations.symmetricSubtract(a,b);
        System.out.println("Set symetric Substract: " + res);
    }

}
