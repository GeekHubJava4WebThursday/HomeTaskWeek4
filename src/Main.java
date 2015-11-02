import com.geekhub.hw4.set.SetHandler;

import java.util.HashSet;
import java.util.Set;

public class Main {

    public static void main(String[] args) {
        System.out.println("Hello World!");
        testingSetHandler();
    }

    private static void testingSetHandler() {

        final Set<Integer> firstSet = new HashSet<>();
        final Set<Integer> secondSet = new HashSet<>();

        firstSet.add(1);
        firstSet.add(2);
        firstSet.add(5);
        firstSet.add(7);
        firstSet.add(10);

        secondSet.add(0);
        secondSet.add(2);
        secondSet.add(3);
        secondSet.add(8);
        secondSet.add(10);

        System.out.println("First set: " + firstSet);
        System.out.println("Second set: " + secondSet + "\n");

        SetHandler<Integer> setHandler = new SetHandler<>();
        System.out.println("Equals: " + setHandler.equals(firstSet, secondSet));
        System.out.println("Union: " + setHandler.union(firstSet, secondSet));
        System.out.println("Subtract: " + setHandler.subtract(firstSet, secondSet));
        System.out.println("Intersect: " + setHandler.intersect(firstSet, secondSet));
        System.out.println("Symmetric subtract: " + setHandler.symmetricSubtract(firstSet, secondSet));

    }

}
