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
    private Date start;
    private Date end;
    private TourLeader tourLeader;

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