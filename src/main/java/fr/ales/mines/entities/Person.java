package fr.ales.mines.entities;

import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class Person {
    private String id;
    private String name;
    private String email;
    private String password;
    private List<Person> followed;
}
