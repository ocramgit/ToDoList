import java.util.ArrayList;

public class TaskTrash {
    ArrayList<String> trash = new ArrayList<>();

    public void deleteTask(String task) {
        trash.add(task);
    }

    public void getTrash() {
        int count = 0;
        for (String el : trash) {
            System.out.println(count++ + ": " + el);
        }
    }

}
