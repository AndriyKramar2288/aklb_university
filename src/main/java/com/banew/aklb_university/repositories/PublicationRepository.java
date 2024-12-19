package com.banew.aklb_university.repositories;

import com.banew.aklb_university.entities.Publication;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;


public interface PublicationRepository extends CrudRepository<Publication, Integer> {
    
    @Query(value = "SELECT * FROM publication ORDER BY date DESC LIMIT :limit", nativeQuery = true)
    List<Publication> recentPublication(@Param("limit") int param);
}
