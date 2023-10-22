import java.util.Scanner;

public class TaskIsConcluded {
    int count = 0;

    public void markAsConcluded(String[] tasks, String[] isConcluded, TaskManager taskManager) {
        Scanner sc = new Scanner(System.in);
        taskManager.checkTasksList(tasks);
        System.out.println("What task want to mark as completed: ");
        int userInput = sc.nextInt();
        int taskNumber = userInput - 1;

        if (taskNumber >= 0 && taskNumber < tasks.length && !tasks[taskNumber].isEmpty()) {
            isConcluded[count] = tasks[taskNumber];
            tasks[taskNumber] = "";
            count++;
            System.out.println(count);
            System.out.println("Marked as completed.");
        } else {
            System.out.println("Task not found.");
        }
    }
}

