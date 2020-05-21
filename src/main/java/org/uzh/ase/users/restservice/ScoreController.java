package org.uzh.ase.users.restservice;

import java.util.ArrayList;
import java.util.List;

import org.owasp.encoder.Encode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.uzh.ase.users.models.Score;
import org.uzh.ase.users.models.ScoreDB;
import org.uzh.ase.users.repository.ScoreRepository;

/**
 * REST API for the User Microservice
 *
 * <p>More detailed API Documentation available on
 * <a href="https://app.swaggerhub.com/apis-docs/ltoedt/ASE/0.1">SwaggerHub</a>
 * </p>
 */
@RestController
public class ScoreController {
    @Autowired
    ScoreRepository repository;

    /**
     * REST API getScores(). Checkout the <a href="https://app.swaggerhub.com/apis-docs/ltoedt/ASE/0.1#/User%20Microservice/get_api_scores">Swagger Documentation</a>
     * @return List of {@link Score}
     */
    @GetMapping(path = "/api/scores")
    public List<Score> getScores(){
            List<ScoreDB> resultDB = repository.findAll(Sort.by(Sort.Direction.DESC, "scoreNo"));
            List<Score> result = new ArrayList<>();

            if (resultDB.size() > 100) {
                for (ScoreDB scoreDB : resultDB.subList(0, 100)) {
                    result.add(new Score(scoreDB));
                }
            } else {
                for (ScoreDB scoreDB : resultDB) {
                    result.add(new Score(scoreDB));
                }
            }
            return result;
    }

    /**
     * REST API postScore(). Checkout the <a href="https://app.swaggerhub.com/apis-docs/ltoedt/ASE/0.1#/User%20Microservice/post_api_scores_score">Swagger Documentation</a>
     * @return String representation of the score
     */
    @PostMapping(path = "/api/scores/score")
    public ResponseEntity<String> postScore(@RequestBody Score score){
            repository.save(new ScoreDB(score));
            String encodeScore = Encode.forHtmlContent(score.toString());
            return new ResponseEntity<>(encodeScore, HttpStatus.CREATED);
    }
}
