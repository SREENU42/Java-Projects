// 4. Library Management System

// Description: Track books, borrowing, returning, and availability.
// Concepts Covered: Classes, Objects, Arrays/List, Encapsulation, Inheritance.
// Features:
// Add/remove books.
// Issue and return books.
// Check availability.
// Extend for different user roles (Student, Teacher) using inheritance.

import java.util.ArrayList;

class Book {
    private int bookId;
    private String author;
    private String title;
    private boolean isAvailable;

    Book(int bookId, String author, String title, boolean isAvailable) {
        this.bookId = bookId;
        this.author = author;
        this.title = title;
        this.isAvailable = isAvailable;
    }

    public int getBookId() {
        return bookId;
    }

    public String getAuthor() {
        return author;
    }

    public String getTitle() {
        return title;
    }

    public boolean getIsAvailable() {
        return isAvailable;
    }

    public void setAvailable(boolean available) {
        this.isAvailable = available;
    }
}


class User {
    String name;
    int userId;

    User(String name, int userId) {
        this.name = name;
        this.userId = userId;
    }
}

class Student extends User {
    Student(String name, int userId) {
        super(name, userId);
    }
}

class Teacher extends User {
    Teacher(String name, int userId) {
        super(name, userId);
    }
}


class Library {

    private ArrayList<Book> books = new ArrayList<>();

    public void addBook(Book book) {
        books.add(book);
        System.out.println(book.getTitle() + " added to library.");
    }

    public void removeBook(int bookId) {
        books.removeIf(b -> b.getBookId() == bookId);
        System.out.println("Book removed successfully.");
    }

    public void issueBook(int bookId, User user) {
        for (Book book : books) {
            if (book.getBookId() == bookId && book.getIsAvailable()) {
                book.setAvailable(false);
                System.out.println(user.name + " borrowed: " + book.getTitle());
                return;
            }
        }
        System.out.println("Book is not available.");
    }

    public void returnBook(int bookId, User user) {
        for (Book book : books) {
            if (book.getBookId() == bookId && !book.getIsAvailable()) {
                book.setAvailable(true);
                System.out.println(user.name + " returned: " + book.getTitle());
                return;
            }
        }
        System.out.println("Invalid return request.");
    }

    public void showAvailableBooks() {
        System.out.println("\nAvailable Books:");
        for (Book book : books) {
            if (book.getIsAvailable()) {
                System.out.println(book.getBookId() + " - " + book.getTitle());
            }
        }
    }
}
public class LibraryManagementSystem {
    public static void main(String[] args) {

        Library library = new Library();

        Book b1 = new Book(1, "James Gosling", "Java Programming", true);
        Book b2 = new Book(2, "Narsimha Karumanchi", "Data Structures", true);

        System.out.println("--------Library Details----------");

        library.addBook(b1);
        library.addBook(b2);

        Student student = new Student("Sreenu", 101);
        Teacher teacher = new Teacher("Somesh", 102);

        library.issueBook(1, student);
        library.showAvailableBooks();

        library.returnBook(1, student);
        library.showAvailableBooks();
    }
}
