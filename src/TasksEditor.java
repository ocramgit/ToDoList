import java.util.Scanner;
public class TasksEditor {

    public void editTask(String[] task) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Qual o número da task que quer editar?");
        int taskNumber = sc.nextInt();

        for (int i = 0; i < task.length; i++) {
            if (i + 1 == taskNumber) {
                if (task[i] != "") {
                    System.out.println(task[i]);
                    System.out.print("Edite a task: ");
                    task[i] = sc.next();
                    System.out.println("Task editada!");
                } else {
                    System.out.println("Essa task não existe.");
                }
            }
        }
    }
}
