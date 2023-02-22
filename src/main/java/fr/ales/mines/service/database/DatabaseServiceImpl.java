package fr.ales.mines.service.database;

import fr.ales.mines.repository.PersonRepository;
import fr.ales.mines.repository.dto.postgres.PersonDto;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DatabaseServiceImpl implements DatabaseService {

    private final Logger log = LoggerFactory.getLogger(DatabaseServiceImpl.class);

    private final PersonRepository repository;

    @Autowired
    public DatabaseServiceImpl(PersonRepository repository) {
        this.repository = repository;
    }

    @Override
    public void switchDatabaseType(DatabaseType databaseType) {
        log.debug("Database switched to '%s'".formatted(databaseType.getName()));
    }

    @Override
    public List<PersonDto> listPerson() {
        return repository.findAll();
    }
}
