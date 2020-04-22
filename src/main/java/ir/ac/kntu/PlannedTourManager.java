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
                System.out.println(tour.toString());
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
        if (access.getAccesslvl().equals("d")||access.getAccesslvl().equals("c")||access.getAccesslvl().equals("b")) {
            System.out.println("you dont have permission");
        } else {
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
        }
        pause();
        printTourMenu();
    }

    public static void editPlannedTour() {
        if (access.getAccesslvl().equals("d")||access.getAccesslvl().equals("c")) {
            System.out.println("you dont have permission");
        } else {
            System.out.print("Enter tour's name: ");
            String name = scanner.nextLine();
            System.out.println("tour starts from: ");
            Date date = Date.setDate();
            if (PlannedTour.searchByAreaAndDate(plannedTours, name, date) == null) {
                System.out.println("no tour found");
            } else {
                System.out.println(PlannedTour.searchByAreaAndDate(plannedTours, name, date).toString());
                PlannedTour.searchByAreaAndDate(plannedTours, name, date).getTourLeader().getDot().remove(PlannedTour.searchByAreaAndDate(plannedTours, name, date).getStart());
                PlannedTour.searchByAreaAndDate(plannedTours, name, date).getTourLeader().getDot().remove(PlannedTour.searchByAreaAndDate(plannedTours, name, date).getEnd());
                PlannedTour plannedTour = PlannedTour.searchByAreaAndDate(plannedTours, name, date);
                PlannedTour.addPlannedTour(plannedTours, rawTours);
                plannedTour.setArea(plannedTours.get(rawTours.size() - 1).getArea());
                plannedTour.setTourLeader(plannedTours.get(rawTours.size() - 1).getTourLeader());
                plannedTour.setEnd(plannedTours.get(rawTours.size() - 1).getEnd());
                plannedTour.setStart(plannedTours.get(rawTours.size() - 1).getStart());
                plannedTour.setDestination(plannedTours.get(rawTours.size() - 1).getDestination());
                plannedTour.setOrigin(plannedTours.get(rawTours.size() - 1).getOrigin());
                plannedTour.setByAirplane(plannedTours.get(rawTours.size() - 1).isByAirplane());
                plannedTour.setDuration(plannedTours.get(rawTours.size() - 1).getDuration());
                plannedTour.setForeign(plannedTours.get(rawTours.size() - 1).isForeign());
                plannedTour.setMaxParticipant(plannedTours.get(rawTours.size() - 1).getMaxParticipant());
                plannedTour.setMinParticipant(plannedTours.get(rawTours.size() - 1).getMinParticipant());
                plannedTour.setPrice(plannedTours.get(rawTours.size() - 1).getPrice());
                plannedTour.setPlacesToVisit(plannedTours.get(rawTours.size() - 1).getPlacesToVisit());
                plannedTours.remove(plannedTours.get(rawTours.size() - 1));
                System.out.println(plannedTour.toString());
            }
        }
        pause();
        printTourMenu();
    }

    public static void planTour() {
        if (access.getAccesslvl().equals("d")||access.getAccesslvl().equals("c")) {
            System.out.println("you dont have permission");
        } else {
            PlannedTour.addPlannedTour(plannedTours, rawTours);
            System.out.println(plannedTours.get(plannedTours.size() - 1).toString());
        }
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
