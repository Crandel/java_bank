package com.banktest.repo;

import java.util.List;

import com.banktest.models.User;
import org.springframework.data.repository.CrudRepository;

public interface  UserRepository extends CrudRepository<User, Long> {

    List<User> findByLastName(String lastName);
}
