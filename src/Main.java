import com.geekhub.hw4.set.SetImplementation;
import com.geekhub.hw4.taskmanager.TaskManImp;
import com.geekhub.hw4.taskmanager.Task;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.Random;
public class Main {
    public static SetImplementation setImp = new SetImplementation();
    public static void main(String[] args) {

        Set a = new HashSet<>();
        Set b = new HashSet<>();
        Random random = new Random();

        for(int i = 0; i < 5; i++){
            a.add(random.nextInt(5));
            b.add(random.nextInt(5));
        }
        System.out.println("Set operations implementation:");
        System.out.println("A = " + a + "\n" + "B = " + b);
        System.out.println("Set A equals set B: " + setImp.equals(a,b));
        System.out.println("Union: " + setImp.union(a,b));
        System.out.println("Substraction: " + setImp.subtract(a, b));
        System.out.println("Intersection: " + setImp.intersect(a, b));
        System.out.println("Symetric substraction: " + setImp.symmetricSubtract(a,b));

        System.out.println("\nTaskmanager:");
        TaskManImp taskManager = new TaskManImp();
        Date currentDate = new Date(System.currentTimeMillis());

        Task task1 = new Task("chores","buy groceries");
        Task task2 = new Task("chores","cook dinner");
        Task task3 = new Task("meeting","complete annual report");
        Task task4 = new Task("weekends","receive a mail delivery");


        taskManager.addTask(currentDate, task1);
        taskManager.addTask(currentDate,task2);
        taskManager.addTask(new Date(854421), task3);
        taskManager.addTask(new Date(789023),task4);

        System.out.println("Categories set:\n" + taskManager.getCategories());
        System.out.println("Tasks in weekends category:\n"+taskManager.getTasksByCategory("weekends"));
        System.out.println("Tasks for today:\n");

        for(Task task : taskManager.getTasksForToday())
            System.out.println(task.getCategory()+": "+task.getDescription());


    }



}
