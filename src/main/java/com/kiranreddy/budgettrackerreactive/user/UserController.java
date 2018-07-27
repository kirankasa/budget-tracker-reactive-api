package com.kiranreddy.budgettrackerreactive.user;

import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/users")
@CrossOrigin
public class UserController {

    private UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping
    public Mono<User> register(@RequestBody User user) {
        return userService.saveUser(user);
    }
}
