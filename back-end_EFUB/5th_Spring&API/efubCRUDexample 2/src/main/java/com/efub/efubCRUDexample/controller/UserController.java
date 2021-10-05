package com.efub.efubCRUDexample.controller;

import com.efub.efubCRUDexample.model.User;
import com.efub.efubCRUDexample.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

//localhost:8080/user
@RestController
@RequestMapping("/user") //localhost:8080/user
public class UserController {
    @Autowired
    private UserService userService;

    @GetMapping("")
    public List<User> getAllUsers(){return userService.getAllUsers();}

    //get localhost:8080/user/testId1
    //get localhost:8080/user/testId2
    @CrossOrigin(origins="http://localhost:3000")
    @GetMapping("/{userid}")
    public User getUserByUserId(@PathVariable String userid){return userService.getUserByUserId(userid);}

    @PostMapping("")
    public User registerUser(@RequestBody User user){return  userService.registerUser(user);}

    @PutMapping("/{userid}")
    public void modifyUser(@PathVariable String userid, @RequestBody User user){
        userService.modifyUser(userid,user);
    }

    @DeleteMapping("/{userid}")
    public void removeUser(@PathVariable String userid){userService.removeUser(userid);}
}
