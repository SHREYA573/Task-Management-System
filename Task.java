import java.time.LocalDate;

public class Task {

    private String title;
    private String description;
    private String priority;
    private LocalDate deadline;
    private String status;

    public Task(String title, String description, String priority,
                LocalDate deadline, String status) {
        this.title = title;
        this.description = description;
        this.priority = priority;
        this.deadline = deadline;
        this.status = status;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public String getPriority() {
        return priority;
    }

    public LocalDate getDeadline() {
        return deadline;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
    public boolean isOverdue() {
    return LocalDate.now().isAfter(deadline)
            && !status.equalsIgnoreCase("Completed");
}
public boolean isUrgent() {
    return !isOverdue()
            && deadline.isAfter(LocalDate.now())
            && deadline.isBefore(LocalDate.now().plusDays(3))
            && !status.equalsIgnoreCase("Completed");
}

}
