package com.login.repository.util;
import java.util.Scanner;

public class Menu {
    private static final Scanner scanner = new Scanner(System.in);
    
    public static void showMenu() {
        do {
            System.out.println("Welcome to the Login System");
            System.out.println("1. Login");
            System.out.println("2. Register");
            System.out.println("3. Update");
            System.out.println("4. Delete Account");
            System.out.println("5. View All Users");
            System.out.println("6. View User by CPF");
            System.out.println("7. Exit");
            System.out.print("Please choose an option: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline
            switch (choice) {
            case 1:
              Handle.handleLogin();
            break;
            case 2:
                Handle.handleRegister();
            break;
            case 3:
                Handle.handleUpdateUser();
            break;
            case 4:
                   Handle.handleDelete();
            break;
            case 5:
                  Handle.handleViewAllUsers();
            break;
            case 6:
                   Handle.handleViewByCpf();
            break;
            case 7:
                System.out.println("Exiting...");
            return;
            default:
                System.out.println("Invalid choice. Please try again.");
            break;
            }
        } while (true);
    }
}