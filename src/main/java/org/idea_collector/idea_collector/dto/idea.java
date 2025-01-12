package org.idea_collector.idea_collector.dto;

import java.sql.Time;

import org.hibernate.annotations.TimeZoneStorage;
import org.springframework.format.annotation.DateTimeFormat;

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

    @DateTimeFormat(pattern = "HH:mm")
    private Time addedAt;
    
}
