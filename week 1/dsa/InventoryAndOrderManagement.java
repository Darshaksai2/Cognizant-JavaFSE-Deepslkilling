package week1.dsa_exercises;

import java.util.*;

// ==========================================================================
// EXERCISE 1 & 2: PRODUCT MODELS
// ==========================================================================
class Product {
    int productId;
    String productName;
    int quantity;
    double price;
    String category;

    public Product(int productId, String productName, int quantity, double price, String category) {
        this.productId = productId;
        this.productName = productName;
        this.quantity = quantity;
        this.price = price;
        this.category = category;
    }

    @Override
    public String toString() {
        return "Product[ID=" + productId + ", Name=" + productName + ", Price=" + price + ", Qty=" + quantity + "]";
    }
}

// Inventory Management Engine Utilizing HashMap for O(1) Key-Based Lookups
class InventoryManager {
    // HashMap is chosen because tracking by unique key ID yields O(1) for Add/Update/Delete
    private Map<Integer, Product> inventory = new HashMap<>();

    public void addProduct(Product p) {
        inventory.put(p.productId, p);
        System.out.println("Added: " + p.productName);
    }

    public void updateProduct(int id, int newQty, double newPrice) {
        if (inventory.containsKey(id)) {
            Product p = inventory.get(id);
            p.quantity = newQty;
            p.price = newPrice;
            System.out.println("Updated: " + p.productName);
        } else {
            System.out.println("Product ID not found.");
        }
    }

    public void deleteProduct(int id) {
        if (inventory.containsKey(id)) {
            Product removed = inventory.remove(id);
            System.out.println("Deleted: " + removed.productName);
        } else {
            System.out.println("Product ID not found.");
        }
    }
}

// ==========================================================================
// EXERCISE 3: SORTING CUSTOMER ORDERS[cite: 9]
// ==========================================================================
class Order {
    int orderId;
    String customerName;
    double totalPrice;

    public Order(int orderId, String customerName, double totalPrice) {
        this.orderId = orderId;
        this.customerName = customerName;
        this.totalPrice = totalPrice;
    }

    @Override
    public String toString() {
        return "Order[ID=" + orderId + ", Customer=" + customerName + ", Total=$" + totalPrice + "]";
    }
}

class OrderSorter {
    // Bubble Sort: O(n^2) worst/average case[cite: 9]
    public static void bubbleSort(Order[] orders) {
        int n = orders.length;
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (orders[j].totalPrice > orders[j + 1].totalPrice) {
                    Order temp = orders[j];
                    orders[j] = orders[j + 1];
                    orders[j + 1] = temp;
                }
            }
        }
    }

    // Quick Sort: O(n log n) average case[cite: 9]
    public static void quickSort(Order[] orders, int low, int high) {
        if (low < high) {
            int pivotIndex = partition(orders, low, high);
            quickSort(orders, low, pivotIndex - 1);
            quickSort(orders, pivotIndex + 1, high);
        }
    }

    private static int partition(Order[] orders, int low, int high) {
        double pivot = orders[high].totalPrice;
        int i = (low - 1);
        for (int j = low; j < high; j++) {
            if (orders[j].totalPrice <= pivot) {
                i++;
                Order temp = orders[i];
                orders[i] = orders[j];
                orders[j] = temp;
            }
        }
        Order temp = orders[i + 1];
        orders[i + 1] = orders[high];
        orders[high] = temp;
        return i + 1;
    }
}

// ==========================================================================
// EXERCISE 4: EMPLOYEE MANAGEMENT SYSTEM (STATIC ARRAY)[cite: 9]
// ==========================================================================
class Employee {
    int employeeId;
    String name;
    String position;
    double salary;

    public Employee(int employeeId, String name, String position, double salary) {
        this.employeeId = employeeId;
        this.name = name;
        this.position = position;
        this.salary = salary;
    }

    @Override
    public String toString() {
        return "Emp[ID=" + employeeId + ", Name=" + name + ", Role=" + position + "]";
    }
}

class EmployeeManager {
    private Employee[] registry;
    private int count;

    public EmployeeManager(int capacity) {
        registry = new Employee[capacity]; // Continuous allocation in memory blocks[cite: 9]
        count = 0;
    }

    public void addEmployee(Employee emp) {
        if (count < registry.length) {
            registry[count++] = emp;
            System.out.println("Registered employee: " + emp.name);
        } else {
            System.out.println("Registry structurally full.");
        }
    }

    public Employee searchEmployee(int id) {
        for (int i = 0; i < count; i++) {
            if (registry[i].employeeId == id) return registry[i];
        }
        return null; // O(n) linear lookup scans[cite: 9]
    }

    public void traverseEmployees() {
        System.out.println("--- Employee Registry Logs ---");
        for (int i = 0; i < count; i++) {
            System.out.println(registry[i]);
        }
    }

    public void deleteEmployee(int id) {
        int indexToDelete = -1;
        for (int i = 0; i < count; i++) {
            if (registry[i].employeeId == id) {
                indexToDelete = i;
                break;
            }
        }
        if (indexToDelete != -1) {
            // Shift operations to maintain continuous block symmetry[cite: 9]
            for (int i = indexToDelete; i < count - 1; i++) {
                registry[i] = registry[i + 1];
            }
            registry[--count] = null;
            System.out.println("Employee ID record deleted safely.");
        } else {
            System.out.println("Record not found.");
        }
    }
}

// ==========================================================================
// CORE EXECUTION ENTRY SUITE
// ==========================================================================
public class InventoryAndOrderManagement {
    public static void main(String[] args) {
        System.out.println("=== INTERACTIVE WORKSPACE: EXECUTION TRACE ===");

        // Test Inventory[cite: 9]
        InventoryManager inv = new InventoryManager();
        inv.addProduct(new Product(101, "Laptop", 10, 1200.0, "Tech"));
        inv.updateProduct(101, 15, 1150.0);

        // Test Sorter[cite: 9]
        Order[] clientOrders = {
            new Order(1, "Alice", 250.0),
            new Order(2, "Bob", 1200.0),
            new Order(3, "Charlie", 45.0)
        };
        System.out.println("\nOrders before QuickSort: " + Arrays.toString(clientOrders));
        OrderSorter.quickSort(clientOrders, 0, clientOrders.length - 1);
        System.out.println("Orders after QuickSort: " + Arrays.toString(clientOrders));

        // Test Employee Array Manager[cite: 9]
        EmployeeManager empMgr = new EmployeeManager(5);
        empMgr.addEmployee(new Employee(1, "Suresh", "Lead Architect", 95000));
        empMgr.traverseEmployees();
    }
}