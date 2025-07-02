package com.login;
import com.login.repository.util.Menu;
import java.io.PrintStream;
import java.nio.charset.StandardCharsets;

public class Main {
    public static void main(String[] args) {
        try {
            System.setOut(new PrintStream(System.out, true, StandardCharsets.UTF_8.name()));
        } catch (Exception e) {
            System.err.println("Failed to set UTF-8 encoding for System.out");
        }
        System.out.println("Olá, Márilia! Teste de acentuação: ç, ã, é, í.");
        Menu.showMenu();
    }
}