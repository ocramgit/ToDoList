import java.util.Scanner;

public class TasksCreator {

    public void createTask(String[] tasksList) {
        Scanner sc = new Scanner(System.in);
        System.out.print("What task you want to add?");
        String task = sc.next();

        if(task.length() < 1 ) {
            System.out.println("Task inválida!");
            createTask(tasksList);
        } else {
            for (int i = 0; i < tasksList.length; i++) {
                if (tasksList[i] == "") {
                    tasksList[i] = task;
                    break;
                }
            }
        }
    }
}
