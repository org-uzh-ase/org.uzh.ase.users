package org.uzh.ase.users.models;

/**
 * Data Transfer Object between Frontend and User Microservice. Not to be confused with {@link org.uzh.ase.users.models.ScoreDB}
 * which is the representation of the MongoDB document "score".
 */
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

    /**
     * Score constructor
     * @param user player name
     * @param scoreNo score achieved by player
     */
    public Score (String user, Integer scoreNo){
        this.scoreNo = scoreNo;
        this.user = user;
    }

    /**
     * Convenience constructor
     * @param scoreDB Score object retrieved from the database {@link org.uzh.ase.users.models.ScoreDB}
     */
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
