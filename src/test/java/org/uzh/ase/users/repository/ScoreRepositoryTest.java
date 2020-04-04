package org.uzh.ase.users.repository;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.data.mongo.DataMongoTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.uzh.ase.users.models.Score;
import org.uzh.ase.users.models.User;
import org.uzh.ase.users.repository.UserRepository;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@DataMongoTest
@ExtendWith(SpringExtension.class)
public class ScoreRepositoryTest {

    @Test
    public void testRepository(@Autowired ScoreRepository repository){
        repository.deleteAll();

        repository.save(new Score("userId", 100));
        List<Score> scores = repository.findByUserId("userId");
        assertEquals(1, scores.size());
        Score score = scores.get(0);
        assertEquals("userId", score.getUserId());
        assertEquals(100, score.getScore());
    }
}