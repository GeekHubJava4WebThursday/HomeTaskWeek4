package com.geekhub.hw4.set;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by developer on 28.11.2015.
 */
public class SetOperationsReaslization implements SetOperations {
    @Override
    public boolean equals(Set a, Set b) {
        return a.equals(b);
    }

    @Override
    public Set union(Set a, Set b) {
        Set<Object> ab1 = new HashSet<>();
        ab1.add(a);
        ab1.add(b);
        return ab1;
    }

    @Override
    public Set subtract(Set a, Set b) {
        Set<Object> ab2 = new HashSet<>();
        ab2.addAll(a);
        ab2.removeAll(b);
        return ab2;
    }

    @Override
    public Set intersect(Set a, Set b) {
        Set<Object> ab3 = new HashSet<>();
        ab3.addAll(a);
        ab3.retainAll(b);
        return ab3;
    }

    @Override
    public Set symmetricSubtract(Set a, Set b) {
        return union(subtract(a, b), subtract(b, a));
    }
}
