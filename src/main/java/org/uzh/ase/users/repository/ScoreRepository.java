package org.uzh.ase.users.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.uzh.ase.users.models.Score;
import org.uzh.ase.users.models.ScoreDB;


public interface ScoreRepository extends MongoRepository<ScoreDB, String> {
}
