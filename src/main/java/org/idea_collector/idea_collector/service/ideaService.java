package org.idea_collector.idea_collector.service;

import org.idea_collector.idea_collector.repository.ideaRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class ideaService {

    @Autowired
    ideaRepo repository;
    
}
