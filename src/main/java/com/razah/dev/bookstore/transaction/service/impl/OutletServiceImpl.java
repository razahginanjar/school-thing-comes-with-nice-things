package com.razah.dev.bookstore.transaction.service.impl;

import com.razah.dev.bookstore.transaction.dto.request.OutletRequest;
import com.razah.dev.bookstore.transaction.entity.Outlet;
import com.razah.dev.bookstore.transaction.service.OutletService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class OutletServiceImpl implements OutletService {
    @Override
    public Outlet create(OutletRequest request) {
        return null;
    }

    @Override
    public Outlet update(OutletRequest request) {
        return null;
    }

    @Override
    public Outlet getById(String id) {
        return null;
    }

    @Override
    public List<Outlet> getAll() {
        return List.of();
    }

    @Override
    public void delete(String id) {

    }
}
