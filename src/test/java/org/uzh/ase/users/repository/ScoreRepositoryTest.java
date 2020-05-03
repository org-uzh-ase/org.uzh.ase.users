package org.uzh.ase.users.repository;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.data.mongo.DataMongoTest;
import org.springframework.data.domain.Sort;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.uzh.ase.users.models.Score;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@DataMongoTest
@ExtendWith(SpringExtension.class)
public class ScoreRepositoryTest {
    @Autowired
    ScoreRepository repository;

    @Test
    public void testRepository(){
        repository.save(new Score("user1", 100));
        repository.save(new Score("user2", 1000));
        repository.save(new Score("user3", 500));

        List<Score> scores = repository.findAll(Sort.by(Sort.Direction.DESC, "scoreNo"));
        assertEquals(3, scores.size());
        Score score1 = scores.get(0);
        Score score2 = scores.get(1);
        Score score3 = scores.get(2);

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