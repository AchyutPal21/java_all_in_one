Out of all 23 Gang of Four (GoF) design patterns, you only need to master about 10–12 core patterns—specifically Singleton, Factory Method, Builder, Adapter, Decorator, Proxy, Facade, Strategy, Observer, and Template Method—to cover 90% of day-to-day Java/Spring Boot development and technical interviews.
Because you are working in Java and Spring Boot, Spring handles many of these under the hood, making it easy to connect theory to real code during interviews.

1. Creational Patterns (Object Creation)


Pattern	Priority	Day-to-Day & Spring Boot Usage	Interview Angle
Builder	Must-Know	Constructing complex DTOs/entities cleanly (User.builder().name("A").build() via Lombok) and StringBuilder.	Solving "telescoping constructor" anti-patterns and ensuring immutability.
Factory Method	Must-Know	Returning different service implementations based on a type (e.g., NotificationFactory.get("EMAIL")).	Decoupling object instantiation from business logic; often paired with Strategy.
Singleton	Must-Know	Every @Service, @Repository, and @Component in Spring is a singleton bean by default.	Thread safety (Double-Checked Locking, enum singleton) and breaking singletons via Reflection/Serialization.
Prototype	Good to Know	Spring @Scope("prototype") beans when you need a fresh stateful instance per request.	Shallow vs. deep copy (Cloneable pitfalls vs. copy constructors).
Abstract Factory	Good to Know	Creating families of related objects (e.g., DocumentBuilderFactory in Java XML APIs).	Difference between Factory Method (inheritance/one product) and Abstract Factory (composition/product families).


2. Structural Patterns (Class & Object Composition)


Pattern	Priority	Day-to-Day & Spring Boot Usage	Interview Angle
Proxy	Must-Know	The backbone of Spring AOP (@Transactional, @Cacheable, @Async wrap your beans in CGLIB/JDK proxies).	Difference between Proxy (controls access/adds cross-cutting behavior) and Decorator (adds features).
Adapter	Must-Know	Wrapping third-party SDKs (like Stripe or AWS) into your own internal interface, or Arrays.asList().	Making two incompatible interfaces work together without modifying existing code.
Decorator	Must-Know	Java I/O streams (new BufferedReader(new FileReader(...))) and Spring HttpServletRequestWrapper.	Favoring composition over inheritance to add responsibilities dynamically at runtime.
Facade	Must-Know	Service layer classes that coordinate multiple repositories, external APIs, and Kafka producers behind one simple method.	Simplifying a complex subsystem behind a clean, unified API.
Composite	Low / Niche	Tree structures like file systems, organization hierarchies, or UI menus.	Treating individual objects and groups of objects uniformly.


3. Behavioral Patterns (Communication & Responsibility)


Pattern	Priority	Day-to-Day & Spring Boot Usage	Interview Angle
Strategy	Must-Know	Replacing giant if-else or switch blocks (e.g., selecting payment methods, discount rules, or file parsers).	Injecting a Map<String, PaymentStrategy> in Spring Boot to dynamically pick an implementation.
Observer	Must-Know	Spring ApplicationEventPublisher & @EventListener, Kafka/RabbitMQ consumers, and reactive streams.	Decoupling event producers from multiple subscribers (publish-subscribe model).
Template Method	Must-Know	Spring's JdbcTemplate, RestTemplate, and AbstractController where the skeleton is fixed and steps are overridden.	The "Hollywood Principle" ("Don't call us, we'll call you").
Chain of Responsibility	High Value	Spring Security filter chains (OncePerRequestFilter), servlet filters, and validation pipelines.	Passing a request sequentially through a chain of handlers until one handles or rejects it.
State	Good to Know	Managing entity lifecycles (e.g., Order transitioning from NEW -> PAID -> SHIPPED -> DELIVERED).	Difference between State (object changes behavior based on internal state) and Strategy (client picks the algorithm).
Command	Low / Niche	Runnable tasks, undo/redo functionality, and queuing background jobs.	Encapsulating a request as an object so it can be logged, queued, or undone.


What You Can Safely Skip for Now

