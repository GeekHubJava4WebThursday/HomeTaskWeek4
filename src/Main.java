import com.geekhub.hw4.set.SetOperations;
import com.geekhub.hw4.set.SetOperationsImpl;
import com.geekhub.hw4.taskmanager.Task;
import com.geekhub.hw4.taskmanager.TaskManager;
import com.geekhub.hw4.taskmanager.TaskManagerImpl;

import javax.sound.midi.Soundbank;
import java.util.*;

public class Main {

    public static void main(String[] args) {
        System.out.println("Hello World!");
        SetOperations setOperations = new SetOperationsImpl();
        Set a = new HashSet<>(Arrays.asList(1, 2, 3, 4, 9));
        Set b = new HashSet<>(Arrays.asList(1, 2, 3, 4, 5, 6));
        System.out.println(setOperations.equals(a, b));

        System.out.println(setOperations.union(a, b));
        System.out.println(setOperations.subtract(a, b));
        System.out.println(setOperations.intersect(a, b));
        System.out.println(setOperations.symmetricSubtract(a, b));

        TaskManager taskManager = new TaskManagerImpl();
        Calendar date = Calendar.getInstance();
        taskManager.addTask(date.getTime(), new Task("Important", "Call to frend"));
        date.add(Calendar.HOUR, 1);
        taskManager.addTask(date.getTime(), new Task("Important", "Call to father"));
        date.add(Calendar.DATE, 1);
        taskManager.addTask(date.getTime(), new Task("Important", "Go to University"));
        date.add(Calendar.HOUR, 1);
        taskManager.addTask(date.getTime(), new Task("No important", "Go to Home"));


        for (String category : taskManager.getCategories()) {
            List<Task> tasks = taskManager.getTasksByCategory(category);
            System.out.println(category);
            for (Task task : tasks) {
                System.out.println(task);
            }

        }

        System.out.println("TaskForToday");
        for (Task task : taskManager.getTasksForToday()) {
            System.out.println(task);
        }
    }
}