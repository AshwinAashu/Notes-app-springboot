package com.example.demo.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document("notes")
public class Notes {
	public Long id;
	public String  text;
	public String timestamp;
	public String username;
	
	
	

	public Notes( Long id, String text, String timestamp, String username) {
		super();
		this.id = id;
		this.text = text;
		this.timestamp = timestamp;
		this.username = username;
	}
	
	
	@Id
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getText() {
		return text;
	}
	public void setText(String text) {
		this.text = text;
	}
	public String getTimestamp() {
		return timestamp;
	}
	public void setTimestamp(String timestamp) {
		this.timestamp = timestamp;
	}
	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}
	
	@Override
	public String toString() {
		return String.format("Notes[id='%s',text='%s', timestamp='%s', username= '%s']", id, text, timestamp, username);
	}
	
	
}
