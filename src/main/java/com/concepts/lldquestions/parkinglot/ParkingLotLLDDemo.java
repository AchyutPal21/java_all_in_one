package com.concepts.lldquestions.parkinglot;

import java.time.Duration;
import java.time.Instant;
import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;

// ============================================================================
// 1. ENUMS (Fixed Domain Types & States)
// ============================================================================

enum VehicleType {
    MOTORCYCLE,
    CAR,
    TRUCK
}

enum SpotType {
    SMALL,   // Best for MOTORCYCLE
    MEDIUM,  // Best for CAR (also fits MOTORCYCLE)
    LARGE    // Best for TRUCK (also fits CAR / MOTORCYCLE)
}

enum TicketStatus {
    ACTIVE,
    PAID
}

// ============================================================================
// 2. VEHICLE HIERARCHY (Abstract Class for Shared State + Concrete Subclasses)
// ============================================================================

abstract class Vehicle {
    private final String licensePlate;
    private final VehicleType type;

    protected Vehicle(String licensePlate, VehicleType type) {
        if (licensePlate == null || licensePlate.isBlank()) {
            throw new IllegalArgumentException("License plate cannot be empty.");
        }
        this.licensePlate = licensePlate;
        this.type = type;
    }

    public String getLicensePlate() {
        return licensePlate;
    }

    public VehicleType getType() {
        return type;
    }
}

class Motorcycle extends Vehicle {
    public Motorcycle(String licensePlate) {
        super(licensePlate, VehicleType.MOTORCYCLE);
    }
}

class Car extends Vehicle {
    public Car(String licensePlate) {
        super(licensePlate, VehicleType.CAR);
    }
}

class Truck extends Vehicle {
    public Truck(String licensePlate) {
        super(licensePlate, VehicleType.TRUCK);
    }
}

// ============================================================================
// 3. PARKING SPOT HIERARCHY (Abstract Class for Shared State & Occupancy Rules)
// ============================================================================

abstract class ParkingSpot {
    private final String spotId;
    private final int floorNumber;
    private final SpotType spotType;
    private boolean occupied;
    private Vehicle parkedVehicle;

    protected ParkingSpot(String spotId, int floorNumber, SpotType spotType) {
        this.spotId = spotId;
        this.floorNumber = floorNumber;
        this.spotType = spotType;
        this.occupied = false;
    }

    // Defines compatibility between this spot size and an incoming vehicle
    public abstract boolean canFit(Vehicle vehicle);

    public synchronized boolean isAvailable() {
        return !occupied;
    }

    public synchronized void assignVehicle(Vehicle vehicle) {
        if (occupied) {
            throw new IllegalStateException("Spot " + spotId + " is already occupied.");
        }
        if (!canFit(vehicle)) {
            throw new IllegalArgumentException("Vehicle " + vehicle.getLicensePlate() + " cannot fit in spot " + spotId);
        }
        this.parkedVehicle = vehicle;
        this.occupied = true;
    }

    public synchronized Vehicle removeVehicle() {
        if (!occupied) {
            throw new IllegalStateException("Spot " + spotId + " is already empty.");
        }
        Vehicle freed = this.parkedVehicle;
        this.parkedVehicle = null;
        this.occupied = false;
        return freed;
    }

    public String getSpotId() {
        return spotId;
    }

    public int getFloorNumber() {
        return floorNumber;
    }

    public SpotType getSpotType() {
        return spotType;
    }

    public Vehicle getParkedVehicle() {
        return parkedVehicle;
    }
}

class SmallSpot extends ParkingSpot {
    public SmallSpot(String spotId, int floorNumber) {
        super(spotId, floorNumber, SpotType.SMALL);
    }

    @Override
    public boolean canFit(Vehicle vehicle) {
        return vehicle.getType() == VehicleType.MOTORCYCLE;
    }
}

class MediumSpot extends ParkingSpot {
    public MediumSpot(String spotId, int floorNumber) {
        super(spotId, floorNumber, SpotType.MEDIUM);
    }

