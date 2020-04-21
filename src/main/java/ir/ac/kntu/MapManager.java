package ir.ac.kntu;

import ir.ac.kntu.maputil.MapUtil;

import java.util.Scanner;

import static ir.ac.kntu.Main.*;
import static ir.ac.kntu.Menu.printMenu;

public class MapManager {
    public static Scanner scanner = new Scanner(System.in);

    public static void showAllPlaces() {
        System.out.print("enter the area's name: ");
        String name = scanner.nextLine();
        System.out.println("enter the first day");
        Date date = new Date(Date.setDate());
        for (PlannedTour planned : plannedTours) {
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

    public static void showCurrentLocation() {
        System.out.print("enter the area's name: ");
        scanner.nextLine();
        String name = scanner.nextLine();
        System.out.println("enter the first day");
        Date date = new Date(Date.setDate());
        boolean flag = true;
        for (PlannedTour planned : plannedTours) {
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

    public static void showOriginAndDestinationOnMap() {
        System.out.print("Enter the area name: ");
        String name = scanner.nextLine();
        if (TourMethods.searchByArea(PlannedTour.castPlannedTORaw(),name) == null) {
            System.out.println("nothing found");
        } else {
            MapUtil.showMap(TourMethods.searchByArea(PlannedTour.castPlannedTORaw(),name).getOrigin(), TourMethods.searchByArea(PlannedTour.castPlannedTORaw(),name).getDestination());
        }
        pause();
        printMenu();
    }

    public static void showDestinationOnMap() {
        System.out.print("Enter the area name: ");
        String name = scanner.nextLine();
        if (TourMethods.searchByArea(PlannedTour.castPlannedTORaw(),name) == null) {
            System.out.println("nothing found");
        } else {
            MapUtil.showMap(TourMethods.searchByArea(PlannedTour.castPlannedTORaw(),name).getDestination());
        }
        pause();
        printMenu();
    }

    public static void showOriginOnMap() {
        System.out.print("Enter the area name: ");
        String name = scanner.nextLine();
        if (TourMethods.searchByArea(PlannedTour.castPlannedTORaw(),name) == null) {
            System.out.println("nothing found");
        } else {
            MapUtil.showMap(TourMethods.searchByArea(PlannedTour.castPlannedTORaw(),name).getOrigin());
        }
        pause();
        printMenu();
    }

    public static void showTwoOnMap() {
        System.out.print("Enter the first area: ");
        String name1 = scanner.nextLine();
        System.out.print("Enter the second area: ");
        String name2 = scanner.nextLine();
        MapUtil.showMap(name1, name2);
        pause();
        printMenu();
    }

    public static void showOneOnMap() {
        System.out.print("Enter the name: ");
        String name = scanner.nextLine();
        MapUtil.showMap(name);
        pause();
        printMenu();
    }
}
