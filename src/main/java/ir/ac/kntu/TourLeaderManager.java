package ir.ac.kntu;

import static ir.ac.kntu.Main.*;
import static ir.ac.kntu.Menu.printTourLeaderMenu;

public class TourLeaderManager {

    public static void searchBetween2Ages() {
        System.out.println("Enter age: ");
        int age1 = getInt("from: ");
        int age2 = getInt("to: ");
        if (TourLeaderMethods.searchBetween2Ages(tourLeaders, age1, age2, today).size() == 0) {
            System.out.println("no one found");
        } else {
            for (TourLeader tourLeader : TourLeaderMethods.searchBetween2Ages(tourLeaders, age1, age2, today)) {
                System.out.println(tourLeader.toString());
                System.out.println("-------------");
            }
        }
        pause();
        printTourLeaderMenu();
    }

    public static void searchYoungerThan() {
        int age = getInt("Enter the age: ");
        if (TourLeaderMethods.searchYoungerThan(tourLeaders, age, today).size() == 0) {
            System.out.println("no one found");
        } else {
            for (TourLeader tourLeader : TourLeaderMethods.searchYoungerThan(tourLeaders, age, today)) {
                System.out.println(tourLeader.toString());
                System.out.println("-------------");
            }
        }
        pause();
        printTourLeaderMenu();
    }

    public static void searchOlderThan() {
        int age = getInt("Enter the age: ");
        if (TourLeaderMethods.searchOlderThan(tourLeaders, age, today).size() == 0) {
            System.out.println("no one found");
        } else {
            for (TourLeader tourLeader : TourLeaderMethods.searchOlderThan(tourLeaders, age, today)) {
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
        if (TourLeaderMethods.searchByAge(tourLeaders, age, today).size() == 0) {
            System.out.println("no one found");
        } else {
            for (TourLeader tourLeader : TourLeaderMethods.searchByAge(tourLeaders, age, today)) {
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
        if (TourLeaderMethods.searchByArea(tourLeaders,area).size() == 0) {
            System.out.println("no one found");
        } else {
            for (TourLeader tourLeader : TourLeaderMethods.searchByArea(tourLeaders, area)) {
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
        if (TourLeaderMethods.searchByLastName(tourLeaders, lastName) == null) {
            System.out.println("no one found");
        } else {
            System.out.println(TourLeaderMethods.searchByLastName(tourLeaders, lastName).toString());
        }
        pause();
        printTourLeaderMenu();
    }

    public static void searchTourLeaderByName() {
        System.out.print("Enter first name: ");
        String firstName = scanner.nextLine();
        System.out.print("Enter last name: ");
        String lastName = scanner.nextLine();
        if (TourLeaderMethods.searchByName(tourLeaders, firstName, lastName) == null) {
            System.out.println("no one found");
        } else {
            System.out.println(TourLeaderMethods.searchByName(tourLeaders, firstName, lastName).toString());
        }
        pause();
        printTourLeaderMenu();
    }

    public static void editTourLeader() {
        if (access.getAccesslvl().equals("d")||access.getAccesslvl().equals("c")||access.getAccesslvl().equals("b")) {
            System.out.println("you dont have permission");
        } else {
            System.out.print("Enter national code: ");
            String nationalCode = scanner.nextLine();
            if (TourLeaderMethods.searchByNationalCode(tourLeaders, nationalCode) == null) {
                System.out.println("no one found");
            } else {
                TourLeader tourLeader = TourLeaderMethods.searchByNationalCode(tourLeaders, nationalCode);
                System.out.println(tourLeader.toString());
                TourLeader.addTourLeader(tourLeaders);
                tourLeader.setFirstName(tourLeaders.get(tourLeaders.size() - 1).firstName);
                tourLeader.setLastName(tourLeaders.get(tourLeaders.size() - 1).lastName);
                tourLeader.setDot(tourLeaders.get(tourLeaders.size() - 1).dot);
                tourLeader.setSingle(tourLeaders.get(tourLeaders.size() - 1).single);
                tourLeader.setDOE(tourLeaders.get(tourLeaders.size() - 1).doe);
                tourLeader.setDOB(tourLeaders.get(tourLeaders.size() - 1).dob);
                tourLeader.setNationalCode(tourLeaders.get(tourLeaders.size() - 1).nationalCode);
                tourLeader.setAreas(tourLeaders.get(tourLeaders.size() - 1).areas);
                tourLeaders.remove(tourLeaders.get(tourLeaders.size() - 1));
                System.out.println(tourLeader.toString());
            }
        }
        pause();
        printTourLeaderMenu();
    }

    public static void addTourLeader() {
        if (access.getAccesslvl().equals("d")||access.getAccesslvl().equals("c")||access.getAccesslvl().equals("b")) {
            System.out.println("you dont have permission");
        } else {
            TourLeader.addTourLeader(tourLeaders);
            System.out.println(tourLeaders.get(tourLeaders.size() - 1).toString());
        }
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
