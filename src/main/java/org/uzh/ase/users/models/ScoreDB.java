package org.uzh.ase.users.models;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document("score")
public class ScoreDB {
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

    public ScoreDB(){}

    public ScoreDB(String user, Integer scoreNo){
        this.scoreNo = scoreNo;
        this.user = user;
    }

    public ScoreDB(Score score){
        this.scoreNo = score.getScoreNo();
        this.user = score.getUser();
    }

    @Override
    public String toString() {
        return String.format(
                "Score[user=%s, score='%s']",
                user, scoreNo);
    }
}
