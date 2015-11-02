package com.geekhub.hw4.set;

import java.util.Set;

public class SetOperationsUtility implements SetOperations {

    @Override
    public boolean equals(Set a, Set b) {
        return a.equals(b);
    }

    @Override
    public Set union(Set a, Set b) throws IllegalAccessException, InstantiationException {
        Class aClass = a.getClass();
        Object resultSet = aClass.newInstance();
        ((Set)resultSet).addAll(a);
        ((Set)resultSet).addAll(b);
        return (Set)resultSet;
    }

    @Override
    public Set subtract(Set a, Set b) throws IllegalAccessException, InstantiationException {
        Class aClass = a.getClass();
        Object resultSet = aClass.newInstance();
        ((Set)resultSet).addAll(a);
        for (Object o: b) {
            if (a.contains(o)) {
                ((Set)resultSet).remove(o);
            }
        }
        return (Set)resultSet;
    }

    @Override
    public Set intersect(Set a, Set b) throws IllegalAccessException, InstantiationException {
        Class aClass = a.getClass();
        Object resultSet = aClass.newInstance();
        ((Set)resultSet).addAll(a);
        for (Object o: a) {
            if (!b.contains(o)) {
                ((Set)resultSet).remove(o);
            }
        }
        return (Set)resultSet;
    }

    @Override
    public Set symmetricSubtract(Set a, Set b) throws InstantiationException, IllegalAccessException {
        Set resultSet = subtract(a,b);
        resultSet.addAll(subtract(b,a));
        return resultSet;
    }
}
