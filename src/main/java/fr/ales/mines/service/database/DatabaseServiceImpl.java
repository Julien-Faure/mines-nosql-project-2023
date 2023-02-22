package fr.ales.mines.service.database;

import fr.ales.mines.entities.Person;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DatabaseServiceImpl implements DatabaseService {

    private final Logger log = LoggerFactory.getLogger(DatabaseServiceImpl.class);

    private DatabaseStrategy strategy;
    private final DatabaseStrategyFactory strategyFactory;

    @Autowired
    public DatabaseServiceImpl(DatabaseStrategyFactory strategyFactory) {
        this.strategy = strategyFactory.getStrategy(DatabaseType.SQL);
        this.strategyFactory = strategyFactory;
    }

    @Override
    public void switchDatabaseType(DatabaseType databaseType) {
        log.debug("Database switched to '%s'".formatted(databaseType.getName()));
        this.strategy = this.strategyFactory.getStrategy(databaseType);
        log.debug("Database strategy class update to %s".formatted(this.strategy.getClass().getName()));
    }

    @Override
    public List<Person> listPerson() {
        return strategy.listPerson();
    }
}
