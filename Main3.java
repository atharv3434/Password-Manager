import java.util.Scanner;

public class Main3 {
    private static PasswordManager passwordManager = new PasswordManager();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("🔐 Welcome to Secure Password Manager 🔐");

        while (true) {
            System.out.println("\n1. Register\n2. Login\n3. Exit");
            System.out.print("Choose an option: ");
            int choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {
                case 1:
                    passwordManager.registerUser();
                    break;
                case 2:
                    passwordManager.loginUser();
                    break;
                case 3:
                    System.out.println("Exiting... Stay Secure! 🔒");
                    sc.close();
                    System.exit(0);
                    break;
                default:
                    System.out.println("Invalid choice, try again!");
            }
        }
    }
}
