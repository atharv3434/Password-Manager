import java.io.*;
import java.util.List;

public class FileHandler1 {
    public static void savePasswords(List<PasswordEntry> passwords) {
        try (FileWriter writer = new FileWriter("passwords.txt", true)) {
            for (PasswordEntry p : passwords) {
                writer.write(p.getWebsite() + "," + p.getUsername() + "," + p.getEncryptedPassword() + "\n");
            }
        } catch (IOException e) {
            System.out.println("❌ Error saving passwords.");
        }
    }

    public static void loadPasswords(List<PasswordEntry> passwords) {
        try (BufferedReader reader = new BufferedReader(new FileReader("passwords.txt"))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",");
                passwords.add(new PasswordEntry(parts[0], parts[1], parts[2]));
            }
        } catch (IOException e) {
            System.out.println("❌ Error loading passwords.");
        }
    }
}
