package org.uzh.ase.users.models;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document("score")
public class Score {
    @Id
    private String id;

    private String userId;
    private Integer scoreNo;

    public String getId() {
        return id;
    }

    public Integer getScoreNo() {
        return scoreNo;
    }

    public String getUserId() {
        return userId;
    }

    public Score(){}

    public Score (String userId, Integer scoreNo){
        this.scoreNo = scoreNo;
        this.userId = userId;
    }

    @Override
    public String toString() {
        return String.format(
                "Score[user=%s, score='%s']",
                userId, scoreNo);
    }
}
