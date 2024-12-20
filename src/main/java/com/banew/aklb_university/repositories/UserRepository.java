package com.banew.aklb_university.repositories;

import org.springframework.data.repository.CrudRepository;
import com.banew.aklb_university.entities.User;

public interface UserRepository extends CrudRepository<User, Long> {

}
