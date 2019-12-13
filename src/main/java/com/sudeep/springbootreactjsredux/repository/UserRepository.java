package com.sudeep.springbootreactjsredux.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;



import com.sudeep.springbootreactjsredux.model.User;

@Repository
public interface UserRepository extends CrudRepository<User, Long> {


    User findByUsername(String username);
    User getById(Long id);


}