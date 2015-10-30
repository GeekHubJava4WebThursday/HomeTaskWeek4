package com.geekhub.hw4.set;

import java.util.HashSet;
import java.util.Set;

public class SetOperationsImpl implements SetOperations {

    @Override
    public <T> boolean equals(Set<T> a, Set<T> b) {
        return a.containsAll(b);
    }

    @Override
    public <T> Set<T> union(Set<T> a, Set<T> b) {
        Set<T> c = new HashSet<>(a);
        c.addAll(b);
        return c;
    }

    @Override
    public <T> Set<T> subtract(Set<T> a, Set<T> b) {
        a.removeAll(b);
        return new HashSet<>(a);
    }

    @Override
    public <T> Set<T> intersect(Set<T> a, Set<T> b) {
        a.retainAll(b);
        return a;
    }

    @Override
    public <T> Set<T> symmetricSubtract(Set<T> a, Set<T> b) {
        Set<T> ab = subtract(a, b);
        Set<T> ba = subtract(b, a);
        return union(ab, ba);
    }
}
