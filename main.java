import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Library library = new Library();

        // Add some sample books
        library.addBook(new Book(1, "Java Basics"));
        library.addBook(new Book(2, "OOP in Java"));
        library.addBook(new Book(3, "Data Structures"));

        // Register a user
        library.registerUser(new User(101, "Kashyap"));

        Scanner sc = new Scanner(System.in);
        int choice;

        do {
            System.out.println("\n--- Library Menu ---");
            System.out.println("1. Show Books");
            System.out.println("2. Issue Book");
            System.out.println("3. Return Book");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");
            choice = sc.nextInt();

            switch (choice) {
                case 1:
                    library.showAllBooks();
                    break;
                case 2:
                    System.out.print("Enter Book ID to issue: ");
                    int issueBookId = sc.nextInt();
                    library.issueBook(issueBookId, 101); // using sample user
                    break;
                case 3:
                    System.out.print("Enter Book ID to return: ");
                    int returnBookId = sc.nextInt();
                    library.returnBook(returnBookId);
                    break;
                case 4:
                    System.out.println("Exiting library system.");
                    break;
                default:
                    System.out.println("Invalid choice.");
            }
        } while (choice != 4);

        sc.close();
    }
}
