package ch.noseryoung.immobilien.domain.user;

import ch.noseryoung.immobilien.domain.user.userDto.UserDTO;
import ch.noseryoung.immobilien.domain.user.userDto.UserMapper;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/users")
public class UserController {


    private final UserService userService;
    private final UserMapper userMapper;
    @Autowired
    public UserController(UserService userService, UserMapper userMapper) {
        this.userService = userService;
        this.userMapper = userMapper;
    }

    @GetMapping
    public ResponseEntity<List<User>> findAll(){
        return ResponseEntity.ok(userService.findAll());
    }
    @GetMapping("/{id}")
    public ResponseEntity<User> findAById(@PathVariable("id") UUID userId) {
        return ResponseEntity.ok(userService.findById(userId));
    } //returns user with the specific userId

    @GetMapping("/name")
    public ResponseEntity<User> findByFirstname(String firstname){
        return ResponseEntity.ok(userService.findByFirstname(firstname));
    } //returns user with the specific name
    @PostMapping
    public ResponseEntity<UserDTO> create(@Valid @RequestBody UserDTO.WithPassword dto){
        return ResponseEntity.status(HttpStatus.CREATED).body(userMapper.toDTO(userService.create(userMapper.fromDTO(dto))));
    } //creates a new user with defined values;
}