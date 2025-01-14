package org.idea_collector.idea_collector.controller;

import java.util.List;

import org.idea_collector.idea_collector.dto.idea;
import org.idea_collector.idea_collector.service.ideaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
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

    //Add Multiple Ideas
    @PostMapping("/ideas/multiple")
    public ResponseEntity<Object> addMultipleIdeas(@RequestBody List<idea> ideas){
        return service.addMultipleIdeas(ideas);
    }
    




    /**To fetch idea Records*/
    //Get All Ideas
    @GetMapping("/ideas")
    public ResponseEntity<Object> getAllIdeas(){
        return service.getAllIdeas();
    }

    //Get Idea By Name
    @GetMapping("/ideas/{title}")
    public ResponseEntity<Object> getIdeaByName(@PathVariable String title){
        return service.getIdeaByName(title);
    }
    








    /* To Delete a Idea Record By Id */
    @DeleteMapping("/ideas/{id}")
    public ResponseEntity<Object> deleteById(@PathVariable int id){
        return service.deleteById(id);
    }








    /* To Update a Idea Record By Id */
}
