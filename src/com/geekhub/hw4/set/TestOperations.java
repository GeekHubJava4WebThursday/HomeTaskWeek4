package com.geekhub.hw4.set;

/**
 * TestOparetions
 */
public class TestOperations {

    public static void main(String[] args) {
        Set<Integer> a = new Set<>(1, 2, 3, 1, 5);
        equals(a);
        union(a);
        subtract(a);
        intersect(a);
        symmetricSubtract(a);
    }

    private static void equals(Set set) {
        System.out.println("EQUALS : " + set.equals(set, new Set<>(1, 2, 3, 1, 5, 5, 2)));
        System.out.println("EQUALS : " + set.equals(set, new Set<>(1, 2, 3, 0)));
    }

    private static void union(Set set) {
        System.out.println("UNION : " + set.union(set, new Set<>(1, 9, 5, 7, 0)));
    }

    private static void subtract(Set set) {
        System.out.println("SUBTRACT : " + set.subtract(set, new Set<>(1, 2, 6, 7)));
    }

    private static void intersect(Set set) {
        System.out.println("INTERSECT : " + set.intersect(set, new Set<>(4, 3, 8, 1, 2, 4, 0)));
    }

    private static void symmetricSubtract(Set set) {
        System.out.print("SYMMETRICAL_SUBTRACT : ");
        System.out.print(set.symmetricSubtract(set, new Set<>(1, 2, 4, 6, 7, 8)) + "\n");
    }

}
