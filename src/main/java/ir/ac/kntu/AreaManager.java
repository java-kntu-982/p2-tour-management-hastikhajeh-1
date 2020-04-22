package ir.ac.kntu;

import java.util.Scanner;

import static ir.ac.kntu.Main.*;
import static ir.ac.kntu.Menu.printAreaMenu;

public class AreaManager {
    public static Scanner scanner = new Scanner(System.in);

    public static void removeArea() {
        if (access.getAccesslvl().equals("d")||access.getAccesslvl().equals("c")) {
            System.out.println("you dont have permission");
        } else {
            System.out.print("Enter areas name: ");
            String name = scanner.nextLine();
            if (Area.searchByName(areas, name) == null) {
                System.out.println("no area found");
            } else {
                System.out.println(Area.searchByName(areas, name).toString());
                areas.remove(Area.searchByName(areas, name));
                System.out.println("area is removed");
            }
        }
        pause();
        printAreaMenu();
    }

    public static void editArea() {
        if (access.getAccesslvl().equals("d")||access.getAccesslvl().equals("c")) {
            System.out.println("you dont have permission");
        } else {
            System.out.print("Enter areas name: ");
            String name = scanner.nextLine();
            if (Area.searchByName(areas, name) == null) {
                System.out.println("no area found");
            } else {
                System.out.println(Area.searchByName(areas, name).toString());
                Area area = Area.searchByName(areas, name);
                Area.addArea(areas);
                area.setForeign(areas.get(areas.size() - 1).isForeign());
                area.setName(areas.get(areas.size() - 1).getName());
                area.setPlaces(areas.get(areas.size() - 1).getPlaces());
                areas.remove(areas.get(areas.size() - 1));
                System.out.println(area.toString());
            }
        }
        pause();
        printAreaMenu();
    }

    public static void addArea() {
        if (access.getAccesslvl().equals("d")||access.getAccesslvl().equals("c")) {
            System.out.println("you dont have permission");
        } else {
            Area.addArea(areas);
            System.out.println(areas.get(areas.size() - 1).toString());
        }
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
