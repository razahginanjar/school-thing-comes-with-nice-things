package com.razah.dev.bookstore.transaction.mapper;

import com.razah.dev.bookstore.transaction.dto.response.OutletResponse;
import com.razah.dev.bookstore.transaction.entities.Outlet;

public interface OutletMapper {
    OutletResponse map(Outlet outlet);
}
