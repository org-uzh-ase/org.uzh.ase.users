package org.uzh.ase.users.models;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document("score")
public class Score {
    @Id
    private String id;

    private String userId;
    private Integer score;

    public String getId() {
        return id;
    }

    public Integer getScore() {
        return score;
    }

    public String getUserId() {
        return userId;
    }

    public Score(){}

    public Score (String userId, Integer score){
        this.score = score;
        this.userId = userId;
    }

    @Override
    public String toString() {
        return String.format(
                "Score[user=%s, score='%s']",
                userId, score);
    }
}
