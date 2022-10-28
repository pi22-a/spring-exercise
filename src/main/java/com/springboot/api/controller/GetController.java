package com.springboot.api.controller;

import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController //스프링이 컨트롤러로 인지함
@RequestMapping("/api/v1/get-api")
@Slf4j
public class GetController {
    @RequestMapping(value = "/hello", method = RequestMethod.GET)
    public String hello(){
        log.info("hello로 요청이 들어왔습니다.");
        return "Hello World";
    }

    @GetMapping(value = "/name")
    public String getName() {
        log.info("getName으로 요청이 들어왔습니다.");
        return "pizza";
    }

    @GetMapping(value = "/variable1/{variable}")
    public String getVariable1(@PathVariable String variable) {
        log.info("getVariable1으로 요청이 들어왔습니다. variable:{}", variable);
        return variable;

    }
    private final Logger LOGGER = LoggerFactory.getLogger(GetController.class);


}



