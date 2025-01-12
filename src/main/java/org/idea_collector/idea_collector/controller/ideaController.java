package org.idea_collector.idea_collector.controller;

import org.idea_collector.idea_collector.service.ideaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;



@RestController
public class ideaController {

    @Autowired
    ideaService service;
    
}
