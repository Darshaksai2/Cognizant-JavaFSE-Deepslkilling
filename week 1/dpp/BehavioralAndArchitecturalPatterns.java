package week1.design_principles;

import java.util.*;

// ==========================================================================
// EXERCISE 7: OBSERVER PATTERN (STOCK DISPATCH CORE)
// ==========================================================================
interface Observer { void update(double price); }
class MobileApp implements Observer { @Override public void update(double price) { System.out.println("Mobile Push Event: Price modified to $" + price); } }

interface Stock { void register(Observer o); void notifyObservers(); }
class StockMarket implements Stock {
    private List<Observer> observers = new ArrayList<>();
    private double stockPrice;
    public void setPrice(double price) { this.stockPrice = price; notifyObservers(); }
    @Override public void register(Observer o) { observers.add(o); }
    @Override public void notifyObservers() { for(Observer o : observers) o.update(stockPrice); }
}

// ==========================================================================
// EXERCISE 9: COMMAND PATTERN (HOME AUTOMATION MODULES)
// ==========================================================================
interface Command { void execute(); }
class Light {
    public void turnOn() { System.out.println("Receiver: System light source turned on."); }
}
class LightOnCommand implements Command {
    private Light light;
    public LightOnCommand(Light l) { this.light = l; }
    @Override public void execute() { light.turnOn(); }
}
class RemoteControl {
    private Command slot;
    public void setCommand(Command c) { this.slot = c; }
    public void pressButton() { slot.execute(); }
}

// ==========================================================================
// EXERCISE 10: MVC CONFIGURATOR ENVIRONMENT
// ==========================================================================
class Student {
    private String name, id;
    public Student(String name, String id) { this.name = name; this.id = id; }
    public String getName() { return name; }
    public String getId() { return id; }
}
class StudentView {
    public void displayStudentDetails(String name, String id) { System.out.println("View Render -> Student: " + name + " | Registration Code: " + id); }
}
class StudentController {
    private Student model; private StudentView view;
    public StudentController(Student m, StudentView v) { this.model = m; this.view = v; }
    public void updateView() { view.displayStudentDetails(model.getName(), model.getId()); }
}

// ==========================================================================
// EXERCISE 11: DEPENDENCY INJECTION MECHANISMS
// ==========================================================================
interface CustomerRepository { String findCustomerById(int id); }
class CustomerRepositoryImpl implements CustomerRepository {
    @Override public String findCustomerById(int id) { return "Alice Mason Core Profile Data"; }
}
class CustomerService {
    private CustomerRepository repo;
    public CustomerService(CustomerRepository r) { this.repo = r; } // Constructor Injection
    public void printCustomer(int id) { System.out.println("Fetched via DI Logic: " + repo.findCustomerById(id)); }
}

// ==========================================================================
// MAIN RUNNER
// ==========================================================================
public class BehavioralAndArchitecturalPatterns {
    public static void main(String[] args) {
        System.out.println("--- EXERCISE 7: OBSERVER TEST ---");
        StockMarket market = new StockMarket();
        market.register(new MobileApp());
        market.setPrice(184.25);

        System.out.println("\n--- EXERCISE 9: COMMAND TEST ---");
        Light homeLight = new Light();
        RemoteControl remote = new RemoteControl();
        remote.setCommand(new LightOnCommand(homeLight));
        remote.pressButton();

        System.out.println("\n--- EXERCISE 10: MVC TEST ---");
        StudentController ctrl = new StudentController(new Student("Rohan", "DN-2026"), new StudentView());
        ctrl.updateView();

        System.out.println("\n--- EXERCISE 11: DEPENDENCY INJECTION TEST ---");
        CustomerService service = new CustomerService(new CustomerRepositoryImpl());
        service.printCustomer(505);
    }
}