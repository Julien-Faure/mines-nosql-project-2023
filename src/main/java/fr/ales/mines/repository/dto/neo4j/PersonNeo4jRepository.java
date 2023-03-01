package fr.ales.mines.repository.dto.neo4j;

import org.neo4j.driver.Record;
import org.springframework.data.neo4j.repository.Neo4jRepository;

import org.springframework.data.neo4j.repository.query.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public interface PersonNeo4jRepository extends Neo4jRepository<PersonNeo4jDto, Long> {

    @Query("MATCH (u:User)-[r]->(n)\n" +
        "WHERE u:User\n" +
        "WITH u, collect(r) AS rels, collect(n) AS nodes\n" +
        "RETURN u, rels, nodes\n" +
        "LIMIT $limit\n")
    List<PersonNeo4jDto> findPersonWithLimit(@Param("limit") int limit);

    @Query("MATCH (u:User {name: $username})-[:Follows*1..1]->()-[p:Purchased]->(product:Product)\n" +
        "RETURN product.name AS product, sum(p.quantity) AS total_quantity, COUNT(*) AS num_purchases\n" +
        "ORDER BY total_quantity DESC")
    List<Record> executeRequest11(@Param("username") String username, @Param("depth") int depth);
}
