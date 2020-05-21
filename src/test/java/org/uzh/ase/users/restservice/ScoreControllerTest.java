package org.uzh.ase.users.restservice;

import de.flapdoodle.embed.process.collections.Collections;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.owasp.encoder.Encode;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.uzh.ase.users.models.Score;
import org.uzh.ase.users.models.ScoreDB;
import org.uzh.ase.users.repository.ScoreRepository;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;


/**
 * Test for {@link org.uzh.ase.users.restservice.ScoreController}
 */
@SpringBootTest
@RunWith(MockitoJUnitRunner.class)
public class ScoreControllerTest {
    /**
     * The actual call to the database is mocked in order to prevent side-effects
     */
    @Mock
    ScoreRepository repository;

    /**
     * The controller works as in production except for the database call which is mocked
     */
    @InjectMocks
    private ScoreController scoreController = new ScoreController();

    /**
     * Verify that the ScoreController retrieves all the scores
     */
    @Test
    void testGetScores(){
        ScoreDB score1 = new ScoreDB("user1", 100);
        ScoreDB score2 = new ScoreDB("user2", 1000);
        ScoreDB score3 = new ScoreDB("user3", 500);

        List<ScoreDB> scoreDBList = Collections.newArrayList(score1, score2, score3);

        Mockito.when(repository.findAll(Sort.by(Sort.Direction.DESC, "scoreNo")))
                .thenReturn(scoreDBList);

        List<Score> list = scoreController.getScores();

        assertTrue(list.size() == 3);
    }

    /**
     * Verify that if more than 100 scores are in the database that only 100 are returned
     */
    @Test
    void testNoMoreThan100(){
        List<ScoreDB> scoreDBList = new ArrayList<>();

        for(int i = 0; i < 105; i++){
            scoreDBList.add(new ScoreDB("user" + String.valueOf(i), 100 + 10*i));
        }

        Mockito.when(repository.findAll(Sort.by(Sort.Direction.DESC, "scoreNo")))
                .thenReturn(scoreDBList);

        List<Score> list = scoreController.getScores();

        assertTrue(scoreDBList.size() > 100);
        assertTrue(list.size() == 100);
    }

    /**
     * Verify that correct status 203 is returned
     */
    @Test
    void testPostScore(){
        Score score = new Score("test-user", 450);
        Mockito.when(repository.save(new ScoreDB(score))).thenReturn(new ScoreDB(score));
        ResponseEntity<String> response = scoreController.postScore(score);

        assertSame(HttpStatus.CREATED, response.getStatusCode());
    }
}
