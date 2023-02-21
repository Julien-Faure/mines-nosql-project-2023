package fr.ales.mines.service.database;

public enum DatabaseType {
    SQL("PostgresSQL"),
    NO_SQL("neo4j");

    private String name;

    DatabaseType(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
