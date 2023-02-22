package fr.ales.mines.service.database;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

@Component
public class DatabaseStrategyFactory {
    private final ApplicationContext context;

    @Autowired
    public DatabaseStrategyFactory(ApplicationContext context) {
        this.context = context;
    }

    public DatabaseStrategy getStrategy(DatabaseType type){
        switch (type){
            case SQL -> {
                return context.getBean(DatabaseStrategyPostgresSqlImpl.class);
            }
            default ->{
                return context.getBean(DatabaseStrategyMokeImpl.class);
            }
        }
    }
}
