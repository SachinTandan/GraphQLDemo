package com.example.demo.resolver;


import com.example.demo.model.Book;
import com.example.demo.repo.BookRepository;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.stereotype.Controller;

@Controller
public class BookMutationResolver {

    private final BookRepository bookRepository;

    public BookMutationResolver(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    @MutationMapping
    public Book addBook(@Argument String title, @Argument String author) {
        Book book = new Book();
        book.setTitle(title);
        book.setAuthor(author);
        return bookRepository.save(book);
    }
}
