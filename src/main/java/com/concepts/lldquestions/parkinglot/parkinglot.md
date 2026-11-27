Let’s treat this like a real **Low-Level Design (LLD) interview**. I’ll act as your interviewer and give you a comprehensive **Parking Lot** problem statement with rich, clear requirements so that as you design it—and when you come back later to revise—every piece connects cleanly.

---

### Interview Problem: Multi-Floor Smart Parking Lot System

> *"Welcome! Today I want you to design the **Low-Level Design** for a **Multi-Floor Smart Parking Lot System** for a commercial mall. Take your time structuring your classes, relationships, patterns, and edge cases—we’ll review your design once you share it."*

---

### 1. Functional Requirements

* **Multi-Floor & Multi-Gate Structure:**
* The parking lot has multiple floors (`Floor 1`, `Floor 2`, etc.), and each floor contains multiple parking spots (`Spot 1`, `Spot 2`, ...).
* There are multiple **Entry Gates** and **Exit Gates**.


* **Vehicle Types & Spot Compatibility:**
* Support at least three vehicle categories: `MOTORCYCLE`, `CAR` (includes sedans/SUVs), and `TRUCK` (or `LARGE_VEHICLE`).
* Parking spots come in matching sizes/types (`SMALL` / `MOTORCYCLE`, `COMPACT` / `MEDIUM` / `CAR`, `LARGE` / `TRUCK`).
* Define clear compatibility rules (for example: a `MOTORCYCLE` can fit in a `SMALL`, `MEDIUM`, or `LARGE` spot if needed, a `CAR` needs at least `MEDIUM` or `LARGE`, and a `TRUCK` requires `LARGE`).


* **Spot Allocation Strategy:**
* When a vehicle arrives at an entry gate, the system finds an available compatible spot (e.g., nearest to the gate, or lowest floor/spot number).
* If no compatible spot is available, deny entry gracefully (e.g., `"Parking Lot Full"` for that vehicle type).


* **Ticketing & Exit Flow:**
* On entry, issue a **Parking Ticket** containing `ticketId`, `vehicle`, `spot`, `entryTime`, and `status` (`ACTIVE` / `PAID`).
* On exit, scan/look up the ticket, record `exitTime`, calculate the **parking fee**, process **payment**, free up the parking spot, and mark the ticket settled.


* **Pricing / Fee Calculation:**
* Support flexible pricing rules (for example: hourly rates that vary by vehicle type, a minimum charge, or peak vs. off-peak / flat + hourly).


* **Payment Modes:**
* Support multiple payment methods at exit (e.g., `CASH`, `CARD`, `UPI`) and handle payment failure cleanly without prematurely releasing the spot before payment succeeds.


* **Real-Time Availability / Display Board:**
* Ability to check or display available spot counts per floor and/or per spot type at any moment.



---

### 2. Non-Functional & Edge-Case Expectations to Keep in Mind

* **Thread Safety / Concurrency:** Two vehicles arriving at different entry gates at the same time shouldn't be assigned the same parking spot.
* **Extensibility & SOLID Principles:** Adding a new vehicle type (`EV_CAR`), a new pricing rule (`WEEKEND_SURGE`), or a new payment method shouldn't require rewriting core orchestration classes.
* **Edge Cases to Think Through:**
* Invalid or already-closed ticket presented at exit.
* Vehicle exits in less than 1 hour (rounding/minimum billing rule).
* Spot becomes occupied/unoccupied cleanly across repeated check-ins and check-outs.



---

### 3. Suggested Checklist to Connect All Dots During Design & Revision

When you write your solution, make sure you explicitly cover:

1. **Entities & Models:** `ParkingLot`, `ParkingFloor`, `ParkingSpot` (and subclasses/types), `Vehicle` (and subclasses/types), `ParkingTicket`, `EntryGate`, `ExitGate`.
2. **Design Patterns Used (and Why):** Where you use **Strategy** (spot allocation, pricing, payment), **Factory** (creating spots/vehicles/payments if applicable), or **Singleton** (if the parking lot / manager is a single instance—be ready to justify thread safety and testability!).
3. **Class Relationships & Key Methods:** Clear fields, method signatures, and how `parkVehicle()` and `unparkVehicle()` interact.
4. **Concurrency & Edge Cases:** Where locks/`synchronized`/atomic operations live and what happens on failure.

---
### Simple Rule of Thumb

* **Concrete class:** *"I need a real object with data and working code right now."*
* **Abstract class:** *"These closely related classes share data/code, and I want to avoid repeating it."*
* **Interface:** *"I want a plug-and-play contract that different classes can implement in their own way."*

Do you want to look at a specific class from the parking lot design and test whether changing it to an interface or abstract class would help or hurt?