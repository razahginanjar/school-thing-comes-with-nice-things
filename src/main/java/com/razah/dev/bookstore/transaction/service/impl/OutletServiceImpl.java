package com.razah.dev.bookstore.transaction.service.impl;

import com.razah.dev.bookstore.transaction.dto.request.CreateOutletRequest;
import com.razah.dev.bookstore.transaction.entity.Outlet;
import com.razah.dev.bookstore.transaction.service.OutletService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class OutletServiceImpl implements OutletService {
    @Override
    public Outlet create(CreateOutletRequest request) {
        return null;
    }

    @Override
    public Outlet update(CreateOutletRequest request) {
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
