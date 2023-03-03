package ch.noseryoung.immobilien.domain.role;

import ch.noseryoung.immobilien.domain.role.roleDto.RoleDTO;
import ch.noseryoung.immobilien.domain.role.roleDto.RoleMapper;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/roles")
public class RoleController {
    private final RoleService roleService;
    private RoleMapper roleMapper;
    @Autowired
    public RoleController(RoleService roleService, RoleMapper roleMapper) {
        this.roleService = roleService;
        this.roleMapper = roleMapper;
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
    public ResponseEntity<RoleDTO> create(@Valid @RequestBody Role role){
        return ResponseEntity.status(HttpStatus.CREATED).body(roleMapper.toDTO(roleService.create(role)));
    }
}
