package com.kiranreddy.budgettrackerreactive.user;

import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@Service
public class UserService {

    private UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public Mono<User> saveUser(User user) {
        return userRepository.save(user);
    }

    public Mono<User> findByUserName(String userName) {
        return userRepository.findByUserName(userName);
    }
}
