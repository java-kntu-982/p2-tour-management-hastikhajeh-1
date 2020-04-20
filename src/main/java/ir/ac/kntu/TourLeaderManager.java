package ir.ac.kntu;

import static ir.ac.kntu.Main.*;
import static ir.ac.kntu.Menu.printTourLeaderMenu;

public class TourLeaderManager {

    public static void searchBetween2Ages() {
        System.out.println("Enter age: ");
        int age1 = getInt("from: ");
        int age2 = getInt("to: ");
        if (TourLeader.searchBetween2Ages(tourLeaders, age1, age2, today).size() == 0) {
            System.out.println("no one found");
        } else {
            for (TourLeader tourLeader : TourLeader.searchBetween2Ages(tourLeaders, age1, age2, today)) {
                System.out.println(tourLeader.toString());
                System.out.println("-------------");
            }
        }
        pause();
        printTourLeaderMenu();
    }

    public static void searchYoungerThan() {
        int age = getInt("Enter the age: ");
        if (TourLeader.searchYoungerThan(tourLeaders, age, today).size() == 0) {
            System.out.println("no one found");
        } else {
            for (TourLeader tourLeader : TourLeader.searchYoungerThan(tourLeaders, age, today)) {
                System.out.println(tourLeader.toString());
                System.out.println("-------------");
            }
        }
        pause();
        printTourLeaderMenu();
    }

    public static void searchOlderThan() {
        int age = getInt("Enter the age: ");
        if (TourLeader.searchOlderThan(tourLeaders, age, today).size() == 0) {
            System.out.println("no one found");
        } else {
            for (TourLeader tourLeader : TourLeader.searchOlderThan(tourLeaders, age, today)) {
                System.out.println(tourLeader.toString());
                System.out.println("-------------");
            }
        }
        pause();
        printTourLeaderMenu();
    }

    public static void searchByGivenAge() {
        clearScreen();
        int age = getInt("Enter the age: ");
        if (TourLeader.searchByAge(tourLeaders, age, today).size() == 0) {
            System.out.println("no one found");
        } else {
            for (TourLeader tourLeader : TourLeader.searchByAge(tourLeaders, age, today)) {
                System.out.println(tourLeader.toString());
                System.out.println("-------------");
            }
        }
        pause();
        printTourLeaderMenu();
    }

    public static void searchTourLeaderByArea() {
        System.out.print("Enter the areas name: ");
        String area = scanner.nextLine();
        if (TourLeader.searchByArea(tourLeaders,area).size() == 0) {
            System.out.println("no one found");
        } else {
            for (TourLeader tourLeader : TourLeader.searchByArea(tourLeaders, area)) {
                System.out.println(tourLeader.toString());
                System.out.println("-------------");
            }
        }
        pause();
        printTourLeaderMenu();
    }

    public static void searchTourLeaderByLastName() {
        System.out.print("Enter last name: ");
        String lastName = scanner.nextLine();
        if (TourLeader.searchByLastName(tourLeaders, lastName) == null) {
            System.out.println("no one found");
        } else {
            System.out.println(TourLeader.searchByLastName(tourLeaders, lastName).toString());
        }
        pause();
        printTourLeaderMenu();
    }

    public static void searchTourLeaderByName() {
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
        printTourLeaderMenu();
    }

    public static void editTourLeader() {
        clearScreen();
        System.out.print("Enter national code: ");
        String nationalCode = scanner.nextLine();
        TourLeader tourLeader = TourLeader.searchByNationalCode(tourLeaders, nationalCode);
        System.out.println(tourLeader.toString());
        tourLeaders.remove(tourLeader);
        TourLeader.addTourLeader(tourLeaders);
        System.out.println(tourLeaders.get(tourLeaders.size()-1).toString());
        pause();
        printTourLeaderMenu();
    }

    public static void addTourLeader() {
        TourLeader.addTourLeader(tourLeaders);
        System.out.println(tourLeaders.get(tourLeaders.size() - 1).toString());
        pause();
        printTourLeaderMenu();
    }

    public static void printAllTourLeaders() {
        for (TourLeader tourLeader : tourLeaders) {
            System.out.println(tourLeader.toString());
            System.out.println("---------------------");
        }
        pause();
        printTourLeaderMenu();
    }
}
