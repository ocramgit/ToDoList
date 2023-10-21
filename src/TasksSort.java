public class TasksSort {

    public void sortTasks(String[] tasks) {

        String temp;

        for (int i = 0; i < tasks.length; i++) {
            for (int j = i + 1; j < tasks.length; j++) {
                //comparar por ordem alfabetica
                if (!tasks[i].isEmpty() && !tasks[j].isEmpty()) {
                    if (tasks[i].charAt(0) > tasks[j].charAt(0)) {
                        temp = tasks[i];
                        tasks[i] = tasks[j];
                        tasks[j] = temp;
                    }
                    //mover elementos vazios para o final
                } else if (tasks[i].isEmpty() && !tasks[j].isEmpty()) {
                    temp = tasks[i];
                    tasks[i] = tasks[j];
                    tasks[j] = temp;
                }
            }
        }
    }
}
