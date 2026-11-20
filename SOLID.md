The **SOLID principles** are five design principles intended to make software designs more understandable, flexible, and maintainable. Originally introduced by Robert C. Martin (Uncle Bob), these principles form the backbone of **Low-Level Design (LLD)** and are heavily scrutinized in SDE-2 and senior-level system design interviews.

Here is an in-depth breakdown of each principle in Java, complete with anti-patterns (violations) and clean refactored solutions.

---

### 1. Single Responsibility Principle (SRP)

> **Definition:** A class should have only one reason to change, meaning it should have only one job or responsibility.

If a class handles business logic, database operations, and logging all at once, any change to logging or database schemas forces a modification to the core business logic class. This tightly couples unrelated concerns.

#### Violation Example (God Class)

```java
public class Invoice {
    private double amount;
    private String customerName;

    public Invoice(double amount, String customerName) {
        this.amount = amount;
        this.customerName = customerName;
    }

    // Responsibility 1: Business Logic / Calculation
    public double calculateTotalWithTax() {
        return amount * 1.18; // 18% tax
    }

    // Responsibility 2: Data Persistence
    public void saveToDatabase() {
        System.out.println("Saving invoice for " + customerName + " to MySQL DB.");
    }

    // Responsibility 3: Reporting / Printing
    public void printInvoice() {
        System.out.println("Printing invoice: $" + calculateTotalWithTax());
    }
}

```

#### Refactored Solution (Separation of Concerns)

```java
// Handles only data and core calculation rules
public class Invoice {
    private double amount;
    private String customerName;

    public Invoice(double amount, String customerName) {
        this.amount = amount;
        this.customerName = customerName;
    }

    public double getAmount() { return amount; }
    public String getCustomerName() { return customerName; }
    
    public double calculateTotalWithTax() {
        return amount * 1.18;
    }
}

// Handles only persistence
public class InvoiceRepository {
    public void save(Invoice invoice) {
        System.out.println("Saving invoice for " + invoice.getCustomerName() + " to DB.");
    }
}

// Handles only output/presentation
public class InvoicePrinter {
    public void print(Invoice invoice) {
        System.out.println("Printing invoice: $" + invoice.calculateTotalWithTax());
    }
}

```

---

### 2. Open/Closed Principle (OCP)

> **Definition:** Software entities (classes, modules, functions) should be open for extension, but closed for modification.

You should be able to add new functionality without touching existing, tested source code. This is typically achieved through **polymorphism**, interfaces, and abstract classes.

#### Violation Example (Using `if-else` or `switch` for behavior)

```java
public class ShippingCostCalculator {
    public double calculateShippingCost(String orderType, double weight) {
        if (orderType.equals("STANDARD")) {
            return weight * 5.0;
        } else if (orderType.equals("EXPRESS")) {
            return weight * 10.0;
        } else if (orderType.equals("INTERNATIONAL")) { // Adding a new type requires modifying this class!
            return weight * 25.0;
        }
        return 0.0;
    }
}

```

#### Refactored Solution (Using Interfaces and Strategy Pattern)

```java
// Abstract contract
public interface ShippingStrategy {
    double calculate(double weight);
}

// Extensions
public class StandardShipping implements ShippingStrategy {
    public double calculate(double weight) { return weight * 5.0; }
}

public class ExpressShipping implements ShippingStrategy {
    public double calculate(double weight) { return weight * 10.0; }
}

// New shipping type added later without modifying existing classes!
public class InternationalShipping implements ShippingStrategy {
    public double calculate(double weight) { return weight * 25.0; }
}

// Calculator is now "closed" for modification
public class ShippingCostCalculator {
    public double calculate(ShippingStrategy strategy, double weight) {
        return strategy.calculate(weight);
    }
}

```

---

### 3. Liskov Substitution Principle (LSP)

> **Definition:** Objects in a program should be replaceable with instances of their subtypes without altering the correctness of that program.

If class `B` is a subtype of class `A`, then we should be able to replace an object of type `A` with an object of type `B` without breaking the application logic or throwing unexpected exceptions.

#### Violation Example (The classic Square-Rectangle trap)

Mathematically, a square is a rectangle. But in OOP, forcing `Square` to inherit from `Rectangle` breaks behavior because changing width independently of height violates rectangle invariants.

