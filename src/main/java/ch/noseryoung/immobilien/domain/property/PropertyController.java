package ch.noseryoung.immobilien.domain.property;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/property")
public class PropertyController {


    private PropertyServiceImpl propertyService;

    @Autowired
    public PropertyController(PropertyServiceImpl propertyService) {
        this.propertyService = propertyService;
    }

    @GetMapping
    public ResponseEntity<List<Property>> findAll(){
        return ResponseEntity.ok(propertyService.findAll());
    }
    @GetMapping("/id")
    public ResponseEntity<Property> findById(UUID propertyId){
        return ResponseEntity.ok(propertyService.findById(propertyId));
    }
    @GetMapping("/canton")
    public ResponseEntity<Property> findByCanton(String canton){
        return ResponseEntity.ok(propertyService.findByCanton(canton));
    }
    @PostMapping
    public ResponseEntity<Property> create(@RequestBody Property property){
        return ResponseEntity.status(HttpStatus.CREATED).body(propertyService.create(property));
    }
}