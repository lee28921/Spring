package kr.lee.controller;

import kr.lee.document.UserDocument;
import kr.lee.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class MainController {

    @Autowired
    private UserService userService;

    @GetMapping("/user")
    public ResponseEntity<List<UserDocument>> findAllUser() {
        List<UserDocument> users = userService.findAllUser();

        return ResponseEntity
                .status(HttpStatus.ACCEPTED)
                .body(users);
    }

    @GetMapping("/user/{uid}")
    public ResponseEntity<UserDocument> findUser(@PathVariable("uid") String uid) {

        Optional<UserDocument> user = userService.findUser(uid);

        return null;
    }

    @PostMapping("/user")
    public ResponseEntity<UserDocument> insertUser(UserDocument user) {

        UserDocument resultUser = userService.insertUser(user);

        return ResponseEntity
                .ok()
                .body(resultUser);
    }

    @PutMapping("/user")
    public void updateUser(UserDocument use) {
        userService.updateUser(use);
    }

    @DeleteMapping("/user/{uid}")
    public void deleteUser(@PathVariable("uid") String uid) {

        userService.deleteUser(uid);
    }
}
