package org.idea_collector.idea_collector.repository;

import java.util.Optional;

import org.idea_collector.idea_collector.dto.idea;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ideaRepo extends JpaRepository<idea, Integer> {

    boolean existsByTitle(String title);

    Optional<idea> findByTitle(String title);

}
