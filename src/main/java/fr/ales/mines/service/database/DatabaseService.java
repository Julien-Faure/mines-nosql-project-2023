package fr.ales.mines.service.database;

import fr.ales.mines.repository.dto.postgres.PersonDto;

import java.util.List;

public interface DatabaseService {
    void switchDatabaseType(DatabaseType databaseType);

    List<PersonDto> listPerson();
}
