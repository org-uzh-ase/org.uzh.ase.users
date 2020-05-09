package org.uzh.ase.users.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.uzh.ase.users.models.ScoreDB;

/**
 * <p>Interface to recover Score Documents from the MongoDB.
 * @link org.uzh.ase.users.models.ScoreDB
 * </p>
 */
public interface ScoreRepository extends MongoRepository<ScoreDB, String> {
}
