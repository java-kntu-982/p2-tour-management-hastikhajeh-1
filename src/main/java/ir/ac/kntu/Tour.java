package ir.ac.kntu;

import java.util.ArrayList;

public class Tour {
    private int duration;
    private int price;
    private int maxParticipant;
    private int minParticipant;
    private Area area;
    private String origin;
    private String destination;
    private boolean foreign;
    private boolean ByAirplane;
    private ArrayList<String> PlacesToVisit = new ArrayList<>(duration);
    private Date start;
    private Date end;
    private TourLeader tourLeader;
}

//
//    private static void printTourMenu() {
//        clearScreen();
//        System.out.println("1. Print all raw tours");
//        System.out.println("2. Print all planned tours");
//        System.out.println("3. Add a raw tour");
//        System.out.println("4. Plan a tour");
//        System.out.println("5. Edit a tour");
//        System.out.println("6. Remove a tour");
//        System.out.println("7. Search for a raw tour");
//        System.out.println("8. Search for a planned tour");
//        System.out.println("9. Back to main menu");
//        tourMenu();
//    }
//
//    private static void tourMenu() {
//        System.out.print("Enter your choice: ");
//        int choice = scanner.nextInt();
//        switch (choice) {
//            case 1:
//                break;
//            case 2:
//                break;
//            case 3:
//                break;
//            case 4:
//                break;
//            case 5:
//                break;
//            case 6:
//                break;
//            case 7:
//                break;
//            case 8:
//                break;
//            case 9:
//                break;
//            default:
//                tourMenu();
//        }
//    }
