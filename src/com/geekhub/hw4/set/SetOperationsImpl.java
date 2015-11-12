package com.geekhub.hw4.set;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by Kvart on 12.11.2015.
 */
public class SetOperationsImpl implements SetOperations {
    @Override
    public boolean equals(Set a, Set b) {
        if (a.equals(b)){
            return true;
        }
        return false;
    }

    @Override
    public Set union(Set a, Set b) {
        Set c = new HashSet<>();
        c.addAll(a);
        c.addAll(b);
        return c;
    }

    @Override
    public Set subtract(Set a, Set b) {
        Set c = new HashSet<>();
        c.addAll(a);
        c.removeAll(b);

        return c;
    }

    @Override
    public Set intersect(Set a, Set b) {
        Set c = new HashSet<>(a);
        c.retainAll(b);

        return c;
    }

    @Override
    public Set symmetricSubtract(Set a, Set b) {
        Set c = new HashSet<>();
        c = union(subtract(a,b),subtract(b,a));

        return c;
    }
}
