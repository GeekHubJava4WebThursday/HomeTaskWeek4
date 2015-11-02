package com.geekhub.hw4.set;

import java.util.ArrayList;

/**
 * Set
 */
public class Set<T> implements SetOperations<T> {

    private ArrayList<T> data;

    /**
     * base construct
     */
    public Set() {
        data = new ArrayList<>();
    }

    /**
     * construct
     * @param value input array
     */
    public Set(T... value) {
        data = new ArrayList<>();
        add(value);
    }

    /**
     * get data foe index
     * @param index
     * @return <T>data
     */
    public T get(int index) {
        return data.get(index);
    }

    /**
     * add
     * @param value adding array
     */
    public void add(T... value) {
        boolean repeat;
        for (int i = 0; i < value.length; i++) {
            repeat = false;
            for (T var : data) {
                if (value[i].equals(var)) {
                    repeat = true;
                    break;
                }
            }
            if (repeat == false) {
                data.add(value[i]);
            }
        }
    }

    /**
     * remove
     * @param value removing array
     */
    public void remove(T... value) {
        for (int i = 0; i < value.length; i++) {
            data.remove(value[i]);
        }
    }

    /**
     * get size
     * @return size
     */
    public int size() { return data.size(); }


    @Override
    public String toString() {
        String str = "[ ";

        for (T value : data) {
            str += value + " ";
        }

        return str + "]";
    }


    @Override
    public boolean equals(Set<T> a, Set<T> b) {
        if (a.size() == b.size()) {
            boolean in;
            for (T currentA : a.data) {
                in = false;
                for (T currentB : b.data) {
                    if (currentA.equals(currentB)) {
                        in = true;
                        break;
                    }
                }
                if (in == false) {
                    return false;
                }
            }
        } else {
            return false;
        }
        return true;
    }

    @Override
    public Set union(Set<T> a, Set<T> b) {
        // union set
        Set<T> uni = new Set<>();

        // add a.data
        a.data.forEach(uni::add);
        // add b.data
        b.data.forEach(uni::add);

        return uni;
    }

    @Override
    public Set subtract(Set<T> a, Set<T> b) {
        // subtract set
        Set<T> sub = new Set<>();

        boolean original;
        for (T currentA : a.data) {
            original = true;
            for (T currentB : b.data) {
                if (currentA.equals(currentB)) {
                    original = false;
                    break;
                }
            }
            if (original == true) {
                sub.add(currentA);
            }
        }

        return sub;
    }

    @Override
    public Set intersect(Set<T> a, Set<T> b) {
        // new set
        Set<T> inter = new Set<>();

        // working time - (sizeA * sizeB)
        for (T currentA : a.data) {
            for (T currentB : b.data) {
                if (currentA.equals(currentB)) {
                    inter.add(currentA);
                }
            }
        }

        return inter;
    }

    @Override
    public Set symmetricSubtract(Set<T> a, Set<T> b) {
        // subtract a, b
        Set<T> AB = subtract(a, b);
        // subtract b, a
        Set<T> BA = subtract(b, a);

        return union(AB, BA);
    }
}
