package org.idea_collector.idea_collector.service;

import java.util.HashMap;
import java.util.Map;

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
            map.put("message", "Idea already exists with the title : " + idea.getTitle());

            return new ResponseEntity<Object>(map, HttpStatus.IM_USED);
        }else{
            repository.save(idea);

            Map<String, Object> map = new HashMap<String, Object>();
            map.put("message", "Idea added successfully");
            map.put("Data", idea);

            return new ResponseEntity<Object>(map, HttpStatus.CREATED);
        }
    }
    
}
