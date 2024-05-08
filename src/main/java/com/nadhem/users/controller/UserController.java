package com.nadhem.users.controller;

import com.nadhem.users.dto.request.UserRequestDto;
import com.nadhem.users.dto.request.update.UpdateUserRequestDto;
import com.nadhem.users.dto.response.UserResponseDto;
import com.nadhem.users.entities.User;
import com.nadhem.users.service.UserServiceImpl;
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
}
