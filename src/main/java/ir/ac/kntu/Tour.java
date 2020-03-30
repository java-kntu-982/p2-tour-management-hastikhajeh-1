package ir.ac.kntu;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Scanner;

public class Tour {
    private int duration;
    private int price;
    private int maxParticipant;
    private int minParticipant;
    private Area area;
    private String origin;
    private String destination;
    private boolean foreign;
    private boolean byAirplane;
    private ArrayList<String> placesToVisit = new ArrayList<>(duration);
    private Date start;
    private Date end;
    private TourLeader tourLeader;

    static Scanner scanner = new Scanner(System.in);

    public static void addPlannedTour(ArrayList<Tour> plannedTours, ArrayList<Tour> rawTours) {
        Tour plannedTour = new Tour();
        System.out.println(Tour.rawToursToString(rawTours));
        System.out.print("Choose an area: ");
        String name = scanner.nextLine();
        for (Tour tour : rawTours) {
            if (tour.getArea().getName().equalsIgnoreCase(name)) {
                copyRawTourInPlannedTour(plannedTour,tour);
                break;
            }
        }
        System.out.println("Tour starts from: ");
        plannedTour.setStart(Date.setDate());
        System.out.println("Tour last day: ");
        plannedTour.setEnd(Date.setDate());
        System.out.println(TourLeader.tourLeaderNamesToString());
        System.out.print("Enter tour leader's name: ");
        name = scanner.nextLine();
        for (TourLeader tourLeader : Main.tourLeaders) {
            if (tourLeader.getFullName().equalsIgnoreCase(name)) {
                plannedTour.setTourLeader(tourLeader);
                break;
            }
        }
        plannedTours.add(plannedTour);
    }

    public static void copyRawTourInPlannedTour(Tour planned, Tour raw) {
        planned.setPlacesToVisit(raw.getPlacesToVisit());
        planned.setDestination(raw.getDestination());
        planned.setOrigin(raw.getOrigin());
        planned.setByAirplane(raw.isByAirplane());
        planned.setPrice(raw.getPrice());
        planned.setMaxParticipant(raw.getMaxParticipant());
        planned.setMinParticipant(raw.getMinParticipant());
        planned.setForeign(raw.isForeign());
        planned.setDuration(raw.getDuration());
        planned.setArea(raw.getArea());
    }

    public static void addRawTour(ArrayList<Tour> rawTours) {
        Tour tour = new Tour();
        tour.setArea(getAreaFromTerminal());
        tour.setDuration(getDurationFromTerminal());
        tour.setForeign(tour.getArea().isForeign());
        tour.setMaxParticipant(getMaxParticipantFromTerminal());
        tour.setMinParticipant(getMinParticipantFromTerminal());
        tour.setPrice(getPriceFromTerminal());
        tour.setByAirplane(getVehicleFromTerminal());
        if (!tour.isForeign()) {
            tour.setOrigin(tour.getArea().getName());
            tour.setDestination(tour.getArea().getName());
        } else {
            tour.setOrigin(getOriginFromTerminal());
            tour.setDestination(getDestinationFromTerminal());
        }
        tour.setPlacesToVisit(getPlacesToVisitFromTerminal(tour));
        rawTours.add(tour);
    }

    private static ArrayList<String> getPlacesToVisitFromTerminal(Tour tour) {
        ArrayList<String> places = new ArrayList<>();
        System.out.println(tour.getArea().placesToString());
        System.out.println("Choose from these places");
        for (int i = 0; i < tour.getDuration(); i++) {
            System.out.print("Enter "+(i+1)+"st day's location or press enter: ");
            places.add(scanner.nextLine());
        }
        return places;
    }

    private static String getDestinationFromTerminal() {
        System.out.print("Enter the capital city: ");
        return scanner.nextLine();
    }

    private static String getOriginFromTerminal() {
        System.out.print("Enter the first city to visit: ");
        return scanner.nextLine();
    }

    private static boolean getVehicleFromTerminal() {
        System.out.println("1. Air transport");
        System.out.println("2. Land transport");
        System.out.print("Enter your choice: ");
        int choice = scanner.nextInt();
        switch (choice) {
            case 1: return true;
            case 2: return false;
            default: getVehicleFromTerminal();
        }
        return false;
    }

    private static int getPriceFromTerminal() {
        System.out.print("Enter price: ");
        return scanner.nextInt();
    }

    private static int getMinParticipantFromTerminal() {
        System.out.print("Enter minimum participants: ");
        return scanner.nextInt();
    }

    private static int getMaxParticipantFromTerminal() {
        System.out.print("Enter maximum participants: ");
        return scanner.nextInt();
    }

    private static int getDurationFromTerminal() {
        System.out.print("Enter duration: ");
        return scanner.nextInt();
    }

    private static Area getAreaFromTerminal() {
        System.out.println("Defined areas: ");
        System.out.println(Area.allNamesToString(Main.areas));
        System.out.println("Enter the area's name: ");
        scanner.nextLine();
        String name = scanner.nextLine();
        for (Area area : Main.areas) {
            if (area.getName().equalsIgnoreCase(name)) {
                return area;
            }
        }
        System.out.println("you should add this area");
        Main.pause();
        Area.addArea(Main.areas);
        return Main.areas.get(Main.areas.size()-1);
    }

    public static Tour searchByArea(ArrayList<Tour> tours, String name) {
        for (Tour tour : tours) {
            if (tour.getArea().getName().equalsIgnoreCase(name)) {
                return tour;
            }
        }
        return null;
    }

