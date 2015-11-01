package com.geekhub.hw4.set;

import java.util.HashSet;
import java.util.Set;

public class SetProcessor<E> implements SetOperations<E> {

    @Override
    public boolean equals(Set<E> a, Set<E> b) {
        return a.containsAll(b) && b.containsAll(a);
    }

    @Override
    public Set<E> union(Set<E> a, Set<E> b) {
        a.addAll(b);
        return a;
    }

    @Override
    public Set<E> subtract(Set<E> a, Set<E> b) {
        a.removeAll(b);
        return a;
    }

    @Override
    public Set<E> intersect(Set<E> a, Set<E> b) {
        a.retainAll(b);
        return a;
    }

    @Override
    public Set<E> symmetricSubtract(Set<E> a, Set<E> b) {
        Set<E> c = new HashSet<>(a);
        c.retainAll(b);
        a.addAll(b);
        a.removeAll(c);
        return a;
    }

}
