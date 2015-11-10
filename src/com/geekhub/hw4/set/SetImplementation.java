package com.geekhub.hw4.set;

import java.util.HashSet;
import java.util.Set;

public class SetImplementation implements SetOperations {

    @Override
    public boolean equals(Set a, Set b){
        return a.equals(b);
    }

    @Override
    public Set union(Set a, Set b) {
        Set unifiedSet = new HashSet<>(a);
        unifiedSet.addAll(b);
        return unifiedSet;
    }

    @Override
    public Set subtract(Set a, Set b) {
        Set substractedSet = new HashSet<>();
        for(Object object: a)
            if (!b.contains(object))
                substractedSet.add(object);
        return substractedSet;
    }

    @Override
    public Set intersect(Set a, Set b) {
        Set intersectedSet = new HashSet<>();
        for(Object object: a)
            if (b.contains(object))
                intersectedSet.add(object);
        return intersectedSet;
    }

    @Override
    public Set symmetricSubtract(Set a, Set b) {
        Set symSybstract = union(subtract(a,b), subtract(b,a));
        return symSybstract;
    }
}
