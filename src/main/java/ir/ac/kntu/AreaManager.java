package ir.ac.kntu;

import java.util.Scanner;

import static ir.ac.kntu.Main.*;
import static ir.ac.kntu.Menu.printAreaMenu;

public class AreaManager {
    public static Scanner scanner = new Scanner(System.in);

    public static void removeArea() {
        System.out.print("Enter areas name: ");
        String name = scanner.nextLine();
        if (Area.searchByName(areas, name) == null) {
            System.out.println("no area found");
        } else {
            System.out.println(Area.searchByName(areas, name).toString());
            areas.remove(Area.searchByName(areas, name));
            System.out.println("area is removed");
        }
        pause();
        printAreaMenu();
    }

    public static void editArea() {
        System.out.print("Enter areas name: ");
        String name = scanner.nextLine();
        if (Area.searchByName(areas, name) == null) {
            System.out.println("no area found");
        } else {
            System.out.println(Area.searchByName(areas, name).toString());
            areas.remove(Area.searchByName(areas, name));
            Area.addArea(areas);
            System.out.println(areas.get(areas.size()-1).toString());
        }
        pause();
        printAreaMenu();
    }

    public static void addArea() {
        Area.addArea(areas);
        System.out.println(areas.get(areas.size()-1).toString());
        pause();
        printAreaMenu();
    }

    public static void printAllAreas() {
        clearScreen();
        for (Area area : areas) {
            System.out.println(area.toString());
            System.out.println("---------------------");
        }
        pause();
        printAreaMenu();
    }
}
