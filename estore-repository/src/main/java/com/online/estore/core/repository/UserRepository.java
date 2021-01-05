package com.online.estore.repository;

import com.online.estore.model.User;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface UserRepository extends PagingAndSortingRepository<User, Long>  {
    User findByUsername(String username);
}