Unless you are interviewing for a specialized domain (like compilers, game engines, or low-level UI frameworks), Flyweight, Bridge, Interpreter, Memento, Mediator, and Visitor rarely appear in standard backend development or interviews.

How to Study Them Effectively

1. Master the "Big 4" first: Builder, Factory, Strategy, and Proxy—these come up in almost every backend LLD (Low-Level Design) interview.
2. Learn the "Spring Boot Map Injection" trick: Knowing how to combine Factory + Strategy by injecting Map<String, MyInterface> in Spring Boot is one of the most practical real-world patterns you can show an interviewer.
Would you like to see concrete Java/Spring Boot code examples for the top patterns (like Factory + Strategy with Spring DI), or are you preparing for Low-Level Design (LLD) interview problems?

The remaining 10% consists of two distinct categories: the 11 niche GoF patterns (used in specialized systems like compilers, UI frameworks, or high-memory engines) and modern Enterprise/Microservice patterns (which are far more important for senior backend/Spring Boot roles than obscure GoF patterns).

1. The Remaining 11 Niche GoF Patterns (Specialized Domains)

These appear rarely in standard CRUD/REST backends, but they power the frameworks, compilers, and JVMs you use every day:
• Flyweight (Structural): Sharing intrinsic state across millions of tiny objects to save RAM.
	• Where you see it: Java's String pool and Integer.valueOf(-128 to 127) cache. Used in game engines (rendering millions of trees/particles).
• Iterator (Behavioral): Traversing a collection without exposing its underlying structure.
	• Where you see it: Built directly into Java (java.util.Iterator and enhanced for-each loops), so you rarely implement it from scratch anymore.
• Mediator (Behavioral): Centralizing complex many-to-many communication between objects so they don't reference each other directly.
	• Where you see it: Air traffic control systems, chat room servers, and Spring's DispatcherServlet coordinating controllers, view resolvers, and handlers.
• Memento (Behavioral): Capturing and restoring an object's internal state without violating encapsulation.
	• Where you see it: Undo/redo stacks in text editors, browser history, or transactional rollback snapshots.
• Visitor (Behavioral): Adding new operations to an existing hierarchy of classes without modifying those classes (Double Dispatch).
	• Where you see it: Compilers and parsers traversing Abstract Syntax Trees (ASTs), such as Java's FileVisitor or ANTLR/ASM bytecode tools.
• Interpreter (Behavioral): Defining a grammar and an interpreter to evaluate sentences in a custom language.
	• Where you see it: Spring Expression Language (SpEL), SQL query parsers, and Regex engines.
• Bridge (Structural): Splitting a large class into two separate hierarchies (abstraction and implementation) so both can vary independently.
	• Where you see it: JDBC drivers (java.sql.Connection interface separated from vendor-specific PostgreSQL/MySQL implementations).

2. What Actually Makes Up the Other 10% in Real Spring Boot & Senior Interviews

In modern Java/Spring Boot backend roles, interviewers rarely quiz you on Visitor or Interpreter. Instead, once you pass the core GoF patterns, they test Enterprise, Concurrency, and Microservice patterns:

Category	Key Patterns	What They Solve
Enterprise / Data	Repository, DTO, Unit of Work, Specification	Decoupling domain logic from database queries (e.g., Spring Data JPA Specification for dynamic search filters).
Resilience	Circuit Breaker, Retry, Bulkhead, Rate Limiter	Preventing cascading failures when downstream microservices go down (implemented via Resilience4j in Spring Boot).
Distributed Data	Saga, Transactional Outbox, CQRS	Managing distributed transactions and reliable Kafka/RabbitMQ event publishing without two-phase commits.
Concurrency	Producer-Consumer, Thread Pool (Executor), Future / CompletableFuture	Handling high-throughput background jobs and non-blocking I/O safely without race conditions.


Bottom Line

If you are aiming for mid-level to senior Java/Spring Boot roles, skip memorizing Interpreter or Flyweight and spend your extra time learning Circuit Breaker, Transactional Outbox, Saga, and JPA Specification instead.
Would you like to explore Spring Data JPA's Specification pattern for dynamic filtering, or dive into Microservice resilience patterns (like Circuit Breaker and Transactional Outbox) with Spring Boot examples?
