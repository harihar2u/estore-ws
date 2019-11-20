package com.online.estore.rest;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PingController {

    @GetMapping("/healthy")
    public String ping() {
        return "success";
    }
}
