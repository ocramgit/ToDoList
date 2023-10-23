import java.util.Scanner;
public class TasksEditor {

    public void editTask(String[] task, TaskManager taskManager) {
        Scanner sc = new Scanner(System.in);
        taskManager.checkTasksList(task);
        System.out.println("What task want to edit?");
        int taskNumber = sc.nextInt();

        for (int i = 0; i < task.length; i++) {
            if (i + 1 == taskNumber) {
                if (task[i] != "") {
                    System.out.print("Edit task: ");
                    task[i] = sc.next();
                    System.out.println("Task edited!");
                } else {
                    System.out.println("Invalid task.");
                }
            }
        }
    }
}
