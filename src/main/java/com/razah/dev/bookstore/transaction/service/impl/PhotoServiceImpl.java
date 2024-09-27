package com.razah.dev.bookstore.transaction.service.impl;

import com.razah.dev.bookstore.transaction.dto.request.*;
import com.razah.dev.bookstore.transaction.dto.response.PhotoResponse;
import com.razah.dev.bookstore.transaction.entity.Outlet;
import com.razah.dev.bookstore.transaction.entity.Photo;
import com.razah.dev.bookstore.transaction.entity.Product;
import com.razah.dev.bookstore.transaction.mapper.PhotoMapper;
import com.razah.dev.bookstore.transaction.repository.PhotoRepository;
import com.razah.dev.bookstore.transaction.service.*;
import com.razah.dev.bookstore.transaction.utils.ValidationUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Objects;

@Service
@RequiredArgsConstructor
public class PhotoServiceImpl implements PhotoService {
    private final PhotoRepository photoRepository;
    private final OutletService outletService;
    private final ProductService productService;
    private final SequenceGeneratorServiceImpl sequenceGenerator;
    private final StockService stockService;
    private final PhotoMapper photoMapper;
    private final ValidationUtil validationUtil;


    @Override
    public Photo create(CreatePhotoRequest request) {
        validationUtil.validate(request);

        Outlet byId = outletService.getById(request.getIdOutlet());
        String photoSequence = sequenceGenerator.getPhotoSequence(byId.getCode());

        CreateProductRequest build = CreateProductRequest
                .builder()
                .code(photoSequence)
                .price(request.getPrice())
                .build();
        Product product = productService.create(build);


        Photo photo = new Photo();
        photo.setProductPhoto(product);
        photo.setMaterial(request.getMaterial());
        photo.setSize(request.getSize());

        CreateStockRequest build1 = CreateStockRequest.builder()
                .stock(request.getStock())
                .build();

        stockService.create(build1, byId, product);
        return photoRepository.saveAndFlush(photo);
    }

    @Override
    public Photo update(UpdatePhotoRequest request) {
        validationUtil.validate(request);
        Outlet byId = outletService.getById(request.getIdOutlet());
        Photo byId1 = getById(request.getId());
        byId1.setMaterial(request.getMaterial());
        byId1.setSize(request.getSize());

        Product productPhoto = byId1.getProductPhoto();

        UpdateProductRequest build = UpdateProductRequest.builder()
                .price(request.getPrice())
                .id(productPhoto.getId())
                .build();
        productService.update(build);

        stockService.updateStock(UpdateStockRequest.builder().stock(request.getStock()).build());
        return photoRepository.saveAndFlush(byId1);
    }

    @Override
    public Photo getById(String id) {
        if(Objects.isNull(id))
        {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, HttpStatus.BAD_REQUEST.getReasonPhrase());
        }
        return photoRepository.findById(id).orElseThrow(
                () -> new ResponseStatusException(HttpStatus.NOT_FOUND, HttpStatus.NOT_FOUND.getReasonPhrase())
        );
    }

    @Override
    public List<Photo> getAll() {
        return photoRepository.findAll();
    }

    @Override
    public void delete(String id) {
        Photo byId = getById(id);
        photoRepository.delete(byId);
    }

    @Override
    public PhotoResponse createResponse(CreatePhotoRequest request) {
        Photo photo = create(request);
        return photoMapper.map(photo);
    }

    @Override
    public PhotoResponse updateResponse(UpdatePhotoRequest request) {
        Photo update = update(request);
        return photoMapper.map(update);
    }

    @Override
    public PhotoResponse getByIdResponse(String id) {
        Photo byId = getById(id);
        return photoMapper.map(byId);
    }

    @Override
    public List<PhotoResponse> getAllResponses() {
        return getAll().stream().map(
                photoMapper::map
        ).toList();
    }
}
