package com.example.demo.controller;

import com.example.demo.model.User;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/demo")
public class DemoController {

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public User addUser(@RequestBody  User user){
      //  User user = new User();
        user.setId(1);
        user.setName("show user");
        user.setNick("add name...");
        user.setSaying("test");
        return user;
    }

    @RequestMapping(value="/delete/{id}", method = RequestMethod.DELETE)
    public ResponseEntity delete(@PathVariable Integer id){
        //mock deleted;
        return new ResponseEntity("User had been deleted", HttpStatus.OK);
    }

    @RequestMapping(value = "/show", method= RequestMethod.GET)
    public User showUser(@RequestParam("id") Integer id){
        User user = new User();
        user.setId(1);
        user.setName("show user");
        user.setNick("nick...");
        user.setSaying("test");
        return user;
    }

}
