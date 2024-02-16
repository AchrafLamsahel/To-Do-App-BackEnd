package ma.arkToDoApp.web;

import lombok.AllArgsConstructor;
import ma.arkToDoApp.dtos.UserRequestDto;
import ma.arkToDoApp.services.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@AllArgsConstructor
@RequestMapping(value = "/api/v1/users", produces = "application/json", consumes = "application/json")
public class UserController {
    private final UserService userService;

    @GetMapping("/")
    public ResponseEntity<?> getAllUsers() {
        return new ResponseEntity<>(userService.getAllUsers(), HttpStatus.OK);
    }

    @PostMapping("/create")
    public ResponseEntity<?> createUser(@RequestBody UserRequestDto userDto) {
        return new ResponseEntity<>(userService.createUser(userDto), HttpStatus.CREATED);
    }
}