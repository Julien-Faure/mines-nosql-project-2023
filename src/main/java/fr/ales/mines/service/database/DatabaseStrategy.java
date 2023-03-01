package fr.ales.mines.service.database;

import fr.ales.mines.entities.Person;
import fr.ales.mines.entities.Request1Response;

import java.util.List;

public interface DatabaseStrategy {

    List<Person> listPerson();

    default Request1Response executeRequest1(String username, int depth){
        return Request1Response.builder().build();
    }
}
