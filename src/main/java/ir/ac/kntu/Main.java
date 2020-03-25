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
    static Date today;

    public static void main(String[] args) {

        setToday();

//        printMenu();

//        Good for showing one location
        MapUtil.showMap("Shiraz");
        MapUtil.showMap("esfehan");
        MapUtil.showMap("hafezie");
        MapUtil.showMap("@29.6257966,52.5563165,17z");
//        Good for showing two locations
//        MapUtil.showMap("Tehran","Dubai");
    }

    private static void setToday() {
        clearScreen();
        System.out.println("Enter today");
        today = new Date(Date.setDate());
        printMenu();
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
        System.out.println("5. change today's date");
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
            case 5:
                setToday();
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
        System.out.println("5. Back to menu");
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
                printSearchByAgeMenu();
                break;
            case 5:
                printTourLeaderMenu();
                break;
            default:
                tourLeaderSearchMenu();
        }
    }

    private static void printSearchByAgeMenu() {
        clearScreen();
        System.out.println("1. search for specific age");
        System.out.println("2. search for leaders older than given age");
        System.out.println("3. search for leaders younger than given age");
        System.out.println("4. search between 2 given ages");
        System.out.println("5. Go back to menu");
        searchByAgeMenu();
    }

    private static void searchByAgeMenu() {
        System.out.print("Enter your choice: ");
        int choice = scanner.nextInt();
        switch (choice) {
            case 1:
                searchByGivenAge();
                break;
            case 2:
                searchOlderThan();
                break;
            case 3:
                searchYoungerThan();
                break;
            case 4:
                searchBetween2Ages();
                break;
            case 5:
                printTourLeaderMenu();
                break;
            default:
                searchByAgeMenu();
        }
    }

    private static void searchBetween2Ages() {
        System.out.println("Enter age: ");
        System.out.print("from: ");
        int age1 = scanner.nextInt();
        System.out.print("to: ");
        int age2 = scanner.nextInt();
        for (TourLeader tourLeader: TourLeader.searchBetween2Ages(tourLeaders,age1,age2,today)) {
            System.out.println(tourLeader.toString());
            System.out.println("-------------");
        }
        pause();
        tourLeaderMenu();
    }

    private static void searchYoungerThan() {
        System.out.print("Enter the age: ");
        int age = scanner.nextInt();
        for (TourLeader tourLeader: TourLeader.searchYoungerThan(tourLeaders,age,today)) {
            System.out.println(tourLeader.toString());
            System.out.println("-------------");
        }
        pause();
        tourLeaderMenu();
    }

    private static void searchOlderThan() {
        System.out.print("Enter the age: ");
        int age = scanner.nextInt();
        for (TourLeader tourLeader: TourLeader.searchOlderThan(tourLeaders,age,today)) {
            System.out.println(tourLeader.toString());
            System.out.println("-------------");
        }
        pause();
        tourLeaderMenu();
    }

    private static void searchByGivenAge() {
        System.out.print("Enter the age: ");
        int age = scanner.nextInt();
        for (TourLeader tourLeader: TourLeader.searchByAge(tourLeaders,age,today)) {
            System.out.println(tourLeader.toString());
            System.out.println("-------------");
        }
        pause();
        tourLeaderMenu();
    }

    private static void searchTourLeaderByLastName() {
        clearScreen();
        System.out.print("Enter last name: ");
        String lastName = scanner.nextLine();
        if (TourLeader.searchByLastName(tourLeaders, lastName) == null) {
            System.out.println("no one found");
        } else {
            System.out.println(TourLeader.searchByLastName(tourLeaders, lastName).toString());
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
        if (TourLeader.searchByName(tourLeaders, firstName, lastName) == null) {
            System.out.println("no one found");
        } else {
            System.out.println(TourLeader.searchByName(tourLeaders, firstName, lastName).toString());
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
