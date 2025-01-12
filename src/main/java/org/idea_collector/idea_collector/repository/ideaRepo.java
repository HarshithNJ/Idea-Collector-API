package org.idea_collector.idea_collector.repository;

import org.idea_collector.idea_collector.dto.idea;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ideaRepo extends JpaRepository<idea, Integer> {

}
