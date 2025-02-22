package com.example.demo.DTO;

import com.example.demo.model.Book;

import java.util.List;

public class BookPage {
    private List<Book> books;
    private int totalPages;
    private long totalElements;

    public BookPage(List<Book> books, int totalPages, long totalElements) {
        this.books = books;
        this.totalPages = totalPages;
        this.totalElements = totalElements;
    }

    public List<Book> getBooks() {
        return books;
    }

    public int getTotalPages() {
        return totalPages;
    }

    public long getTotalElements() {
        return totalElements;
    }
}
