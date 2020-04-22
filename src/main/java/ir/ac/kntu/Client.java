package ir.ac.kntu;

import java.util.Scanner;

import static ir.ac.kntu.Main.people;

public class Client extends Person {
    private String accesslvl;
    public Client(String username, String password, String email, String phoneNumber) {
        super(username, password, email, phoneNumber);
        accesslvl = "d";
    }

    public static void addClient() {
        System.out.print("enter user name: ");
        Scanner scanner = new Scanner(System.in);
        String username = scanner.nextLine();
        System.out.print("enter password: ");
        String password = scanner.nextLine();
        System.out.print("enter email: ");
        String email = scanner.nextLine();
        System.out.print("enter phone number: ");
        String phoneNumber = scanner.nextLine();
        people.add(new Client(username,password,email,phoneNumber));
    }

    public static Client searchByUserAndPass(String username, String password) {
        for (Person client : people) {
            if (client.getClass().getSimpleName().equals("Employee") && client.getUsername().equals(username) && client.getPassword().equals(password)) {
                return (Client) client;
            }
        }
        return null;
    }

    public String getAccesslvl() {
        return accesslvl;
    }
}
