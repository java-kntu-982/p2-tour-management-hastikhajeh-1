package ir.ac.kntu;

import ir.ac.kntu.maputil.MapUtil;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Scanner;

public class Main {

    static Scanner scanner = new Scanner(System.in);
    static ArrayList<TourLeader> tourLeaders = new ArrayList<>();
    static ArrayList<Tour> rawTours = new ArrayList<>();
    static ArrayList<Tour> plannedTours = new ArrayList<>();
    static ArrayList<Area> areas = new ArrayList<>();
    static Date today;

    public static void main(String[] args) {

        setToday();

//        Good for showing one location
//        MapUtil.showMap("Shiraz");
//        MapUtil.showMap("esfehan");
//        MapUtil.showMap("shiraz hafezie");
//        MapUtil.showMap("@29.6257966,52.5563165,17z");
//        Good for showing two locations
//        MapUtil.showMap("Tehran","Dubai");
    }

    private static void setToday() {
        clearScreen();
        System.out.println("Enter today");
        today = new Date(Date.setDate());
        printMenu();
    }

    public static void pause() {
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
                printTourMenu();
                break;
            case 3:
                printAreaMenu();
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

    private static void printTourMenu() {
        clearScreen();
        System.out.println("1. Print all raw tours");
        System.out.println("2. Print all planned tours");
        System.out.println("3. Add a raw tour");
        System.out.println("4. Plan a tour");
        System.out.println("5. Edit a raw tour");
        System.out.println("6. Edit a planned tour");
        System.out.println("7. Remove a tour");
        System.out.println("8. Search for a raw tour");
        System.out.println("9. Search for a planned tour");
        System.out.println("10. Back to main menu");
        tourMenu();
    }

    private static void tourMenu() {
        System.out.print("Enter your choice: ");
        int choice = scanner.nextInt();
        switch (choice) {
            case 1:
                printAllRawTours();
                break;
            case 2:
                printAllPlannedTours();
                break;
            case 3:
                addRawTour();
                break;
            case 4:
                planTour();
                break;
            case 5:
                editRawTour();
                break;
            case 6:
                editPlannedTour();
                break;
            case 7:
                removePlannedTour();
                break;
            case 8:
                printRawTourSearch();
                break;
            case 9:
                break;
            case 10:
                break;
            default:
                tourMenu();
        }
    }

    private static void printRawTourSearch() {
        clearScreen();
        System.out.println("1. search by duration");
        System.out.println("2. search by places to visit");
        System.out.println("3. search by area");
        System.out.println("4. search by min and man participants");
        System.out.println("5. search by price");
        System.out.println("6. back to tour menu");
        rawTourSearch();
    }

    private static void rawTourSearch() {
        System.out.print("Enter your choice: ");
        int choice = scanner.nextInt();
        switch (choice) {
            case 1:
                searchTourByDuration();
                break;
            case 2:
                searchTourByPlaces();
                break;
            case 3:
                searchTourByArea();
                break;
            case 4:
                searchByMinAndMaxParticipants();
                break;
            case 5:
                printSearchTourByPrice();
                break;
            case 6:
                printMenu();
                break;
            default:
                rawTourSearch();
        }
    }

    private static void printSearchTourByPrice() {
        clearScreen();
        System.out.println("1. search for a prince");
        System.out.println("2. search for more expensive tours");
        System.out.println("3. search for cheaper tours");
        System.out.println("4. search between 2 prices");
        System.out.println("5. back to tour menu");
        searchTourByPrice();
    }

    private static void searchTourByPrice() {
        System.out.print("Enter your choice: ");
        int choice = scanner.nextInt();
        switch (choice) {
            case 1:
                searchTourByGivenPrice();
                break;
            case 2:
                searchTourMoreExpensiveThanGivenPrice();
                break;
            case 3:
                searchTourCheaperThanGivenPrice();
                break;
            case 4:
                searchBetween2Price();
                break;
            case 5:
                printTourMenu();
                break;
            default:
                searchTourByPrice();
        }
    }

    private static void searchBetween2Price() {
        System.out.print("Enter minimum price: ");
        int min = scanner.nextInt();
        System.out.print("Enter maximum price: ");
        int max = scanner.nextInt();
        if (Tour.searchBetween2Price(rawTours, min, max).size() == 0) {
            System.out.println("nothing found");
        } else {
            for (Tour tour : Tour.searchBetween2Price(rawTours, min, max)) {
                System.out.println(tour.rawTourToString());
                System.out.println("________________");
            }
        }
        pause();
        printTourMenu();
    }

    private static void searchTourCheaperThanGivenPrice() {
        System.out.print("Enter price: ");
        int price = scanner.nextInt();
        if (Tour.searchCheaperPrice(rawTours, price).size() == 0) {
            System.out.println("nothing found");
        } else {
            for (Tour tour : Tour.searchCheaperPrice(rawTours, price)) {
                System.out.println(tour.rawTourToString());
                System.out.println("________________");
            }
        }
        pause();
        printTourMenu();
    }

    private static void searchTourMoreExpensiveThanGivenPrice() {
        System.out.print("Enter price: ");
        int price = scanner.nextInt();
        if (Tour.searchMoreExpensivePrice(rawTours, price).size() == 0) {
            System.out.println("nothing found");
        } else {
            for (Tour tour : Tour.searchMoreExpensivePrice(rawTours, price)) {
                System.out.println(tour.rawTourToString());
                System.out.println("________________");
            }
        }
        pause();
        printTourMenu();
    }

    private static void searchTourByGivenPrice() {
        System.out.print("Enter price: ");
        int price = scanner.nextInt();
        if (Tour.searchByPrice(rawTours, price).size() == 0) {
            System.out.println("nothing found");
        } else {
            for (Tour tour : Tour.searchByPrice(rawTours, price)) {
                System.out.println(tour.rawTourToString());
                System.out.println("________________");
            }
        }
        pause();
        printTourMenu();
    }

    private static void searchByMinAndMaxParticipants() {
        System.out.print("Enter minimum participants: ");
        int min = scanner.nextInt();
        System.out.print("Enter maximum participants: ");
        int max = scanner.nextInt();
        if (Tour.searchByMinAndMaxParticipants(rawTours, min, max).size() == 0) {
            System.out.println("nothing found");
        } else {
            for (Tour tour : Tour.searchByMinAndMaxParticipants(rawTours, min, max)) {
                System.out.println(tour.rawTourToString());
                System.out.println("________________");
            }
        }
        pause();
        printTourMenu();
    }

    private static void searchTourByArea() {
        System.out.print("Enter Area's name: ");
        String name = scanner.nextLine();
        if (Tour.searchByArea(rawTours, name) == null) {
            System.out.println("nothing found");
        } else {
            System.out.println(Tour.searchByArea(rawTours, name).rawTourToString());
        }
        pause();
        printTourMenu();
    }

    private static void searchTourByPlaces() {
        System.out.print("Enter place: ");
        String place = scanner.nextLine();
        if (Tour.searchByPlace(rawTours, place) == null) {
            System.out.println("nothing found");
        } else {
            System.out.println(Tour.searchByPlace(rawTours, place).rawTourToString());
        }
        pause();
        printTourMenu();
    }

    private static void searchTourByDuration() {
        System.out.print("Enter duration: ");
        int duration = scanner.nextInt();
        if (Tour.searchTourByDuration(rawTours, duration).size() == 0) {
            System.out.println("nothing found");
        } else {
            for (Tour tour : Tour.searchTourByDuration(rawTours, duration)) {
                System.out.println(tour.rawTourToString());
                System.out.println("________________");
            }
        }
        pause();
        printTourMenu();
    }

    private static void removePlannedTour() {
        System.out.print("Enter tour's name: ");
        String name = scanner.nextLine();
        System.out.println("tour starts from: ");
        Date date = Date.setDate();
        if (Tour.searchByAreaAndDate(plannedTours, name, date) == null) {
            System.out.println("no tour found");
        } else {
            plannedTours.remove(Tour.searchByAreaAndDate(plannedTours, name, date));
            System.out.println("tour is removed");
        }
        pause();
        printTourMenu();
    }

    private static void editPlannedTour() {
        System.out.print("Enter tour's name: ");
        String name = scanner.nextLine();
        System.out.println("tour starts from: ");
        Date date = Date.setDate();
        if (Tour.searchByAreaAndDate(plannedTours, name, date) == null) {
            System.out.println("no tour found");
        } else {
            System.out.println(Tour.searchByAreaAndDate(plannedTours, name ,date).plannedTourToString());
            plannedTours.remove(Tour.searchByAreaAndDate(plannedTours, name, date));
            Tour.addPlannedTour(plannedTours, rawTours);
            System.out.println(plannedTours.get(rawTours.size()-1).plannedTourToString());
        }
        pause();
        printTourMenu();
    }

    private static void editRawTour() {
        System.out.print("Enter tour's name: ");
        String name = scanner.nextLine();
        if (Tour.searchByArea(rawTours, name) == null) {
            System.out.println("no tour found");
        } else {
            System.out.println(Tour.searchByArea(rawTours, name).rawTourToString());
            rawTours.remove(Tour.searchByArea(rawTours, name));
            Tour.addRawTour(rawTours);
            System.out.println(rawTours.get(rawTours.size()-1).rawTourToString());
        }
        pause();
        printTourMenu();
    }

    private static void planTour() {
        Tour.addPlannedTour(plannedTours, rawTours);
        System.out.println(plannedTours.get(plannedTours.size()-1).plannedTourToString());
        pause();
        printTourMenu();
    }

    private static void addRawTour() {
        Tour.addRawTour(rawTours);
        System.out.println(rawTours.get(rawTours.size()-1).rawTourToString());
        pause();
        printTourMenu();
    }

    private static void printAllPlannedTours() {
        for (Tour plannedTour : plannedTours) {
            System.out.println(plannedTour.plannedTourToString());
            System.out.println("---------------------");
        }
        pause();
        printTourMenu();
    }

    private static void printAllRawTours() {
        for (Tour rawTour : rawTours) {
            System.out.println(rawTour.rawTourToString());
            System.out.println("---------------------");
        }
        pause();
        printTourMenu();
    }

    private static void printAreaMenu() {
        clearScreen();
        System.out.println("1. Print all defined areas");
        System.out.println("2. Add an area");
        System.out.println("3. Edit an area");
        System.out.println("4. Remove an area");
        System.out.println("5. go back to main menu");
        areaMenu();
    }

    private static void areaMenu() {
        System.out.print("Enter your choice: ");
        int choice = scanner.nextInt();
        switch (choice) {
            case 1:
                printAllAreas();
                break;
            case 2:
                addArea();
                break;
            case 3:
                editArea();
                break;
            case 4:
                removeArea();
                break;
            case 5:
                printMenu();
                break;
            default:
                areaMenu();
        }
    }

    private static void removeArea() {
        System.out.print("Enter areas name: ");
        String name = scanner.nextLine();
        if (Area.searchByName(areas, name) == null) {
            System.out.println("no area found");
        } else {
            System.out.println(Area.searchByName(areas, name).toString());
            areas.remove(Area.searchByName(areas, name));
            System.out.println("area is removed");
        }
        pause();
        printAreaMenu();
    }

    private static void editArea() {
        System.out.print("Enter areas name: ");
        String name = scanner.nextLine();
        if (Area.searchByName(areas, name) == null) {
            System.out.println("no area found");
        } else {
            System.out.println(Area.searchByName(areas, name).toString());
            areas.remove(Area.searchByName(areas, name));
            Area.addArea(areas);
            System.out.println(areas.get(areas.size()-1).toString());
        }
        pause();
        printAreaMenu();
    }

    private static void addArea() {
        Area.addArea(areas);
        System.out.println(areas.get(areas.size()-1).toString());
        pause();
        printAreaMenu();
    }

    private static void printAllAreas() {
        for (Area area : areas) {
            System.out.println(area.toString());
            System.out.println("---------------------");
        }
        pause();
        printAreaMenu();
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
                searchTourLeaderByArea();
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

    private static void searchYoungerThan() {
        System.out.print("Enter the age: ");
        int age = scanner.nextInt();
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

    private static void searchOlderThan() {
        System.out.print("Enter the age: ");
        int age = scanner.nextInt();
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

    private static void searchByGivenAge() {
        clearScreen();
        System.out.print("Enter the age: ");
        int age = scanner.nextInt();
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

    private static void searchTourLeaderByArea() {
        System.out.print("Enter the areas name: ");
        scanner.nextLine();
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

    private static void searchTourLeaderByLastName() {
        clearScreen();
        System.out.print("Enter last name: ");
        scanner.nextLine();
        String lastName = scanner.nextLine();
        if (TourLeader.searchByLastName(tourLeaders, lastName) == null) {
            System.out.println("no one found");
        } else {
            System.out.println(TourLeader.searchByLastName(tourLeaders, lastName).toString());
        }
        pause();
        printTourLeaderMenu();
    }

    private static void searchTourLeaderByName() {
        clearScreen();
        System.out.print("Enter first name: ");
        scanner.nextLine();
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

    private static void editTourLeader() {
        clearScreen();
        System.out.print("Enter national code: ");
        scanner.nextLine();
        String nationalCode = scanner.nextLine();
        TourLeader tourLeader = TourLeader.searchByNationalCode(tourLeaders, nationalCode);
        System.out.println(tourLeader.toString());
        tourLeaders.remove(tourLeader);
        TourLeader.addTourLeader(tourLeaders);
        System.out.println(tourLeaders.get(tourLeaders.size()-1).toString());
        pause();
        printTourLeaderMenu();
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
