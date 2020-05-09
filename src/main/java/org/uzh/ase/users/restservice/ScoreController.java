package org.uzh.ase.users.restservice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.*;
import org.uzh.ase.users.models.Score;
import org.uzh.ase.users.models.ScoreDB;
import org.uzh.ase.users.repository.ScoreRepository;

import java.util.ArrayList;
import java.util.List;

@RestController
public class ScoreController {
    @Autowired
    ScoreRepository repository;

    @GetMapping(path = "/api/scores")
    public List<Score> getScores(){
        List<ScoreDB> resultDB = repository.findAll(Sort.by(Sort.Direction.DESC, "scoreNo"));
        List<Score> result = new ArrayList<>();

        if(resultDB.size() > 100){
            for(ScoreDB scoreDB : resultDB.subList(0, 100)){
                result.add(new Score(scoreDB));
            };
        }else{
            for(ScoreDB scoreDB : resultDB){
                result.add(new Score(scoreDB));
            };
        }
        return result;
    }

    @PostMapping(path = "/api/scores/score")
    public void postScore(@RequestBody Score score){
        repository.save(new ScoreDB(score));
    }
}
