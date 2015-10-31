import com.geekhub.hw4.set.SetOperations;
import com.geekhub.hw4.set.SetOperationsImpl;
import com.geekhub.hw4.taskmanager.Task;
import com.geekhub.hw4.taskmanager.TaskManager;
import com.geekhub.hw4.taskmanager.TaskManagerImpl;

import java.util.*;

public class Main {

    private static TaskManager taskManager = new TaskManagerImpl();
    private static SetOperations setOperations = new SetOperationsImpl();
    private static Set<Task> a;
    private static Set<Task> b;
    private static Set<Task> c;

    public static void main(String[] args) {
        initTaskMap();
        testTaskManager();
        System.out.println("*****************************");
        initTaskSet();
        testSetOperations();
    }

    private static void initTaskSet() {
        a = new HashSet<>(taskManager.getTasksByCategory("holiday"));
        b = new HashSet<>(taskManager.getTasksByCategory("holiday"));
        c = setOperations.union(new HashSet<>(taskManager.getTasksByCategory("memo")), a);
    }

    private static void testSetOperations() {
        System.out.println("a: " + a);
        System.out.println("b: " + b);
        System.out.println("union(a, b): " + c);
        System.out.println("b == a: " + setOperations.equals(b, a));
        System.out.println("b == c: " + setOperations.equals(b, c));
        b.addAll(taskManager.getTasksByCategory("meeting"));
        System.out.println("subtract(c, b): " + setOperations.subtract(c, b));
        System.out.println("subtract(b, c): " + setOperations.subtract(b, c));
        System.out.println("intersect(c, b): " + setOperations.intersect(c, b));
        System.out.println("symmetric subtract(c, b): " + setOperations.symmetricSubtract(c, b));
    }

    private static void initTaskMap() {
        taskManager.addTask(setDate(4, 12, 2015), new Task("meeting", "task1"));
        taskManager.addTask(setDate(5, 11, 2015), new Task("meeting", "task2"));
        taskManager.addTask(setDate(30, 10, 2015), new Task("meeting", "task3"));
        taskManager.addTask(setDate(1, 1, 2016), new Task("holiday", "task4"));
        taskManager.addTask(setDate(31, 12, 2015), new Task("holiday", "task5"));
        taskManager.addTask(setDate(15, 11, 2015), new Task("memo", "task6"));
        taskManager.addTask(setDate(15, 11, 2015), new Task("anniversary", "task7"));
        taskManager.addTask(setDate(7, 1, 2016), new Task("holiday", "task8"));
        taskManager.addTask(setDate(9, 1, 2016), new Task("memo", "task9"));

        Calendar today = Calendar.getInstance();
        taskManager.addTask(setDate(today.get(Calendar.DATE), today.get(Calendar.MONTH), today.get(Calendar.YEAR)),
                new Task("memo", "task10"));
    }

    private static void testTaskManager() {
        System.out.println("Categories: " + taskManager.getCategories());
        System.out.println("Task for today: " + taskManager.getTasksForToday());
        System.out.println("Tasks by meeting: " + taskManager.getTasksByCategory("meeting"));
        System.out.println("Tasks by categories:");
        for (List<Task> taskList : taskManager.getTasksByCategories().values()) {
            System.out.println("\t" + taskList);
        }
    }

    private static Date setDate(int day, int month, int year) {
        Calendar calendar = Calendar.getInstance();
        calendar.set(Calendar.DATE, day);
        calendar.set(Calendar.MONTH, month);
        calendar.set(Calendar.YEAR, year);
        return calendar.getTime();
    }
}
