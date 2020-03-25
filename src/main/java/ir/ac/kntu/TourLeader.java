package ir.ac.kntu;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Scanner;

public class TourLeader {
    private String firstName;
    private String lastName;
    private String nationalCode;
    private Date DOB;
    private Date DOE;
    private boolean single;
    private HashSet<Area> areas;
    private boolean available = true;

    static Scanner scanner = new Scanner(System.in);

    public static void addTourLeader(ArrayList<TourLeader> tourLeaders) {
        TourLeader tourLeader = new TourLeader();
        System.out.println("Enter first name: ");
        tourLeader.setFirstName(getNameFromTerminal());

        System.out.println("Enter last name: ");
        tourLeader.setLastName(getNameFromTerminal());

        tourLeader.setNationalCode(getNationalCodeFromTerminal());

        System.out.println("Date of birth");
        tourLeader.setDOB(Date.setDate());

        System.out.println("Date of employment");
        tourLeader.setDOE(Date.setDate());

        tourLeader.setSingle(getMaritalStatusFromTerminal());

        tourLeader.getAreas().add(getAreaFromTerminal());

        tourLeaders.add(tourLeader);
    }

    public static String getNameFromTerminal() {
        String name;
        while (true) {
            System.out.print("Enter name: ");
            name = scanner.nextLine();
            if (Validator.checkName(name)) {
                break;
            }
        }
        return name;
    }

    public static String getNationalCodeFromTerminal() {
        String nationalCode;
        while (true) {
            System.out.print("Enter national code: ");
            nationalCode = scanner.nextLine();
            if (Validator.checkName(nationalCode)) {
                break;
            }
        }
        return nationalCode;
    }

    public static boolean getMaritalStatusFromTerminal() {
        System.out.println("1. Single");
        System.out.println("2. married");
        System.out.print("Enter Marital status: ");
        int choice = scanner.nextInt();
        switch (choice) {
            case 1: return true;
            case 2: return false;
            default: getMaritalStatusFromTerminal();
        }
        return true;
    }

    public static Area getAreaFromTerminal() {
        System.out.println("Enter the area's name: ");
        String name = scanner.nextLine();
        for (Area area : Main.areas) {
            if (area.getName().equals(name)) {
                return area;
            }
        }
        return null;
    }

    public static TourLeader searchByName(ArrayList<TourLeader> tourLeaders, String firstName, String lastName) {
        for (int i = 0; i < tourLeaders.size(); i++) {
            if (tourLeaders.get(i).firstName.equals(firstName) && tourLeaders.get(i).lastName.equals(lastName)) {
                return tourLeaders.get(i);
            }
        }
        return null;
    }

    public static TourLeader searchByLastName(ArrayList<TourLeader> tourLeaders, String lastName) {
        for (int i = 0; i < tourLeaders.size(); i++) {
            if (tourLeaders.get(i).lastName.equals(lastName)) {
                return tourLeaders.get(i);
            }
        }
        return null;
    }

    public static TourLeader searchByNationalCode(ArrayList<TourLeader> tourLeaders, String nationalCode) {
        for (int i = 0; i < tourLeaders.size(); i++) {
            if (tourLeaders.get(i).nationalCode.equals(nationalCode)) {
                return tourLeaders.get(i);
            }
        }
        return null;
    }

    public static ArrayList<TourLeader> searchByAge(ArrayList<TourLeader> tourLeaders, int age, Date today) {
        ArrayList<TourLeader> wanted = new ArrayList<>();
        for (TourLeader tourLeader : tourLeaders) {
            if (tourLeader.getDOB().ageCalculator(today) == age) {
                wanted.add(tourLeader);
            }
        }
        return wanted;
    }

    public static ArrayList<TourLeader> searchOlderThan(ArrayList<TourLeader> tourLeaders, int age, Date today) {
        ArrayList<TourLeader> wanted = new ArrayList<>();
        for (TourLeader tourLeader : tourLeaders) {
            if (tourLeader.getDOB().ageCalculator(today) > age) {
                wanted.add(tourLeader);
            }
        }
        return wanted;
    }

    public static ArrayList<TourLeader> searchYoungerThan(ArrayList<TourLeader> tourLeaders, int age, Date today) {
        ArrayList<TourLeader> wanted = new ArrayList<>();
        for (TourLeader tourLeader : tourLeaders) {
            if (tourLeader.getDOB().ageCalculator(today) < age) {
                wanted.add(tourLeader);
            }
        }
        return wanted;
    }

    public static ArrayList<TourLeader> searchBetween2Ages(ArrayList<TourLeader> tourLeaders, int age1, int age2, Date today) {
        ArrayList<TourLeader> wanted = new ArrayList<>();
        for (TourLeader tourLeader : tourLeaders) {
            if (tourLeader.getDOB().ageCalculator(today) > age1 && tourLeader.getDOB().ageCalculator(today) < age2) {
                wanted.add(tourLeader);
            }
        }
        return wanted;
    }

    public String toString() {
        String string =  "TourLeader" + "\n" +
                "firstName: " + firstName + '\n' +
                "lastName: " + lastName + '\n' +
                "nationalCode: " + nationalCode + '\n' +
                "date of birth: " + DOB.toString() + "\n" +
                "date of employment: " + DOE.toString() + "\n" +
                "marital status: " + (single ? "single":"married") + "\n" +
                "areas: ";
        for (Area area: areas) {
            string += area.getName();
            string += " ";
        }
        return string;
    }



    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getNationalCode() {
        return nationalCode;
    }

    public boolean setNationalCode(String nationalCode) {
        if(Validator.checkNationalCode(nationalCode)) {
            this.nationalCode = nationalCode;
            return true;
        }
        return false;
    }

    public Date getDOB() {
        return DOB;
    }

    public void setDOB(Date DOB) {
        this.DOB = DOB;
    }

    public Date getDOE() {
        return DOE;
    }

    public void setDOE(Date DOE) {
        this.DOE = DOE;
    }

    public boolean isSingle() {
        return single;
    }

    public void setSingle(boolean single) {
        this.single = single;
    }

    public HashSet<Area> getAreas() {
        return areas;
    }

    public void setAreas(HashSet<Area> areas) {
        this.areas = areas;
    }

    public boolean isAvailable() {
        return available;
    }

    public void setAvailable(boolean available) {
        this.available = available;
    }

}