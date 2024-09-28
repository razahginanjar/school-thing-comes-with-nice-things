package com.razah.dev.bookstore.transaction.service.impl;

import com.razah.dev.bookstore.transaction.dto.request.CreateOutletRequest;
import com.razah.dev.bookstore.transaction.dto.request.UpdateOutletRequest;
import com.razah.dev.bookstore.transaction.dto.response.OutletResponse;
import com.razah.dev.bookstore.transaction.entity.Outlet;
import com.razah.dev.bookstore.transaction.mapper.OutletMapper;
import com.razah.dev.bookstore.transaction.repository.OutletRepository;
import com.razah.dev.bookstore.transaction.service.OutletService;
import com.razah.dev.bookstore.transaction.service.SequenceGeneratorService;
import com.razah.dev.bookstore.transaction.utils.ValidationUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Objects;

@Service
@RequiredArgsConstructor
public class OutletServiceImpl implements OutletService {
    private final OutletRepository outletRepository;
    private final SequenceGeneratorService sequenceGeneratorService;
    private final OutletMapper outletMapper;
    private final ValidationUtil validationUtil;

    @Override
    public Outlet create(CreateOutletRequest request) {
        validationUtil.validate(request);
        Outlet outlet = new Outlet();
        outlet.setCode(sequenceGeneratorService.getOutletSequence());
        outlet.setEmail(request.getEmail());
        outlet.setLocation(request.getLocation());
        outlet.setTelephone(request.getTelephone());
        return outletRepository.saveAndFlush(outlet);
    }

    @Override
    public Outlet update(UpdateOutletRequest request) {
        validationUtil.validate(request);
        Outlet byId = getById(request.getId());
        byId.setTelephone(request.getTelephone());
        byId.setEmail(request.getEmail());
        byId.setLocation(request.getLocation());
        return outletRepository.saveAndFlush(byId);
    }

    @Override
    public Outlet getById(String id) {
        if(Objects.isNull(id))
        {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, HttpStatus.BAD_REQUEST.getReasonPhrase());
        }
        return outletRepository.findById(id).orElseThrow(
                () -> new ResponseStatusException(HttpStatus.NOT_FOUND, HttpStatus.NOT_FOUND.getReasonPhrase())
        );
    }

    @Override
    public Outlet getByCode(String code) {
        if(Objects.isNull(code))
        {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, HttpStatus.BAD_REQUEST.getReasonPhrase());
        }
        return outletRepository.findByCode(code).orElseThrow(
                () -> new ResponseStatusException(HttpStatus.NOT_FOUND, HttpStatus.NOT_FOUND.getReasonPhrase())
        );
    }

    @Override
    public List<Outlet> getAll() {
        return outletRepository.findAll();
    }

    @Override
    public void delete(String id) {
        Outlet byId = getById(id);
        outletRepository.delete(byId);
    }

    @Override
    public OutletResponse createResponse(CreateOutletRequest request) {
        Outlet outlet = create(request);
        return outletMapper.map(outlet);
    }

    @Override
    public OutletResponse updateResponse(UpdateOutletRequest request) {
        Outlet update = update(request);
        return outletMapper.map(update);
    }

    @Override
    public OutletResponse getByIdResponse(String id) {
        Outlet byId = getById(id);
        return outletMapper.map(byId);
    }

    @Override
    public List<OutletResponse> getAllResponses() {
        return getAll().stream().map(
                outletMapper::map
        ).toList();
    }
}
