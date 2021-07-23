package com.lrn.springboot;

import io.swagger.annotations.Api;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@Api
@RestController
public class ParamController {
    @GetMapping("/noannotation")
    public User noAnnotation(User user){
        return user;
    }

    @GetMapping("/requestparam")
    public User RequestParam(@RequestParam String name, @RequestParam int age){
        User user = new User();
        user.setName(name);
        user.setAge(age);
        return user;
    }

    @GetMapping("/requestparam2")
    public String RequestParam(@RequestParam(value="na", required = false, defaultValue = "李若宁") String name){
        return "Hello: " + name;
    }

    @GetMapping("/pathvariable/{name}/{age}")
    public User PathVariable(@PathVariable String name, @PathVariable int age){
        User user = new User();
        user.setName(name);
        user.setAge(age);
        return user;
    }
}
