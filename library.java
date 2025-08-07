import java.util.*;

public class Library {
    private List<Book> books = new ArrayList<>();
    private List<User> users = new ArrayList<>();

    public void addBook(Book book) {
        books.add(book);
    }

    public void registerUser(User user) {
        users.add(user);
    }

    public void issueBook(int bookId, int userId) {
        Book book = findBook(bookId);
        if (book != null && !book.isIssued()) {
            book.issue();
            System.out.println("Book '" + book.getTitle() + "' issued to user ID " + userId);
        } else {
            System.out.println("Book not available or already issued.");
        }
    }

    public void returnBook(int bookId) {
        Book book = findBook(bookId);
        if (book != null && book.isIssued()) {
            book.returnBook();
            System.out.println("Book '" + book.getTitle() + "' returned.");
        } else {
            System.out.println("Invalid book or not issued.");
        }
    }

    private Book findBook(int bookId) {
        for (Book book : books) {
            if (book.getBookId() == bookId)
                return book;
        }
        return null;
    }

    public void showAllBooks() {
        for (Book book : books) {
            System.out.println(book.getBookId() + " - " + book.getTitle() +
                " [" + (book.isIssued() ? "Issued" : "Available") + "]");
        }
    }
}
