import com.geekhub.hw4.set.SetOperations;
import com.geekhub.hw4.set.SetOperationsImplement;
import java.util.HashSet;
import java.util.Set;

public class Main {

    public static void main(String[] args) {
        startSetOperations();
    }

        public static void startSetOperations() {
            SetOperations setOperations = new SetOperationsImplement();

            //initial first sets
            Set a = new HashSet<>();
            Set b = new HashSet<>();

            a.add('a');
            a.add('b');
            a.add('c');

            b.add('a');
            b.add('x');
            b.add('y');
            b.add('z');


            System.out.println("First set(A): " + a);
            System.out.println("Second set(B): " + b);

            System.out.println("A equls B: " + setOperations.equals(a, b));
            System.out.println("Union: " + setOperations.union(a, b));
            System.out.println("Subtract: " + setOperations.subtract(a, b));
            System.out.println("Intersect:" + setOperations.intersect(a,b));
            System.out.println("Symmetric Subtract: " + setOperations.symmetricSubtract(a,b));
        }
}
