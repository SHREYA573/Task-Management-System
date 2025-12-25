import java.time.LocalDate;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        TaskManager manager = new TaskManager();
        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.println("\n--- Task Management System ---");
            System.out.println("1. Add Task");
            System.out.println("2. View Tasks");
            System.out.println("3. Update Task Status");
            System.out.println("4. Sort Tasks by Deadline");
            System.out.println("5. Exit");
            System.out.print("Choose option: ");

            int choice = sc.nextInt();
            sc.nextLine();

            if (choice == 1) {
                System.out.print("Title: ");
                String title = sc.nextLine();

                System.out.print("Description: ");
                String desc = sc.nextLine();

                System.out.print("Priority (High/Medium/Low): ");
                String priority = sc.nextLine();

                System.out.print("Deadline (YYYY-MM-DD): ");
                String dateInput = sc.nextLine();
                LocalDate deadline = LocalDate.parse(dateInput);

                manager.addTask(title, desc, priority, deadline);
                System.out.println("Task added!");

            } else if (choice == 2) {
                for (Task t : manager.getAllTasks()) {
                    System.out.println("-----------------");
                    System.out.println("Title: " + t.getTitle());
                    System.out.println("Priority: " + t.getPriority());
                    System.out.println("Deadline: " + t.getDeadline());
                    System.out.println("Status: " + t.getStatus());

                    if (t.isOverdue()) {
                        System.out.println("⚠️ Status Alert: OVERDUE");
                    } else if (t.isUrgent()) {
                        System.out.println("⏳ Status Alert: URGENT");
                    }

                }

            } else if (choice == 3) {

                System.out.println("Enter task number to update:");
                int index = sc.nextInt();
                sc.nextLine();

                System.out.print("Enter new status (Pending/In Progress/Completed): ");
                String newStatus = sc.nextLine();

                manager.updateTaskStatus(index - 1, newStatus);
                System.out.println("Task status updated!");
            } else if (choice == 4) {
                manager.sortByDeadline();
                System.out.println("Tasks sorted by deadline.");
            } else if (choice == 5) {
                System.out.println("Exiting...");
                sc.close();
                break;
            } else {
                System.out.println("Invalid choice");
            }
            
        }
    }
}
