package ee.eek.bigsmall.repository;
// "repository" package provides data persistence

import ee.eek.bigsmall.model.Game;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

// CrudRepository generates CRUD methods
@Repository
public interface GameRepository extends CrudRepository<Game, Long> {
    // Let's return List<Game> instead of Iterable<Game>
    @Override
    List<Game> findAll();
}
