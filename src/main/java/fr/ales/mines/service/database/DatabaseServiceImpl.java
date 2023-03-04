package fr.ales.mines.service.database;

import fr.ales.mines.entities.Person;
import fr.ales.mines.entities.Request1Response;
import fr.ales.mines.entities.Request2Response;
import fr.ales.mines.entities.Request3Response;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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

    @Override
    public Request1Response executeRequest1(String username, int depth) {
        return this.strategy.executeRequest1(username, depth);
    }

    @Override
    public Request2Response executeRequest2(String username, int depth, String productName) {
        return this.strategy.executeRequest2(username, depth, productName);
    }

    @Override
    public Request3Response executeRequest3() {
        return this.strategy.executeRequest3();
    }
}
