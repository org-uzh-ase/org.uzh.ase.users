package org.uzh.ase.users.models;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SessionTest {
    @Test
    public void testInit(){
        Session session = new Session("test_session_token", "test_user_id");
        assertEquals("test_user_id", session.getUserId());
        assertEquals("test_session_token", session.getSessionToken());
    }
}
