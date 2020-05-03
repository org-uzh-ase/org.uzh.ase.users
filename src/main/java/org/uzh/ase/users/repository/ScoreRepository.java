package org.uzh.ase.users.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.uzh.ase.users.models.Score;


public interface ScoreRepository extends MongoRepository<Score, String> {
}
