package com.example.demo.controller;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Notes;
import com.example.demo.services.NotesServiceImptl;

@CrossOrigin(origins="http://localhost:4200")
@RestController
@RequestMapping("/noteslist")
public class NotesController {
	private NotesServiceImptl NotesService;
	
	@GetMapping("notes")
	public List<Notes> getAll(){
		return NotesService.getAll();
	}
	
	@RequestMapping(method=RequestMethod.POST, value ="notes", consumes =  APPLICATION_JSON_VALUE, produces =  APPLICATION_JSON_VALUE)
	public ResponseEntity<Notes> createNotes(@RequestBody Notes Notes){
		Notes obj =  NotesService.create(Notes.id,Notes.text, Notes.timestamp, Notes.username);
		  if(obj==null){
	    	   return ResponseEntity.status(HttpStatus.NOT_ACCEPTABLE).build();
	       }
	       else{
	    	   return ResponseEntity.status(HttpStatus.CREATED).body(obj);
	       }
	}
	
	@GetMapping("notes/{username}")
	public Notes findByUsername(@RequestParam("username") String username) {
		return NotesService.findByUsername(username);
	}
	
	@GetMapping("notes/{id}")
	public Notes finfById(@RequestParam("id") Long id){
		return NotesService.findById(id);
	}
	
	@DeleteMapping("notes/delete")
	public String deleteById(@RequestParam("id") Long id) {
		NotesService.deleteById(id);
		return "Notes deleted";
	}
	
	
}
