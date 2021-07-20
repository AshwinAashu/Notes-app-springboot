package com.example.demo.repository;
import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import com.example.demo.model.Notes;

@Repository
public interface NotesRepository extends MongoRepository<Notes, String>{
	public Notes findByUsername(String username);
	public Notes findById(Long id);
	public List<Notes> findAll();
}