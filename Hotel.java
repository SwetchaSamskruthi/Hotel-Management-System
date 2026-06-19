package Internships;
import java.util.*;

class hotel_reservation {
    public static Scanner sc = new Scanner(System.in);
    public static ArrayList<Integer> room_id = new ArrayList<>();

    public static int[] rooms_reservation(String room_type, ArrayList<Integer> room_id) {
        int[] room_details = new int[5];
        System.out.print("How many days are you going to spend: ");
        int stays = sc.nextInt();

        int price = 0;
        int id = 0;
        if (room_type.equalsIgnoreCase("single") || room_type.equals("1")) {
            price = 200;
            id = 101 + (int)(Math.random() * 20);
        } else if (room_type.equalsIgnoreCase("double ac") || room_type.equals("2")) {
            price = 600;
            id = 501 + (int)(Math.random() * 20);
        } else if (room_type.equalsIgnoreCase("double non ac") || room_type.equals("3")) {
            price = 400;
            id = 301 + (int)(Math.random() * 20);
        } else if (room_type.equalsIgnoreCase("family ac") || room_type.equals("4")) {
            price = 700;
            id = 701 + (int)(Math.random() * 20);
        } else {
            System.out.println("Please enter a valid room type.");
            return room_details;
        }

        int cost = price * stays;
        int total = (int)(cost * 0.28); // 18% GST + 10% maintenance
        int final_cost = cost + total;

        if (room_id.contains(id)) {
            System.out.println("Sorry, the room is unavailable.");
        } else {
            room_id.add(id);
            room_details[0] = price;
            room_details[1] = cost;
            room_details[2] = final_cost;
            room_details[3] = id;
            room_details[4] = stays;
            System.out.println("Hope you will enjoy your lovely vacation!");
        }

        return room_details;
    }

    public static String[] customer() {
        String[] customer_details = new String[2];
        sc.nextLine(); // consume newline
        System.out.print("Enter name: ");
        customer_details[0] = sc.nextLine();
        System.out.print("Enter Phone number: ");
        customer_details[1] = sc.nextLine();
        return customer_details;
    }

    public static void billing(String[] customer_details, int[] room_details, String room_type) {
        String str_code = "QWERTYUIOPASDFGHJKLZXCVBNM";
        String booking_id = (int)(100 + Math.random() * 900) + "";

        for (int i = 0; i < 4; i++) {
            booking_id += str_code.charAt((int)(Math.random() * 26));
        }

        System.out.println("--------------------------------------------");
        System.out.println("    WELCOME TO SUNSHINE RESIDENCY");
        System.out.println("      Tirupathi | Andhra Pradesh");
        System.out.println("         Receipt for your stay");
        System.out.println("--------------------------------------------");
        System.out.println("Name: " + customer_details[0]);
        System.out.println("Phone: " + customer_details[1]);
        System.out.println("Booking ID: " + booking_id);
        System.out.println("Room Type: " + room_type);
        System.out.println("Cost per Night: Rs." + room_details[0]);
        System.out.println("Number of Days: " + room_details[4]);
        System.out.println("Room ID: " + room_details[3]);
        System.out.println("GST: 18%   Maintenance: 10%");
        System.out.println("--------------------------------------------");
        System.out.println("Total Amount: Rs." + room_details[2]);
        System.out.println("Payment Mode: Online Transaction");
        System.out.println("--------------------------------------------");
    }

    public static void main(String[] args) {
        System.out.println("--------------------------------------------");
        System.out.println("    WELCOME TO SUNSHINE RESIDENCY");
        System.out.println("      Tirupathi | Andhra Pradesh");
        System.out.println("--------------------------------------------");
        System.out.println("Room Types:\n 1 - Single\n 2 - Double AC\n 3 - Double Non AC\n 4 - Family AC");
        System.out.print("Enter room type: ");
        String option = sc.nextLine();

        String[] customer = customer();
        int[] room_details = rooms_reservation(option, room_id);
        billing(customer, room_details, option);

        System.out.println("For any queries, contact: 9871236450");
        System.out.println("--------------------------------------------");
        sc.close();
    }
}
