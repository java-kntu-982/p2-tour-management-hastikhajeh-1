package ir.ac.kntu;

import java.util.Scanner;

import static ir.ac.kntu.Main.*;
import static ir.ac.kntu.Menu.printTourMenu;

public class PlannedTourManager {
    public static Scanner scanner = new Scanner(System.in);

    public static void searchPlannedTourBetween2Date() {
        Date date1 = Date.setDate();
        Date date2 = Date.setDate();
        for (PlannedTour tour : plannedTours) {
            if (tour.getStart().compareTo(date1) > 0 && tour.getStart().compareTo(date2) < 0) {
                System.out.println(tour.ToString());
                System.out.println("_____________");
            }
        }
        pause();
        printTourMenu();
    }

    public static void searchPlannedTourBeforeDate() {
        Date date = Date.setDate();
        for (PlannedTour tour : plannedTours) {
            if (tour.getStart().compareTo(date) < 0) {
                System.out.println(tour.toString());
                System.out.println("_____________");
            }
        }
        pause();
        printTourMenu();
    }

    public static void searchPlannedTourAfterDate() {
        Date date = Date.setDate();
        for (PlannedTour tour : plannedTours) {
            if (tour.getStart().compareTo(date) > 0) {
                System.out.println(tour.toString());
                System.out.println("_____________");
            }
        }
        pause();
        printTourMenu();
    }

    public static void searchPlannedTourByTourLeader() {
        System.out.print("Enter tour leader's full name: ");
        String name = scanner.nextLine();
        for (PlannedTour tour : plannedTours) {
            if (tour.getTourLeader().getFullName().equalsIgnoreCase(name)) {
                System.out.println(tour.toString());
                System.out.println("________________");
            }
        }
        pause();
        printTourMenu();
    }

    public static void removePlannedTour() {
        System.out.print("Enter tour's name: ");
        String name = scanner.nextLine();
        System.out.println("tour starts from: ");
        Date date = Date.setDate();
        if (PlannedTour.searchByAreaAndDate(plannedTours, name, date) == null) {
            System.out.println("no tour found");
        } else {
            plannedTours.remove(PlannedTour.searchByAreaAndDate(plannedTours, name, date));
            PlannedTour.searchByAreaAndDate(plannedTours, name, date).getTourLeader().getDot().remove(PlannedTour.searchByAreaAndDate(plannedTours, name, date).getStart());
            PlannedTour.searchByAreaAndDate(plannedTours, name, date).getTourLeader().getDot().remove(PlannedTour.searchByAreaAndDate(plannedTours, name, date).getEnd());
            System.out.println("tour is removed");
        }
        pause();
        printTourMenu();
    }

    public static void editPlannedTour() {
        System.out.print("Enter tour's name: ");
        String name = scanner.nextLine();
        System.out.println("tour starts from: ");
        Date date = Date.setDate();
        if (PlannedTour.searchByAreaAndDate(plannedTours, name, date) == null) {
            System.out.println("no tour found");
        } else {
            System.out.println(PlannedTour.searchByAreaAndDate(plannedTours, name ,date).toString());
            PlannedTour.searchByAreaAndDate(plannedTours, name ,date).getTourLeader().getDot().remove(PlannedTour.searchByAreaAndDate(plannedTours, name ,date).getStart());
            PlannedTour.searchByAreaAndDate(plannedTours, name ,date).getTourLeader().getDot().remove(PlannedTour.searchByAreaAndDate(plannedTours, name ,date).getEnd());
            plannedTours.remove(PlannedTour.searchByAreaAndDate(plannedTours, name, date));
            PlannedTour.addPlannedTour(plannedTours, rawTours);
            System.out.println(plannedTours.get(rawTours.size()-1).toString());
        }
        pause();
        printTourMenu();
    }

    public static void planTour() {
        PlannedTour.addPlannedTour(plannedTours, rawTours);
        System.out.println(plannedTours.get(plannedTours.size()-1).toString());
        pause();
        printTourMenu();
    }

    public static void printAllPlannedTours() {
        for (Tour plannedTour : plannedTours) {
            System.out.println(plannedTour.toString());
            System.out.println("---------------------");
        }
        pause();
        printTourMenu();
    }
}
