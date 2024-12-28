import java.util.Scanner;

public class ToDoList {
    public static void main(String[] args) {
        final int MAX_TASKS = 100; // Maximum number of tasks
        String[] tasks = new String[MAX_TASKS];
        boolean[] taskStatus = new boolean[MAX_TASKS];
        int taskCount = 0; // Current number of tasks
        Scanner scanner = new Scanner(System.in);
        int choice;

        System.out.println("Welcome to the To-Do List Application!");

        while (true) {
            // Display the menu
            System.out.println("\nMenu:");
            System.out.println("1. Add Task");
            System.out.println("2. View Tasks");
            System.out.println("3. Mark Task as Complete");
            System.out.println("4. Delete Task");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();
            scanner.nextLine(); // Clear the newline

            switch (choice) {
                case 1:
                    // Add a task
                    if (taskCount < MAX_TASKS) {
                        System.out.print("Enter the task: ");
                        String task = scanner.nextLine();
                        tasks[taskCount] = task;
                        taskStatus[taskCount] = false; // Task is incomplete by default
                        taskCount++;
                        System.out.println("Task added successfully!");
                    } else {
                        System.out.println("Task limit reached. Cannot add more tasks.");
                    }
                    break;

                case 2:
                    // View all tasks
                    if (taskCount == 0) {
                        System.out.println("No tasks available.");
                    } else {
                        System.out.println("\nYour To-Do List:");
                        for (int i = 0; i < taskCount; i++) {
                            String status = taskStatus[i] ? "✓ (Completed)" : "✗ (Incomplete)";
                            System.out.println((i + 1) + ". " + tasks[i] + " - " + status);
                        }
                    }
                    break;

                case 3:
                    // Mark a task as complete
                    if (taskCount == 0) {
                        System.out.println("No tasks available to mark as complete.");
                    } else {
                        System.out.println("\nSelect a task to mark as complete:");
                        for (int i = 0; i < taskCount; i++) {
                            String status = taskStatus[i] ? "✓ (Completed)" : "✗ (Incomplete)";
                            System.out.println((i + 1) + ". " + tasks[i] + " - " + status);
                        }
                        System.out.print("Enter the task number: ");
                        int taskNumber = scanner.nextInt();
                        if (taskNumber > 0 && taskNumber <= taskCount) {
                            taskStatus[taskNumber - 1] = true;
                            System.out.println("Task marked as complete!");
                        } else {
                            System.out.println("Invalid task number.");
                        }
                    }
                    break;

                case 4:
                    // Delete a task
                    if (taskCount == 0) {
                        System.out.println("No tasks available to delete.");
                    } else {
                        System.out.println("\nSelect a task to delete:");
                        for (int i = 0; i < taskCount; i++) {
                            String status = taskStatus[i] ? "✓ (Completed)" : "✗ (Incomplete)";
                            System.out.println((i + 1) + ". " + tasks[i] + " - " + status);
                        }
                        System.out.print("Enter the task number: ");
                        int taskNumber = scanner.nextInt();
                        if (taskNumber > 0 && taskNumber <= taskCount) {
                            // Shift tasks and statuses to remove the selected task
                            for (int j = taskNumber - 1; j < taskCount - 1; j++) {
                                tasks[j] = tasks[j + 1];
                                taskStatus[j] = taskStatus[j + 1];
                            }
                            tasks[taskCount - 1] = null; // Clear the last task
                            taskCount--;
                            System.out.println("Task deleted successfully!");
                        } else {
                            System.out.println("Invalid task number.");
                        }
                    }
                    break;

                case 5:
                    // Exit the program
                    System.out.println("Thank you for using the To-Do List Application. Goodbye!");
                    scanner.close();
                    System.exit(0);

                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }
}