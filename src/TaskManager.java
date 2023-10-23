import java.util.Arrays;
import java.util.Scanner;

public class TaskManager {
    boolean programIsRunning = true;
    String[] tasksDrawer;
    String[] isConcluded;
    TasksCreator tasksCreator;
    TasksEditor tasksEditor;
    TasksSort tasksSort;
    TaskIsConcluded taskIsConcluded;
    TaskRemover taskRemover;
    TaskTrash taskTrash;

    Scanner sc;

    public TaskManager() {
        tasksCreator = new TasksCreator();
        tasksEditor = new TasksEditor();
        tasksDrawer = new String[10];
        isConcluded = new String[10];
        tasksSort = new TasksSort();
        taskIsConcluded = new TaskIsConcluded();
        taskRemover = new TaskRemover();
        taskTrash = new TaskTrash();
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

            switch (sc.nextInt()) {
                case 1:
                    tasksCreator.createTask(tasksDrawer);
                    break;
                case 2:
                    checkListOfTasks();
                    break;
                case 3:
                    tasksEditor.editTask(tasksDrawer);
                    break;
                case 4:
                    tasksSort.sortTasks(tasksDrawer);
                    break;
                case 5:
                    markTask();
                    break;
                case 6:
                    removeTask();
                    break;
                case 7:
                    admin();
                    break;
                case 8:
                    break;
                default:
                    System.out.println("Invalid choice!");
                    startTaskManager();
                    break;
            }
        }
    }

    public void markTask() {

        System.out.println("1 - MARK TASK AS COMPLETED");
        System.out.println("2 - MARK TASK AS UNCOMPLETED");
        System.out.println("3 - QUIT");

        switch (sc.nextInt()) {
            case 1:
                taskIsConcluded.markAsConcluded(tasksDrawer, isConcluded, this);
                break;
            case 2:
                taskIsConcluded.markAsUncompleted(tasksDrawer, isConcluded, this);
                break;
            case 3:
                startTaskManager();
                break;
            default:
                System.out.println("Invalid task!");
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
                    taskTrash.recoverTask(this);
                    break;
                case 2:
                    startTaskManager();
                    break;
                default:
                    System.out.println("Invalid choice!");
                    break;
            }
        } else {
            System.out.println("Wrong password!");
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
                taskRemover.removeNormalTask(tasksDrawer, this, taskTrash);
                break;
            case 2:
                taskRemover.removeCompletedTask(isConcluded, this, taskTrash);
                break;
            case 3:
                break;
            default:
                System.out.println("Invalid choice.");
                removeTask();
                break;
        }
    }

    public void checkListOfTasks() {

        System.out.println("1 - List of uncompleted tasks");
        System.out.println("2 - List of completed tasks");
        System.out.println("3 - Quit");


        switch(sc.nextInt()) {
            case 1:
                checkTasksList(tasksDrawer);
                break;
            case 2:
                checkConcludedTaskList(isConcluded);
                break;
            case 3:
                startTaskManager();
            default:
                System.out.println("Invalid choice!");
                break;
        }
    }

    public void checkTasksList(String[] tasksDrawer) {
        int count = 1;

        for (int i = 0; i < tasksDrawer.length; i++) {
            if (tasksDrawer[i] != "") {
                System.out.println(count++ + ". " + tasksDrawer[i]);
            }
        }
    }

    public void checkConcludedTaskList(String[] concludedTasks) {
        int count = 1;

        for (int i = 0; i < concludedTasks.length; i++) {
            if (!concludedTasks[i].isEmpty()) {
                System.out.println(count++ + ". " + concludedTasks[i]);
            }
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