package com.online.estore.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class HomeController {

    @GetMapping("/")
    public String home(Model model){ return "redirect:index";}

    @GetMapping("/index")
    public String index(Model model) {
        return "index";
    }

   }
