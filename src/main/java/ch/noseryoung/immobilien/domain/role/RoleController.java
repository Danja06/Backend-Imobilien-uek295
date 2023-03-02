package ch.noseryoung.immobilien.domain.role;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/roles")
public class RoleController {
    private final RoleService roleService;
    @Autowired
    public RoleController(RoleService roleService) {
        this.roleService = roleService;
    }
    @GetMapping("/role")
    public ResponseEntity<Role> findByRole(String role){
        return ResponseEntity.ok(roleService.findByRole(role));
    }
    @GetMapping("/{roleId}")
    public ResponseEntity<Role> findAllById(@PathVariable("roleId") int roleId){
        return ResponseEntity.ok(roleService.findById(roleId));
    }
    @PostMapping
    public ResponseEntity<Role> create(@Valid @RequestBody Role role){
        return ResponseEntity.status(HttpStatus.CREATED).body(roleService.create(role));
    }
}
