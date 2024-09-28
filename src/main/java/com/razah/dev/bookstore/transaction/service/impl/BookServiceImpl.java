package com.razah.dev.bookstore.transaction.service.impl;

import com.razah.dev.bookstore.transaction.dto.request.*;
import com.razah.dev.bookstore.transaction.dto.response.BookResponse;
import com.razah.dev.bookstore.transaction.dto.response.PhotoResponse;
import com.razah.dev.bookstore.transaction.entity.*;
import com.razah.dev.bookstore.transaction.mapper.BookMapper;
import com.razah.dev.bookstore.transaction.repository.BookRepository;
import com.razah.dev.bookstore.transaction.service.BookService;
import com.razah.dev.bookstore.transaction.service.OutletService;
import com.razah.dev.bookstore.transaction.service.ProductService;
import com.razah.dev.bookstore.transaction.service.StockService;
import com.razah.dev.bookstore.transaction.utils.ValidationUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Objects;

@Service
@RequiredArgsConstructor
public class BookServiceImpl implements BookService {
    private final BookRepository bookRepository;
    private final OutletService outletService;
    private final ProductService productService;
    private final SequenceGeneratorServiceImpl sequenceGenerator;
    private final StockService stockService;
    private final BookMapper bookMapper;
    private final ValidationUtil validationUtil;

    @Override
    public Book create(CreateBookRequest request) {
        validationUtil.validate(request);

        Outlet byId = outletService.getById(request.getIdOutlet());
        String photoSequence = sequenceGenerator.getBookSequence();

        CreateProductRequest build = CreateProductRequest
                .builder()
                .code(photoSequence)
                .price(request.getPrice())
                .build();
        Product product = productService.create(build);

        Book book = new Book();
        book.setName(request.getName());
        book.setType(request.getType());
        book.setProductBook(product);

        CreateStockRequest build1 = CreateStockRequest.builder()
                .stock(request.getStock())
                .build();

        stockService.create(build1, byId, product);
        return bookRepository.saveAndFlush(book);
    }

    @Override
    public Book update(UpdateBookRequest request) {
        validationUtil.validate(request);
        Outlet byId = outletService.getById(request.getIdOutlet());
        Book byId1 = getById(request.getId());
        byId1.setName(request.getName());
        byId1.setType(request.getType());

        Product productPhoto = byId1.getProductBook();

        UpdateProductRequest build = UpdateProductRequest.builder()
                .price(request.getPrice())
                .id(productPhoto.getId())
                .build();
        productService.update(build);

        stockService.updateStock(UpdateStockRequest.builder().stock(request.getStock()).build());
        return bookRepository.saveAndFlush(byId1);
    }

    @Override
    public Book getById(String id) {
        if(Objects.isNull(id))
        {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, HttpStatus.BAD_REQUEST.getReasonPhrase());
        }
        return bookRepository.findById(id).orElseThrow(
                () -> new ResponseStatusException(HttpStatus.NOT_FOUND, HttpStatus.NOT_FOUND.getReasonPhrase())
        );
    }

    @Override
    public List<Book> getAll() {
        return bookRepository.findAll();
    }

    @Override
    public void delete(String id) {
        Book byId = getById(id);
        bookRepository.delete(byId);
    }

    @Override
    public BookResponse createResponse(CreateBookRequest request) {
        Book photo = create(request);
        return bookMapper.map(photo);
    }

    @Override
    public BookResponse updateResponse(UpdateBookRequest request) {
        Book update = update(request);
        return bookMapper.map(update);
    }

    @Override
    public BookResponse getByIdResponse(String id) {
        Book byId = getById(id);
        return bookMapper.map(byId);
    }

    @Override
    public List<BookResponse> getAllResponses() {
        return getAll().stream().map(
                bookMapper::map
        ).toList();
    }
}
