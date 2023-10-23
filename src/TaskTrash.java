import java.util.ArrayList;
import java.util.Scanner;

public class TaskTrash {
    ArrayList<String> trash = new ArrayList<>();
    Scanner sc = new Scanner(System.in);

    public void deleteTask(String task) {
        trash.add(task);
    }

    public void getTrash() {
        int count = 0;
        for (String el : trash) {
            System.out.println(count++ + ": " + el);
        }
    }

    public void recoverTask(TaskManager taskManager) {
        int count = 0;
        for (String el : trash) {
            System.out.println(count++ + ": " + el);
        }
        System.out.println("Select the number of task to recover it.");

        for (int i = 0; i < taskManager.tasksDrawer.length; i++) {
            if(taskManager.tasksDrawer[i].isEmpty()) {
                taskManager.tasksDrawer[i] = trash.get(sc.nextInt());
                System.out.println("Task "+ i + " recovered!");
                break;
            }
        }
    }
}
