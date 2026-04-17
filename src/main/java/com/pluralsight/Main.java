package com.pluralsight;

import java.util.Scanner;

public class Main {
    static Scanner inputScanner = new Scanner(System.in);

    public static void main(String[] args) {

        Book[] books = new Book[10];

        books[0] = new Book(1, "978-0000000001", "The Hobbit", false, "");
        books[1] = new Book(2, "978-0000000002", "1984", false, "");
        books[2] = new Book(3, "978-0000000003", "To Kill a Mockingbird", false, "");
        books[3] = new Book(4, "978-0000000004", "The Great Gatsby", false, "");
        books[4] = new Book(5, "978-0000000005", "Moby Dick", false, "");
        books[5] = new Book(6, "978-0000000006", "Pride and Prejudice", false, "");
        books[6] = new Book(7, "978-0000000007", "Harry Potter", false, "");
        books[7] = new Book(8, "978-0000000008", "The Catcher in the Rye", false, "");
        books[8] = new Book(9, "978-0000000009", "The Lord of the Rings", false, "");
        books[9] = new Book(10, "978-0000000010", "The Alchemist", false, "");

        boolean keepGoing = true;

        do {
            String mainPrompt = """
                        Main Menu
                    1. Show available books
                    2. Show checked out books
                    3. Exit this awesome applicaiton
                    
                    Please enter your selection.
                    """;

            System.out.println(mainPrompt);
            String userSelection = inputScanner.nextLine();

            switch (userSelection) {
                case "1":
                    showAviableMenu(books);

                    break;

                case "2":
                    showCheckedOutMenu(books);
                    break;
                case "3":
                    keepGoing = false;
                    break;

                default:
                    System.err.println("Invalid selection");


            }


        } while (keepGoing);

    }

    private static void showAviableMenu(Book[] books) {
        boolean keepGoing = true;

        System.out.println("\nAviable Book Menu");
        System.out.println("ID\t ISBN\t\t Tittle");
        for (Book currentBook : books) {
            if (currentBook.isCheckedOut == false) {
                System.out.println(currentBook.id + " ");
                System.out.println(currentBook.isbn + " ");
                System.out.println(currentBook.tittle);
            }
        }

        String prompt = """
                
                1. Check out a book
                2. Exit to main menu
                
                Enter your selection
                
                """;

        System.out.println();
        System.out.println(prompt);
        String userSelection = inputScanner.nextLine();

        switch (userSelection) {
            case "1":

                System.out.println("Enter the ID number of the book you want to check out");
                userSelection = inputScanner.nextLine();
                int id = Integer.parseInt(userSelection);

                System.out.println("Enter your Name");
                String name = inputScanner.nextLine();

                books[id].isCheckedOut = true;
                books[id].checkedOutTo = name;
                break;
            case "2":
                break;
            default:
                System.err.println("Invalid selection");
        }


    }


    private static void showCheckedOutMenu(Book[] books) {
        System.out.println("\nChecked Out Books Menu");

        System.out.println("ID\tISBN\t\t Tittle\tCheck out to");
        for (Book currentBook : books) {
            if (currentBook.isCheckedOut) {

                System.out.println(currentBook.id + "\t");
                System.out.println(currentBook.isbn + "\t");
                System.out.println(currentBook.tittle + "\t");
                System.out.println(currentBook.checkedOutTo);
            }

        }

        String promt = """
                1. Check in a book
                2. Exit to main menu
                
                Enter your selection
                """;
        System.out.println();
        System.out.println(promt);
        String userSelection = inputScanner.nextLine();

        switch (userSelection) {
            case "1":
                System.out.println("Enter the ID number of the book you want to check in");
                userSelection = inputScanner.nextLine();
                int id = Integer.parseInt(userSelection);

                books[id].isCheckedOut = false;
                books[id].checkedOutTo = "";
                break;
            case "2":
                break;
            default:
                System.err.println("Invalid selection");



        }


    }
}
