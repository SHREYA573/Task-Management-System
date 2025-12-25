import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Comparator;


public class TaskManager {

    private List<Task> tasks;

    public TaskManager() {
        tasks = new ArrayList<>();
    }
    public void sortByDeadline() {
    tasks.sort(Comparator.comparing(Task::getDeadline));
}


    public void addTask(String title, String description,
                        String priority, LocalDate deadline) {

        Task task = new Task(title, description, priority, deadline, "Pending");
        tasks.add(task);
    }

    public List<Task> getAllTasks() {
        return tasks;
    }
    public void updateTaskStatus(int index, String newStatus) {
    if (index >= 0 && index < tasks.size()) {
        tasks.get(index).setStatus(newStatus);
    } else {
        System.out.println("Invalid task number.");
    }
}

}
