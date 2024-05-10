package com.lucca.controller;

import com.lucca.dto.response.UserResponseDto;
import com.lucca.service.UserServiceImpl;
import com.lucca.dto.request.UserRequestDto;
import com.lucca.entities.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UserController {

    @Autowired
    private UserServiceImpl userService;

    @PostMapping("/register")
    public User registerUser(@RequestBody UserRequestDto user){
        return this.userService.saveUser(user);
    }

    @PostMapping("/addEmployee/{managerId}")
    public User addEmployee(@RequestBody UserRequestDto user, @PathVariable int managerId){
        return this.userService.saveEmployee(user, managerId);
    }

    @PostMapping("/updateUser/{username}")
    public UserResponseDto updateUserDetails(@RequestBody UserRequestDto userDetails, @PathVariable String username){
        return this.userService.updateUserDetails(userDetails, username);
    }

    @GetMapping("/getCurrentUser/{username}")
    public UserResponseDto getUserByUsername(@PathVariable String username){
        return this.userService.findUserByUsername2(username);
    }

    @GetMapping("/getAllUsers/{username}")
    public ResponseEntity<List<UserResponseDto>> getAllUser(@PathVariable String username){
        return ResponseEntity.ok(this.userService.getAllUsers(username));
    }

    @GetMapping("/getUserDetails/{username}")
    public ResponseEntity<UserResponseDto> getUserByUser(@PathVariable String username){
        return ResponseEntity.ok(this.userService.findUserByUsername2(username));
    }
    @GetMapping("/getUserById/{userId}")
    public ResponseEntity<UserResponseDto> getUserById(@PathVariable int userId){
        return ResponseEntity.ok(this.userService.getUserById2(userId));
    }

    @DeleteMapping("/deleteUser/{userId}")
    public ResponseEntity<String> deleteUser(@PathVariable int userId){
        this.userService.deleteUser(userId);
        return ResponseEntity.ok("USER DELETED !");
    }
}
