package com.razah.dev.bookstore.transaction.service.impl;

import com.razah.dev.bookstore.transaction.dto.request.CreateProductPriceRequest;
import com.razah.dev.bookstore.transaction.dto.request.CreateProductRequest;
import com.razah.dev.bookstore.transaction.dto.request.UpdateProductRequest;
import com.razah.dev.bookstore.transaction.dto.response.ProductResponse;
import com.razah.dev.bookstore.transaction.entities.Product;
import com.razah.dev.bookstore.transaction.entities.PhotoPrice;
import com.razah.dev.bookstore.transaction.mapper.ProductMapper;
import com.razah.dev.bookstore.transaction.repository.ProductRepository;
import com.razah.dev.bookstore.transaction.service.ProductPriceService;
import com.razah.dev.bookstore.transaction.service.ProductService;
import com.razah.dev.bookstore.transaction.utils.ValidationUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Objects;

@Service
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService {
    private final ProductRepository productRepository;
    private final ProductMapper productMapper;
    private final ProductPriceService productPriceService;
    private final ValidationUtil validationUtil;

    @Override
    public Product create(CreateProductRequest request) {
        validationUtil.validate(request);
        Product product = new Product();
        PhotoPrice photoPrice =
                productPriceService.create(CreateProductPriceRequest.builder().price(request.getPrice()).build());
        product.setCode(request.getCode());
        product.setProductPrice(photoPrice);
        return productRepository.saveAndFlush(product);
    }

    @Override
    public Product update(UpdateProductRequest request) {
        validationUtil.validate(request);
        Product byId = getById(request.getId());
        PhotoPrice photoPrice =
                productPriceService.create(CreateProductPriceRequest.builder().price(request.getPrice()).build());
        byId.setProductPrice(photoPrice);
        return productRepository.saveAndFlush(byId);
    }

    @Override
    public Product getById(String id) {
        if(Objects.isNull(id))
        {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, HttpStatus.BAD_REQUEST.getReasonPhrase());
        }
        return productRepository.findById(id).orElseThrow(
                () -> new ResponseStatusException(HttpStatus.NOT_FOUND, HttpStatus.NOT_FOUND.getReasonPhrase())
        );
    }

    @Override
    public Product getByCode(String code) {
        if(Objects.isNull(code))
        {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, HttpStatus.BAD_REQUEST.getReasonPhrase());
        }
        return productRepository.findByCode(code).orElseThrow(
                () -> new ResponseStatusException(HttpStatus.NOT_FOUND, HttpStatus.NOT_FOUND.getReasonPhrase())
        );
    }

    @Override
    public List<Product> getAll() {
        return productRepository.findAll();
    }

    @Override
    public void delete(String id) {
        Product byId = getById(id);
        productRepository.delete(byId);
    }

    @Override
    public ProductResponse createResponse(CreateProductRequest request) {
        Product product = create(request);
        return productMapper.map(product);
    }

    @Override
    public ProductResponse updateResponse(UpdateProductRequest request) {
        Product update = update(request);
        return productMapper.map(update);
    }

    @Override
    public ProductResponse getByIdResponse(String id) {
        Product byId = getById(id);
        return productMapper.map(byId);
    }

    @Override
    public List<ProductResponse> getAllResponses() {
        return getAll().stream().map(
                productMapper::map
        ).toList();
    }
}
