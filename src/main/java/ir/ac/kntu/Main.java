package ir.ac.kntu;

import ir.ac.kntu.maputil.MapUtil;
import org.checkerframework.checker.units.qual.A;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Scanner;

public class Main {

    static Scanner scanner = new Scanner(System.in);
    static ArrayList<TourLeader> tourLeaders = new ArrayList<>();
    static ArrayList<Tour> tours = new ArrayList<>();
    static HashSet<Area> areas = new HashSet<>();

    public static void main(String[] args) {

//        printMenu();

//        Good for showing one location
        MapUtil.showMap("Shiraz");
        MapUtil.showMap("esfehan");
        MapUtil.showMap("hafezie");
        MapUtil.showMap("@29.6257966,52.5563165,17z");
//        Good for showing two locations
//        MapUtil.showMap("Tehran","Dubai");
    }

    private static void pause() {
        System.out.print("Press Enter");
        Scanner scanner = new Scanner(System.in);
        String pause = scanner.nextLine();
    }

    public static void clearScreen() {
        for(int i = 0; i < 50; i++) {
            System.out.println();
        }
    }

    private static void printMenu() {
        clearScreen();
        System.out.println("1. Tour leader menu");
        System.out.println("2. Tour menu");
        System.out.println("3. Region menu");
        System.out.println("4. Map menu");
        menu();
    }

    private static void menu() {
        System.out.print("Enter your choice: ");
        int choice = scanner.nextInt();
        switch (choice) {
            case 1:
                printTourLeaderMenu();
                break;
            case 2:
                break;
            case 3:
                break;
            case 4:
                break;
            default:
                menu();
        }


    }

    private static void printTourLeaderMenu() {
        clearScreen();
        System.out.println("1. Print all leaders");
        System.out.println("2. Add leader");
        System.out.println("3. Edit a leader");
        System.out.println("4. Search for a leader");
        System.out.println("5. Back to main menu");
        tourLeaderMenu();
    }

    private static void tourLeaderMenu() {
        System.out.print("Enter your choice: ");
        int choice = scanner.nextInt();
        switch (choice) {
            case 1:
                printAllTourLeaders();
                break;
            case 2:
                addTourLeader();
                break;
            case 3:
                editTourLeader();
                break;
            case 4:
                printTourLeaderSearchMenu();
                break;
            case 5:
                printMenu();
                break;
            default:
                tourLeaderMenu();
        }
    }

    private static void printTourLeaderSearchMenu() {
        clearScreen();
        System.out.println("1. Search with name");
        System.out.println("2. Search with last name");
        System.out.println("3. Search by province");
        System.out.println("4. Search by age");
        System.out.println("5. Back to main menu");
        tourLeaderSearchMenu();
    }

    private static void tourLeaderSearchMenu() {
        System.out.print("Enter your choice: ");
        int choice = scanner.nextInt();
        switch (choice) {
            case 1:
                searchTourLeaderByName();
                break;
            case 2:
                searchTourLeaderByLastName();
                break;
            case 3:
                break;
            case 4:
                break;
            case 5:
                break;
            default:
                tourLeaderSearchMenu();
        }
    }

    private static void searchTourLeaderByLastName() {
        clearScreen();
        System.out.print("Enter last name: ");
        String lastName = scanner.nextLine();
        for (TourLeader tourLeader: TourLeader.searchByLastName(tourLeaders, lastName)) {
            System.out.println(tourLeader.toString());
            System.out.println("------------------");
        }
        pause();
        tourLeaderMenu();
    }

    private static void searchTourLeaderByName() {
        clearScreen();
        System.out.print("Enter first name: ");
        String firstName = scanner.nextLine();
        System.out.print("Enter last name: ");
        String lastName = scanner.nextLine();
        for (TourLeader tourLeader: TourLeader.searchByName(tourLeaders, firstName, lastName)) {
            System.out.println(tourLeader.toString());
            System.out.println("------------------");
        }
        pause();
        tourLeaderMenu();
    }
    private static void editTourLeader() {
        clearScreen();
        System.out.print("Enter national code: ");
        String nationalCode = scanner.nextLine();
        TourLeader tourLeader = TourLeader.searchByNationalCode(tourLeaders, nationalCode);
        System.out.println(tourLeader.toString());
        tourLeaders.remove(tourLeader);
        TourLeader.addTourLeader(tourLeaders);
        System.out.println(tourLeaders.get(tourLeaders.size()-1).toString());
        pause();
        tourLeaderMenu();
    }

    private static void addTourLeader() {
        TourLeader.addTourLeader(tourLeaders);
        System.out.println(tourLeaders.get(tourLeaders.size() - 1).toString());
        pause();
        printTourLeaderMenu();
    }

    private static void printAllTourLeaders() {
        for (TourLeader tourLeader : tourLeaders) {
            System.out.println(tourLeader.toString());
            System.out.println("---------------------");
        }
        pause();
        printTourLeaderMenu();
    }
}
