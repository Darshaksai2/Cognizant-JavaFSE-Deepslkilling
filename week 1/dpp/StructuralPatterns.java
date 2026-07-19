package week1.design_principles;

// ==========================================================================
// EXERCISE 4: ADAPTER PATTERN (PAYMENT ENGINE OVERRIDES)
// ==========================================================================
interface PaymentProcessor { void processPayment(double amount); }

class OldGatewayAdaptee {
    public void makePayment(double amt) { System.out.println("Processing legacy vendor token value: $" + amt); }
}

class PaymentAdapter implements PaymentProcessor {
    private OldGatewayAdaptee adaptee;
    public PaymentAdapter(OldGatewayAdaptee adaptee) { this.adaptee = adaptee; }
    @Override
    public void processPayment(double amount) { adaptee.makePayment(amount); }
}

// ==========================================================================
// EXERCISE 5: DECORATOR PATTERN (DYNAMIC CHANNELS EXTENSION)
// ==========================================================================
interface Notifier { void send(String msg); }

class EmailNotifier implements Notifier {
    @Override public void send(String msg) { System.out.println("Dispatching Base SMTP Email: " + msg); }
}

abstract class NotifierDecorator implements Notifier {
    protected Notifier wrappedNotifier;
    public NotifierDecorator(Notifier n) { this.wrappedNotifier = n; }
    @Override public void send(String msg) { wrappedNotifier.send(msg); }
}

class SMSNotifierDecorator extends NotifierDecorator {
    public SMSNotifierDecorator(Notifier n) { super(n); }
    @Override
    public void send(String msg) {
        super.send(msg);
        System.out.println("Appending SMS Text Protocol Gateway Stream: " + msg);
    }
}

// ==========================================================================
// EXERCISE 6: PROXY PATTERN (LAZY RENDERING ENGINE & CACHE MOCK)
// ==========================================================================
interface Image { void display(); }

class RealImage implements Image {
    private String filename;
    public RealImage(String filename) {
        this.filename = filename;
        loadFromRemoteServer();
    }
    private void loadFromRemoteServer() { System.out.println("Downloading high-res payload from remote cloud server: " + filename); }
    @Override public void display() { System.out.println("Rendering real pixel arrays for: " + filename); }
}

class ProxyImage implements Image {
    private RealImage realImage;
    private String filename;
    public ProxyImage(String filename) { this.filename = filename; }
    @Override
    public void display() {
        if (realImage == null) { realImage = new RealImage(filename); } // Lazy initialization
        else { System.out.println("Cache Hit confirmed via internal pointer registry."); }
        realImage.display();
    }
}

// ==========================================================================
// STRUCTURAL TEST RUNNER CORE
// ==========================================================================
public class StructuralPatterns {
    public static void main(String[] args) {
        System.out.println("--- EXERCISE 4: ADAPTER TEST ---");
        PaymentProcessor payment = new PaymentAdapter(new OldGatewayAdaptee());
        payment.processPayment(450.00);

        System.out.println("\n--- EXERCISE 5: DECORATOR TEST ---");
        Notifier alertEngine = new SMSNotifierDecorator(new EmailNotifier());
        alertEngine.send("System Update Log Completed.");

        System.out.println("\n--- EXERCISE 6: PROXY TEST ---");
        Image img = new ProxyImage("photo_2026.png");
        img.display(); // First run down: Downloads from server
        System.out.println();
        img.display(); // Second run down: Loads from cache instantly
    }
}