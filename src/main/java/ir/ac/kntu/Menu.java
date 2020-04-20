package ir.ac.kntu;

import java.util.ArrayList;

import static ir.ac.kntu.Main.clearScreen;

public class Menu {

    public static void printMenu() {
        clearScreen();
        System.out.println("1. Tour leader menu");
        System.out.println("2. Tour menu");
        System.out.println("3. Area menu");
        System.out.println("4. Map menu");
        System.out.println("5. change today's date");
        Main.menu();
    }

    public static void printMapMenu() {
        clearScreen();
        System.out.println("1. show origin");
        System.out.println("2. show destination");
        System.out.println("3. show origin and destination");
        System.out.println("4. show the current area for the foreign tours");
        System.out.println("5. show all the places for foreign tours");
        System.out.println("6. show a city or country");
        System.out.println("7. show 2 cities");
        System.out.println("8. back to main menu");
        Main.mapMenu();
    }

    public static void printTourMenu() {
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
        Main.tourMenu();
    }

    public static void printPlannedTourSearch() {
        clearScreen();
        System.out.println("1. search by tour leader");
        System.out.println("2. search by date");
        System.out.println("3. search by duration");
        System.out.println("4. search by places to visit");
        System.out.println("5. search by area");
        System.out.println("6. search by min and man participants");
        System.out.println("7. search by price");
        System.out.println("8. back to tour menu");
        Main.plannedTourSearch();
    }

    public static void printSearchPlannedTourByDate() {
        clearScreen();
        System.out.println("1. after a date");
        System.out.println("2. before a date");
        System.out.println("3. between 2 dates");
        Main.searchPlannedTourByDate();
    }

    public static void printRawTourSearch() {
        clearScreen();
        System.out.println("1. search by duration");
        System.out.println("2. search by places to visit");
        System.out.println("3. search by area");
        System.out.println("4. search by min and man participants");
        System.out.println("5. search by price");
        System.out.println("6. back to tour menu");
        Main.rawTourSearch();
    }

    public static void printSearchTourByPrice(ArrayList<Tour> tours) {
        clearScreen();
        System.out.println("1. search for a prince");
        System.out.println("2. search for more expensive tours");
        System.out.println("3. search for cheaper tours");
        System.out.println("4. search between 2 prices");
        System.out.println("5. back to tour menu");
        Main.searchTourByPrice(tours);
    }

    public static void printAreaMenu() {
        clearScreen();
        System.out.println("1. Print all defined areas");
        System.out.println("2. Add an area");
        System.out.println("3. Edit an area");
        System.out.println("4. Remove an area");
        System.out.println("5. go back to main menu");
        Main.areaMenu();
    }

    public static void printTourLeaderMenu() {
        clearScreen();
        System.out.println("1. Print all leaders");
        System.out.println("2. Add leader");
        System.out.println("3. Edit a leader");
        System.out.println("4. Search for a leader");
        System.out.println("5. Back to main menu");
        Main.tourLeaderMenu();
    }

    public static void printTourLeaderSearchMenu() {
        clearScreen();
        System.out.println("1. Search with name");
        System.out.println("2. Search with last name");
        System.out.println("3. Search by province");
        System.out.println("4. Search by age");
        System.out.println("5. Back to menu");
        Main.tourLeaderSearchMenu();
    }

    public static void printSearchByAgeMenu() {
        clearScreen();
        System.out.println("1. search for specific age");
        System.out.println("2. search for leaders older than given age");
        System.out.println("3. search for leaders younger than given age");
        System.out.println("4. search between 2 given ages");
        System.out.println("5. Go back to menu");
        Main.searchByAgeMenu();
    }
}
