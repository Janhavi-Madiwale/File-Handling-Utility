import java.io.*;
import java.util.Scanner;

public class FileUtility {

    // Method to write to a file
    public static void writeFile(String filePath, String content) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath))) {
            writer.write(content);
            System.out.println("File written successfully.");
        } catch (IOException e) {
            System.err.println("Error writing to file: " + e.getMessage());
        }
    }

    // Method to read from a file
    public static void readFile(String filePath) {
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            System.out.println("File content:");
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
            }
        } catch (IOException e) {
            System.err.println("Error reading file: " + e.getMessage());
        }
    }

    // Method to append to a file
    public static void appendToFile(String filePath, String content) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath, true))) {
            writer.newLine();
            writer.write(content);
            System.out.println("Content appended successfully.");
        } catch (IOException e) {
            System.err.println("Error appending to file: " + e.getMessage());
        }
    }

    // Method to modify file (replace text)
    public static void modifyFile(String filePath, String oldWord, String newWord) {
        StringBuilder content = new StringBuilder();
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = reader.readLine()) != null) {
                content.append(line.replaceAll(oldWord, newWord)).append(System.lineSeparator());
            }
        } catch (IOException e) {
            System.err.println("Error reading file: " + e.getMessage());
            return;
        }

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath))) {
            writer.write(content.toString());
            System.out.println("File modified successfully.");
        } catch (IOException e) {
            System.err.println("Error modifying file: " + e.getMessage());
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // 1. Write to the file
        System.out.println("FILE HANDLING UTILITY");
        System.out.print("Enter the file path: ");
        String filePath = scanner.nextLine();

        System.out.print("Enter content to write to the file: ");
        String content = scanner.nextLine();
        writeFile(filePath, content);

        // 2. Read the file
        readFile(filePath);

        // 3. Append to the file
        System.out.print("Enter content to append to the file: ");
        String appendContent = scanner.nextLine();
        appendToFile(filePath, appendContent);

        // 4. Read the updated file
        readFile(filePath);

        // 5. Modify (replace words) in the file    
        System.out.print("Enter the word to replace: ");
        String oldWord = scanner.nextLine();
        System.out.print("Enter the new word: ");
        String newWord = scanner.nextLine();
        modifyFile(filePath, oldWord, newWord);

        // 6. Final file read
        readFile(filePath);

        scanner.close();
    }
}
