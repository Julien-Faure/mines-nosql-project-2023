package fr.ales.mines.service.database;

import fr.ales.mines.entities.Person;
import fr.ales.mines.entities.Request1Response;
import fr.ales.mines.entities.Request2Response;
import fr.ales.mines.entities.Request3Response;
import java.util.List;

public interface DatabaseStrategy {
    List<Person> listPerson();

    default Request1Response executeRequest1(String username, int depth) {
        return Request1Response.builder().build();
    }

    default Request2Response executeRequest2(String username, int depth, String productName) {
        return Request2Response.builder().build();
    }

    default Request3Response executeRequest3() {
        return Request3Response.builder().build();
    }
}
