package ir.ac.kntu;

import java.util.Scanner;

import static ir.ac.kntu.Main.people;

public class Employee extends Person {
    private Date doe;
    private int baseSalary;
    private String accesslvl;


    public Employee(String username, String password, String email, String phoneNumber) {
        super(username, password, email, phoneNumber);
        accesslvl = "b";
    }

    static Scanner scanner = new Scanner(System.in);

    public static void addEmployee() {
        System.out.print("enter user name: ");
        String username = scanner.nextLine();
        System.out.print("enter password: ");
        String password = scanner.nextLine();
        System.out.print("enter email: ");
        String email = scanner.nextLine();
        System.out.print("enter phone number: ");
        String phoneNumber = scanner.nextLine();
        Person employee = new Employee(username,password,email,phoneNumber);
        System.out.println("enter date of employment");
        Date date = new Date(Date.setDate());
        int salary = Main.getInt("enter the base salary: ");
        ((Employee) employee).setBaseSalary(salary);
        ((Employee) employee).setDoe(date);
        people.add(employee);
    }

    public static Employee searchByUserAndPass(String username, String password) {
        for (Person employee : people) {
            if (employee.getClass().getSimpleName().equals("Employee") && employee.getUsername().equals(username) && employee.getPassword().equals(password)) {
                return (Employee) employee;
            }
        }
        return null;
    }

    @Override
    public String toString() {
        return super.toString()+
                "date of employment: " + doe.toString() + "\n" +
                "baseSalary: " + baseSalary;
    }

    public String getAccesslvl() {
        return accesslvl;
    }

    public int getBaseSalary() {
        return baseSalary;
    }

    public void setBaseSalary(int baseSalary) {
        this.baseSalary = baseSalary;
    }

    public Date getDoe() {
        return doe;
    }

    public void setDoe(Date doe) {
        this.doe = doe;
    }
}
