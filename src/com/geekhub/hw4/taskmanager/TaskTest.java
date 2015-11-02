package com.geekhub.hw4.taskmanager;

import java.util.*;

/**
 * TaskTest
 */
public class TaskTest {

    public static void main(String[] args) throws InterruptedException {

        test.setByUser();
        printMenu();

        boolean flag = true;
        while (flag == true) {
            System.out.print("\nChoice : ");
            int choice = new Scanner(System.in).nextInt();
            switch (choice) {
                case 1:
                    test.showAll();
                    break;
                case 2:
                    test.getAllCategories();
                    break;
                case 3:
                    test.getTaskByCategory();
                    break;
                case 4:
                    test.getTaskForToday();
                    break;
                case 5:
                    test.remove();
                    break;
                default:
                    flag = false;
                    break;
            }
        }
    }

    /**
     * print menu
     */
    private static void printMenu() {
        System.out.println("\nMenu : ");
        System.out.println("1 - show all tasks");
        System.out.println("2 - get all categories");
        System.out.println("3 - get tasks by categories");
        System.out.println("4 - get task for today");
        System.out.println("5 - remove");
        System.out.println("Else - exit");
    }

    static class test {

        public static Manager manager = new Manager();
        public static ArrayList<Date> dates = new ArrayList<>();

        /**
         * set tasks by user
         * @throws InterruptedException
         */
        public static Manager setByUser() throws InterruptedException {
            boolean choice = true;
            do {
                // read date
                System.out.print("Set date {YY : MM : DD : hh : mm} : ");
                Scanner scanner = new Scanner(System.in);

                int year = scanner.nextInt();
                int month = scanner.nextInt();
                int day = scanner.nextInt();
                int hours = scanner.nextInt();
                int minutes = scanner.nextInt();

                Date date = setDate(year, month, day, hours, minutes);
                dates.add(date);
                // read categories
                System.out.print("Set categories : ");
                scanner = new Scanner(System.in);
                String categories = scanner.nextLine();
                // read description
                System.out.print("Set description : ");
                String description = scanner.nextLine();
                // add task
                manager.addTask(date, new Task(categories, description));

                System.out.print("Add more (N - exit, else - continue) ? : ");
                String ch = scanner.nextLine();

                if (ch.equals("N") || ch.equals("n")) {
                    choice = false;
                }

            } while (choice == true);

            return manager;
        }

        /**
         * show all tasks
         */
        public static void showAll() {
            // show all tasks
            System.out.println("\nSHOW ALL");
            manager.showAll();
        }

        /**
         * remove by date
         */
        public static void remove() {
            // remove first task
            System.out.println("\nREMOVE : ");
            if (dates.size() == 0) {
                System.out.println("Task table is empty");
            } else {
                int i = 0;
                for (Date d : dates) {
                    System.out.println("" + i + " - " + d);
                    i++;
                }

                System.out.print("Removing index : ");
                i = new Scanner(System.in).nextInt();
                manager.removeTask(dates.get(i));
                dates.remove(dates.get(i));
            }
        }

        /**
         * get all categories
         */
        public static void getAllCategories() {
            // get all categories
            System.out.println("\nGET ALL CATEGORIES");
            ArrayList<String> categories = (ArrayList<String>) manager.getCategories();
            if (categories.size() == 0) {
                System.out.println("Not found categories");
            } else {
                for (String s : categories) {
                    System.out.println(s);
                }
            }
        }

        /**
         * get task by category
         */
        public static void getTaskByCategory() {
            // get task by category
            System.out.println("\nGET TASK B CATEGORY");
            System.out.print("Input category : ");
            String string = new Scanner(System.in).nextLine();
            LinkedList<Task> tasks = (LinkedList<Task>) manager.getTasksByCategory(string);
            if (tasks.size() == 0) {
                System.out.println("Not found tasks for this category");
            } else {
                for (Task t : tasks) {
                    System.out.println(t);
                }
            }
        }

        /**
         * get task for today
         */
        public static void getTaskForToday() {
            // get task for today
            System.out.println("\nGET TASK FOR TODAY");
            LinkedList<Task> tasks = (LinkedList<Task>) manager.getTasksForToday();
            if (tasks.size() == 0) {
                System.out.println("Not found tasks for today");
            } else {
                for (Task t : tasks) {
                    System.out.println(t);
                }
            }
        }

        /**
         * set Date
         * @param year    - year
         * @param month   - month
         * @param day     - day
         * @param hours   - hours
         * @param minutes - minutes
         * @return date
         */
        private static Date setDate(int year, int month, int day, int hours, int minutes) {
            Date date = new Date();
            date.setYear(year - 1900);
            date.setMonth(month - 1);
            date.setDate(day);
            date.setHours(hours);
            date.setMinutes(minutes);
            date.setSeconds(0);
            return date;
        }
    }
}
