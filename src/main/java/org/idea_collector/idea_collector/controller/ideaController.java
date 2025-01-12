package org.idea_collector.idea_collector.controller;

import org.idea_collector.idea_collector.dto.idea;
import org.idea_collector.idea_collector.service.ideaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;




@RestController
public class ideaController {

    @Autowired
    ideaService service;
    

    /*To add a new idea*/
    //Add a Single Idea
    @PostMapping("/ideas")
    public ResponseEntity<Object> addIdea(@RequestBody idea idea){
        return service.addIdea(idea);
    }
    
}
