package fr.ales.mines.repository;

import fr.ales.mines.domain.User;
import fr.ales.mines.repository.dto.postgres.PersonDto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PersonRepository extends JpaRepository<PersonDto, Integer> {

}
