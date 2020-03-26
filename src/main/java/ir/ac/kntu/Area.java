package ir.ac.kntu;

import javax.swing.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Scanner;

public class Area {
    private String name;
    private boolean foreign;
    private ArrayList<String> places;

    static Scanner scanner = new Scanner(System.in);

    public static void addArea(ArrayList<Area> areas) {
        Area area = new Area();
        area.setForeign(getForeignFromTerminal());
        scanner.nextLine();
        System.out.print("Enter areas name: ");
        area.setName(scanner.nextLine());
        System.out.print("how many places do you want to add? ");
        int n = scanner.nextInt();
        System.out.println("Enter the places: ");
        scanner.nextLine();
        String name;
        area.setPlaces(new ArrayList<>());
        for (int i = 0; i < n; i++) {
            name = scanner.nextLine();
            area.getPlaces().add(name);
        }
        areas.add(area);
    }

    private static boolean getForeignFromTerminal() {
        Main.clearScreen();
        System.out.println("1. Foreign");
        System.out.println("2. Domestic");
        System.out.print("Enter your choice: ");
        int choice = scanner.nextInt();
        switch (choice) {
            case 1: return true;
            case 2: return false;
            default: getForeignFromTerminal();
        }
        return true;
    }

    public static Area searchByName(ArrayList<Area> areas, String name) {
        for (Area area : areas) {
            if (area.getName().equalsIgnoreCase(name)) {
                return area;
            }
        }
        return null;
    }

    public static String allNamesToString(ArrayList<Area> areas) {
        String string = "";
        for (Area area : areas) {
            string += area.getName() + "  ";
        }
        return string;
    }

    @Override
    public String toString() {
        return (foreign ? "Foreign":"Domestic") + " Area" + "\n" +
                "name: " + name + '\n' +
                "places: " + placesToString() + '\n';
    }

    public String placesToString() {
        String string = "";
        for (String place : places) {
            string += place + " ";
        }
        return string;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isForeign() {
        return foreign;
    }

    public void setForeign(boolean foreign) {
        this.foreign = foreign;
    }

    public ArrayList<String> getPlaces() {
        return places;
    }

    public void setPlaces(ArrayList<String> places) {
        this.places = places;
    }
}
