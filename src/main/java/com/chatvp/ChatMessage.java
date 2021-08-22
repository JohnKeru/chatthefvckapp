package com.chatvp;

public class ChatMessage {

	private int id;
	private String message;
	private String name;
	
	public ChatMessage(String message, String name, int id) {
		super();
		this.message = message;
		this.name = name;
		this.id = id;
	}
	public ChatMessage() {
		super();
	}
	
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}

}
