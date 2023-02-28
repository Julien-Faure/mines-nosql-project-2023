package fr.ales.mines.service.database;

import fr.ales.mines.entities.Person;
import fr.ales.mines.repository.dto.postgres.PersonPostgresRepository;
import fr.ales.mines.service.database.mapper.PersonMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class DatabaseStrategyPostgresSqlImpl implements DatabaseStrategy {

    private final PersonPostgresRepository repository;

    @Autowired
    public DatabaseStrategyPostgresSqlImpl(PersonPostgresRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<Person> listPerson() {
        return repository.findAll().stream().map(PersonMapper::map).toList();
    }
}