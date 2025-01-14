package org.idea_collector.idea_collector.controller;

import java.util.List;

import org.idea_collector.idea_collector.dto.idea;
import org.idea_collector.idea_collector.service.ideaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;





@RestController
@Tag(name = "Idea Controller", description = "API for managing ideas")
public class ideaController {

    @Autowired
    ideaService service;
    

    /*To add a new idea*/
    @Operation(summary = "Add a new idea", description = "Add a new idea to the database")
    @ApiResponse(responseCode = "201", description = "Idea added successfully")
    @ApiResponse(responseCode = "226", description = "Idea already exists with the title")
    @PostMapping("/ideas")
    public ResponseEntity<Object> addIdea(@RequestBody idea idea){
        return service.addIdea(idea);
    }

    
    @Operation(summary = "Add Multiple ideas", description = "Add multiple ideas to the database")
    @ApiResponse(responseCode = "201", description = "Ideas added successfully")
    @ApiResponse(responseCode = "226", description = "Idea already exists with the title")
    @PostMapping("/ideas/multiple")
    public ResponseEntity<Object> addMultipleIdeas(@RequestBody List<idea> ideas){
        return service.addMultipleIdeas(ideas);
    }
    




    /**To fetch idea Records*/
    @Operation(summary = "Get all ideas", description = "Get all ideas from the database")
    @ApiResponse(responseCode = "302", description = "Ideas fetched successfully")
    @ApiResponse(responseCode = "404", description = "Ideas not found")
    @GetMapping("/ideas")
    public ResponseEntity<Object> getAllIdeas(){
        return service.getAllIdeas();
    }

    @Operation(summary = "Get idea by name", description = "Get an idea by name from the database")
    @ApiResponse(responseCode = "302", description = "Idea fetched successfully")
    @ApiResponse(responseCode = "404", description = "Idea not found")
    @GetMapping("/ideas/{title}")
    public ResponseEntity<Object> getIdeaByName(@PathVariable String title){
        return service.getIdeaByName(title);
    }
    








    /* To Delete a Idea Record By Id */
    @Operation(summary = "Delete a idea by id", description = "Delete a idea by id from the database")
    @ApiResponse(responseCode = "200", description = "Idea deleted successfully")
    @ApiResponse(responseCode = "404", description = "Idea not found")
    @DeleteMapping("/ideas/{id}")
    public ResponseEntity<Object> deleteById(@PathVariable int id){
        return service.deleteById(id);
    }








    /* To Update a Idea Record By Id */
    @Operation(summary = "Update a idea by id", description = "Update a idea by id from the database")
    @ApiResponse(responseCode = "200", description = "Idea updated successfully")
    @ApiResponse(responseCode = "404", description = "Idea not found")
    @PatchMapping("/ideas/{id}")
    public ResponseEntity<Object> updateById(@PathVariable int id, @RequestBody idea idea){
        return service.updateById(id, idea);
    }
}