```java
public class Rectangle {
    protected int width, height;

    public void setWidth(int width) { this.width = width; }
    public void setHeight(int height) { this.height = height; }
    public int getArea() { return width * height; }
}

public class Square extends Rectangle {
    @Override
    public void setWidth(int width) {
        this.width = width;
        this.height = width; // Enforcing square property
    }

    @Override
    public void setHeight(int height) {
        this.width = height;
        this.height = height;
    }
}

// Client Code that breaks:
public class Test {
    public void resizeAndVerify(Rectangle r) {
        r.setWidth(5);
        r.setHeight(4);
        // Expects area = 5 * 4 = 20. But if r is a Square, area becomes 4 * 4 = 16!
        assert r.getArea() == 20; 
    }
}

```

#### Refactored Solution (Using a common interface or separating hierarchies)

Instead of forcing incorrect inheritance, extract a shared abstraction (`Shape`) or separate the models.

```java
public interface Shape {
    int getArea();
}

public class Rectangle implements Shape {
    private int width, height;
    public Rectangle(int width, int height) { this.width = width; this.height = height; }
    public int getArea() { return width * height; }
}

public class Square implements Shape {
    private int side;
    public Square(int side) { this.side = side; }
    public int getArea() { return side * side; }
}

```

---

### 4. Interface Segregation Principle (ISP)

> **Definition:** A client should never be forced to implement an interface that it doesn't use, or clients shouldn't be forced to depend on methods they do not use.

Fat interfaces should be split into smaller, more specific ones so that implementing classes only care about methods relevant to them.

#### Violation Example (Fat Interface)

```java
public interface Worker {
    void work();
    void eat();
    void attendMeetings();
}

// A Robot implements Worker, but robots don't eat or attend meetings!
public class RobotWorker implements Worker {
    public void work() { System.out.println("Robot working..."); }
    public void eat() { 
        // Forced to implement, but meaningless for a robot
        throw new UnsupportedOperationException("Robots don't eat!"); 
    }
    public void attendMeetings() { 
        // Meaningless 
        throw new UnsupportedOperationException("Robots don't attend meetings!"); 
    }
}

```

#### Refactored Solution (Segregated Interfaces)

```java
public interface Workable {
    void work();
}

public interface Eatable {
    void eat();
}

public interface Attendable {
    void attendMeetings();
}

public class HumanWorker implements Workable, Eatable, Attendable {
    public void work() { /* ... */ }
    public void eat() { /* ... */ }
    public void attendMeetings() { /* ... */ }
}

public class RobotWorker implements Workable {
    public void work() { System.out.println("Robot working..."); }
    // No unwanted methods forced upon it!
}

```

---

### 5. Dependency Inversion Principle (DIP)

> **Definition:**
> 1. High-level modules should not depend on low-level modules. Both should depend on abstractions.
> 2. Abstractions should not depend on details. Details should depend on abstractions.
> 
> 

In traditional architectures, high-level business logic components directly instantiate low-level utility classes (like MySQL databases or specific email clients), creating tight coupling. DIP inverts this dependency using interfaces.

#### Violation Example (Direct Tight Coupling)

```java
public class MySqlDatabase {
    public void save(String data) {
        System.out.println("Saving to MySQL: " + data);
    }
}

public class UserService {
    private MySqlDatabase database = new MySqlDatabase(); // Tightly coupled to MySQL!

    public void registerUser(String username) {
        // Business logic...
        database.save(username);
    }
}

```

#### Refactored Solution (Dependency Injection via Abstractions)

```java
// 1. Abstraction
public interface Database {
    void save(String data);
}

// 2. Low-level detail implements abstraction
public class MySqlDatabase implements Database {
    public void save(String data) {
        System.out.println("Saving to MySQL: " + data);
    }
}

public class MongoDatabase implements Database {
    public void save(String data) {
        System.out.println("Saving to MongoDB: " + data);
    }
}

// 3. High-level module depends on abstraction, injected via constructor
public class UserService {
    private final Database database;

    // Dependency Injection (Spring Framework style)
    public UserService(Database database) {
        this.database = database;
    }

    public void registerUser(String username) {
        database.save(username); // Works with ANY database implementation seamlessly
    }
}

```

---

### Quick Summary Reference Table

| Principle | Core Objective | Primary Design Tool |
| --- | --- | --- |
| **S** - Single Responsibility | One class = One reason to change | Splitting classes by domain concern |
| **O** - Open/Closed | Extend behavior without modifying code | Interfaces, Abstract classes, Strategy Pattern |
| **L** - Liskov Substitution | Subtypes must be safely interchangeable | Strict contract adherence in inheritance |
| **I** - Interface Segregation | Avoid bloated, monolithic interfaces | Granular, role-specific interfaces |
| **D** - Dependency Inversion | Depend on abstractions, not concretions | Interfaces + Dependency Injection (DI) |