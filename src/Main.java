import com.geekhub.hw4.set.SetProcessor;
import com.geekhub.hw4.taskmanager.Task;
import com.geekhub.hw4.taskmanager.TasksContainer;

import java.util.*;

public class Main {

    private static final long MILLIS_IN_DAY = 86400000;

    public static void main(String[] args) {
        testSetOperations();
        System.out.println();
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
        Task[] tasks = {
                new Task("Main", "1"),
                new Task("Additional", "2"),
                new Task("Main", "3"),
                new Task("Undefined", "4"),
                new Task("Additional", "5"),
                new Task("Main", "6")
        };

        TasksContainer tasksContainer = new TasksContainer();

        tasksContainer.addTask(new Date(System.currentTimeMillis() + MILLIS_IN_DAY), new Task("Main", "tomorrow"));
        tasksContainer.addTask(new Date(System.currentTimeMillis() - MILLIS_IN_DAY), new Task("Out-of-date", "yesterday"));

        for (Task task : tasks) {
            tasksContainer.addTask(new Date(), task);
            try {
                Thread.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        System.out.println("Categories:");
        printCollection(tasksContainer.getCategories());

        System.out.println("Tasks by category:");
        printTasksList(tasksContainer.getTasksByCategory("Main"));

        System.out.println("Tasks by categories:");
        printListsInMap(tasksContainer.getTasksByCategories());

        System.out.println("Tasks for today:");
        printCollection(tasksContainer.getTasksForToday());
    }

    private static void printListsInMap(Map<String, List<Task>> tasksByCategories) {
        for (String category : tasksByCategories.keySet()) {
            System.out.println("Category: " + category);
            List<Task> categoriesTask = tasksByCategories.get(category);
            for (Task task : categoriesTask) {
                System.out.print(task + ", ");
            }
            System.out.println();
        }
    }

    private static <E> void printCollection(Collection<E> collection) {
        for (E element : collection) {
            System.out.print(element + " ");
        }
        System.out.println();
    }

    private static void printTasksList(List<Task> taskList) {
        taskList.forEach(System.out::println);
        System.out.println();
    }

}
