import java.util.Scanner;

public class Main{
    public static void main(String args[]){
        Scanner scan = new Scanner(System.in);

        boolean running = true;
        while(running){
            System.out.println("\n Welcome to Tweets. Tweet what ever you like!");
            System.out.println("1. Regsiter");
            System.out.println("2. Login");
            System.out.println("3. Exit");
            System.out.println("Enter your choice");
            int choice = scan.nextInt();
            scan.nextLine();
        }
    }
}