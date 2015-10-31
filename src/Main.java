import com.geekhub.hw4.set.SetOperationImpl;
import com.geekhub.hw4.set.SetOperations;
import com.geekhub.hw4.taskmanager.Task;
import com.geekhub.hw4.taskmanager.TaskManager;
import com.geekhub.hw4.taskmanager.TaskManagerImpl;

import java.util.*;

public class Main {

    public static void main(String[] args) {
        testSetOperation();
        testTaskManager();
    }

    public static void testSetOperation() {
        SetOperations setOperations = new SetOperationImpl();
        Set<Integer> a = new HashSet<>();
        a.add(1);
        a.add(2);
        a.add(3);
        a.add(4);

        Set<Integer> b = new HashSet<>();
        b.add(1);
        b.add(2);
        b.add(5);
        b.add(6);

        System.out.println("equals: " + setOperations.equals(a, b));
        System.out.println("union: " + setOperations.union(a, b));
        System.out.println("subtract:" + setOperations.subtract(a, b));
        System.out.println("intersect: " + setOperations.intersect(a, b));
        System.out.println("symmetricSubtract: " + setOperations.symmetricSubtract(a, b));

    }

    public static void testTaskManager() {
        TaskManager taskManager = new TaskManagerImpl();
        taskManager.addTask(new Date(), new Task("cat. 1", "task 1"));
        taskManager.addTask(new Date(357575), new Task("cat. 2", "task 2"));
        taskManager.addTask(new Date(5455), new Task("cat. 2", "task 3"));
        taskManager.addTask(new Date(435), new Task("cat. 1", "task 4"));
        taskManager.addTask(new Date(345345), new Task("cat. 3", "task 5"));

        System.out.println("All categories: " + taskManager.getCategories());

        System.out.println("\nTasks by categories: ");
        for(Map.Entry<String, List<Task>> tasks: taskManager.getTasksByCategories().entrySet()){
            System.out.println("\n category: " + tasks.getKey());
            for(Task t :tasks.getValue()){
                System.out.println("\t" + t.getDescription());
            }
        }

        System.out.println("\nTasks by category: cat. 2 ");
        for(Task tasks: taskManager.getTasksByCategory("cat. 2") ){
            System.out.println("\t" + tasks.getDescription());
        }

        System.out.println("\nTasks for today: ");
        for(Task tasks: taskManager.getTasksForToday()){
            System.out.println("\t" + tasks.getCategory()+" "+tasks.getDescription());
        }
    }
}