    public static Tour searchByAreaAndDate(ArrayList<Tour> plannedTours, String name, Date date) {
        for (Tour tour : plannedTours) {
            if(tour.getArea().getName().equalsIgnoreCase(name) && tour.getStart().equals(date)) {
                return tour;
            }
        }
        return null;
    }

    public static String rawToursToString(ArrayList<Tour> rawTours) {
        String string = "";
        for (Tour tour : rawTours) {
            string += tour.getArea().getName() + " ";
        }
        return string;
    }

    public static ArrayList<Tour> searchTourByDuration(ArrayList<Tour> tours, int duration) {
        ArrayList<Tour> tours1 = new ArrayList<>();
        for (Tour tour : tours) {
            if (tour.getDuration() == duration) {
                tours1.add(tour);
            }
        }
        return tours1;
    }

    public static Tour searchByPlace(ArrayList<Tour> tours, String place) {
        for (Tour tour : tours) {
            for (String name : tour.getPlacesToVisit()) {
                if (name.equalsIgnoreCase(place)) {
                    return tour;
                }
            }
        }
        return null;
    }

    public static ArrayList<Tour> searchByMinAndMaxParticipants(ArrayList<Tour> tours, int min, int max) {
        ArrayList<Tour> tours1 = new ArrayList<>();
        for (Tour tour : tours) {
            if (tour.getMinParticipant() == min && tour.getMaxParticipant() == max) {
                tours1.add(tour);
            }
        }
        return tours1;
    }

    public static ArrayList<Tour> searchByPrice(ArrayList<Tour> tours, int price) {
        ArrayList<Tour> tours1 = new ArrayList<>();
        for (Tour tour : tours) {
            if (tour.getPrice() == price) {
                tours1.add(tour);
            }
        }
        return tours1;
    }

    public static ArrayList<Tour> searchMoreExpensivePrice(ArrayList<Tour> tours, int price) {
        ArrayList<Tour> tours1 = new ArrayList<>();
        for (Tour tour : tours) {
            if (tour.getPrice() > price) {
                tours1.add(tour);
            }
        }
        return tours1;
    }

    public static ArrayList<Tour> searchCheaperPrice(ArrayList<Tour> tours, int price) {
        ArrayList<Tour> tours1 = new ArrayList<>();
        for (Tour tour : tours) {
            if (tour.getPrice() < price) {
                tours1.add(tour);
            }
        }
        return tours1;
    }

    public static ArrayList<Tour> searchBetween2Price(ArrayList<Tour> tours, int min, int max) {
        ArrayList<Tour> tours1 = new ArrayList<>();
        for (Tour tour : tours) {
            if (tour.getPrice() > min && tour.getPrice() < max) {
                tours1.add(tour);
            }
        }
        return tours1;
    }

    public String plannedTourToString() {
        return "Planned tour: " + "\n" +
                "duration: " + duration + "\n" +
                "price: " + price + "\n" +
                "maxParticipant: " + maxParticipant + "\n" +
                "minParticipant: " + minParticipant + "\n" +
                "area: " + area.getName() + "\n" +
                "origin: " + origin + '\n' +
                "destination: " + destination + '\n' +
                (foreign?"Foreign":"Domestic") + " tour" + "\n" +
                (byAirplane?"By airplane":"By bus") + "\n" +
                "PlacesToVisit: " + placesToVisitToString() + "\n" +
                "start: " + start.toString() + "\n" +
                "end: " + end.toString() + "\n" +
                "tourLeader: " + tourLeader.getFirstName() + " " + tourLeader.getLastName();
    }

    public String rawTourToString() {
        return "Raw tour" + "\n" +
                "duration: " + duration + "\n" +
                "price: " + price + "\n" +
                "maxParticipant: " + maxParticipant + "\n" +
                "minParticipant: " + minParticipant + "\n" +
                "area: " + area.getName() + "\n" +
                "origin: " + origin + '\n' +
                "destination: " + destination + '\n' +
                (foreign?"Foreign":"Domestic") + " tour" + "\n" +
                (byAirplane?"By airplane":"By bus") + "\n" +
                "PlacesToVisit: " + placesToVisitToString();
    }

    public String placesToVisitToString() {
        String string = "";
        for (String s : placesToVisit) {
            string += s + " ";
        }
        return string;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getMaxParticipant() {
        return maxParticipant;
    }

    public void setMaxParticipant(int maxParticipant) {
        this.maxParticipant = maxParticipant;
    }

    public int getMinParticipant() {
        return minParticipant;
    }

    public void setMinParticipant(int minParticipant) {
        this.minParticipant = minParticipant;
    }

    public Area getArea() {
        return area;
    }

    public void setArea(Area area) {
        this.area = area;
    }

    public String getOrigin() {
        return origin;
    }

    public void setOrigin(String origin) {
        this.origin = origin;
    }

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public boolean isForeign() {
        return foreign;
    }

    public void setForeign(boolean foreign) {
        this.foreign = foreign;
    }

    public boolean isByAirplane() {
        return byAirplane;
    }

    public void setByAirplane(boolean byAirplane) {
        this.byAirplane = byAirplane;
    }

    public ArrayList<String> getPlacesToVisit() {
        return placesToVisit;
    }

    public void setPlacesToVisit(ArrayList<String> placesToVisit) {
        this.placesToVisit = placesToVisit;
    }

    public Date getStart() {
        return start;
    }

    public void setStart(Date start) {
        this.start = start;
    }

    public Date getEnd() {
        return end;
    }

    public void setEnd(Date end) {
        this.end = end;
    }

    public TourLeader getTourLeader() {
        return tourLeader;
    }

    public void setTourLeader(TourLeader tourLeader) {
        this.tourLeader = tourLeader;
    }
}