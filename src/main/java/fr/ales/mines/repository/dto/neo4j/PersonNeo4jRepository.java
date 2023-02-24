package fr.ales.mines.repository.dto.neo4j;

import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PersonNeo4jRepository extends Neo4jRepository<PersonNeo4jDto, Long> {

}
