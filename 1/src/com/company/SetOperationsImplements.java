package com.company;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by InnaBakum on 09.11.2015.
 */
public class SetOperationsImplements  implements SetOperations{

    @Override
    public boolean equals (Set a, Set b)
    {
        return a.equals(b);
    }

    @Override
    public Set union(Set a, Set b) {
        Set c = new HashSet<>(a);
        c.addAll(b);
        return c;
    }

    @Override
    public Set subtract(Set a, Set b) {
        Set c = new HashSet<>(a);
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
        return union(subtract(a, b), subtract(b,a));
    }

}
