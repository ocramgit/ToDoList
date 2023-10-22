import java.util.Arrays;
import java.util.Scanner;

public class TaskManager {
    boolean programIsRunning = true;
    String[] tasksDrawer;
    String[] concludedTasks;
    String[] isConcluded;
    TasksCreator tasksCreator;
    TasksEditor tasksEditor;
    TasksSort tasksSort;
    TaskIsConcluded taskIsConcluded;
    TaskRemover taskRemover;
    TaskTrash taskTrash;

    public TaskManager() {
        tasksCreator = new TasksCreator();
        tasksEditor = new TasksEditor();
        tasksDrawer = new String[10];
        tasksSort = new TasksSort();
        taskIsConcluded = new TaskIsConcluded();
        concludedTasks = new String[10];
        taskRemover = new TaskRemover();
        taskTrash = new TaskTrash();

        addEmptyStringsToArray(tasksDrawer, concludedTasks);
    }

    public void startTaskManager() {
        while (programIsRunning) {
            refreshList();

            Scanner sc = new Scanner(System.in);
            System.out.println("1 - CREATE TASK");
            System.out.println("2 - CHECK LIST OF TASKS");
            System.out.println("3 - EDIT TASK");
            System.out.println("4 - SORT TASKS BY ALPHABET");
            System.out.println("5 - MARK TASK AS CONCLUDED");
            System.out.println("6 - CHECK LIST OF COMPLETED TASKS");
            System.out.println("7 - DELETE TASK");

            switch (sc.nextInt()) {
                case 1:
                    tasksCreator.createTask(tasksDrawer);
                    break;
                case 2:
                    checkTasksList(tasksDrawer);
                    break;
                case 3:
                    tasksEditor.editTask(tasksDrawer);
                    break;
                case 4:
                    tasksSort.sortTasks(tasksDrawer);
                    break;
                case 5:
                    taskIsConcluded.markAsConcluded(tasksDrawer, concludedTasks, this);
                    break;
                case 6:
                    checkConcludedTaskList(concludedTasks);
                    break;
                case 7:
                    removeTask();
                    break;
                case 8:
                    taskTrash.getTrash();
                    break;
                default:
                    System.out.println("Invalid choice!");
                    startTaskManager();
                    break;
            }
        }
    }

    public void removeTask() {
        Scanner sc = new Scanner(System.in);

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
                taskRemover.removeCompletedTask(concludedTasks, this, taskTrash);
                break;
            case 3:
                break;
            default:
                System.out.println("Invalid choice.");
                removeTask();
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

    public static void checkConcludedTaskList(String[] concludedTasks) {
        int count = 1;

        for (int i = 0; i < concludedTasks.length; i++) {
            if (!concludedTasks[i].isEmpty()) {
                System.out.println(count++ + ". " + concludedTasks[i]);
            }
        }
    }

    public void addEmptyStringsToArray(String[] tasksDrawer, String[] isConcluded) {
        Arrays.fill(tasksDrawer, "");
        Arrays.fill(concludedTasks, "");
    }

    public void refreshList() {
        int count = 0;

        //internet solution
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
