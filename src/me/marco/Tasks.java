package me.marco;

import java.util.ArrayList;
import java.util.Scanner;

public class Tasks {

    private ArrayList<String> trash = new ArrayList<>();
    private Scanner sc = new Scanner(System.in);
    private int countCreator = 0;
    private int countCompleted = 0;

    public void sort(String[] tasks) {

        String temp;

        for (int i = 0; i < tasks.length; i++) {
            for (int j = i + 1; j < tasks.length; j++) {
                //comparar por ordem alfabetica
                if (!tasks[i].isEmpty() && !tasks[j].isEmpty()) {
                    if (tasks[i].charAt(0) > tasks[j].charAt(0)) {
                        temp = tasks[i];
                        tasks[i] = tasks[j];
                        tasks[j] = temp;
                    }
                    //mover elementos vazios para o final
                } else if (tasks[i].isEmpty() && !tasks[j].isEmpty()) {
                    temp = tasks[i];
                    tasks[i] = tasks[j];
                    tasks[j] = temp;
                }
            }
        }
        System.out.println("\u001b[1m\u001b[32mList organized.\u001b[0m");
    }

   private void delete(String task) {
        trash.add(task);
    }

    public void recover(TaskManager taskManager) {;
        int count = 0;
        for (String el : trash) {
            System.out.println(count++ + ": " + el);
        }
        System.out.println("Select the number of task to recover it.");
        int userInput = sc.nextInt();

        for (int i = 0; i < taskManager.tasksDrawer.length; i++) {
        if(trash.size() >= userInput-1) {
            if (taskManager.tasksDrawer[i].isEmpty()) {
                taskManager.tasksDrawer[i] = trash.get(userInput);
                trash.remove(userInput);
                System.out.println("\u001b[1m\u001b[32mTask " + userInput + 1 + " recovered!\u001b[0m");
                break;
                }
            } else {
            System.out.println("\u001b[1m\u001b[31mYour trash bin don't have any task with that number!\u001b[0m");
            break;
            }
        }
    }

    public void remove(String[] normalTask) {
        checkList(normalTask);
        System.out.println("What task want remove: ");
        int userNumber = sc.nextInt();

        if (!normalTask[userNumber - 1].isEmpty()) {
            delete(normalTask[userNumber - 1]);
            normalTask[userNumber - 1] = "";
            System.out.println("\u001b[1m\u001b[32mTask removed with success!\u001b[0m");
        } else {
            System.out.println("\u001b[1m\u001b[31mThis task is empty.\u001b[0m");
        }
    }

    public void removeCompleted(String[] completedTasks) {
        checkCompletedList(completedTasks);
        System.out.println("What task want remove: ");
        int userNumber = sc.nextInt();

        if (!completedTasks[userNumber - 1].isEmpty()) {
            delete(completedTasks[userNumber - 1]);
            completedTasks[userNumber - 1] = "";
            System.out.println("\u001b[1m\u001b[32mTask removed " + completedTasks[userNumber - 1] + " with success!\u001b[0m");
        } else {
            System.out.println("\u001b[1m\u001b[31mThis task is empty.\u001b[0m");
        }
    }

    public void markAsUncompleted(String[] tasks, String[] isConcluded) {
        checkCompletedList(isConcluded);
        System.out.println("What task want to mark as uncompleted: ");

        int userInput = sc.nextInt();
        int taskNumber = userInput - 1;
        int count = 0;

        if (taskNumber >= 0 && !isConcluded[taskNumber].isEmpty()) {
            tasks[count] = isConcluded[taskNumber];
            isConcluded[taskNumber] = "";
            count++;
            System.out.println("\u001b[1m\u001b[32mMarked as uncompleted.\u001b[0m");
        } else {
            System.out.println("\u001b[1m\u001b[31mTask not found.\u001b[0m");
        }
    }

