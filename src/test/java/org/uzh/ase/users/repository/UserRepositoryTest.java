package org.uzh.ase.users.repository;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.Before;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.data.mongo.DataMongoTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.uzh.ase.users.models.User;


import java.util.List;

@DataMongoTest
@ExtendWith(SpringExtension.class)
public class UserRepositoryTest {

    @Test
    public void testRepository(@Autowired UserRepository repository){
        repository.deleteAll();

        repository.save(new User("Alice", "alice@test.com"));
        List<User> users = repository.findByName("Alice");
        assertEquals(1, users.size());
        User user = users.get(0);
        assertEquals("Alice", user.getName());
        assertEquals("alice@test.com", user.getEmail());
    }
}
