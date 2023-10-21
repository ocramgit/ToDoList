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

    public TaskManager() {
       tasksCreator = new TasksCreator();
       tasksEditor = new TasksEditor();
       tasksDrawer = new String[10];
       tasksSort = new TasksSort();
       taskIsConcluded = new TaskIsConcluded();
       concludedTasks = new String[10];

       addEmptyStringsToArray(tasksDrawer, concludedTasks);
    }

    public void startTaskManager() {

        while(programIsRunning) {

            refreshList();
            System.out.println(Arrays.toString(tasksDrawer));
            System.out.println(Arrays.toString(concludedTasks));

            Scanner sc = new Scanner(System.in);
            System.out.println("1 - CREATE TASK");
            System.out.println("2 - CHECK LIST");
            System.out.println("3 - EDIT TASK");
            System.out.println("4 - SORT TASKS BY ALPHABET");
            System.out.println("5 - MARK TASK AS CONCLUDED");

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
                    taskIsConcluded.markAsConcluded(tasksDrawer, concludedTasks);
                    break;
                case 6:
                    checkConcludedTaskList(concludedTasks);
                    break;
                default:
                    System.out.println("Invalid choice!");
                    startTaskManager();
                    break;
            }
        }
    }

    public void checkTasksList(String[] tasksDrawer) {

        int count = 1;

        for (int i = 0; i < tasksDrawer.length; i++) {

            if(tasksDrawer[i] != "") {
                System.out.println(count++ + ". " + tasksDrawer[i]);
            }
        }
    }

    public static void checkConcludedTaskList(String[] concludedTasks) {

        int count = 1;
        for (int i = 0; i < concludedTasks.length; i++) {
            if(!concludedTasks[i].isEmpty()) {
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
