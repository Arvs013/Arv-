package com.blood_donation_backend.Controller;

import com.blood_donation_backend.Entity.UserEntity;
import com.blood_donation_backend.Service.UserService;
import com.blood_donation_backend.DTO.LoginRequest;
import com.google.firebase.auth.FirebaseAuthException;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/users")
public class UserController {

    @Autowired
    private UserService userService;

    // Create or update a user
    @PostMapping
    public ResponseEntity<UserEntity> saveUser(@RequestBody UserEntity userEntity) {
        UserEntity savedUser = userService.saveUser(userEntity);
        return ResponseEntity.ok(savedUser);
    }

    // Get all users
    @GetMapping
    public ResponseEntity<List<UserEntity>> getAllUsers() {
        List<UserEntity> users = userService.getAllUsers();
        return ResponseEntity.ok(users);
    }

    // Get user by ID
    @GetMapping("/{id}")
    public ResponseEntity<UserEntity> getUserById(@PathVariable int id) {
        Optional<UserEntity> user = userService.getUserById(id);
        return user.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    // Delete user by ID
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteUser(@PathVariable int id) {
        userService.deleteUser(id);
        return ResponseEntity.noContent().build();
    }

    @PostMapping("/login/manual")
    public String manualLogin(@RequestBody LoginRequest loginRequest){
        try{
            UserEntity user = userService.loginUserWithCredentials(loginRequest.getEmail(), loginRequest.getPassword());
                return "Login successful for user: " + user.getEmail();
        }catch (IllegalArgumentException e){
            return "Login failed: " + e.getMessage();
        }
    }

    @PostMapping("/login/google")
    public String googleLogin(@RequestBody LoginRequest loginRequest) {
        try {
            UserEntity user = userService.loginUserWithGoogle(loginRequest.getIdToken());
            return "Login successful for user: " + user.getEmail();
        } catch (FirebaseAuthException e) {
            return "Firebase Auth failed: " + e.getMessage();
        } catch (IllegalArgumentException e) {
            return "Login failed: " + e.getMessage();
        }
    }
}
