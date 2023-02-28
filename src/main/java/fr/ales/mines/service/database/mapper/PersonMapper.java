package fr.ales.mines.service.database.mapper;

import fr.ales.mines.entities.Person;
import fr.ales.mines.entities.PersonMinimized;
import fr.ales.mines.entities.Product;
import fr.ales.mines.repository.dto.neo4j.PersonNeo4jDto;
import fr.ales.mines.repository.dto.neo4j.ProductNeo4jDto;
import fr.ales.mines.repository.dto.postgres.PersonPostgresDto;
import fr.ales.mines.repository.dto.postgres.ProductPostgresDto;

import java.util.List;

public abstract class PersonMapper {

    public static Person map(PersonPostgresDto dto) {
        List<PersonMinimized> personsMinimized = dto.getFollowed().stream().map(PersonMapper::minimizingMap).toList();
        List<Product> purchases = dto.getPurchases().stream().map(PersonMapper::map).toList();

        Person.PersonBuilder builder = Person.builder();
        builder.id(String.valueOf(dto.getUserId()));
        builder.name(dto.getName());
        builder.email(dto.getEmail());
        builder.password(dto.getPassword());
        builder.followed(personsMinimized);
        builder.purchasedProducts(purchases);

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

    private static Product map(ProductPostgresDto dto){
        Product.ProductBuilder builder = Product.builder();

        builder.id(String.valueOf(dto.getId()));
        builder.name(dto.getName());
        builder.description(dto.getDescription());
        builder.price(dto.getPrice());

        return builder.build();
    }

    // ===============================================================================================================

    public static Person map(PersonNeo4jDto dto){
        List<PersonMinimized> minimized = dto.getPersons().stream().map(PersonMapper::minimizedMap).toList();
        List<Product> purchased = dto.getPurchasedProducts().stream().map(PersonMapper::map).toList();

        Person.PersonBuilder builder = Person.builder();
        builder.id(String.valueOf(dto.getId()));
        builder.name(dto.getName());
        builder.email(dto.getEmail());
        builder.password(dto.getPassword());
        builder.followed(minimized);
        builder.purchasedProducts(purchased);

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

    private static Product map(ProductNeo4jDto dto){
        Product.ProductBuilder builder = Product.builder();

        builder.id(String.valueOf(dto.getId()));
        builder.name(dto.getName());
        builder.description(dto.getDescription());
        builder.price(dto.getPrice());

        return builder.build();
    }
}
