package com.pluralsight;

public class Book {

    int id;
    String isbn;
    String tittle;
    boolean isCheckedOut;
    String checkedOutTo;

    public Book(int id, String isbn, String tittle, boolean isCheckedOut, String checkedOutTo) {
        this.id = id;
        this.isbn = isbn;
        this.tittle = tittle;
        this.isCheckedOut = isCheckedOut;
        this.checkedOutTo = checkedOutTo;
    }
}
