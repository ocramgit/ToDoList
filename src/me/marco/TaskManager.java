package me.marco;

import java.util.Arrays;
import java.util.Scanner;

public class TaskManager {
    boolean programIsRunning = true;
    String[] tasksDrawer;
    String[] isConcluded;
    Tasks task;
    Scanner sc;

    public TaskManager() {
        tasksDrawer = new String[10];
        isConcluded = new String[10];
        task = new Tasks();
        sc = new Scanner(System.in);

        addEmptyStringsToArray(tasksDrawer, isConcluded);
    }

    public void startTaskManager() {
        while (programIsRunning) {
            refreshList();

            System.out.println("1 - CREATE TASK");
            System.out.println("2 - CHECK LIST OF TASKS");
            System.out.println("3 - EDIT TASK");
            System.out.println("4 - SORT TASKS BY ALPHABET");
            System.out.println("5 - MARK TASK AS COMPLETED OR UNCOMPLETED");
            System.out.println("6 - DELETE TASK");
            System.out.println("7 - ADMIN");
            System.out.println("8 - QUIT");
            System.out.println("");
            System.out.print("Option: ");

            switch (sc.next().replaceAll("[^0-9]", "")) {
                case "1":
                    task.create(tasksDrawer);
                    break;
                case "2":
                    task.menuList(tasksDrawer, isConcluded, this);
                    break;
                case "3":
                    task.edit(tasksDrawer);
                    break;
                case "4":
                    task.sort(tasksDrawer);
                    break;
                case "5":
                    markTask();
                    break;
                case "6":
                    removeTask();
                    break;
                case "7":
                    admin();
                    break;
                case "8":
                    programIsRunning = false;
                    break;
                default:
                    System.out.println("\u001b[1m\u001b[31mInvalid choice! Please select a number between 1 and 8.\u001b[0m");
                    startTaskManager();
                    break;
            }
        }
    }

    public void markTask() {

        System.out.println("1 - MARK TASK AS COMPLETED");
        System.out.println("2 - MARK TASK AS UNCOMPLETED");
        System.out.println("3 - QUIT");

        switch (sc.next().replaceAll("[^0-9]", "")) {
            case "1":
                task.markAsCompleted(tasksDrawer, isConcluded);
                break;
            case "2":
                task.markAsUncompleted(tasksDrawer, isConcluded);
                break;
            case "3":
                startTaskManager();
                break;
            default:
                System.out.println("\u001b[1m\u001b[31mInvalid task!\u001b[0m");
                break;
        }
    }

    public void admin() {
        System.out.println("Password: ");
        String password = sc.next();
        String adminPassword = "admin";

        if(password.equals(adminPassword)) {
            System.out.println("1 - Recover task");
            System.out.println("2 - Quit");

            switch (sc.nextInt()) {
                case 1:
                    task.recover(this);
                    break;
                case 2:
                    startTaskManager();
                    break;
                default:
                    System.out.println("\u001b[1m\u001b[31mInvalid choice!\u001b[0m");
                    break;
            }
        } else  {
            System.out.println("\u001b[1m\u001b[31m Wrong password \u001b[0m");
            admin();
        }
    }

    public void removeTask() {

        System.out.println("Want remove a:");
        System.out.println("1 - UNCOMPLETED TASK");
        System.out.println("2 - COMPLETED TASK");
        System.out.println("3 - EXIT");
        System.out.println("Choice: ");

        switch (sc.nextInt()) {
            case 1:
                task.remove(tasksDrawer);
                break;
            case 2:
                task.removeCompleted(isConcluded);
                break;
            case 3:
                break;
            default:
                System.out.println("\u001b[1m\u001b[31m Invalid choice. \u001b[0m");
                removeTask();
                break;
        }
    }

    public void addEmptyStringsToArray(String[] tasksDrawer, String[] isConcluded) {
        Arrays.fill(tasksDrawer, "");
        Arrays.fill(isConcluded, "");
    }

    public void refreshList() {
        int count = 0;

        //se estiver vazio adiciona 1 ao count senão se o count for > 0 adiciona o valor não vazio
        // ao i - count e depois adiciona ao valor não vazio o valor ""
        for (int i = 0; i < tasksDrawer.length; i++) {
            if (tasksDrawer[i].isEmpty()) {
                count++;
            } else if (count > 0) {
                tasksDrawer[i - count] = tasksDrawer[i];
                tasksDrawer[i] = "";
            }
        }
    }
}