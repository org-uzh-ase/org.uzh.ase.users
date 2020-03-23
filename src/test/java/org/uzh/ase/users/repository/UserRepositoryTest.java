package org.uzh.ase.users.repository;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.uzh.ase.users.models.User;

import java.util.List;


@SpringBootTest
public class UserRepositoryTest {

    @Autowired
    private UserRepository repository;

    @Test
    public void testRepository(){
        setup();

        repository.save(new User("Alice", "alice@test.com"));
        List<User> users = repository.findByName("Alice");
        assertEquals(1, users.size());
        User user = users.get(0);
        assertEquals("Alice", user.getName());
        assertEquals("alice@test.com", user.getEmail());
    }

    public void setup(){
        repository.deleteAll();
    }
}
