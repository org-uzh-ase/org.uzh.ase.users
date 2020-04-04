package org.uzh.ase.users.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.uzh.ase.users.models.Score;

import java.util.List;

public interface ScoreRepository extends MongoRepository<Score, String> {
    List<Score> findByUserId(String userId);
}
