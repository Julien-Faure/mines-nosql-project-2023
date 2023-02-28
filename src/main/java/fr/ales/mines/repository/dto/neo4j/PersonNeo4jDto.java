package fr.ales.mines.repository.dto.neo4j;

import org.springframework.data.neo4j.core.schema.*;

import java.util.List;

@Node("User")
public class PersonNeo4jDto {

    @Id
    @GeneratedValue
    private Long id;

    @Property("email")
    private String email;

    @Property("name")
    private String name;

    @Property("password")
    private String password;

    @Relationship(type = "Follows", direction = Relationship.Direction.OUTGOING)
    private List<PersonNeo4jDto> persons;

    @Relationship(type = "Purchased", direction = Relationship.Direction.OUTGOING)
    private List<ProductNeo4jDto> purchasedProducts;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public List<PersonNeo4jDto> getPersons() {
        return persons;
    }

    public void setPersons(List<PersonNeo4jDto> persons) {
        this.persons = persons;
    }

    public List<ProductNeo4jDto> getPurchasedProducts() {
        return purchasedProducts;
    }

    public void setPurchasedProducts(List<ProductNeo4jDto> purchasedProducts) {
        this.purchasedProducts = purchasedProducts;
    }
}
