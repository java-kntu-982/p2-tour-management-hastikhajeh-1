package ir.ac.kntu;

import ir.ac.kntu.maputil.MapUtil;

import java.util.ArrayList;
import java.util.InputMismatchException;
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
                System.out.println("Invalid intput");
            }
            scanner.nextLine();
        } while (integer <= 0);
        return integer;
    }

    private static void printMenu() {
        clearScreen();
        System.out.println("1. Tour leader menu");
        System.out.println("2. Tour menu");
        System.out.println("3. Area menu");
        System.out.println("4. Map menu");
        System.out.println("5. change today's date");
        menu();
    }

    private static void menu() {
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

    private static void printMapMenu() {
        clearScreen();
        System.out.println("1. show origin");
        System.out.println("2. show destination");
        System.out.println("3. show origin and destination");
        System.out.println("4. show the current area for the foreign tours");
        System.out.println("5. show all the places for foreign tours");
        System.out.println("6. show a city or country");
        System.out.println("7. show 2 cities");
        System.out.println("8. back to main menu");
        mapMenu();
    }

    private static void mapMenu() {
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

    private static void printPlannedTourSearch() {
        clearScreen();
        System.out.println("1. search by tour leader");
        System.out.println("2. search by date");
        System.out.println("3. search by duration");
        System.out.println("4. search by places to visit");
        System.out.println("5. search by area");
        System.out.println("6. search by min and man participants");
        System.out.println("7. search by price");
        System.out.println("8. back to tour menu");
        plannedTourSearch();
    }

    private static void plannedTourSearch() {
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

    private static void printSearchPlannedTourByDate() {
        clearScreen();
        System.out.println("1. after a date");
        System.out.println("2. before a date");
        System.out.println("3. between 2 dates");
        searchPlannedTourByDate();
    }

    private static void searchPlannedTourByDate() {
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

    private static void printSearchTourByPrice(ArrayList<Tour> tours) {
        clearScreen();
        System.out.println("1. search for a prince");
        System.out.println("2. search for more expensive tours");
        System.out.println("3. search for cheaper tours");
        System.out.println("4. search between 2 prices");
        System.out.println("5. back to tour menu");
        searchTourByPrice(tours);
    }

    private static void searchTourByPrice(ArrayList<Tour> tours) {
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

    private static void searchBetween2Ages() {
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

    private static void searchYoungerThan() {
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

    private static void searchOlderThan() {
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

    private static void searchByGivenAge() {
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

    private static void searchTourLeaderByArea() {
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

    private static void searchTourLeaderByLastName() {
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

    private static void searchTourLeaderByName() {
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