    @Override
    public boolean canFit(Vehicle vehicle) {
        // Motorcycles can also use medium spots when small spots are unavailable
        return vehicle.getType() == VehicleType.MOTORCYCLE || vehicle.getType() == VehicleType.CAR;
    }
}

class LargeSpot extends ParkingSpot {
    public LargeSpot(String spotId, int floorNumber) {
        super(spotId, floorNumber, SpotType.LARGE);
    }

    @Override
    public boolean canFit(Vehicle vehicle) {
        // Large spots can accommodate any vehicle type
        return true;
    }
}

// ============================================================================
// 4. PARKING FLOOR & TICKET
// ============================================================================

class ParkingFloor {
    private final int floorNumber;
    private final List<ParkingSpot> spots;

    public ParkingFloor(int floorNumber, List<ParkingSpot> spots) {
        this.floorNumber = floorNumber;
        this.spots = new ArrayList<>(spots);
    }

    public int getFloorNumber() {
        return floorNumber;
    }

    public List<ParkingSpot> getSpots() {
        return Collections.unmodifiableList(spots);
    }

    // Returns count of currently free spots grouped by SpotType for display boards
    public Map<SpotType, Integer> getAvailableSpotCounts() {
        Map<SpotType, Integer> counts = new EnumMap<>(SpotType.class);
        for (SpotType type : SpotType.values()) {
            counts.put(type, 0);
        }
        for (ParkingSpot spot : spots) {
            if (spot.isAvailable()) {
                counts.merge(spot.getSpotType(), 1, Integer::sum);
            }
        }
        return counts;
    }
}

class ParkingTicket {
    private final String ticketId;
    private final Vehicle vehicle;
    private final ParkingSpot spot;
    private final Instant entryTime;
    private Instant exitTime;
    private double amountCharged;
    private TicketStatus status;

    public ParkingTicket(String ticketId, Vehicle vehicle, ParkingSpot spot, Instant entryTime) {
        this.ticketId = ticketId;
        this.vehicle = vehicle;
        this.spot = spot;
        this.entryTime = entryTime;
        this.status = TicketStatus.ACTIVE;
    }

    public void markPaid(Instant exitTime, double amountCharged) {
        this.exitTime = exitTime;
        this.amountCharged = amountCharged;
        this.status = TicketStatus.PAID;
    }

    public String getTicketId() { return ticketId; }
    public Vehicle getVehicle() { return vehicle; }
    public ParkingSpot getSpot() { return spot; }
    public Instant getEntryTime() { return entryTime; }
    public Instant getExitTime() { return exitTime; }
    public double getAmountCharged() { return amountCharged; }
    public TicketStatus getStatus() { return status; }
}

// ============================================================================
// 5. STRATEGY INTERFACES (Spot Allocation, Pricing, Payment)
// ============================================================================

interface SpotAllocationStrategy {
    Optional<ParkingSpot> findSpot(List<ParkingFloor> floors, Vehicle vehicle);
}

// Picks the first available compatible spot from lower floors to higher floors
class NearestAvailableSpotStrategy implements SpotAllocationStrategy {
    @Override
    public Optional<ParkingSpot> findSpot(List<ParkingFloor> floors, Vehicle vehicle) {
        // Prefer exact-fit spot types first before falling back to larger spots
        List<SpotType> preferredOrder = switch (vehicle.getType()) {
            case MOTORCYCLE -> List.of(SpotType.SMALL, SpotType.MEDIUM, SpotType.LARGE);
            case CAR        -> List.of(SpotType.MEDIUM, SpotType.LARGE);
            case TRUCK      -> List.of(SpotType.LARGE);
        };

        for (SpotType desiredType : preferredOrder) {
            for (ParkingFloor floor : floors) {
                for (ParkingSpot spot : floor.getSpots()) {
                    if (spot.getSpotType() == desiredType && spot.isAvailable()) {
                        return Optional.of(spot);
                    }
                }
            }
        }
        return Optional.empty();
    }
}

interface PricingStrategy {
    double calculateFee(ParkingTicket ticket, Instant exitTime);
}

