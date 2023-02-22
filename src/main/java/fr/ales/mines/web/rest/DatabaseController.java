package fr.ales.mines.web.rest;

import fr.ales.mines.service.database.DatabaseService;
import fr.ales.mines.service.database.DatabaseType;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class DatabaseController {

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
}
