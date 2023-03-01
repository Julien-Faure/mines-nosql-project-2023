package fr.ales.mines.repository.dto.neo4j;

import org.neo4j.driver.*;
import org.neo4j.driver.Record;

import java.util.List;

public class Neo4jRepoCustom implements AutoCloseable {

    private final Driver driver;

    public Neo4jRepoCustom() {
        this.driver = GraphDatabase.driver("bolt://localhost:7687", AuthTokens.basic("neo4j", "rootroot"));
    }

    public List<Record> executeRequest11(String username, int depth) throws Exception{
        try(Session session = this.driver.session()){
            List<Record> records = session.writeTransaction(tx -> {
                Query query = new Query(
                    """
                    MATCH (u:User {name: '%s'})-[:Follows*1..%d]->()-[p:Purchased]->(product:Product)
                    RETURN product.name AS product, sum(p.quantity) AS total_quantity, COUNT(*) AS num_purchases
                    ORDER BY total_quantity DESC""".formatted(username, depth));

                Result result = tx.run(query);

                return result.list();
            });

            return records;
        }
        catch (Exception e){
            throw e;
        }
    }

    public Record executeRequest12(String username, int depth) throws Exception{
        try(Session session = this.driver.session()){
            Record record = session.writeTransaction(tx -> {
                Query query = new Query(
                    """
                        MATCH (u:User{name:'%s'})-[:Follows*1..%d]->()-[p:Purchased]->(product:Product)
                        RETURN COUNT(DISTINCT product) AS num_products, COUNT(p) AS num_purchases, SUM(p.quantity) AS total_quantity;"""
                        .formatted(username, depth));

                Result result = tx.run(query);

                return result.single();
            });

            return record;
        }
        catch (Exception e){
            throw e;
        }
    }

    @Override
    public void close() {
        this.driver.close();
    }
}
