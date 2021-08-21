package com.chatvp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
public class ChatController {
	@Autowired
	private SimpMessagingTemplate smp;
	
	@PostMapping("/send")
	public ResponseEntity<Void> message(@RequestBody ChatMessage chatMessage) {
		smp.convertAndSend("/topic/public", chatMessage);
		return new ResponseEntity<Void>(HttpStatus.OK);
	}
	@MessageMapping("/sendMessage")
	public void recievedMessage(@Payload ChatMessage chatMessage) {
		System.out.println(chatMessage);
	}
	@SendTo("/topic/public")
	public ChatMessage chatMessage(@Payload ChatMessage chatMessage) {
		return chatMessage;
	}
}

