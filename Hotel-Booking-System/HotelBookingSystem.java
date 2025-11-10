// 8. Hotel Room Booking System

// Description: Book rooms, check availability, and calculate billing.
// Concepts Covered: Classes, Objects, Methods, Encapsulation, Inheritance.
// Features:
// Manage room types (Single, Double, Suite).
// Check availability and book rooms.
// Calculate total charges.
// Extend for seasonal discounts using method overriding.

import java.util.*;

class Room {
    private int roomNumber;
    private String roomType;
    private double pricePerNight;
    private boolean isBooked;

    Room(int roomNumber, String roomType, double pricePerNight) {
        this.roomNumber = roomNumber;
        this.roomType = roomType;
        this.pricePerNight = pricePerNight;
        this.isBooked = false;
    }

    public boolean bookRoom() {
        if (!isBooked) {
            isBooked = true;
            return true;
        }
        return false;
    }

    public String getRoomType() {
        return roomType;
    }

    public double getPricePerNight() {
        return pricePerNight;
    }

    public int getRoomNumber() {
        return roomNumber;
    }

    public boolean isBooked() {
        return isBooked;
    }
}


class SeasonalRoom extends Room {
    private double discountPercentage;

    public SeasonalRoom(int roomNumber, String roomType, double pricePerNight, double discountPercentage) {
        super(roomNumber, roomType, pricePerNight);
        this.discountPercentage = discountPercentage;
    }

    @Override
    public double getPricePerNight() {   
        double price = super.getPricePerNight();
        return price - (price * (discountPercentage / 100));
    }
}

class Hotel {
    private ArrayList<Room> rooms = new ArrayList<>();

    public void addRoom(Room room) {
        rooms.add(room);
    }

    public void checkAvailability(String type) {
        System.out.println("\nAvailable Rooms:");
        for (Room r : rooms) {
            if (r.getRoomType().equalsIgnoreCase(type) && !r.isBooked()) {
                System.out.println("Room No: " + r.getRoomNumber() + " | Price per Night: " + r.getPricePerNight());
            }
        }
    }

    public double bookRoom(int roomNumber, int nights) {
        for (Room r : rooms) {
            if (r.getRoomNumber() == roomNumber) {
                if (r.bookRoom()) {
                    return r.getPricePerNight() * nights;
                }
            }
        }
        return -1;
    }
}

public class HotelBookingSystem {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        Hotel hotel = new Hotel();
        hotel.addRoom(new Room(101, "Single", 1200));
        hotel.addRoom(new Room(102, "Double", 2000));
        hotel.addRoom(new SeasonalRoom(201, "Suite", 4500, 20)); // discount room

        while (true) {
            System.out.println("\n----- Hotel Booking System -----");
            System.out.println("1. Check Room Availability");
            System.out.println("2. Book Room");
            System.out.println("3. Exit");
            System.out.print("Choose: ");

            int choice = sc.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter Room type (Single/Double/Suite): ");
                    String type = sc.next();
                    hotel.checkAvailability(type);
                    break;

                case 2:
                    System.out.print("Enter Room Number: ");
                    int roomNo = sc.nextInt();

                    System.out.print("Enter no. of Nights: ");
                    int nights = sc.nextInt();

                    double bill = hotel.bookRoom(roomNo, nights);

                    if (bill == -1) {
                        System.out.println("Room Already Booked or Invalid Room Number!");
                    } else {
                        System.out.println("✅ Room Booked Successfully!");
                        System.out.println("Total Bill: ₹" + bill);
                    }
                    break;

                case 3:
                    System.out.println("Thanks for Using Hotel Booking System!");
                    System.exit(0);

                default:
                    System.out.println("Choose a Valid Option");
            }
        }
    }
}
