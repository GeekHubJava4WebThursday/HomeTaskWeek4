package com.geekhub.hw4.set;

import java.util.HashSet;
import java.util.Set;

public class SetHandler<E> implements SetOperations<E> {

    @Override
    public boolean equals(Set<E> a, Set<E> b) {
        return a.containsAll(b) && b.containsAll(a);
    }

    @Override
    public Set<E> union(Set<E> a, Set<E> b) {
        Set<E> result = new HashSet<>(a);
        result.addAll(b);
        return result;

    }

    @Override
    public Set<E> subtract(Set<E> a, Set<E> b) {
        Set<E> result = new HashSet<>(a);
        result.removeAll(b);
        return result;
    }

    @Override
    public Set<E> intersect(Set<E> a, Set<E> b) {
        Set<E> result = new HashSet<>(a);
        result.retainAll(b);
        return result;
    }

    @Override
    public Set<E> symmetricSubtract(Set<E> a, Set<E> b) {
        Set<E> result = new HashSet<>(a);
        result.removeAll(b);

        Set<E> c = new HashSet<>(b);
        c.removeAll(a);

        result.addAll(c);

        return result;
    }
}
