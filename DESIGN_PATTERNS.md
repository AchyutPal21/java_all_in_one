The **Gang of Four (GoF) Design Patterns** are classified into three main categories based on their purpose: **Creational**, **Structural**, and **Behavioral**. Mastering these patterns is essential for Low-Level Design (LLD) and SDE-2 interviews because they provide reusable, industry-standard solutions to recurring architectural problems.

---

## I. Creational Design Patterns

Creational patterns deal with object creation mechanisms, trying to create objects in a manner suitable to the situation. They help isolate the details of object creation, making a system independent of how its objects are created, composed, and represented.

1. **Singleton Pattern**
* **What it does:** Ensures a class has only one instance and provides a global point of access to it.
* **Use Case:** Database connection pools, configuration managers, logging services.


2. **Factory Method Pattern**
* **What it does:** Defines an interface for creating an object, but lets subclasses decide which class to instantiate. It lets a class defer instantiation to subclasses.
* **Use Case:** Document openers (PDFDocument vs WordDocument), notification senders (Email vs SMS).


3. **Abstract Factory Pattern**
* **What it does:** Provides an interface for creating families of related or dependent objects without specifying their concrete classes.
* **Use Case:** Cross-platform UI toolkits (Windows button/checkbox vs Mac button/checkbox).


4. **Builder Pattern**
* **What it does:** Encapsulates the construction of a complex object step-by-step, allowing the same construction process to create different representations.
* **Use Case:** Constructing complex domain models with many optional fields (e.g., an HTTP Request builder or a `User` profile object).


5. **Prototype Pattern**
* **What it does:** Creates new objects by cloning an existing object (the prototype) rather than creating them from scratch via `new`.
* **Use Case:** Game character creation where enemies share base attributes but vary slightly; heavy database objects cloned for caching.



---

## II. Structural Design Patterns

Structural patterns explain how to assemble objects and classes into larger structures while keeping these structures flexible and efficient. They focus on inheritance and composition.

1. **Adapter Pattern**
* **What it does:** Allows objects with incompatible interfaces to work together by wrapping an existing class with a new interface.
* **Use Case:** Integrating a legacy third-party payment gateway into a modern microservice architecture.


2. **Bridge Pattern**
* **What it does:** Decouples an abstraction from its implementation so that the two can vary independently.
* **Use Case:** Cross-platform rendering (separating the shape abstraction from platform-specific drawing engines).


3. **Composite Pattern**
* **What it does:** Composes objects into tree structures to represent part-whole hierarchies. It lets clients treat individual objects and compositions uniformly.
* **Use Case:** File systems (files and directories) or organizational hierarchies (employees and managers).


4. **Decorator Pattern**
* **What it does:** Dynamically attaches additional responsibilities to an object without altering its underlying class structure.
* **Use Case:** Coffee ordering systems (adding Milk, Caramel, or Whipped Cream dynamically to a base Coffee) or Java I/O streams (`BufferedInputStream` wrapping `FileInputStream`).


5. **Facade Pattern**
* **What it does:** Provides a simplified, unified interface to a complex subsystem, making it easier to use.
* **Use Case:** A home theater facade button ("Watch Movie") that turns on the TV, sound system, and streaming device simultaneously.


6. **Flyweight Pattern**
* **What it does:** Reduces memory usage by sharing common parts of state among multiple objects instead of keeping all data in each object.
* **Use Case:** Text editors rendering characters (sharing font and style metadata across identical glyphs) or rendering thousands of trees in a game engine.


7. **Proxy Pattern**
* **What it does:** Provides a surrogate or placeholder for another object to control access, delay initialization, or add logging/security.
* **Use Case:** Virtual proxies (lazy loading large images), protection proxies (access control lists), or remote proxies.



---

## III. Behavioral Design Patterns

Behavioral patterns are concerned with algorithms and the assignment of responsibilities between objects. They describe not just patterns of objects or classes, but also the patterns of communication between them.

1. **Chain of Responsibility Pattern**
* **What it does:** Passes a request along a chain of handlers. Upon receiving a request, each handler decides either to process it or to pass it to the next handler in the chain.
* **Use Case:** Logging frameworks (Debug -> Info -> Error loggers) or middleware request pipelines in web servers.


2. **Command Pattern**
* **What it does:** Encapsulates a request as an object, thereby letting you parameterize clients with different requests, queue or log requests, and support undoable operations.
* **Use Case:** Text editor actions (Undo/Redo stack) or smart home remote control buttons.


3. **Interpreter Pattern**
* **What it does:** Given a language, defines a representation for its grammar along with an interpreter that uses the representation to interpret sentences in the language.
* **Use Case:** SQL parsers, expression evaluators, or rule engines.


4. **Iterator Pattern**
* **What it does:** Provides a way to access the elements of an aggregate object sequentially without exposing its underlying representation.
* **Use Case:** Traversing Java Collections (`ArrayList`, `HashSet`) using a standard `Iterator` or `Stream`.


5. **Mediator Pattern**
* **What it does:** Defines an object that encapsulates how a set of objects interact, promoting loose coupling by preventing objects from referring to each other explicitly.
* **Use Case:** Air traffic control tower coordinating planes or chat room dialog boxes where components communicate through a central mediator.


6. **Memento Pattern**
* **What it does:** Without violating encapsulation, captures and externalizes an object's internal state so that the object can be restored to this state later.
* **Use Case:** Game save-state features or software "Undo" checkpoints.


7. **Observer Pattern**
* **What it does:** Defines a one-to-many dependency between objects so that when one object changes state, all its dependents are notified automatically.
* **Use Case:** Event-driven systems, stock market ticker displays, or pub-sub messaging architectures.


8. **State Pattern**
* **What it does:** Allows an object to alter its behavior when its internal state changes. The object will appear to change its class.
* **Use Case:** Vending machine states (NoCoin, HasCoin, Dispensing) or order lifecycle management (Created, Shipped, Delivered).


9. **Strategy Pattern**
* **What it does:** Defines a family of algorithms, encapsulates each one, and makes them interchangeable. Strategy lets the algorithm vary independently from clients that use it.
* **Use Case:** Pluggable pricing engines, sorting algorithms, or payment routing strategies.


10. **Template Method Pattern**
* **What it does:** Defines the skeleton of an algorithm in an operation, deferring some steps to subclasses. It lets subclasses redefine certain steps of an algorithm without changing its structure.
* **Use Case:** Data mining frameworks (CSV parser vs PDF parser sharing the same extraction workflow skeleton).


11. **Visitor Pattern**
* **What it does:** Represents an operation to be performed on the elements of an object structure. Visitor lets you define a new operation without changing the classes of the elements on which it operates.
* **Use Case:** Compilers performing syntax tree analysis (type checking, code generation) across different syntax node types.