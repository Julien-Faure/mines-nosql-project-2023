package fr.ales.mines.service.database;

public interface DatabaseService extends DatabaseStrategy {
    void switchDatabaseType(DatabaseType databaseType);
}
