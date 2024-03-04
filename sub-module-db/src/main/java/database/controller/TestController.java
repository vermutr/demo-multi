package database.controller;

import database.util.DatabaseUtil;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/database")
public class TestController {

    @GetMapping
    public ResponseEntity<String> sayDatabase() {
        return ResponseEntity.ok().body(DatabaseUtil.sayDatabase());
    }

}
