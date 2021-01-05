package com.online.estore.repository;

import com.online.estore.model.Supplier;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface SupplierRepository extends PagingAndSortingRepository<Supplier, Long> {
    @Override
    <S extends Supplier> S save(S s);
}
