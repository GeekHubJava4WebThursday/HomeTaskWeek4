package com.geekhub.hw4.set;

import java.util.HashSet;
import java.util.Set;


/**
 * Implement some methods from SetOperations interface
 */
public class SetOperationsImplement implements SetOperations {

    @Override
    public boolean equals(Set a, Set b) {
        return a.equals(b);
    }

    @Override
    public Set union(Set a, Set b) {
        HashSet setUnion = new HashSet(a);
        setUnion.addAll(b);
        return setUnion;
    }

    @Override
    public Set subtract(Set a, Set b) {
        Set setSubtruct = new HashSet<>();
        for (Object iterObject : a) {
            if (!b.contains(iterObject)) {
                setSubtruct.add(iterObject);
            }
        }
        return setSubtruct;
    }

    @Override
    public Set intersect(Set a, Set b) {
        Set intersectSet = new HashSet<>(a);
        intersectSet.retainAll(b);
        return intersectSet;
    }

    @Override
    public Set symmetricSubtract(Set a, Set b) {
        return union(subtract(a, b), subtract(b, a));
    }


}
