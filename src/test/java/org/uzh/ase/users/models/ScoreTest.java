package org.uzh.ase.users.models;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ScoreTest {
    @Test
    public void testInit(){
        Score score = new Score("test-username", 120);
        assertEquals("test-username", score.getUser());
        assertEquals(120, score.getScoreNo());
    }
}
