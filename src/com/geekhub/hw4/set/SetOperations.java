package com.geekhub.hw4.set;

import java.util.Set;

public interface SetOperations {
    //Два множества А и В равны (А=В), если они состоят из одних и тех же элементов
    boolean equals(Set a, Set b);

    //Объединением (суммой) множеств А и В называется множество А ? В,
    //элементы которого принадлежат хотя бы одному из этих множеств
    Set union(Set a, Set b) throws IllegalAccessException, InstantiationException;

    //Разностью множеств А и В называется множество АВ, элементы которого
    //принадлежат множеству А, но не принадлежат множеству В
    Set subtract(Set a, Set b)  throws IllegalAccessException, InstantiationException;

    //Пересечением (произведением) множеств А и В называется множество А ? В,
    //элементы которого принадлежат как множеству А, так и множеству В
    Set intersect(Set a, Set b) throws IllegalAccessException, InstantiationException;

    //Симметричной разностью множеств А и В называется множество А ? В,
    //являющееся объединением разностей множеств АВ и ВА, то есть А ? В = (АВ) ? (ВА)
    Set symmetricSubtract(Set a, Set b) throws InstantiationException, IllegalAccessException;
}
