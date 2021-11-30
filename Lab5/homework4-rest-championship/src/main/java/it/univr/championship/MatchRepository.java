package it.univr.championship;

import org.springframework.data.repository.CrudRepository;

public interface MatchRepository extends CrudRepository<Match, Long> {
    Iterable<Match> findByTeamAOrTeamB(String nameA, String nameB);
}
