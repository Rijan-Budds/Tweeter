import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        SocialMedia app = new SocialMedia();
        String currentUser = null;

        while (true) {
            if (currentUser == null) {
                System.out.println("Welcome to Social Media Platform!");
                System.out.println("1. Register");
                System.out.println("2. Login");
                System.out.println("3. Exit");
                System.out.print("Enter your choice: ");
                int choice = scanner.nextInt();
                scanner.nextLine(); // Consume newline

                if (choice == 1) {
                    System.out.print("Enter username: ");
                    String username = scanner.nextLine();
                    System.out.print("Enter password: ");
                    String password = scanner.nextLine();
                    if (app.registerUser(username, password)) {
                        System.out.println("Registration successful!");
                    } else {
                        System.out.println("Username already exists!");
                    }
                } else if (choice == 2) {
                    System.out.print("Enter username: ");
                    String username = scanner.nextLine();
                    System.out.print("Enter password: ");
                    String password = scanner.nextLine();
                    if (app.loginUser(username, password)) {
                        currentUser = username;
                        System.out.println("Login successful!");
                    } else {
                        System.out.println("Invalid username or password!");
                    }
                } else if (choice == 3) {
                    System.out.println("Exiting...");
                    break;
                } else {
                    System.out.println("Invalid choice!");
                }
            } else {
                System.out.println("Post-Login Options:");
                System.out.println("1. Create Post");
                System.out.println("2. View Posts");
                System.out.println("3. Logout");
                System.out.print("Enter your choice: ");
                int choice = scanner.nextInt();
                scanner.nextLine(); // Consume newline

                if (choice == 1) {
                    System.out.print("Enter your post content: ");
                    String postContent = scanner.nextLine();
                    app.addPost(currentUser, postContent);
                    System.out.println("Post created: " + postContent);
                } else if (choice == 2) {
                    System.out.println("Displaying all posts:");
                    for (String post : app.getPosts()) {
                        System.out.println(post);
                    }
                } else if (choice == 3) {
                    currentUser = null;
                } else {
                    System.out.println("Invalid choice!");
                }
            }
        }

        scanner.close();
    }
}