// Minimum 1-hour billing with per-hour rates based on vehicle type
class HourlyPricingStrategy implements PricingStrategy {
    private final Map<VehicleType, Double> hourlyRates;

    public HourlyPricingStrategy(Map<VehicleType, Double> hourlyRates) {
        this.hourlyRates = hourlyRates;
    }

    @Override
    public double calculateFee(ParkingTicket ticket, Instant exitTime) {
        long minutes = Math.max(1, Duration.between(ticket.getEntryTime(), exitTime).toMinutes());
        long billableHours = (long) Math.ceil(minutes / 60.0); // Minimum 1 hour
        double ratePerHour = hourlyRates.getOrDefault(ticket.getVehicle().getType(), 50.0);
        return billableHours * ratePerHour;
    }
}

interface PaymentStrategy {
    boolean processPayment(double amount);
}

class UpiPayment implements PaymentStrategy {
    private final String upiId;

    public UpiPayment(String upiId) {
        this.upiId = upiId;
    }

    @Override
    public boolean processPayment(double amount) {
        System.out.println("Processed ₹" + amount + " via UPI (" + upiId + ")");
        return true;
    }
}

class CardPayment implements PaymentStrategy {
    private final String cardLast4;

    public CardPayment(String cardLast4) {
        this.cardLast4 = cardLast4;
    }

    @Override
    public boolean processPayment(double amount) {
        System.out.println("Processed ₹" + amount + " via Card ending in " + cardLast4);
        return true;
    }
}

// ============================================================================
// 6. PARKING LOT CORE (Thread-Safe Singleton) & GATES
// ============================================================================

class ParkingLot {
    private static volatile ParkingLot instance;

    private final List<ParkingFloor> floors;
    private final SpotAllocationStrategy allocationStrategy;
    private final PricingStrategy pricingStrategy;
    private final Map<String, ParkingTicket> activeTickets = new ConcurrentHashMap<>();
    private final AtomicInteger ticketCounter = new AtomicInteger(1000);

    private ParkingLot(
            List<ParkingFloor> floors,
            SpotAllocationStrategy allocationStrategy,
            PricingStrategy pricingStrategy
    ) {
        this.floors = new ArrayList<>(floors);
        this.allocationStrategy = allocationStrategy;
        this.pricingStrategy = pricingStrategy;
    }

    // Initializes or retrieves the singleton ParkingLot instance
    public static ParkingLot getInstance(
            List<ParkingFloor> floors,
            SpotAllocationStrategy allocationStrategy,
            PricingStrategy pricingStrategy
    ) {
        if (instance == null) {
            synchronized (ParkingLot.class) {
                if (instance == null) {
                    instance = new ParkingLot(floors, allocationStrategy, pricingStrategy);
                }
            }
        }
        return instance;
    }

    public static ParkingLot getInstance() {
        if (instance == null) {
            throw new IllegalStateException("ParkingLot has not been initialized yet.");
        }
        return instance;
    }

    // Synchronized check-and-assign prevents race conditions across concurrent entry gates
    public synchronized Optional<ParkingTicket> parkVehicle(Vehicle vehicle) {
        Optional<ParkingSpot> spotOpt = allocationStrategy.findSpot(floors, vehicle);
        if (spotOpt.isEmpty()) {
            return Optional.empty();
        }

        ParkingSpot spot = spotOpt.get();
        spot.assignVehicle(vehicle);

        String ticketId = "TKT-" + ticketCounter.incrementAndGet();
        ParkingTicket ticket = new ParkingTicket(ticketId, vehicle, spot, Instant.now());
        activeTickets.put(ticketId, ticket);
        return Optional.of(ticket);
    }

