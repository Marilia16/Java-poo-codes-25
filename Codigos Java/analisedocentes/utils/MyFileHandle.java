package utils;
import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class MyFileHandle {

    // Lê o arquivo CSV e retorna as linhas como arrays de strings (sem cabeçalho)
    public static ArrayList<String[]> read(String filepath) {
        ArrayList<String[]> lines = new ArrayList<>();

        try (Scanner scanner = new Scanner(new File(filepath), "UTF-8")) {
            if (scanner.hasNextLine()) {
                scanner.nextLine(); // Ignora o cabeçalho
            }

            while (scanner.hasNextLine()) {
                String linha = scanner.nextLine();
                // Divide respeitando campos com aspas
                String[] campos = linha.split(";");
                lines.add(campos);
            }
        } catch (IOException e) {
            System.err.println("Erro ao ler o arquivo: " + e.getMessage());
        }

        return lines;
    }

    // Escreve uma lista de linhas no arquivo CSV com cabeçalho fixo
    public static void write(String filepath, ArrayList<String> linhas) {
        try (PrintWriter writer = new PrintWriter(new File(filepath), "UTF-8")) {
            writer.println("siape;nome;email"); // Cabeçalho fixo
            // Escreve cada linha
            for (String linha : linhas) {
                writer.println(linha);
            }
        } catch (IOException e) {
            System.err.println("Erro ao escrever no arquivo: " + e.getMessage());
        }
    }
}