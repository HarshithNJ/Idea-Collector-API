package org.idea_collector.idea_collector.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class swaggerController {

    @GetMapping("/")
    public String home(){
        return "redirect:/swagger-ui/index.html";
    }
    
}
