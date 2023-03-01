package ch.noseryoung.immobilien.domain.property;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/users")
public class PropertyController {


    private PropertyService propertyService;

    @Autowired
    public PropertyController(PropertyService propertyService) {
        this.propertyService = propertyService;
    }

    @GetMapping
    public ResponseEntity<List<Property>> findAll(){
        return ResponseEntity.ok(propertyService.findAll());
    }
    @GetMapping("/id")
    public ResponseEntity<Property> findById(UUID id){
        return ResponseEntity.ok(propertyService.findById(id));
    }
    @GetMapping("/name")
    public ResponseEntity<Property> findByFirstname(String name){
        return ResponseEntity.ok(propertyService.findByName(name));
    }
    @PostMapping
    public ResponseEntity<Property> create(@RequestBody Property property){
        return ResponseEntity.status(HttpStatus.CREATED).body(propertyService.create(property));
    }
}