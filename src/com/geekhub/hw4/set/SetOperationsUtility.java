package com.geekhub.hw4.set;

import java.util.HashSet;
import java.util.Set;

public class SetOperationsUtility implements SetOperations {

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
        set.removeAll(b);
        return set;
    }

    @Override
    public Set intersect(Set a, Set b) {
        Set set = new HashSet<>();
        set.addAll(a);
        set.retainAll(b);
        return set;
    }

    @Override
    public Set symmetricSubtract(Set a, Set b) {
        Set resultSet = subtract(a,b);
        resultSet.addAll(subtract(b,a));
        return resultSet;
    }
}
