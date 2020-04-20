package ir.ac.kntu;

import ir.ac.kntu.maputil.MapUtil;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

import static ir.ac.kntu.Menu.*;
import static ir.ac.kntu.TourLeaderManager.*;

public class Main {

    static Scanner scanner = new Scanner(System.in);
    static ArrayList<TourLeader> tourLeaders = new ArrayList<>();
    static ArrayList<Tour> rawTours = new ArrayList<>();
    static ArrayList<Tour> plannedTours = new ArrayList<>();
    static ArrayList<Area> areas = new ArrayList<>();
    static Date today;

    public static void main(String[] args) {

        setToday();

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

    public static int getInt(String string) {
        int integer = 0;
        do {
            try {
                System.out.print(string);
                integer = scanner.nextInt();
            } catch (InputMismatchException e) {
                System.out.println("Invalid input");
            }
            scanner.nextLine();
        } while (integer <= 0);
        return integer;
    }

    public static void menu() {
        int choice = getInt("Enter your choice: ");
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
                printMapMenu();
                break;
            case 5:
                setToday();
                break;
            default:
                menu();
        }
    }

    public static void mapMenu() {
        int choice = getInt("Enter your choice: ");
        switch (choice) {
            case 1:
                showOriginOnMap();
                break;
            case 2:
                showDestinationOnMap();
                break;
            case 3:
                showOriginAndDestinationOnMap();
                break;
            case 4:
                showCurrentLocation();
                break;
            case 5:
                showAllPlaces();
                break;
            case 6:
                showOneOnMap();
                break;
            case 7:
                showTwoOnMap();
                break;
            case 8:
                printMenu();
                break;
            default:
                mapMenu();
        }
    }

    private static void showAllPlaces() {
        System.out.print("enter the area's name: ");
        String name = scanner.nextLine();
        System.out.println("enter the first day");
        Date date = new Date(Date.setDate());
        for (Tour planned : plannedTours) {
            if (planned.getArea().getName().equalsIgnoreCase(name) && planned.getStart().equals(date) && planned.isForeign()) {
                for (String place : planned.getPlacesToVisit()) {
                    MapUtil.showMap(place);
                }
                break;
            }
        }
        pause();
        printMenu();
    }

    private static void showCurrentLocation() {
        System.out.print("enter the area's name: ");
        scanner.nextLine();
        String name = scanner.nextLine();
        System.out.println("enter the first day");
        Date date = new Date(Date.setDate());
        boolean flag = true;
        for (Tour planned : plannedTours) {
            if (planned.getArea().getName().equalsIgnoreCase(name) && planned.getStart().equals(date) && planned.isForeign()) {
                for (int i = 0; i < planned.getPlacesToVisit().size(); i++) {
                    if (today.equals(planned.getStart().nextDay(i))) {
                        MapUtil.showMap(planned.getPlacesToVisit().get(i));
                        flag = false;
                        break;
                    }
                }
                if (flag) {
                    MapUtil.showMap("Tehran");
                }
                break;
            } else {
                System.out.println("nothing found");
            }
        }
        pause();
        printMenu();
    }

    private static void showOriginAndDestinationOnMap() {
        System.out.print("Enter the area name: ");
        String name = scanner.nextLine();
        if (Tour.searchByArea(plannedTours,name) == null) {
            System.out.println("nothing found");
        } else {
            MapUtil.showMap(Tour.searchByArea(plannedTours,name).getOrigin(), Tour.searchByArea(plannedTours,name).getDestination());
        }
        pause();
        printMenu();
    }

    private static void showDestinationOnMap() {
        System.out.print("Enter the area name: ");
        String name = scanner.nextLine();
        if (Tour.searchByArea(plannedTours,name) == null) {
            System.out.println("nothing found");
        } else {
            MapUtil.showMap(Tour.searchByArea(plannedTours,name).getDestination());
        }
        pause();
        printMenu();
    }

    private static void showOriginOnMap() {
        System.out.print("Enter the area name: ");
        String name = scanner.nextLine();
        if (Tour.searchByArea(plannedTours,name) == null) {
            System.out.println("nothing found");
        } else {
            MapUtil.showMap(Tour.searchByArea(plannedTours,name).getOrigin());
        }
        pause();
        printMenu();
    }

    private static void showTwoOnMap() {
        System.out.print("Enter the first area: ");
        String name1 = scanner.nextLine();
        System.out.print("Enter the second area: ");
        String name2 = scanner.nextLine();
        MapUtil.showMap(name1, name2);
        pause();
        printMenu();
    }

    private static void showOneOnMap() {
        System.out.print("Enter the name: ");
        String name = scanner.nextLine();
        MapUtil.showMap(name);
        pause();
        printMenu();
    }

