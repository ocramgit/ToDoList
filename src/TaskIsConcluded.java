import java.util.Scanner;

public class TaskIsConcluded {
    int count = 0;
    Scanner sc = new Scanner(System.in);

    public void markAsConcluded(String[] tasks, String[] isConcluded, TaskManager taskManager) {
        taskManager.checkTasksList(tasks);
        System.out.println("What task want to mark as completed: ");
        int userInput = sc.nextInt();
        int taskNumber = userInput - 1;

        if (taskNumber >= 0 && !tasks[taskNumber].isEmpty()) {
            isConcluded[count] = tasks[taskNumber];
            tasks[taskNumber] = "";
            count++;
            System.out.println("Marked as completed. ✅");
        } else {
            System.out.println("Task not found.");
        }
    }

    public void markAsUncompleted(String[] tasks, String[] isConcluded, TaskManager taskManager) {
        taskManager.checkConcludedTaskList(isConcluded);
        System.out.println("What task want to mark as uncompleted: ");

        int userInput = sc.nextInt();
        int taskNumber = userInput-1;

        if(taskNumber >= 0 && !isConcluded[taskNumber].isEmpty()) {
            tasks[count] = isConcluded[taskNumber];
            isConcluded[taskNumber] = "";
            count++;
            System.out.println("Marked as uncompleted.");
        } else {
            System.out.println("Task not found.");
        }
    }
}

