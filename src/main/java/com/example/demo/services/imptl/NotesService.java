package com.example.demo.services.imptl;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.demo.model.Notes;
import com.example.demo.repository.NotesRepository;
import com.example.demo.services.NotesServiceImptl;
import com.mongodb.DuplicateKeyException;

@Service
public class NotesService implements NotesServiceImptl{
	@Autowired
	private NotesRepository notesRepo;
	
	//to create a note 
	public Notes create(Long id, String text, String timestamp, String username) {
		try {
			return notesRepo.save(new Notes(id, text, timestamp, username));
		}catch(DuplicateKeyException e) {
			System.out.println(e.getMessage());
			return null;
		}
	}

	@Override
	public List<Notes> getAll() {
		// TODO Auto-generated method stub
		return notesRepo.findAll();
	}
	


	@Override
	public Notes findByUsername(String username) {
		return notesRepo.findByUsername(username);
	}
	
	@Override 
	public Notes findById(Long id) {
		return notesRepo.findById(id);
	}
	
	@Override
	public void deleteById(Long id) {
		Notes tempNotes =  findById(id);
		notesRepo.delete(tempNotes);
	}
	
}
