package com.geekhub.hw4.set;

import java.util.HashSet;
import java.util.Set;

public class SetOperationImpl implements SetOperations {

    @Override
    public boolean equals(Set a, Set b) {
        return a.equals(b);
    }

    @Override
    public Set union(Set a, Set b) {
        Set<Object> s = new HashSet<>();
        s.addAll(a);
        s.addAll(b);
        return s;
    }

    @Override
    public Set subtract(Set a, Set b) {
        Set<Object> s = new HashSet<>();
        s.addAll(a);
        s.removeAll(b);
        return s;
    }

    @Override
    public Set intersect(Set a, Set b) {
        Set<Object> s = new HashSet<>();
        s.addAll(a);
        s.retainAll(b);
        return s;
    }

    @Override
    public Set symmetricSubtract(Set a, Set b) {
        return union(subtract(a, b), subtract(b, a));
    }
}
