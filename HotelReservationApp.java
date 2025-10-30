import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Room {
    private int roomNumber;
    private String type;   // Single / Double / Suite
    private double price;
    private boolean isBooked;

    public Room(int roomNumber, String type, double price) {
        this.roomNumber = roomNumber;
        this.type = type;
        this.price = price;
        this.isBooked = false;
    }

    public int getRoomNumber() {
        return roomNumber;
    }

    public String getType() {
        return type;
    }

    public double getPrice() {
        return price;
    }

    public boolean isBooked() {
        return isBooked;
    }

    public void bookRoom() {
        this.isBooked = true;
    }

    public void vacateRoom() {
        this.isBooked = false;
    }

    @Override
    public String toString() {
        return "Room " + roomNumber + " [" + type + "] - Rs." + price + " - " + (isBooked ? "Booked" : "Available");
    }
}

class Hotel {
    private List<Room> rooms = new ArrayList<>();

    public Hotel() {
        // Pre-defined rooms
        rooms.add(new Room(101, "Single", 1500));
        rooms.add(new Room(102, "Double", 2500));
        rooms.add(new Room(201, "Suite", 4000));
        rooms.add(new Room(202, "Double", 2500));
    }

    public void showAvailableRooms() {
        System.out.println("\n--- Available Rooms ---");
        for (Room r : rooms) {
            if (!r.isBooked()) {
                System.out.println(r);
            }
        }
    }

    public void showAllRooms() {
        System.out.println("\n--- All Rooms ---");
        for (Room r : rooms) {
            System.out.println(r);
        }
    }

    public void bookRoom(int roomNumber) {
        for (Room r : rooms) {
            if (r.getRoomNumber() == roomNumber) {
                if (!r.isBooked()) {
                    r.bookRoom();
                    System.out.println("Room " + roomNumber + " booked successfully!");
                } else {
                    System.out.println("Room " + roomNumber + " is already booked!");
                }
                return;
            }
        }
        System.out.println("Room not found!");
    }

    public void vacateRoom(int roomNumber) {
        for (Room r : rooms) {
            if (r.getRoomNumber() == roomNumber) {
                if (r.isBooked()) {
                    r.vacateRoom();
                    System.out.println("Room " + roomNumber + " is now vacated!");
                } else {
                    System.out.println("Room " + roomNumber + " is not booked!");
                }
                return;
            }
        }
        System.out.println("Room not found!");
    }
}

public class HotelReservationApp {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Hotel hotel = new Hotel();
        int choice;

        do {
            System.out.println("\n===== Hotel Reservation System =====");
            System.out.println("1. Show Available Rooms");
            System.out.println("2. Show All Rooms");
            System.out.println("3. Book a Room");
            System.out.println("4. Vacate a Room");
            System.out.println("5. Exit");
            System.out.print("Enter choice: ");
            choice = sc.nextInt();

            switch (choice) {
                case 1:
                    hotel.showAvailableRooms();
                    break;
                case 2:
                    hotel.showAllRooms();
                    break;
                case 3:
                    System.out.print("Enter room number to book: ");
                    int bookNum = sc.nextInt();
                    hotel.bookRoom(bookNum);
                    break;
                case 4:
                    System.out.print("Enter room number to vacate: ");
                    int vacNum = sc.nextInt();
                    hotel.vacateRoom(vacNum);
                    break;
                case 5:
                    System.out.println("Thank you! Exiting system...");
                    break;
                default:
                    System.out.println("Invalid choice! Try again.");
            }
        } while (choice != 5);

        sc.close();
    }
}
