package ir.ac.kntu;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

import static ir.ac.kntu.AreaManager.*;
import static ir.ac.kntu.MapManager.*;
import static ir.ac.kntu.Menu.*;
import static ir.ac.kntu.PlannedTourManager.*;
import static ir.ac.kntu.TourLeaderManager.*;
import static ir.ac.kntu.TourManager.*;

public class Main {

    static Scanner scanner = new Scanner(System.in);
    static ArrayList<TourLeader> tourLeaders = new ArrayList<>();
    static ArrayList<Tour> rawTours = new ArrayList<>();
    static ArrayList<PlannedTour> plannedTours = new ArrayList<>();
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
                searchTourByDuration(PlannedTour.castPlannedTORaw());
                break;
            case 4:
                searchTourByPlaces(PlannedTour.castPlannedTORaw());
                break;
            case 5:
                searchTourByArea(PlannedTour.castPlannedTORaw());
                break;
            case 6:
                searchByMinAndMaxParticipants(PlannedTour.castPlannedTORaw());
                break;
            case 7:
                printSearchTourByPrice(PlannedTour.castPlannedTORaw());
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
