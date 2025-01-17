import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        SocialMedia app = new SocialMedia();
        Scanner scanner = new Scanner(System.in);
        boolean running = true;

        while (running) {
            System.out.println("\nWelcome to Social Media Platform!");
            System.out.println("1. Register");
            System.out.println("2. Login");
            System.out.println("3. Exit");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    System.out.print("Enter username: ");
                    String username = scanner.nextLine();
                    System.out.print("Enter password: ");
                    String password = scanner.nextLine();
                    if (app.registerUser(username, password)) {
                        System.out.println("Registration successful!");
                    } else {
                        System.out.println("Username already exists!");
                    }
                    break;

                case 2:
                    System.out.print("Enter username: ");
                    username = scanner.nextLine();
                    System.out.print("Enter password: ");
                    password = scanner.nextLine();
                    if (app.loginUser(username, password)) {
                        System.out.println("Login successful!");

                        boolean loggedIn = true;
                        while (loggedIn) {
                            System.out.println("\n1. Add Friend");
                            System.out.println("2. Post Update");
                            System.out.println("3. View Feed");
                            System.out.println("4. Logout");
                            System.out.print("Enter your choice: ");
                            int loginChoice = scanner.nextInt();
                            scanner.nextLine(); // Consume newline

                            switch (loginChoice) {
                                case 1:
                                    System.out.print("Enter friend's username: ");
                                    String friendUsername = scanner.nextLine();
                                    if (app.addFriend(friendUsername)) {
                                        System.out.println("Friend added successfully!");
                                    } else {
                                        System.out.println("Friend not found!");
                                    }
                                    break;

                                case 2:
                                    System.out.print("Enter your post: ");
                                    String post = scanner.nextLine();
                                    app.postUpdate(post);
                                    System.out.println("Post added!");
                                    break;

                                case 3:
                                    app.viewFeed();
                                    break;

                                case 4:
                                    app.logoutUser();
                                    loggedIn = false;
                                    System.out.println("Logged out successfully.");
                                    break;

                                default:
                                    System.out.println("Invalid choice!");
                            }
                        }
                    } else {
                        System.out.println("Invalid username or password!");
                    }
                    break;

                case 3:
                    running = false;
                    System.out.println("Goodbye!");
                    break;

                default:
                    System.out.println("Invalid choice!");
            }
        }
        scanner.close();
    }
}
