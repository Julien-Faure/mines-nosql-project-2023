package fr.ales.mines.service.database;

import fr.ales.mines.entities.Person;
import fr.ales.mines.repository.dto.neo4j.PersonNeo4jRepository;
import fr.ales.mines.service.database.mapper.PersonMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class DatabaseStrategyNeo4jImpl implements DatabaseStrategy {

    private final PersonNeo4jRepository repository;

    @Autowired
    public DatabaseStrategyNeo4jImpl(PersonNeo4jRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<Person> listPerson() {
        List<Person> people = repository.findPersonWithLimit(10).stream().map(PersonMapper::map).toList();
        return people;
    }
}
