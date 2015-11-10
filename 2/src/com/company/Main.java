package com.company;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Scanner;

public class Main {


    public static Date createDate(int dd, int mm, int yy) {
        Calendar c = new GregorianCalendar();
        c.set(Calendar.HOUR_OF_DAY, 0);
        c.set(Calendar.MINUTE, 0);
        c.set(Calendar.SECOND, 0);
        c.set(Calendar.DAY_OF_MONTH, dd);
        c.set(Calendar.MONTH, mm);
        c.set(Calendar.YEAR, yy);
        Date date = c.getTime();
        return date;
    }

    public static void main(String[] args) throws IOException {
        TaskManager taskManager = new TaskManagerImplements();
        int dd;
        int mm;
        int yy;
        String category;
        String description;
        Task task;
        boolean b = false;
        Scanner in = new Scanner(System.in);
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n;
        while (true) {
            System.out.println("Enter 1 to exit");
            System.out.println("Enter 2 to add task");
            System.out.println("Enter 3 to remove task");
            System.out.println("Enter 4 to display all task");
            n = in.nextInt();
            switch (n) {
                case 1:
                    b = true;
                    break;
                case 2:
                    System.out.println("Create task");
                    System.out.println("Please enter Date dd/ mm/ yy/");
                    dd = in.nextInt();
                    mm = in.nextInt();
                    yy = in.nextInt();
                    System.out.println("Please enter category task");
                    category = br.readLine();
                    System.out.println("Please enter description task");
                    description = br.readLine();
                    task = new Task(category, description);
                    taskManager.addTask(createDate(dd, mm, yy), task);
                    break;
                case 3:
                    System.out.println("Delete task");
                    System.out.println("Please enter Date dd/ mm/ yy");
                    dd = in.nextInt();
                    mm = in.nextInt();
                    yy = in.nextInt();
                    taskManager.removeTask(createDate(dd, mm, yy));
                    break;
                case 4:
                    System.out.println("Display all task");
                    System.out.println(taskManager.toString());
                    break;
                default:
                    System.out.println("Error");
            }
            if (b) {
                break;
            }
        }
    }
}
