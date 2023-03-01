package fr.ales.mines.service.database;

import fr.ales.mines.entities.*;
import fr.ales.mines.repository.dto.neo4j.Neo4jRepoCustom;
import fr.ales.mines.repository.dto.neo4j.PersonNeo4jRepository;
import fr.ales.mines.service.database.mapper.PersonMapper;
import fr.ales.mines.service.database.mapper.RequestResponseMapper;
import java.util.List;
import org.neo4j.driver.Record;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class DatabaseStrategyNeo4jImpl implements DatabaseStrategy {

    private final PersonNeo4jRepository repository;
    private final Neo4jRepoCustom customRepo;

    @Autowired
    public DatabaseStrategyNeo4jImpl(PersonNeo4jRepository repository) {
        this.repository = repository;
        this.customRepo = new Neo4jRepoCustom();
    }

    @Override
    public List<Person> listPerson() {
        List<Person> people = repository.findPersonWithLimit(10).stream().map(PersonMapper::map).toList();
        return people;
    }

    @Override
    public Request1Response executeRequest1(String username, int depth) {
        try {
            long start = System.currentTimeMillis();
            List<Record> request11 = this.customRepo.executeRequest11(username, depth);
            Record request12 = this.customRepo.executeRequest12(username, depth);

            List<Request11Response> request11Responses = request11.stream().map(RequestResponseMapper::map11).toList();
            Request12Response request12Response = RequestResponseMapper.map12(request12);

            return Request1Response
                .builder()
                .elapsedMsTime(System.currentTimeMillis() - start)
                .request11Response(request11Responses)
                .request12Response(request12Response)
                .build();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public Request2Response executeRequest2(String username, int depth, String productName) {
        try {
            long start = System.currentTimeMillis();
            Record request2 = this.customRepo.executeRequest2(username, depth, username);

            Request20Response response = RequestResponseMapper.map2(request2);

            return Request2Response.builder().elapsedMsTime(System.currentTimeMillis() - start).payload(response).build();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public Request3Response executeRequest3(String productName, int depth) {
        try {
            long start = System.currentTimeMillis();
            Record request3 = this.customRepo.executeRequest3(productName, depth);

            Request30Response response = RequestResponseMapper.map3(request3);

            return Request3Response.builder().elapsedMsTime(System.currentTimeMillis() - start).payload(response).build();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
