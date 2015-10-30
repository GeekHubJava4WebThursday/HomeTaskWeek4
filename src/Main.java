import com.geekhub.hw4.taskmanager.Task;
import com.geekhub.hw4.taskmanager.TaskManager;
import com.geekhub.hw4.taskmanager.TaskManagerImpl;

import java.util.Calendar;
import java.util.Date;

public class Main {

    public static void main(String[] args) {
        initTaskMap();

    }

    public static void initTaskMap() {
        TaskManager taskManager = new TaskManagerImpl();

        taskManager.addTask(new Date(115, 4, 11), new Task("meeting", "task1"));
        taskManager.addTask(new Date(115, 10, 12), new Task("meeting", "task2"));
        taskManager.addTask(new Date(115, 4, 11), new Task("meeting", "task3"));
        taskManager.addTask(new Date(116, 0, 1), new Task("memo", "task4"));
        taskManager.addTask(new Date(115, 11, 4), new Task("memo", "task5"));
        taskManager.addTask(new Date(115, 10, 12), new Task("memo", "task6"));
        taskManager.addTask(new Date(115, 11, 30), new Task("anniversary", "task7"));
        taskManager.addTask(new Date(116, 1, 18), new Task("anniversary", "task8"));
    }
}
