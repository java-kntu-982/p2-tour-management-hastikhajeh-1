package ir.ac.kntu;

import static ir.ac.kntu.Main.*;
import static ir.ac.kntu.TourLeaderMethods.searchByUserAndPass;

public class PersonManager {

    public static void editClient() {
        if (access.getAccesslvl().equals("c")) {
            System.out.println("you dont have permission");
        } else {
            System.out.print("enter username: ");
            String username = scanner.nextLine();
            System.out.print("enter password: ");
            String password = scanner.nextLine();
            if (Client.searchByUserAndPass(username, password) == null) {
                System.out.println("no one found");
            } else if (access.getAccesslvl().equals("d") && !access.equals(Client.searchByUserAndPass(username, password))) {
                System.out.println("you dont have permission");
            } else {
                Client client = Client.searchByUserAndPass(username, password);
                System.out.print("enter username: ");
                client.setUsername(scanner.nextLine());
                System.out.print("enter password: ");
                client.setPassword(scanner.nextLine());
                System.out.print("enter email: ");
                client.setEmail(scanner.nextLine());
                System.out.print("enter phone number: ");
                client.setPhoneNumber(scanner.nextLine());
                System.out.println(client.toString());
            }
        }
        pause();
        personMenu();
    }

    public static void editTourLeaderAccess() {
        if (access.getAccesslvl().equals("b")||access.getAccesslvl().equals("d")) {
            System.out.println("you dont have permission");
        } else {
            System.out.print("enter username: ");
            String username = scanner.nextLine();
            System.out.print("enter password: ");
            String password = scanner.nextLine();
            if (searchByUserAndPass(username, password) == null) {
                System.out.println("no one found");
            } else if (access.getAccesslvl().equals("c") && !access.equals(searchByUserAndPass(username, password))) {
                System.out.println("you dont have permission");
            } else {
                TourLeader tourLeader = searchByUserAndPass(username, password);
                System.out.print("enter username: ");
                tourLeader.setUsername(scanner.nextLine());
                System.out.print("enter password: ");
                tourLeader.setPassword(scanner.nextLine());
                System.out.print("enter email: ");
                tourLeader.setEmail(scanner.nextLine());
                System.out.print("enter phone number: ");
                tourLeader.setPhoneNumber(scanner.nextLine());
                System.out.println(tourLeader.toString());
            }
        }
        pause();
        personMenu();
    }

    public static void editEmployee() {
        if (access.getAccesslvl().equals("d")||access.getAccesslvl().equals("c")) {
            System.out.println("you dont have permission");
        } else {
            System.out.print("enter username: ");
            String username = scanner.nextLine();
            System.out.print("enter password: ");
            String password = scanner.nextLine();
            if (Employee.searchByUserAndPass(username, password) == null) {
                System.out.println("no one found");
            } else if (access.getAccesslvl().equals("b") && !access.equals(Employee.searchByUserAndPass(username, password))) {
                System.out.println("you dont have permission");
            } else {
                Employee employee = Employee.searchByUserAndPass(username, password);
                System.out.print("enter username: ");
                employee.setUsername(scanner.nextLine());
                System.out.print("enter password: ");
                employee.setPassword(scanner.nextLine());
                System.out.print("enter email: ");
                employee.setEmail(scanner.nextLine());
                System.out.print("enter phone number: ");
                employee.setPhoneNumber(scanner.nextLine());
                employee.setBaseSalary(getInt("enter base salary: "));
                System.out.println("date of employment");
                employee.setDoe(Date.setDate());
                System.out.println(employee.toString());
            }
        }
        pause();
        personMenu();
    }

    public static void removeClient() {
        if (access.getAccesslvl().equals("d")||access.getAccesslvl().equals("c")) {
            System.out.println("you dont have permission");
        } else {
            System.out.print("enter username: ");
            String username = scanner.nextLine();
            System.out.print("enter password: ");
            String password = scanner.nextLine();
            if (Client.searchByUserAndPass(username, password) == null) {
                System.out.println("no one found");
            } else {
                people.remove(Client.searchByUserAndPass(username, password));
                System.out.println("removed!");
            }
        }
        pause();
        personMenu();
    }

    public static void removeTourLeaderAccess() {
        if (access.getAccesslvl().equals("b")||access.getAccesslvl().equals("d")||access.getAccesslvl().equals("c")) {
            System.out.println("you dont have permission");
        } else {
            System.out.print("enter username: ");
            String username = scanner.nextLine();
            System.out.print("enter password: ");
            String password = scanner.nextLine();
            if (searchByUserAndPass(username, password) == null) {
                System.out.println("no one found");
            } else {
                people.remove(searchByUserAndPass(username, password));
                System.out.println("removed!");
            }
        }
        pause();
        personMenu();
    }

    public static void removeEmployee() {
        if (access.getAccesslvl().equals("d")||access.getAccesslvl().equals("b")||access.getAccesslvl().equals("c")) {
            System.out.println("you dont have permission");
        } else {
            System.out.print("enter username: ");
            String username = scanner.nextLine();
            System.out.print("enter password: ");
            String password = scanner.nextLine();
            if (Employee.searchByUserAndPass(username, password) == null) {
                System.out.println("no one found");
            } else {
                people.remove(Employee.searchByUserAndPass(username, password));
                System.out.println("removed!");
            }
        }
        pause();
        personMenu();
    }

    public static void addClient() {
        if (access.getAccesslvl().equals("d")) {
            System.out.println("you dont have permission");
        } else {
            Client.addClient();
            System.out.println(people.get(people.size() - 1).toString());
        }
        pause();
        personMenu();
    }

    public static void addTourLeaderAccess() {
        if (access.getAccesslvl().equals("b")||access.getAccesslvl().equals("d")||access.getAccesslvl().equals("c")) {
            System.out.println("you dont have permission");
        } else {
            TourLeader.addTourLeaderAccess();
            System.out.println(people.get(people.size() - 1).toString());
        }
        pause();
        personMenu();
    }

    public static void addEmployee() {
        if (access.getAccesslvl().equals("b")||access.getAccesslvl().equals("d")||access.getAccesslvl().equals("c")) {
            System.out.println("you dont have permission");
        } else {
            Employee.addEmployee();
            System.out.println(people.get(people.size() - 1).toString());
        }
        pause();
        personMenu();
    }
}
