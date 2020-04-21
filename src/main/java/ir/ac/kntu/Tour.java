package ir.ac.kntu;

import java.util.ArrayList;
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

    static Scanner scanner = new Scanner(System.in);

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
        int choice = Main.getInt("Enter your choice: ");
        switch (choice) {
            case 1: return true;
            case 2: return false;
            default: getVehicleFromTerminal();
        }
        return false;
    }

    private static int getPriceFromTerminal() {
        return Main.getInt("Enter price: ");
    }

    private static int getMinParticipantFromTerminal() {
        return Main.getInt("Enter minimum participants: ");
    }

    private static int getMaxParticipantFromTerminal() {
        return Main.getInt("Enter maximum participants: ");
    }

    private static int getDurationFromTerminal() {
        return Main.getInt("Enter duration: ");
    }

    private static Area getAreaFromTerminal() {
        System.out.println("Defined areas: ");
        System.out.println(Area.allNamesToString(Main.areas));
        System.out.println("Enter the area's name: ");
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

    public static String rawToursToString(ArrayList<Tour> rawTours) {
        String string = "";
        for (Tour tour : rawTours) {
            string += tour.getArea().getName() + " ";
        }
        return string;
    }

    @Override
    protected Tour clone() throws CloneNotSupportedException {
        Tour tour = (Tour) super.clone();
        tour.area = area.clone();
        return tour;
    }

    public String ToString() {
        return "Tour" + "\n" +
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

}