package ir.ac.kntu;

import java.util.ArrayList;
import java.util.Scanner;

import static ir.ac.kntu.Main.people;

public class TourLeader extends Person {
    protected String firstName;
    protected String lastName;
    protected String nationalCode;
    protected Date dob;
    protected Date doe;
    protected boolean single;
    protected ArrayList<Area> areas;
    protected ArrayList<Date> dot;
    private String accesslvl;


    static Scanner scanner = new Scanner(System.in)    ;

    public TourLeader(String username, String password, String email, String phoneNumber) {
        super(username, password, email, phoneNumber);
        accesslvl = "c";
    }

    public TourLeader() {

    }

    public static void addTourLeader(ArrayList<TourLeader> tourLeaders) {
        TourLeader tourLeader = new TourLeader();
        System.out.println("first name");
        tourLeader.setFirstName(getNameFromTerminal());

        System.out.println("last name");
        tourLeader.setLastName(getNameFromTerminal());

        tourLeader.setNationalCode(getNationalCodeFromTerminal());

        System.out.println("Date of birth");
        tourLeader.setDOB(Date.setDate());

        System.out.println("Date of employment");
        tourLeader.setDOE(Date.setDate());

        tourLeader.setSingle(getMaritalStatusFromTerminal());

        tourLeader.setAreas(getAreaFromTerminal());

        tourLeader.setDot(new ArrayList<>());

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
            if (Validator.checkNationalCode(nationalCode)) {
                break;
            }
        }
        return nationalCode;
    }

    public static boolean getMaritalStatusFromTerminal() {
        System.out.println("1. Single");
        System.out.println("2. married");
        int choice = Main.getInt("Enter Marital status: ");
        switch (choice) {
            case 1: return true;
            case 2: return false;
            default: getMaritalStatusFromTerminal();
        }
        return true;
    }

    public static ArrayList<Area> getAreaFromTerminal() {
        ArrayList<Area> areas = new ArrayList<>();
        System.out.println("Defined areas: ");
        System.out.println(Area.allNamesToString(Main.areas));
        int n = Main.getInt("How many areas do you want to add? ");
        System.out.println("Enter the area's name: ");
        String name;
        boolean flag;
        for (int i = 0; i < n; i++) {
            flag = true;
            name = scanner.nextLine();
            for (Area area : Main.areas) {
                if (area.getName().equalsIgnoreCase(name)) {
                    areas.add(area);
                    flag = false;
                }
            }
            if (flag) {
                System.out.println("you should add this area");
                Main.pause();
                Area.addArea(Main.areas);
                areas.add(Main.areas.get(Main.areas.size()-1));
                if (i < n-1) {
                    System.out.println("Enter the area's name: ");
                }
            }
        }
        return areas;
    }

    public static void addTourLeaderAccess() {
        System.out.print("enter user name: ");
        String username = scanner.nextLine();
        System.out.print("enter password: ");
        String password = scanner.nextLine();
        System.out.print("enter email: ");
        String email = scanner.nextLine();
        System.out.print("enter phone number: ");
        String phoneNumber = scanner.nextLine();
        people.add(new TourLeader(username,password,email,phoneNumber));
    }

    public boolean isAvailable(Date date1, Date date2) {
        for (int i = 0; i < dot.size(); i+=2) {
            if (date2.compareTo(dot.get(i)) >= 0 && date1.compareTo(dot.get(i+1)) <= 0) {
                return false;
            }
        }
        return true;
    }

    public static String tourLeaderNamesToString() {
        String string = "";
        for (TourLeader tourLeader : Main.tourLeaders) {
            string += tourLeader.getFirstName() + " " + tourLeader.getLastName() + ", ";
        }
        return string;
    }

    public String toString() {
        return  "TourLeader" + "\n" +
                "firstName: " + firstName + '\n' +
                "lastName: " + lastName + '\n' +
                "nationalCode: " + nationalCode + '\n' +
                "date of birth: " + dob.toString() + "\n" +
                "date of employment: " + doe.toString() + "\n" +
                "marital status: " + (single ? "single":"married") + "\n" +
                "areas: " + Area.allNamesToString(areas);
    }

    public String getFullName() {
        return firstName + " " + lastName;
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
        return dob;
    }

    public void setDOB(Date dob) {
        this.dob = dob;
    }

    public Date getDOE() {
        return doe;
    }

    public void setDOE(Date doe) {
        this.doe = doe;
    }

    public boolean isSingle() {
        return single;
    }

    public void setSingle(boolean single) {
        this.single = single;
    }

    public ArrayList<Area> getAreas() {
        return areas;
    }

    public void setAreas(ArrayList<Area> areas) {
        this.areas = areas;
    }

    public ArrayList<Date> getDot() {
        return dot;
    }

    public void setDot(ArrayList<Date> dot) {
        this.dot = dot;
    }

    public String getAccesslvl() {
        return accesslvl;
    }
}