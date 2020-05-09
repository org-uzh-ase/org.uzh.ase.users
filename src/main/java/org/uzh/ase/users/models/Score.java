package org.uzh.ase.users.models;

public class Score {
    private String user;
    private Integer scoreNo;

    public Integer getScoreNo() {
        return scoreNo;
    }

    public String getUser() {
        return user;
    }

    public Score(){}

    public Score (String user, Integer scoreNo){
        this.scoreNo = scoreNo;
        this.user = user;
    }

    public Score(ScoreDB scoreDB){
        this.user = scoreDB.getUser();
        this.scoreNo = scoreDB.getScoreNo();
    }

    @Override
    public String toString() {
        return String.format(
                "Score[user=%s, score='%s']",
                user, scoreNo);
    }
}
