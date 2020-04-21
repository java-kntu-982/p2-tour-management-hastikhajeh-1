package ir.ac.kntu;

import java.util.ArrayList;
import java.util.Scanner;

import static ir.ac.kntu.Main.*;
import static ir.ac.kntu.Menu.printTourMenu;

public class TourManager {
    private static Scanner scanner = new Scanner(System.in);

    public static void searchBetween2Price(ArrayList<Tour> tours) {
        int min = getInt("Enter minimum price: ");
        int max = getInt("Enter maximum price: ");
        if (TourMethods.searchBetween2Price(tours, min, max).size() == 0) {
            System.out.println("nothing found");
        } else {
            for (Tour tour : TourMethods.searchBetween2Price(tours, min, max)) {
                System.out.println(tour.toString());
                System.out.println("________________");
            }
        }
        pause();
        printTourMenu();
    }

    public static void searchTourCheaperThanGivenPrice(ArrayList<Tour> tours) {
        int price = getInt("Enter price: ");
        if (TourMethods.searchCheaperPrice(tours, price).size() == 0) {
            System.out.println("nothing found");
        } else {
            for (Tour tour : TourMethods.searchCheaperPrice(tours, price)) {
                System.out.println(tour.toString());
                System.out.println("________________");
            }
        }
        pause();
        printTourMenu();
    }

    public static void searchTourMoreExpensiveThanGivenPrice(ArrayList<Tour> tours) {
        int price = getInt("Enter price: ");
        if (TourMethods.searchMoreExpensivePrice(tours, price).size() == 0) {
            System.out.println("nothing found");
        } else {
            for (Tour tour : TourMethods.searchMoreExpensivePrice(tours, price)) {
                System.out.println(tour.toString());
                System.out.println("________________");
            }
        }
        pause();
        printTourMenu();
    }

    public static void searchTourByGivenPrice(ArrayList<Tour> tours) {
        int price = getInt("Enter price: ");
        if (TourMethods.searchByPrice(tours, price).size() == 0) {
            System.out.println("nothing found");
        } else {
            for (Tour tour : TourMethods.searchByPrice(tours, price)) {
                System.out.println(tour.toString());
                System.out.println("________________");
            }
        }
        pause();
        printTourMenu();
    }

    public static void searchByMinAndMaxParticipants(ArrayList<Tour> tours) {
        int min = getInt("Enter minimum participants: ");
        int max = getInt("Enter maximum participants: ");
        if (TourMethods.searchByMinAndMaxParticipants(tours, min, max).size() == 0) {
            System.out.println("nothing found");
        } else {
            for (Tour tour : TourMethods.searchByMinAndMaxParticipants(tours, min, max)) {
                System.out.println(tour.toString());
                System.out.println("________________");
            }
        }
        pause();
        printTourMenu();
    }

    public static void searchTourByArea(ArrayList<Tour> tours) {
        System.out.print("Enter Area's name: ");
        String name = scanner.nextLine();
        if (TourMethods.searchByArea(tours, name) == null) {
            System.out.println("nothing found");
        } else {
            Tour tour = TourMethods.searchByArea(tours, name);
            System.out.println(tour.toString());
        }
        pause();
        printTourMenu();
    }

    public static void searchTourByPlaces(ArrayList<Tour> tours) {
        System.out.print("Enter place: ");
        String place = scanner.nextLine();
        if (TourMethods.searchByPlace(tours, place) == null) {
            System.out.println("nothing found");
        } else {
            Tour tour = TourMethods.searchByPlace(tours, place);
            System.out.println(tour.toString());
        }
        pause();
        printTourMenu();
    }

    public static void searchTourByDuration(ArrayList<Tour> tours) {
        int duration = getInt("Enter duration: ");
        if (TourMethods.searchTourByDuration(tours, duration).size() == 0) {
            System.out.println("nothing found");
        } else {
            for (Tour tour : TourMethods.searchTourByDuration(tours, duration)) {
                System.out.println(tour.toString());
                System.out.println("________________");
            }
        }
        pause();
        printTourMenu();
    }

    public static void editRawTour() {
        System.out.print("Enter tour's name: ");
        String name = scanner.nextLine();
        if (TourMethods.searchByArea(rawTours, name) == null) {
            System.out.println("no tour found");
        } else {
            System.out.println(TourMethods.searchByArea(rawTours, name).toString());
            rawTours.remove(TourMethods.searchByArea(rawTours, name));
            Tour.addRawTour(rawTours);
            System.out.println(rawTours.get(rawTours.size()-1).toString());
        }
        pause();
        printTourMenu();
    }

    public static void addRawTour() {
        Tour.addRawTour(rawTours);
        System.out.println(rawTours.get(rawTours.size()-1).toString());
        pause();
        printTourMenu();
    }

    public static void printAllRawTours() {
        for (Tour rawTour : rawTours) {
            System.out.println(rawTour.toString());
            System.out.println("---------------------");
        }
        pause();
        printTourMenu();
    }

}
