package fr.ales.mines.repository.dto.postgres;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import org.hibernate.annotations.Fetch;
import org.springframework.boot.jackson.JsonComponent;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "users")
@JsonComponent
public class PersonDto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id")
    private Integer userId;

    @Column(name = "name")
    private String name;

    @Column(name = "email")
    private String email;

    @Column(name = "password")
    private String password;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "followers",
        joinColumns = {@JoinColumn(name = "followed_id")},
        inverseJoinColumns = {@JoinColumn(name = "follower_id")})
    private Set<PersonDto> followed;

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Set<PersonDto> getFollowed() {
        return followed;
    }

    public void setFollowed(Set<PersonDto> followed) {
        this.followed = followed;
    }
}
