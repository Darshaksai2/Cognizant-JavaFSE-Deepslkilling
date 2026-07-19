package week1.design_principles;

// ==========================================================================
// EXERCISE 1: SINGLETON PATTERN (LOGGER SYSTEM)
// ==========================================================================
class Logger {
    private static Logger instance;

    // Private constructor blocks direct outside initialization
    private Logger() {}

    public static synchronized Logger getInstance() {
        if (instance == null) {
            instance = new Logger();
        }
        return instance;
    }

    public void log(String message) {
        System.out.println("[LOG LOG ENGINE]: " + message);
    }
}

// ==========================================================================
// EXERCISE 2: FACTORY METHOD PATTERN (DOCUMENT GENERATOR)
// ==========================================================================
interface Document { void open(); }

class WordDocument implements Document { @Override public void open() { System.out.println("Opening MS Word Document Asset..."); } }
class PdfDocument implements Document { @Override public void open() { System.out.println("Opening Adobe PDF Secure Document Asset..."); } }

abstract class DocumentFactory {
    public abstract Document createDocument();
}

class WordFactory extends DocumentFactory {
    @Override public Document createDocument() { return new WordDocument(); }
}

class PdfFactory extends DocumentFactory {
    @Override public Document createDocument() { return new PdfDocument(); }
}

// ==========================================================================
// EXERCISE 3: BUILDER PATTERN (COMPLEX COMPUTER OPTIONAL REQUISITES)
// ==========================================================================
class Computer {
    private String CPU;
    private String RAM;
    private String Storage;

    private Computer(Builder builder) {
        this.CPU = builder.CPU;
        this.RAM = builder.RAM;
        this.Storage = builder.Storage;
    }

    @Override
    public String toString() {
        return "Computer Spec [CPU=" + CPU + ", RAM=" + RAM + ", Storage=" + Storage + "]";
    }

    public static class Builder {
        private String CPU;
        private String RAM;
        private String Storage;

        public Builder setCPU(String cpu) { this.CPU = cpu; return this; }
        public Builder setRAM(String ram) { this.RAM = ram; return this; }
        public Builder setStorage(String storage) { this.Storage = storage; return this; }

        public Computer build() { return new Computer(this); }
    }
}

// ==========================================================================
// CREATIONAL TEST RUNNER CORE
// ==========================================================================
public class CreationalPatterns {
    public static void main(String[] args) {
        System.out.println("--- EXERCISE 1: SINGLETON TEST ---");
        Logger logger1 = Logger.getInstance();
        Logger logger2 = Logger.getInstance();
        System.out.println("Are both logs matching instances?: " + (logger1 == logger2));

        System.out.println("\n--- EXERCISE 2: FACTORY METHOD TEST ---");
        DocumentFactory factory = new PdfFactory();
        Document myDoc = factory.createDocument();
        myDoc.open();

        System.out.println("\n--- EXERCISE 3: BUILDER TEST ---");
        Computer highEndPC = new Computer.Builder()
                .setCPU("Intel Ultra 9 2026")
                .setRAM("64GB DDR5")
                .setStorage("4TB NVMe SSD")
                .build();
        System.out.println(highEndPC);
    }
}