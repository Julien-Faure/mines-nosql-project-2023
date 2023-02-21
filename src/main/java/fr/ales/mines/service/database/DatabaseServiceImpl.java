package fr.ales.mines.service.database;

import fr.ales.mines.web.rest.UserResource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
public class DatabaseServiceImpl implements DatabaseService {

    private final Logger log = LoggerFactory.getLogger(UserResource.class);

    @Override
    public void switchDatabaseType(DatabaseType databaseType) {
        log.debug("Database switched to '%s'".formatted(databaseType.getName()));
    }
}
