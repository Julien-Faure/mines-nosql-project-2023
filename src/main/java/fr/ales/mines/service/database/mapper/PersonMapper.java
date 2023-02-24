package fr.ales.mines.service.database.mapper;

import fr.ales.mines.entities.Person;
import fr.ales.mines.entities.PersonMinimized;
import fr.ales.mines.repository.dto.neo4j.PersonNeo4jDto;
import fr.ales.mines.repository.dto.postgres.PersonPostgresDto;

import java.util.ArrayList;
import java.util.List;

public abstract class PersonMapper {

    public static Person map(PersonPostgresDto dto) {
        List<PersonMinimized> personsMinimized = dto.getFollowed().stream().map(PersonMapper::minimizingMap).toList();

        Person.PersonBuilder builder = Person.builder();
        builder.id(String.valueOf(dto.getUserId()));
        builder.name(dto.getName());
        builder.email(dto.getEmail());
        builder.password(dto.getPassword());
        builder.followed(personsMinimized);

        return builder.build();
    }

    private static PersonMinimized minimizingMap(PersonPostgresDto dto) {
        PersonMinimized.PersonMinimizedBuilder builder = PersonMinimized.builder();
        builder.id(String.valueOf(dto.getUserId()));
        builder.name(dto.getName());
        builder.email(dto.getEmail());
        builder.password(dto.getPassword());

        return builder.build();
    }

    // ===============================================================================================================

    public static Person map(PersonNeo4jDto dto){
        List<PersonMinimized> minimized = dto.getPersons().stream().map(PersonMapper::minimizedMap).toList();

        Person.PersonBuilder builder = Person.builder();
        builder.id(String.valueOf(dto.getId()));
        builder.name(dto.getName());
        builder.email(dto.getEmail());
        builder.password(dto.getPassword());
        builder.followed(minimized);

        return builder.build();
    }

    private static PersonMinimized minimizedMap(PersonNeo4jDto dto){
        PersonMinimized.PersonMinimizedBuilder builder = PersonMinimized.builder();
        builder.id(String.valueOf(dto.getId()));
        builder.name(dto.getName());
        builder.email(dto.getEmail());
        builder.password(dto.getPassword());

        return builder.build();
    }
}
