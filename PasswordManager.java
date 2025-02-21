import java.util.*;

public class PasswordManager {
    private Map<String, User> users = new HashMap<>();
    private List<PasswordEntry> passwords = new ArrayList<>();
    private User currentUser;

    public void registerUser() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter username: ");
        String username = sc.nextLine();
        System.out.print("Enter password: ");
        String password = sc.nextLine();

        users.put(username, new User(username, password));
        System.out.println("✅ Registration Successful! You can now log in.");
    }

    public void loginUser() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter username: ");
        String username = sc.nextLine();
        System.out.print("Enter password: ");
        String password = sc.nextLine();

        if (users.containsKey(username) && users.get(username).getPassword().equals(password)) {
            currentUser = users.get(username);
            System.out.println("✅ Login Successful! Welcome " + username);
            managePasswords();
        } else {
            System.out.println("❌ Invalid credentials!");
        }
    }

    private void managePasswords() {
        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.println("\n1. Add New Password\n2. View Passwords\n3. Logout");
            System.out.print("Choose an option: ");
            int choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {
                case 1:
                    addPassword();
                    break;
                case 2:
                    viewPasswords();
                    break;
                case 3:
                    System.out.println("Logged out successfully.");
                    return;
                default:
                    System.out.println("Invalid option. Try again!");
            }
        }
    }

    private void addPassword() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter website name: ");
        String website = sc.nextLine();
        System.out.print("Enter username: ");
        String username = sc.nextLine();
        System.out.print("Enter password: ");
        String password = sc.nextLine();

        String encryptedPassword = EncryptionUtil.encrypt(password);
        passwords.add(new PasswordEntry(website, username, encryptedPassword));
        System.out.println("✅ Password Added Securely!");
    }

    private void viewPasswords() {
        System.out.println("\n🔹 Stored Passwords 🔹");
        if (passwords.isEmpty()) {
            System.out.println("No passwords stored.");
            return;
        }
        for (PasswordEntry p : passwords) {
            System.out.println(p);
        }
    }
}
