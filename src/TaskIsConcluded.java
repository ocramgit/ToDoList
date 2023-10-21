import java.util.Scanner;

public class TaskIsConcluded {

    int count = 0;

    public void markAsConcluded(String[] tasks, String[] isConcluded) {

        Scanner sc = new Scanner(System.in);
        System.out.println("Escolha a tarefa a ser concluída: ");
        int taskNumber = sc.nextInt();

        if (taskNumber >= 0 && taskNumber < tasks.length && !tasks[taskNumber].isEmpty()) {
            isConcluded[count] = tasks[taskNumber];
            tasks[taskNumber] = "";
            count++;
            System.out.println(count);
        } else {
            System.out.println("Tarefa não encontrada ou está vazia.");
        }
    }
}

