package com.razah.dev.bookstore.transaction.service;

import com.razah.dev.bookstore.transaction.dto.request.CustomerRequest;
import com.razah.dev.bookstore.transaction.dto.request.OutletRequest;
import com.razah.dev.bookstore.transaction.entity.Customer;
import com.razah.dev.bookstore.transaction.entity.Outlet;

import java.util.List;

public interface OutletService {
    Outlet create(OutletRequest request);
    Outlet update(OutletRequest request);
    Outlet getById(String id);
    List<Outlet> getAll();
    void delete(String id);
}
