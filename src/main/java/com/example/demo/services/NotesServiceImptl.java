package com.example.demo.services;
import java.util.List;
import com.example.demo.model.Notes;


public interface NotesServiceImptl {
	List<Notes> getAll();
	Notes create(Long id, String text, String timestamp, String username);
	void deleteById(Long id);
	Notes findById(Long id);
	Notes findByUsername(String username);
}
