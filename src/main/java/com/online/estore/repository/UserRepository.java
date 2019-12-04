package com.online.estore.repository;

import com.online.estore.model.UserDetail;
import org.springframework.data.repository.PagingAndSortingRepository;


public interface UserRepository extends PagingAndSortingRepository<UserDetail, Long> {
    @Override
    <S extends UserDetail> S save(S s);
}
