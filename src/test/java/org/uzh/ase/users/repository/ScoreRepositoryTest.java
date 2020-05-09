package org.uzh.ase.users.repository;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.data.mongo.DataMongoTest;
import org.springframework.data.domain.Sort;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.uzh.ase.users.models.ScoreDB;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Test for {@link org.uzh.ase.users.repository.ScoreRepository}
 */
@DataMongoTest
@ExtendWith(SpringExtension.class)
public class ScoreRepositoryTest {
    @Autowired
    ScoreRepository repository;

    @Test
    public void testRepository(){
        repository.save(new ScoreDB("user1", 100));
        repository.save(new ScoreDB("user2", 1000));
        repository.save(new ScoreDB("user3", 500));

        List<ScoreDB> scores = repository.findAll(Sort.by(Sort.Direction.DESC, "scoreNo"));
        assertEquals(3, scores.size());
        ScoreDB score1 = scores.get(0);
        ScoreDB score2 = scores.get(1);
        ScoreDB score3 = scores.get(2);

        assertTrue(score1.getScoreNo() > score2.getScoreNo());
        assertTrue(score2.getScoreNo() > score3.getScoreNo());

        assertEquals("user2", score1.getUser());
        assertEquals("user3", score2.getUser());
        assertEquals("user1", score3.getUser());

        assertEquals(String.format(
                "Score[user=%s, score='%s']",
                "user1", 100), score3.toString());
    }
}