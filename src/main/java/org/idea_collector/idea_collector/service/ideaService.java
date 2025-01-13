package org.idea_collector.idea_collector.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.idea_collector.idea_collector.dto.idea;
import org.idea_collector.idea_collector.repository.ideaRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;


@Service
public class ideaService {

    @Autowired
    ideaRepo repository;

    public ResponseEntity<Object> addIdea(idea idea) {
        if(repository.existsByTitle(idea.getTitle())) {
            Map<String, Object> map = new HashMap<String, Object>();
            map.put("error", "Idea already exists with the title");

            return new ResponseEntity<Object>(map, HttpStatus.IM_USED);
        }else{
            repository.save(idea);

            Map<String, Object> map = new HashMap<String, Object>();
            map.put("success", "Idea added successfully");
            map.put("Data", idea);

            return new ResponseEntity<Object>(map, HttpStatus.CREATED);
        }
    }

    public ResponseEntity<Object> addMultipleIdeas(List<idea> ideas) {
        for(idea idea : ideas){

            if(repository.existsByTitle(idea.getTitle())) {
                Map<String, Object> map = new HashMap<String, Object>();
                map.put("error", "Idea already exists with the title");
    
                return new ResponseEntity<Object>(map, HttpStatus.IM_USED);
            }

        }

        repository.saveAll(ideas);

            Map<String, Object> map = new HashMap<String, Object>();
            map.put("success", "Ideas added successfully");
            map.put("Data", ideas);

            return new ResponseEntity<Object>(map, HttpStatus.CREATED);
    }








    public ResponseEntity<Object> getAllIdeas() {
        List<idea> ideas = repository.findAll();

        if(ideas.isEmpty()){
            
            Map<String, Object> map = new HashMap<String, Object>();
            map.put("error", "No Ideas Found");

            return new ResponseEntity<Object>(map, HttpStatus.NOT_FOUND);
        }else{

            Map<String, Object> map = new HashMap<String, Object>();
            map.put("success", "Ideas Found");
            map.put("Data", ideas);

            return new ResponseEntity<Object>(map, HttpStatus.FOUND);
        }
    }

    public ResponseEntity<Object> getIdeaByName(String title) {
        Optional<idea> op = repository.findByTitle(title);

        if (op.isPresent()) {

            Map<String, Object> map = new HashMap<String, Object>();
            map.put("success", "Idea Found");
            map.put("Data", op.get());

            return new ResponseEntity<Object>(map, HttpStatus.FOUND);
        }else{

            Map<String, Object> map = new HashMap<String, Object>();
            map.put("error", "Idea not Found");

            return new ResponseEntity<Object>(map, HttpStatus.NOT_FOUND);
        }
    }
    
}
