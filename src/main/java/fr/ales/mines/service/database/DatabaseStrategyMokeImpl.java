package fr.ales.mines.service.database;

import fr.ales.mines.entities.Person;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class DatabaseStrategyMokeImpl implements DatabaseStrategy {
    @Override
    public List<Person> listPerson() {
        return List.of();
    }
}
