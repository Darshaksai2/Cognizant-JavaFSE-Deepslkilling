package week1.dsa_exercises;

import java.util.Arrays;

// ==========================================================================
// EXERCISE 2 & 6: SEARCH ALGORITHMS PLATFORM UTILS[cite: 9]
// ==========================================================================
class SearchEngine {
    // Linear Search: O(n) time complexity[cite: 9]
    public static int linearSearch(Product[] list, String targetName) {
        for (int i = 0; i < list.length; i++) {
            if (list[i].productName.equalsIgnoreCase(targetName)) return i;
        }
        return -1;
    }

    // Binary Search: O(log n) complexity (Assumes input is sorted by criteria)[cite: 9]
    public static int binarySearch(Product[] sortedList, String targetName) {
        int low = 0;
        int high = sortedList.length - 1;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            int comparison = sortedList[mid].productName.compareToIgnoreCase(targetName);
            if (comparison == 0) return mid;
            if (comparison < 0) low = mid + 1;
            else high = mid - 1;
        }
        return -1;
    }
}

// ==========================================================================
// EXERCISE 5: TASK MANAGEMENT SYSTEM (LINKED LIST)[cite: 9]
// ==========================================================================
class Task {
    int taskId;
    String taskName;
    String status;
    Task next; // Link pointer to next continuous element node[cite: 9]

    public Task(int taskId, String taskName, String status) {
        this.taskId = taskId;
        this.taskName = taskName;
        this.status = status;
        this.next = null;
    }
}

class SinglyLinkedList {
    private Task head = null;

    // Add: O(1) append timing at sequence head[cite: 9]
    public void addTask(Task newTask) {
        if (head == null) {
            head = newTask;
        } else {
            newTask.next = head;
            head = newTask;
        }
        System.out.println("Task appended: " + newTask.taskName);
    }

    public void traverseTasks() {
        Task current = head;
        System.out.println("--- Current Tasks Trace ---");
        while (current != null) {
            System.out.println("Task[ID=" + current.taskId + ", Name=" + current.taskName + ", Status=" + current.status + "]");
            current = current.next;
        }
    }

    // Delete: O(n) element search isolation execution[cite: 9]
    public void deleteTask(int id) {
        if (head == null) return;
        if (head.taskId == id) {
            head = head.next;
            return;
        }
        Task current = head;
        while (current.next != null && current.next.taskId != id) {
            current = current.next;
        }
        if (current.next != null) {
            current.next = current.next.next;
            System.out.println("Task matching ID isolated and deleted.");
        }
    }
}

// ==========================================================================
// EXERCISE 7: FINANCIAL FORECASTING ENGINE[cite: 9]
// ==========================================================================
class ForecastingEngine {
    // Exponential Growth Simulation via Basic Recursion[cite: 9]
    // Time Complexity: O(n) simple iteration depth context
    public static double calculateFutureValue(double presentValue, double growthRate, int periods) {
        if (periods == 0) return presentValue; // Baseline operational termination limit[cite: 9]
        return calculateFutureValue(presentValue * (1 + growthRate), growthRate, periods - 1);
    }
}

public class AdvancedStructuresAndAlgorithms {
    public static void main(String[] args) {
        System.out.println("=== MODULE 2: RECURSION & COMPLEX LAYOUT STRUCTURES ===");

        // Test Task Manager List[cite: 9]
        SinglyLinkedList list = new SinglyLinkedList();
        list.addTask(new Task(1, "Configure SonarQube Server Profiles", "Pending"));
        list.addTask(new Task(2, "Construct Rest API Controllers", "Active"));
        list.traverseTasks();

        // Test Recursion Engine[cite: 9]
        double futureVal = ForecastingEngine.calculateFutureValue(10000, 0.05, 5);
        System.out.println("\nFinancial Growth Forecast (5 Periods at 5% rate): $" + String.format("%.2f", futureVal));
    }
}