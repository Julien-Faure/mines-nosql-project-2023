package fr.ales.mines.service.database;

import fr.ales.mines.entities.Person;
import fr.ales.mines.entities.Request11Response;
import fr.ales.mines.entities.Request12Response;
import fr.ales.mines.entities.Request1Response;
import fr.ales.mines.repository.dto.neo4j.Neo4jRepoCustom;
import fr.ales.mines.repository.dto.neo4j.PersonNeo4jRepository;
import fr.ales.mines.service.database.mapper.PersonMapper;
import fr.ales.mines.service.database.mapper.RequestResponseMapper;
import org.neo4j.driver.Record;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

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

            return Request1Response.builder().elapsedMsTime(System.currentTimeMillis() - start).request11Response(request11Responses).request12Response(request12Response).build();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
