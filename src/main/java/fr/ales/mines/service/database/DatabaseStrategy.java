package fr.ales.mines.service.database;

import fr.ales.mines.entities.Person;

import java.util.List;

public interface DatabaseStrategy {

    List<Person> listPerson();
}
