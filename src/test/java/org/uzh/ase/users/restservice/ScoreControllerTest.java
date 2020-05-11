package org.uzh.ase.users.restservice;

import de.flapdoodle.embed.process.collections.Collections;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Sort;
import org.uzh.ase.users.models.Score;
import org.uzh.ase.users.models.ScoreDB;
import org.uzh.ase.users.repository.ScoreRepository;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertTrue;


/**
 * Test for {@link org.uzh.ase.users.restservice.ScoreController}
 */
@SpringBootTest
@RunWith(MockitoJUnitRunner.class)
public class ScoreControllerTest {
    @Mock
    ScoreRepository repository;

    @InjectMocks
    private ScoreController scoreController = new ScoreController();

    @Test
    public void testGetScores(){
        ScoreDB score1 = new ScoreDB("user1", 100);
        ScoreDB score2 = new ScoreDB("user2", 1000);
        ScoreDB score3 = new ScoreDB("user3", 500);

        List<ScoreDB> scoreDBList = Collections.newArrayList(score1, score2, score3);

        Mockito.when(repository.findAll(Sort.by(Sort.Direction.DESC, "scoreNo")))
                .thenReturn(scoreDBList);

        List<Score> list = scoreController.getScores();

        assertTrue(list.size() == 3);
    }

    @Test
    public void testNoMoreThan100(){
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
}
