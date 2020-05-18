package org.uzh.ase.users.models;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * Test for {@link org.uzh.ase.users.models.Score} and {@link org.uzh.ase.users.models.ScoreDB}
 */
public class ScoreTest {

    /**
     * Verify correct instantiation of {@link org.uzh.ase.users.models.Score} and {@link org.uzh.ase.users.models.ScoreDB}
     */
    @Test
    public void testInit(){
        Score score = new Score("test-username", 120);
        assertEquals("test-username", score.getUser());
        assertEquals(120, score.getScoreNo());

        ScoreDB scoreDB = new ScoreDB(score);
        assertEquals("test-username", scoreDB.getUser());
        assertEquals(120, scoreDB.getScoreNo());
    }
}
