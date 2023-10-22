import java.util.Scanner;

public class TaskRemover {

    Scanner sc = new Scanner(System.in);

    public void removeNormalTask(String[] normalTask, TaskManager taskManager, TaskTrash taskTrash) {
        taskManager.checkTasksList(normalTask);
        System.out.println("What task want remove: ");
        int userNumber = sc.nextInt();

        if (!normalTask[userNumber - 1].isEmpty()) {
            taskTrash.deleteTask(normalTask[userNumber - 1]);
            normalTask[userNumber - 1] = "";
            System.out.println("Task removed" + normalTask[userNumber-1] + "with success!");
        } else {
            System.out.println("This task is empty.");
        }
    }

    public void removeCompletedTask(String[] completedTasks, TaskManager taskManager, TaskTrash taskTrash) {
        taskManager.checkTasksList(completedTasks);
        System.out.println("What task want remove: ");
        int userNumber = sc.nextInt();

        if (!completedTasks[userNumber - 1].isEmpty()) {
            taskTrash.deleteTask(completedTasks[userNumber - 1]);
            completedTasks[userNumber - 1] = "";
            System.out.println("Task removed " + completedTasks[userNumber-1] + " with success!");
        } else {
            System.out.println("This task is empty.");
        }
    }
}
