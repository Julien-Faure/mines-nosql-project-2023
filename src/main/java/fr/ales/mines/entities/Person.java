package fr.ales.mines.entities;

import java.util.List;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Person {

    private String id;
    private String name;
    private String email;
    private String password;
    private List<PersonMinimized> followed;
    private List<Product> purchasedProducts;
}
