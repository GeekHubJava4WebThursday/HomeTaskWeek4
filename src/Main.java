import com.geekhub.hw4.set.SetProcessor;

import java.util.HashSet;
import java.util.Set;

public class Main {

    public static void main(String[] args) {
        testSetOperations();
        testTaskManager();
    }

    private static void testSetOperations() {
        Set<String> a = new HashSet<>();
        a.add("one");
        a.add("two");
        a.add("three");
        a.add("four");
        a.add("five");
        a.add("eight");

        Set<String> b = new HashSet<>();
        b.add("six");
        b.add("seven");
        b.add("eight");
        b.add("nine");
        b.add("ten");
        b.add("two");

        Set<String> c;
        SetProcessor<String> setProcessor = new SetProcessor<>();

        System.out.println("Equals: " + setProcessor.equals(a,b));

        c = new HashSet<>(a);
        printSet(setProcessor.union(c,b));

        c = new HashSet<>(a);
        printSet(setProcessor.subtract(c, b));

        c = new HashSet<>(a);
        printSet(setProcessor.intersect(c, b));

        c = new HashSet<>(a);
        printSet(setProcessor.symmetricSubtract(c, b));
    }

    private static <E> void printSet(Set<E> set) {
        for(E element : set) {
            System.out.print(element.toString() + ", ");
        }
        System.out.println();
    }

    private static void testTaskManager() {

    }



}
