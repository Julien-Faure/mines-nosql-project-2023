package fr.ales.mines.web.rest;

import fr.ales.mines.service.database.DatabaseType;
import java.net.URISyntaxException;
import java.util.Arrays;
import java.util.List;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class DatabaseController {

    @GetMapping("/database")
    public ResponseEntity<List<String>> listDatabase() throws URISyntaxException {
        List<String> databaseNames = Arrays.stream(DatabaseType.values()).map(DatabaseType::getName).toList();
        return ResponseEntity.ok(databaseNames);
    }
}
