package fr.ales.mines.web.rest;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import fr.ales.mines.entities.Person;
import fr.ales.mines.entities.Request1Response;
import fr.ales.mines.entities.Request2Response;
import fr.ales.mines.entities.Request3Response;
import fr.ales.mines.service.database.DatabaseService;
import fr.ales.mines.service.database.DatabaseType;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class DatabaseController {

    private final Logger log = LoggerFactory.getLogger(DatabaseController.class);

    private final DatabaseService service;

    @Autowired
    public DatabaseController(DatabaseService service) {
        this.service = service;
    }

    @GetMapping("/database")
    public ResponseEntity<List<String>> listDatabase() {
        List<String> databaseNames = Arrays.stream(DatabaseType.values()).map(DatabaseType::getName).toList();
        return ResponseEntity.ok(databaseNames);
    }

    @PostMapping("/database/select")
    public ResponseEntity<Void> switchDatabaseType(@RequestParam(name = "type") String dbType) {
        Optional<DatabaseType> databaseType = Arrays.stream(DatabaseType.values()).filter(db -> db.getName().equals(dbType)).findFirst();
        if (databaseType.isPresent()) {
            this.service.switchDatabaseType(databaseType.get());
            return ResponseEntity.ok().build();
        } else return ResponseEntity.notFound().build();
    }

    @GetMapping("/person")
    public ResponseEntity<String> listPerson() {
        List<Person> persons = this.service.listPerson();
        ObjectMapper mapper = new ObjectMapper();
        try {
            return ResponseEntity.ok(mapper.writeValueAsString(persons));
        } catch (JsonProcessingException e) {
            log.error("Unable to convert response to JSON : %s".formatted(e.getMessage()), e);
            return ResponseEntity.internalServerError().build();
        }
    }

    @GetMapping("/request/1")
    public ResponseEntity<String> executeRequest1(
        @RequestParam(name = "username") String username,
        @RequestParam(name = "depth") int depth
    ) {
        Request1Response response = this.service.executeRequest1(username, depth);
        ObjectMapper mapper = new ObjectMapper();
        try {
            return ResponseEntity.ok(mapper.writeValueAsString(response));
        } catch (JsonProcessingException e) {
            log.error("Unable to convert response to JSON : %s".formatted(e.getMessage()), e);
            return ResponseEntity.internalServerError().build();
        }
    }

    @GetMapping("/request/2")
    public ResponseEntity<String> executeRequest2(
        @RequestParam(name = "username") String username,
        @RequestParam(name = "depth") int depth,
        @RequestParam(name = "productName") String productName
    ) {
        Request2Response response = this.service.executeRequest2(username, depth, productName);
        ObjectMapper mapper = new ObjectMapper();
        try {
            return ResponseEntity.ok(mapper.writeValueAsString(response));
        } catch (JsonProcessingException e) {
            log.error("Unable to convert response to JSON : %s".formatted(e.getMessage()), e);
            return ResponseEntity.internalServerError().build();
        }
    }

    @GetMapping("/request/3")
    public ResponseEntity<String> executeRequest2(
        @RequestParam(name = "productName") String productName,
        @RequestParam(name = "depth") int depth
    ) {
        Request3Response response = this.service.executeRequest3(productName, depth);
        ObjectMapper mapper = new ObjectMapper();
        try {
            return ResponseEntity.ok(mapper.writeValueAsString(response));
        } catch (JsonProcessingException e) {
            log.error("Unable to convert response to JSON : %s".formatted(e.getMessage()), e);
            return ResponseEntity.internalServerError().build();
        }
    }
}
