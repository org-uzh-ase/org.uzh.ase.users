package org.uzh.ase.users.repository;


import org.springframework.data.mongodb.repository.MongoRepository;
import org.uzh.ase.users.models.User;

import java.util.List;

public interface UserRepository extends MongoRepository<User, String> {

    public User findByName(String name);
}
