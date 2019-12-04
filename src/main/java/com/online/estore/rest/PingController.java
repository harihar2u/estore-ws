package com.online.estore.rest;

import org.springframework.data.rest.webmvc.RepositoryRestController;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PingController {

    @GetMapping("/ping")
    @ResponseBody
    public String ping() {
        return "success";
    }
}
