import com.geekhub.hw4.set.SetOperations;
import com.geekhub.hw4.set.SetOperationsImplement;
import java.util.*;
import com.geekhub.hw4.taskmanager.Task;
import com.geekhub.hw4.taskmanager.TaskManager;
import com.geekhub.hw4.taskmanager.TaskManagerImplement;

public class Main {

    public static void main(String[] args) {

        //aggregation function for test some setOperations methods
        startSetOperations();
        //aggregation function for test some TaskManager methods
        startTaskManager();
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

    public static void startTaskManager() {
        TaskManager taskManager = new TaskManagerImplement();
        taskManager.addTask(new Date(), new Task("Work", "write code"));
        taskManager.addTask(new Date(357575), new Task("Rest", "read book"));
        taskManager.addTask(new Date(5455), new Task("Shop", "buy milk and bread"));
        taskManager.addTask(new Date(435), new Task("Work", "refactoring code"));
        taskManager.addTask(new Date(345345), new Task("Rest", "play football"));

        System.out.println("\n..................................................");
        System.out.println("All categories in Map: " + taskManager.getCategories());

        System.out.println("Tasks by categories in Map: ");

        for (Map.Entry<String, List<Task>> tasks : taskManager.getTasksByCategories().entrySet()) {
            System.out.println("Category: " + tasks.getKey());
            for (Task tsk : tasks.getValue()) {
                System.out.println(tsk.getDescription());
            }
        }
        System.out.println("\n..................................................");

        System.out.println("Tasks by category: Rest ");

        for (Task tasks : taskManager.getTasksByCategory("Rest")) {
            System.out.println(tasks.getDescription());
        }
        System.out.println("\n..................................................");

        System.out.println("Tasks for today: ");

        for (Task tasks : taskManager.getTasksForToday()) {
            System.out.println(tasks.getCategory() + " " + tasks.getDescription());
        }
    }
}
