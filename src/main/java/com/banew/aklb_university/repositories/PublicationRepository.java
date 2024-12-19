package com.banew.aklb_university.repositories;

import com.banew.aklb_university.entities.Publication;
import org.springframework.data.repository.CrudRepository;

import java.sql.Timestamp;
import java.util.List;


public interface PublicationRepository extends CrudRepository<Publication, Integer> {
}
