// Handle.java
package com.login.repository.util;

import java.util.Scanner;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import com.login.repository.LoginsDao;
import com.login.model.Logins;

public class Handle {
    private static final Scanner scanner = new Scanner(new InputStreamReader(System.in, StandardCharsets.UTF_8));  
    private static final LoginsDao loginsDao = new LoginsDao();
    private static Logins currentUser = null;

    public static Logins getCurrentUser() {
        return currentUser;
    }

    public static void setCurrentUser(Logins user) {
        currentUser = user;
    }

    public static void handleLogin() {
        System.out.println("Starting login process...");
        try {
            System.out.print("Enter CPF: ");
            Long cpf = scanner.nextLong();
            scanner.nextLine();
            System.out.print("Enter Password: ");
            String senha = scanner.nextLine();
            if (loginsDao.ifsenhaisvalid(cpf, senha)) {
                currentUser = loginsDao.get(cpf);
                System.out.println("Login successful! Welcome " + currentUser.getName());
            } else {
                System.out.println("Invalid CPF or password.");
            }
        } catch (Exception e) {
            System.out.println("An error occurred during login: " + e.getMessage());
        }
    }

    public static void handleRegister() {
        System.out.println("Starting registration process...");
        try {
            System.out.print("Enter CPF: ");
            Long cpf = scanner.nextLong();
            scanner.nextLine();
            if (loginsDao.ifcpfexists(cpf)) {
                System.out.println("CPF already exists. Please try again.");
                return;
            }
            boolean flag = false;
            do {
                System.out.print("Enter Name: ");
                String name = scanner.nextLine();
                if (loginsDao.isvalidname(name)) {
                    System.out.print("Enter Password: ");
                    String senha = scanner.nextLine();
                    if (senha.isEmpty()) {
                        System.out.println("Password cannot be empty. Please try again.");
                        return;
                    }
                    Logins newUser = new Logins();
                    newUser.setCpf(cpf);
                    newUser.setName(name);
                    newUser.setSenha(senha);
                    loginsDao.save(newUser);
                    System.out.println("Registration successful! Welcome " + name);
                    flag = true;
                } else {
                    System.out.println("Invalid name. Please try again.");
                }
            } while (!flag);
        } catch (Exception e) {
            System.out.println("An error occurred while checking CPF: " + e.getMessage());
        }
    }

    public static void handleUpdateUser() {
        if (currentUser == null) {
            System.out.println("You need to login first.");
            return;
        }
        System.out.println("Starting update process...");
        System.out.println("1. Update Name");
        System.out.println("2. Update Password");
        System.out.println("3. Update CPF");
        System.out.print("Please choose an option: ");
        int updateChoice = scanner.nextInt();
        scanner.nextLine();
        switch (updateChoice) {
            case 1:
                updateName();
                break;
            case 2:
                updatePassword();
                break;
            case 3:
                updateCpf();
                break;
            default:
                System.out.println("Invalid choice. Please try again.");
        }
    }

    private static void updateName() {
        boolean flag = false;
        do {
            System.out.print("Enter new name: ");
            String newName = scanner.nextLine();
            if (loginsDao.isvalidname(newName)) {
                loginsDao.updateName(currentUser.getCpf(), newName);
                currentUser.setName(newName);
                System.out.println("Name updated successfully to " + newName);
                flag = true;
            } else {
                System.out.println("Invalid name. Please try again.");
            }
        } while (!flag);
    }

    private static void updatePassword() {
        System.out.print("Enter new password: ");
        String newPassword = scanner.nextLine();
        if (newPassword.isEmpty()) {
            System.out.println("Password cannot be empty. Please try again.");
        } else if (newPassword.equals(currentUser.getSenha())) {
            System.out.println("New password cannot be the same as the old one. Please try again.");
        } else {
            loginsDao.updateSenha(currentUser.getCpf(), newPassword);
            currentUser.setSenha(newPassword);
            System.out.println("Password updated successfully.");
        }
    }

    private static void updateCpf() {
        System.out.print("Enter new CPF: ");
        Long newCpf = scanner.nextLong();
        scanner.nextLine();
        if (loginsDao.ifcpfexists(newCpf)) {
            System.out.println("CPF already exists. Please try again.");
            return;
        }
        System.out.print("Please confirm your password: ");
        String confirmPassword = scanner.nextLine();
        if (loginsDao.ifsenhaisvalid(currentUser.getCpf(), confirmPassword)) {
            loginsDao.updateCpf(currentUser.getCpf(), newCpf);
            currentUser.setCpf(newCpf);
            System.out.println("CPF updated successfully to " + newCpf);
        } else {
            System.out.println("Invalid password. CPF update failed.");
        }
    }

    public static void handleDelete() {
        if (currentUser == null) {
            System.out.println("You need to login first.");
            return;
        }
        System.out.println("Starting account deletion process...");
        try {
            loginsDao.delete(currentUser.getCpf());
            System.out.println("Account deleted successfully.");
            currentUser = null;
        } catch (Exception e) {
            System.out.println("An error occurred during account deletion: " + e.getMessage());
        }
    }

    public static void handleViewAllUsers() {
        System.out.println("Fetching all users...");
        try {
            for (Logins user : loginsDao.getAll()) {
                System.out.println("Name: " + user.getName() + ", CPF: " + user.getCpf());
            }
        } catch (Exception e) {
            System.out.println("An error occurred while fetching users: " + e.getMessage());
        }
    }

    public static void handleViewByCpf() {
        System.out.println("Fetching user by CPF...");
        try {
            System.out.print("Enter CPF: ");
            Long cpf = scanner.nextLong();
            scanner.nextLine();
            Logins user = loginsDao.get(cpf);
            if (user != null) {
                System.out.println("Name: " + user.getName() + ", CPF: " + user.getCpf());
            } else {
                System.out.println("User not found.");
            }
        } catch (Exception e) {
            System.out.println("An error occurred while fetching user: " + e.getMessage());
        }
    }
}