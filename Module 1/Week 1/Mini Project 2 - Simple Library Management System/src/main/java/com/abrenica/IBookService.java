package com.abrenica;

import java.util.List;

public interface IBookService {

    void addBook(String bookTitle, String bookAuthor, String bookIsbn);

    void removeBook(String isbn);

    List<Book> searchBook(String ISBN);

    void showPublicationType();

    void displayAllBooks();

    List<Book> getBooks();
}