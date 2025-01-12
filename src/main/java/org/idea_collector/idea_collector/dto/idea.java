package org.idea_collector.idea_collector.dto;

import java.sql.Time;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

@Entity
@Data
public class idea {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String title;
    private String description;

    @GeneratedValue(strategy = GenerationType.AUTO, generator = "CURRENT_TIMESTAMP")
    private Time addedAt;
    
}