    // Collects payment first; only releases the spot once payment succeeds
    public synchronized double unparkVehicle(String ticketId, PaymentStrategy paymentStrategy) {
        ParkingTicket ticket = activeTickets.get(ticketId);
        if (ticket == null) {
            throw new IllegalArgumentException("Invalid ticket ID: " + ticketId);
        }
        if (ticket.getStatus() != TicketStatus.ACTIVE) {
            throw new IllegalStateException("Ticket " + ticketId + " is already settled.");
        }

        Instant exitTime = Instant.now();
        double fee = pricingStrategy.calculateFee(ticket, exitTime);

        boolean paid = paymentStrategy.processPayment(fee);
        if (!paid) {
            throw new IllegalStateException("Payment failed for ticket " + ticketId + ". Spot remains held.");
        }

        ticket.getSpot().removeVehicle();
        ticket.markPaid(exitTime, fee);
        activeTickets.remove(ticketId);
        return fee;
    }

    public void printAvailabilityBoard() {
        System.out.println("=== Parking Lot Availability ===");
        for (ParkingFloor floor : floors) {
            System.out.println("Floor " + floor.getFloorNumber() + ": " + floor.getAvailableSpotCounts());
        }
    }
}

class EntryGate {
    private final String gateId;

    public EntryGate(String gateId) {
        this.gateId = gateId;
    }

    public Optional<ParkingTicket> issueTicket(Vehicle vehicle) {
        Optional<ParkingTicket> ticket = ParkingLot.getInstance().parkVehicle(vehicle);
        if (ticket.isPresent()) {
            ParkingTicket t = ticket.get();
            System.out.printf("[%s] Issued %s for %s (%s) at Floor %d, Spot %s%n",
                    gateId, t.getTicketId(), vehicle.getType(), vehicle.getLicensePlate(),
                    t.getSpot().getFloorNumber(), t.getSpot().getSpotId());
        } else {
            System.out.printf("[%s] Sorry, no available spot for %s (%s)%n",
                    gateId, vehicle.getType(), vehicle.getLicensePlate());
        }
        return ticket;
    }
}

class ExitGate {
    private final String gateId;

    public ExitGate(String gateId) {
        this.gateId = gateId;
    }

    public void processExit(String ticketId, PaymentStrategy paymentStrategy) {
        try {
            double amount = ParkingLot.getInstance().unparkVehicle(ticketId, paymentStrategy);
            System.out.printf("[%s] Ticket %s settled. Charged ₹%.2f. Have a safe trip!%n",
                    gateId, ticketId, amount);
        } catch (RuntimeException ex) {
            System.out.printf("[%s] Exit failed for %s: %s%n", gateId, ticketId, ex.getMessage());
        }
    }
}

// ============================================================================
// 7. DEMO / ENTRY POINT
// ============================================================================

public class ParkingLotLLDDemo {
    public void start() {
        // Setup Floor 1 with Small, Medium, and Large spots
        ParkingFloor floor1 = new ParkingFloor(1, List.of(
                new SmallSpot("F1-S1", 1),
                new MediumSpot("F1-M1", 1),
                new MediumSpot("F1-M2", 1),
                new LargeSpot("F1-L1", 1)
        ));

        // Configure hourly rates per vehicle type
        Map<VehicleType, Double> rates = Map.of(
                VehicleType.MOTORCYCLE, 20.0,
                VehicleType.CAR, 50.0,
                VehicleType.TRUCK, 100.0
        );

        ParkingLot lot = ParkingLot.getInstance(
                List.of(floor1),
                new NearestAvailableSpotStrategy(),
                new HourlyPricingStrategy(rates)
        );

        EntryGate entry1 = new EntryGate("ENTRY-GATE-1");
        ExitGate exit1 = new ExitGate("EXIT-GATE-1");

        lot.printAvailabilityBoard();

        // Vehicles enter
        Optional<ParkingTicket> carTicket = entry1.issueTicket(new Car("KA-01-AB-1234"));
        Optional<ParkingTicket> bikeTicket = entry1.issueTicket(new Motorcycle("KA-05-XY-9876"));

        lot.printAvailabilityBoard();

        // Car exits and pays via UPI
        carTicket.ifPresent(t -> exit1.processExit(t.getTicketId(), new UpiPayment("driver@okaxis")));

        lot.printAvailabilityBoard();

        // Bike exits and pays via Card
        bikeTicket.ifPresent(t -> exit1.processExit(t.getTicketId(), new CardPayment("8899")));

        lot.printAvailabilityBoard();
    }
}
