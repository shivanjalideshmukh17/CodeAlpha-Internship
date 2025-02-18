import java.util.ArrayList;
import java.util.Scanner;

class Room 
{
    int roomId;
    String type;
    double price;
    boolean isAvailable;
       
        public Room(int roomId, String type, double price, boolean isAvailable) 
    {
        this.roomId = roomId;
        this.type = type;
        this.price = price;
        this.isAvailable = isAvailable;
    }
    
     public void displayRoom() 
    {
        System.out.println("Room ID: " + roomId + " | Type: " + type + " | Price: $" + price + " | Available: " + (isAvailable ? "Yes" : "No"));
    }
}

class Reservation
   {
    int resId;
    String guestName;
    Room room;
    String checkInDate;
    String checkOutDate;

    public Reservation(int resId, String guestName, Room room, String checkInDate, String checkOutDate) {
        this.resId = resId;
        this.guestName = guestName;
        this.room = room;
        this.checkInDate = checkInDate;
        this.checkOutDate = checkOutDate;
    }

    public void displayBooking() 
    {
        System.out.println("\nBooking ID: " + resId);
        System.out.println("Guest: " + guestName);
        System.out.println("Room ID: " + room.roomId + " | Type: " + room.type);
        System.out.println("Check-in: " + checkInDate);
        System.out.println("Check-out: " + checkOutDate);
        System.out.println("Total Price: $" + room.price);
        System.out.println("-------------------------");
    }
}

class PaymentProcessor 
{
    public static boolean processPayment(String guestName, double amount)
   {
        System.out.println("Processing payment of $" + amount + " for " + guestName + "...");
        System.out.println("Payment successful! ");
        return true;
    }
}

class HotelManagement
 {
    ArrayList<Room> rooms = new ArrayList<>();
    ArrayList<Reservation> reservations = new ArrayList<>();
    Scanner scanner = new Scanner(System.in);

    public HotelManagement()
    {
        
        rooms.add(new Room(101, "Standard", 100.0, true));
        rooms.add(new Room(102, "Deluxe", 150.0, true));
        rooms.add(new Room(103, "Suite", 250.0, true));
    }

    public void displayAvailableRooms() 
    {
        System.out.println("\nAvailable Rooms:");
        for (Room room : rooms) 
        {
            if (room.isAvailable) 
            {
                room.displayRoom();
            }
        }
    }

    public void bookRoom() 
    {
        displayAvailableRooms();
        System.out.print("\nEnter Room ID to book: ");
        int roomId = scanner.nextInt();
        scanner.nextLine();
        System.out.print("Enter your name: ");
        String userName = scanner.nextLine();
        System.out.print("Enter check-in date (YYYY-MM-DD): ");
        String checkIn = scanner.nextLine();
        System.out.print("Enter check-out date (YYYY-MM-DD): ");
        String checkOut = scanner.nextLine();

        for (Room room : rooms) 
        {
            if (room.roomId == roomId && room.isAvailable)
            {
                if (PaymentProcessor.processPayment(userName, room.price))
                {
                    room.isAvailable = false;
                    Reservation res = new Reservation(reservations.size() + 1, userName, room, checkIn, checkOut);
                    reservations.add(res);
                    System.out.println("Booking Successful! \n");
                    res.displayBooking();
                }
                return;
            }
        }
        System.out.println("Invalid Room ID or Room is not available.");
    }

    public void viewBookings() 
    {
        if (reservations.isEmpty()) 
        {
            System.out.println("\nNo reservations found.");
            return;
        }
        System.out.println("\nAll Reservations:");
        for (Reservation res : reservations) 
        {
            res.displayBooking();
        }
    }

    public void run()
    {
        while (true)
        {
            System.out.println("\n Hotel Reservation System ");
            System.out.println("1. View Available Rooms");
            System.out.println("2. Book a Room");
            System.out.println("3. View Reservations");
            System.out.println("4. Exit");
            System.out.print("Choose an option: ");
            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice)
            {
                case 1 -> displayAvailableRooms();
                case 2 -> bookRoom();
                case 3 -> viewBookings();
                case 4 -> 
                {
                    System.out.println("Thank you for using the Hotel Reservation System!");
                    return;
                }
                default -> System.out.println("Invalid choice! Please try again.");
            }
        }
    }
}

public class HotelReservationSystem 
{
    public static void main(String[] args) 
    {
        HotelManagement hotel = new HotelManagement();
        hotel.run();
    }
}