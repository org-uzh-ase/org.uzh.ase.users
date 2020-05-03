package org.uzh.ase.users.models;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document("score")
public class Score {
    @Id
    private String id;

    private String user;
    private Integer scoreNo;

    public String getId() {
        return id;
    }

    public Integer getScoreNo() {
        return scoreNo;
    }

    public String getUser() {
        return user;
    }

    public Score (String user, Integer scoreNo){
        this.scoreNo = scoreNo;
        this.user = user;
    }

    @Override
    public String toString() {
        return String.format(
                "Score[user=%s, score='%s']",
                user, scoreNo);
    }
}
