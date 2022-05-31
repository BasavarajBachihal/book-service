package com.mycompany.bookservice.service;

import com.mycompany.bookservice.dto.BookDTO;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

public interface BookService {

    public BookDTO addBook(BookDTO bookDTO);

    public BookDTO updateBook(BookDTO bookDTO, Long bookId);

    public void deleteBook(Long bookId);

    public BookDTO updateBookPrice(BookDTO bookDTO, Long bookId);

    public List<BookDTO> getAllBook();
}