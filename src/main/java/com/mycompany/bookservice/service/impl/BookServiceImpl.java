package com.mycompany.bookservice.service.impl;

import com.mycompany.bookservice.dto.BookDTO;
import com.mycompany.bookservice.entity.BookEntity;
import com.mycompany.bookservice.repository.BookRepository;
import com.mycompany.bookservice.service.BookService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class BookServiceImpl implements BookService {

    @Autowired
    private BookRepository bookRepository;

    @Override
    public BookDTO addBook(BookDTO bookDTO) {
        BookEntity bookEntity = new BookEntity();
        BeanUtils.copyProperties(bookDTO, bookEntity);
        bookEntity = bookRepository.save(bookEntity);
        BeanUtils.copyProperties(bookEntity, bookDTO);
        return bookDTO;
    }

    //full update
    @Override
    public BookDTO updateBook(BookDTO bookDTO, Long bookId) {

        Optional<BookEntity> optEntity = bookRepository.findById(bookId);
        BookEntity be = null;
        if(optEntity.isPresent()){
            be = optEntity.get();
            be.setAuthorEmail(bookDTO.getAuthorEmail());
            be.setAuthorname(bookDTO.getAuthorname());
            be.setAvailability(bookDTO.getAvailability());
            be.setDescription(bookDTO.getDescription());
            be.setName(bookDTO.getName());
            be.setPricePerQty(bookDTO.getPricePerQty());
            be = bookRepository.save(be);
        }
        BeanUtils.copyProperties(be, bookDTO);
        return bookDTO;
    }

    @Override
    public void deleteBook(Long bookId) {
        bookRepository.deleteById(bookId);
    }
    @Override
    public BookDTO updateBookPrice(BookDTO bookDTO, Long bookId) {
        Optional<BookEntity> optEntity = bookRepository.findById(bookId);
        BookEntity be = null;
        if(optEntity.isPresent()){
            be = optEntity.get();
            be.setPricePerQty(bookDTO.getPricePerQty());
            be = bookRepository.save(be);
        }
        BeanUtils.copyProperties(be, bookDTO);
        return bookDTO;
    }

    @Override
    public List<BookDTO> getAllBook() {

        List<BookEntity> bookEntities = bookRepository.findAll();
        List<BookDTO> bookDtoS = null;

        if (bookEntities != null && !bookEntities.isEmpty()) {
            bookDtoS = new ArrayList<>();
            BookDTO dto = null;
            for (BookEntity be : bookEntities) {
                dto = new BookDTO();
                BeanUtils.copyProperties(be, dto);
                bookDtoS.add(dto);
            }
        }
        return bookDtoS;
    }
}
