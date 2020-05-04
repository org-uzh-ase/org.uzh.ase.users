package org.uzh.ase.users.restservice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.*;
import org.uzh.ase.users.models.Score;
import org.uzh.ase.users.models.ScoreDB;
import org.uzh.ase.users.repository.ScoreRepository;

import java.util.List;

@RestController
public class ScoreController {
    @Autowired
    ScoreRepository repository;

    @GetMapping(path = "/api/scores")
    public List<ScoreDB> getScores(){
        List<ScoreDB> result = repository.findAll(Sort.by(Sort.Direction.DESC, "scoreNo"));
        if(result.size() > 100){
            return result.subList(0, 100);
        }

        return result;

    }

    @PostMapping(path = "/api/scores/score")
    public void postScore(@RequestBody Score score){
        repository.save(new ScoreDB(score));
    }
}
