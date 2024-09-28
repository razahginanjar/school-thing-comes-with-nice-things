package com.razah.dev.bookstore.transaction.service;

import com.razah.dev.bookstore.transaction.dto.request.CreateOutletRequest;
import com.razah.dev.bookstore.transaction.dto.request.UpdateOutletRequest;
import com.razah.dev.bookstore.transaction.dto.response.OutletResponse;
import com.razah.dev.bookstore.transaction.entity.Outlet;

import java.util.List;

public interface OutletService {
    Outlet create(CreateOutletRequest request);
    Outlet update(UpdateOutletRequest request);
    Outlet getById(String id);
    Outlet getByCode(String code);
    List<Outlet> getAll();
    void delete(String id);

    OutletResponse createResponse(CreateOutletRequest request);
    OutletResponse updateResponse(UpdateOutletRequest request);
    OutletResponse getByIdResponse(String id);
    List<OutletResponse> getAllResponses();
}
