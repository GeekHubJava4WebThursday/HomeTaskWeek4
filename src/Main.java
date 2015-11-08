import com.geekhub.hw4.set.SetHandler;
import com.geekhub.hw4.taskmanager.Task;
import com.geekhub.hw4.taskmanager.TaskHandler;

import java.util.*;

public class Main {

    public static void main(String[] args) {
       // testingSetHandler();
        testingTaskHandler();
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

    private static void testingTaskHandler() {

        TaskHandler taskHandler = new TaskHandler();

        Calendar calendar = Calendar.getInstance();

        calendar.set(2015, Calendar.NOVEMBER, 3, 8, 0, 0);
        taskHandler.addTask(calendar.getTime(), new Task("Usual", "Task0"));
        calendar.set(2015, Calendar.NOVEMBER, 1, 9, 0, 0);
        taskHandler.addTask(calendar.getTime(), new Task("Usual", "Task1"));
        calendar.set(2015, Calendar.NOVEMBER, 4, 9, 30, 0);
        taskHandler.addTask(calendar.getTime(), new Task("Unusual", "Task0"));
        calendar.set(2015, Calendar.NOVEMBER, 8, 9, 30, 0);
        taskHandler.addTask(calendar.getTime(), new Task("Unusual", "Task1"));
        calendar.set(2015, Calendar.NOVEMBER, 2, 10, 30, 0);
        taskHandler.addTask(calendar.getTime(), new Task("Unusual", "Task2"));
        calendar.set(2015, Calendar.NOVEMBER, 11, 9, 30, 0);
        taskHandler.addTask(calendar.getTime(), new Task("Unusual", "Task3"));

        calendar.set(2015, Calendar.NOVEMBER, 3, 8, 0, 0);
        taskHandler.removeTask(calendar.getTime());

        Collection<String> categories = taskHandler.getCategories();
        System.out.println("getCategories()");
        System.out.println(categories);
        System.out.println();


        System.out.println("getTasksByCategories()");
        Map<String, List<Task>> tasksByCategories = taskHandler.getTasksByCategories();
        for (Map.Entry<String, List<Task>> entry : tasksByCategories.entrySet()) {
            System.out.println("Category: " + entry.getKey());
            System.out.println(entry.getValue());
        }
        System.out.println();

        System.out.println("getTasksByCategory()");
        List<Task> tasksByCategory = taskHandler.getTasksByCategory("Usual");
        System.out.println(tasksByCategory);
        System.out.println();

        System.out.println("getTasksForToday()");
        List<Task> tasksForToday = taskHandler.getTasksForToday();
        System.out.println(tasksForToday);

    }

}
