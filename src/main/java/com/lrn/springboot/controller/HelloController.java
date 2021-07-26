package com.lrn.springboot.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiParam;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
@Api
@RestController
public class HelloController {
    @GetMapping
    public String hello(@RequestParam(required = false) @ApiParam String name){
        if (name != null && !"".equals(name)){
            return "Hello " + name;
        }
        return "Hello Spring Boot";
    }
}
