package org.uzh.ase.users.models;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

@Document("session")
public class Session {
    @Id
    private String id;

    private String sessionToken;
    @Indexed
    private String userId;

    public String getId() {
        return id;
    }

    public String getSessionToken() {
        return sessionToken;
    }

    public String getUserId() {
        return userId;
    }

    public Session(){}

    public Session (String sessionToken, String userId){
        this.sessionToken = sessionToken;
        this.userId = userId;
    }
}