    public static void tourMenu() {
        int choice = getInt("Enter your choice: ");
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
                printPlannedTourSearch();
                break;
            case 10:
                printMenu();
                break;
            default:
                tourMenu();
        }
    }

    public static void plannedTourSearch() {
        int choice = getInt("Enter your choice: ");
        switch (choice) {
            case 1:
                searchPlannedTourByTourLeader();
                break;
            case 2:
                printSearchPlannedTourByDate();
                break;
            case 3:
                searchTourByDuration(plannedTours);
                break;
            case 4:
                searchTourByPlaces(plannedTours);
                break;
            case 5:
                searchTourByArea(plannedTours);
                break;
            case 6:
                searchByMinAndMaxParticipants(plannedTours);
                break;
            case 7:
                printSearchTourByPrice(plannedTours);
                break;
            case 8:
                printTourMenu();
                break;
            default:
                plannedTourSearch();
        }
    }

    public static void searchPlannedTourByDate() {
        int choice = getInt("Enter your choice: ");
        switch (choice) {
            case 1:
                searchPlannedTourAfterDate();
                break;
            case 2:
                searchPlannedTourBeforeDate();
                break;
            case 3:
                searchPlannedTourBetween2Date();
                break;
            default:
                searchPlannedTourByDate();
        }
    }

    private static void searchPlannedTourBetween2Date() {
        Date date1 = Date.setDate();
        Date date2 = Date.setDate();
        for (Tour tour : plannedTours) {
            if (tour.getStart().compareTo(date1) > 0 && tour.getStart().compareTo(date2) < 0) {
                System.out.println(tour.plannedTourToString());
                System.out.println("_____________");
            }
        }
        pause();
        printTourMenu();
    }

    private static void searchPlannedTourBeforeDate() {
        Date date = Date.setDate();
        for (Tour tour : plannedTours) {
            if (tour.getStart().compareTo(date) < 0) {
                System.out.println(tour.plannedTourToString());
                System.out.println("_____________");
            }
        }
        pause();
        printTourMenu();
    }

    private static void searchPlannedTourAfterDate() {
        Date date = Date.setDate();
        for (Tour tour : plannedTours) {
            if (tour.getStart().compareTo(date) > 0) {
                System.out.println(tour.plannedTourToString());
                System.out.println("_____________");
            }
        }
        pause();
        printTourMenu();
    }

    private static void searchPlannedTourByTourLeader() {
        System.out.print("Enter tour leader's full name: ");
        String name = scanner.nextLine();
        for (Tour tour : plannedTours) {
            if (tour.getTourLeader().getFullName().equalsIgnoreCase(name)) {
                System.out.println(tour.plannedTourToString());
                System.out.println("________________");
            }
        }
        pause();
        printTourMenu();
    }

    public static void rawTourSearch() {
        int choice = getInt("Enter your choice: ");
        switch (choice) {
            case 1:
                searchTourByDuration(rawTours);
                break;
            case 2:
                searchTourByPlaces(rawTours);
                break;
            case 3:
                searchTourByArea(rawTours);
                break;
            case 4:
                searchByMinAndMaxParticipants(rawTours);
                break;
            case 5:
                printSearchTourByPrice(rawTours);
                break;
            case 6:
                printMenu();
                break;
            default:
                rawTourSearch();
        }
    }

    public static void searchTourByPrice(ArrayList<Tour> tours) {
        int choice = getInt("Enter your choice: ");
        switch (choice) {
            case 1:
                searchTourByGivenPrice(tours);
                break;
            case 2:
                searchTourMoreExpensiveThanGivenPrice(tours);
                break;
            case 3:
                searchTourCheaperThanGivenPrice(tours);
                break;
            case 4:
                searchBetween2Price(tours);
                break;
            case 5:
                printTourMenu();
                break;
            default:
                searchTourByPrice(tours);
        }
    }

    private static void searchBetween2Price(ArrayList<Tour> tours) {
        int min = getInt("Enter minimum price: ");
        int max = getInt("Enter maximum price: ");
        if (Tour.searchBetween2Price(tours, min, max).size() == 0) {
            System.out.println("nothing found");
        } else {
            for (Tour tour : Tour.searchBetween2Price(tours, min, max)) {
                if (tour.isRaw()) {
                    System.out.println(tour.rawTourToString());
                } else {
                    System.out.println(tour.plannedTourToString());
                }
                System.out.println("________________");
            }
        }
        pause();
        printTourMenu();
    }

    private static void searchTourCheaperThanGivenPrice(ArrayList<Tour> tours) {
        int price = getInt("Enter price: ");
        if (Tour.searchCheaperPrice(tours, price).size() == 0) {
            System.out.println("nothing found");
        } else {
            for (Tour tour : Tour.searchCheaperPrice(tours, price)) {
                if (tour.isRaw()) {
                    System.out.println(tour.rawTourToString());
                } else {
                    System.out.println(tour.plannedTourToString());
                }
                System.out.println("________________");
            }
        }
        pause();
        printTourMenu();
    }

    private static void searchTourMoreExpensiveThanGivenPrice(ArrayList<Tour> tours) {
        int price = getInt("Enter price: ");
        if (Tour.searchMoreExpensivePrice(tours, price).size() == 0) {
            System.out.println("nothing found");
        } else {
            for (Tour tour : Tour.searchMoreExpensivePrice(tours, price)) {
                if (tour.isRaw()) {
                    System.out.println(tour.rawTourToString());
                } else {
                    System.out.println(tour.plannedTourToString());
                }
                System.out.println("________________");
            }
        }
        pause();
        printTourMenu();
    }

    private static void searchTourByGivenPrice(ArrayList<Tour> tours) {
        int price = getInt("Enter price: ");
        if (Tour.searchByPrice(tours, price).size() == 0) {
            System.out.println("nothing found");
        } else {
            for (Tour tour : Tour.searchByPrice(tours, price)) {
                if (tour.isRaw()) {
                    System.out.println(tour.rawTourToString());
                } else {
                    System.out.println(tour.plannedTourToString());
                }
                System.out.println("________________");
            }
        }
        pause();
        printTourMenu();
    }

    private static void searchByMinAndMaxParticipants(ArrayList<Tour> tours) {
        int min = getInt("Enter minimum participants: ");
        int max = getInt("Enter maximum participants: ");
        if (Tour.searchByMinAndMaxParticipants(tours, min, max).size() == 0) {
            System.out.println("nothing found");
        } else {
            for (Tour tour : Tour.searchByMinAndMaxParticipants(tours, min, max)) {
                if (tour.isRaw()) {
                    System.out.println(tour.rawTourToString());
                } else {
                    System.out.println(tour.plannedTourToString());
                }
                System.out.println("________________");
            }
        }
        pause();
        printTourMenu();
    }

    private static void searchTourByArea(ArrayList<Tour> tours) {
        System.out.print("Enter Area's name: ");
        String name = scanner.nextLine();
        if (Tour.searchByArea(tours, name) == null) {
            System.out.println("nothing found");
        } else {
            Tour tour = Tour.searchByArea(tours, name);
            if (tour.isRaw()) {
                System.out.println(tour.rawTourToString());
            } else {
                System.out.println(tour.plannedTourToString());
            }
        }
        pause();
        printTourMenu();
    }

    private static void searchTourByPlaces(ArrayList<Tour> tours) {
        System.out.print("Enter place: ");
        String place = scanner.nextLine();
        if (Tour.searchByPlace(tours, place) == null) {
            System.out.println("nothing found");
        } else {
            Tour tour = Tour.searchByPlace(tours, place);
            if (tour.isRaw()) {
                System.out.println(tour.rawTourToString());
            } else {
                System.out.println(tour.plannedTourToString());
            }
        }
        pause();
        printTourMenu();
    }

    private static void searchTourByDuration(ArrayList<Tour> tours) {
        int duration = getInt("Enter duration: ");
        if (Tour.searchTourByDuration(tours, duration).size() == 0) {
            System.out.println("nothing found");
        } else {
            for (Tour tour : Tour.searchTourByDuration(tours, duration)) {
                if (tour.isRaw()) {
                    System.out.println(tour.rawTourToString());
                } else {
                    System.out.println(tour.plannedTourToString());
                }
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
            Tour.searchByAreaAndDate(plannedTours, name, date).getTourLeader().getDot().remove(Tour.searchByAreaAndDate(plannedTours, name, date).getStart());
            Tour.searchByAreaAndDate(plannedTours, name, date).getTourLeader().getDot().remove(Tour.searchByAreaAndDate(plannedTours, name, date).getEnd());
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
            Tour.searchByAreaAndDate(plannedTours, name ,date).getTourLeader().getDot().remove(Tour.searchByAreaAndDate(plannedTours, name ,date).getStart());
            Tour.searchByAreaAndDate(plannedTours, name ,date).getTourLeader().getDot().remove(Tour.searchByAreaAndDate(plannedTours, name ,date).getEnd());
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

    public static void areaMenu() {
        int choice = getInt("Enter your choice: ");
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
        clearScreen();
        for (Area area : areas) {
            System.out.println(area.toString());
            System.out.println("---------------------");
        }
        pause();
        printAreaMenu();
    }

    public static void tourLeaderMenu() {
        int choice = getInt("Enter your choice: ");
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

    public static void tourLeaderSearchMenu() {
        int choice = getInt("Enter your choice: ");
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

    public static void searchByAgeMenu() {
        int choice = getInt("Enter your choice: ");
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
}