    public void markAsCompleted(String[] tasks, String[] isConcluded) {
        checkList(tasks);
        System.out.println("What task want to mark as completed: ");
        int userInput = sc.nextInt();
        int taskNumber = userInput - 1;

        if (countCompleted != 11) {
            if (taskNumber >= 0 && !tasks[taskNumber].isEmpty()) {
                isConcluded[countCompleted] = tasks[taskNumber];
                tasks[taskNumber] = "";
                countCompleted++;
                System.out.println("\u001b[1m\u001b[32mMarked as completed. ✅\u001b[0m");
            } else {
                System.out.println("\u001b[1m\u001b[31mTask not found.\u001b[0m");
            }
        } else {
            System.out.println("\u001b[1m\u001b[31mYou can't complete more than 10 tasks. Delete a task or buy premium plan.\u001b[0m");
        }
    }


    public void edit(String[] task) {
        Scanner sc = new Scanner(System.in);
        checkList(task);
        System.out.println("What task want to edit?");
        int taskNumber = sc.nextInt();

        for (int i = 0; i < task.length; i++) {
            if (i + 1 == taskNumber) {
                boolean tasksExists = task[i] == "";
                if (!tasksExists) {
                    System.out.print("Edit task: ");
                    task[i] = sc.next();
                    System.out.println("\u001b[1m\u001b[32mTask edited!\u001b[0m");
                } else {
                    System.out.println("\u001b[1m\u001b[31mInvalid task.\u001b[0m");
                }
            }
        }
    }

    public void create(String[] tasksList) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Write a task: ");
        String userInput = sc.nextLine();
        String task = userInput.trim();

        if (task.length() < 1) {
            System.out.println("\u001b[1m\u001b[31mInvalid task!\u001b[0m");
            create(tasksList);
        } else if (countCreator != 10) {
            for (int i = 0; i < tasksList.length; i++) {
                boolean taskExists = tasksList[i] == "";
                if (taskExists) {
                    tasksList[i] = task;
                    countCreator++;
                    System.out.println("\u001b[1m\u001b[32mTask created with success!\u001b[0m");
                    break;
                }
            }
        } else {
            System.out.println("\u001b[1m\u001b[31m You only have 10 slots on free plan. Buy premium for \u001b[1m\u001b[40m4.99€\u001b[0m \u001b[1m\u001b[31mto open 50 slots & other features. \u001b[1m\u001b[34mhttps://paypal.me/marcosilva\u001b[0m");
        }
    }

    public void menuList(String[] tasksDrawer, String[] isConcluded, TaskManager taskManager) {

        System.out.println("1 - List of tasks");
        System.out.println("2 - List of completed tasks");
        System.out.println("3 - Quit");

        switch (sc.nextInt()) {
            case 1:
                checkList(tasksDrawer);
                break;
            case 2:
                checkCompletedList(isConcluded);
                break;
            case 3:
                taskManager.startTaskManager();
                break;
            default:
                System.out.println("\u001b[1m\u001b[31m Invalid choice. \u001b[0m");
                break;
        }
    }

    public void checkCompletedList(String[] concludedTasks) {
        int countCompletedList = 1;

        System.out.println();
        for (int i = 0; i < concludedTasks.length; i++) {
            if (!concludedTasks[i].isEmpty()) {
                System.out.println("\u001b[1m\u001b[32m " + countCompletedList++ + "\u001b[0m. " + concludedTasks[i]);
            }
        }
        System.out.println();
        if (countCompletedList < 2) {
            System.out.println("\u001b[1m\u001b[31m Empty list!\u001b[0m");
        }
    }

    public void checkList(String[] tasksDrawer) {
        int countCheckList = 1;

        System.out.println();
        for (int i = 0; i < tasksDrawer.length; i++) {
            boolean tasksExists = tasksDrawer[i] == "";
            if (!tasksExists) {
                System.out.println("\u001b[1m\u001b[31m " + countCheckList++ + "\u001b[0m. " + tasksDrawer[i]);
            }
        }
        System.out.println();

        if (countCheckList < 2) {
            System.out.println("\u001b[1m\u001b[31m Empty list!\u001b[0m");
        }
    }
}
