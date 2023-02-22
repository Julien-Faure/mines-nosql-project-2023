package fr.ales.mines.service.database.mapper;

import fr.ales.mines.entities.Person;
import fr.ales.mines.entities.PersonMinimized;
import fr.ales.mines.repository.dto.postgres.PersonDto;
import java.util.List;

public abstract class PersonMapper {

    public static Person map(PersonDto dto) {
        List<PersonMinimized> personsMinimized = dto.getFollowed().stream().map(PersonMapper::minimizingMap).toList();

        Person.PersonBuilder builder = Person.builder();
        builder.id(String.valueOf(dto.getUserId()));
        builder.name(dto.getName());
        builder.email(dto.getEmail());
        builder.password(dto.getPassword());
        builder.followed(personsMinimized);

        return builder.build();
    }

    private static PersonMinimized minimizingMap(PersonDto dto) {
        PersonMinimized.PersonMinimizedBuilder builder = PersonMinimized.builder();
        builder.id(String.valueOf(dto.getUserId()));
        builder.name(dto.getName());
        builder.email(dto.getEmail());
        builder.password(dto.getPassword());

        return builder.build();
    }
}
