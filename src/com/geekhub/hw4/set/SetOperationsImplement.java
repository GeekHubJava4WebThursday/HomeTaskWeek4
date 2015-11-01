package com.geekhub.hw4.set;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created by Вадимка on 01.11.2015.
 */
public class SetOperationsImplement <T> implements SetOperations <T>  {

    private List<T> list;

    public SetOperationsImplement(){
        list = new ArrayList<>();
    }

    @Override
    public boolean equals(Set a, Set b) {
        return a.equals(b);
    }

    @Override
    public Set union(Set a, Set b) {
        Set set = new HashSet<>();
        set.addAll(a);
        set.addAll(b);
        return set;
    }

    @Override
    public Set subtract(Set a, Set b) {
        Set set = new HashSet<>();
        set.addAll(a);
        set.remove(b);
        return set;
    }

    @Override
    public Set intersect(Set a, Set b) {
        Set set = new HashSet<>();
        set.addAll(a);
        set.addAll(b);
        set.retainAll(b);
        return set;

    }

    @Override
    public Set symmetricSubtract(Set a, Set b) {
        Set set = union(subtract(a,b), subtract(b,a));
        return set;
    }

}
