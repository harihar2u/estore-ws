package com.online.estore.repository;

import com.online.estore.model.Product;
import com.online.estore.model.ProductDetail;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface ProductDetailRepository extends PagingAndSortingRepository<ProductDetail, Long> {

    @Override
    <S extends ProductDetail> S save(S s);

}
