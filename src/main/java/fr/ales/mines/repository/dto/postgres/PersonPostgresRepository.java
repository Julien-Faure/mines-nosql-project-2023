package fr.ales.mines.repository.dto.postgres;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PersonPostgresRepository extends JpaRepository<PersonPostgresDto, Integer> {

}
