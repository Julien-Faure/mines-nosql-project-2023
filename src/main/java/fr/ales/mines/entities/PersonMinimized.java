package fr.ales.mines.entities;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class PersonMinimized {

    private String id;
    private String name;
    private String email;
    private String password;
}
