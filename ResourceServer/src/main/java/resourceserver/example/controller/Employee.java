package resourceserver.example.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
@RequestMapping("Employee")
public class Employee {

    @GetMapping(value = "/getAll")
    public ResponseEntity<?> getAllEmployee(){
        return new ResponseEntity<>("All Employee", HttpStatus.OK);
    }

    @PostMapping(value = "/save")
    public ResponseEntity<?> save(){
        return new ResponseEntity<>("save Employee", HttpStatus.OK);
    }

    @PutMapping(value = "/update")
    public ResponseEntity<?> update(){
        return new ResponseEntity<>("update Employee", HttpStatus.OK);
    }

    @PutMapping(value = "/delete")
    public ResponseEntity<?> delete(){
        return new ResponseEntity<>("delete Employee", HttpStatus.OK);
    }
}
