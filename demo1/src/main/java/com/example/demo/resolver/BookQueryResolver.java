package com.example.demo.resolver;

import com.example.demo.DTO.BookPage;
import com.example.demo.model.Book;
import com.example.demo.repo.BookRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

@Controller
public class BookQueryResolver {

    private final BookRepository bookRepository;

    public BookQueryResolver(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    @QueryMapping
    public String hello() {
        return "Hello, GraphQL!";
    }

    @QueryMapping
    public Book getBook(@Argument Long id) {
        return bookRepository.findById(id).orElse(null);
    }

    @QueryMapping
    public BookPage getBooks(
            @Argument String genre,
            @Argument int page,
            @Argument int size) {

        Pageable pageable = PageRequest.of(page, size);
        Page<Book> bookPage = bookRepository.findByGenreContainingIgnoreCase(genre, pageable);

        return new BookPage(
                bookPage.getContent(),
                bookPage.getTotalPages(),
                bookPage.getTotalElements()
        );
    }
}
