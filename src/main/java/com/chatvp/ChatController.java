package com.chatvp;
import java.util.List;

/*
import java.util.List;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import com.chatvp.person.Person;
import com.chatvp.person.PersonServices;
*/
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.chatvp.person.Person;
import com.chatvp.person.PersonServices;

@RestController
@CrossOrigin(origins = "*")
public class ChatController {
	
	@Autowired
	private SimpMessagingTemplate smp;
	@Autowired
	private PersonServices personServices;
	
	
	@PostMapping("/send")
	public ResponseEntity<Void> message(@RequestBody ChatMessage chatMessage) {
		smp.convertAndSend("/topic/public", chatMessage);
		return new ResponseEntity<Void>(HttpStatus.OK);
	}
	
	@SendTo("/topic/public")
	public ChatMessage chatMessage(@Payload ChatMessage chatMessage) {
		return chatMessage;
	}
	
	@MessageMapping("/sendMessage")
	public void recievedMessage(@Payload ChatMessage chatMessage) {
		System.out.println(chatMessage);
	}
	
	/* FOR PERSON SERVICES */
	@PostMapping("/add")
	public Person add(@RequestBody Person person) {
		return personServices.postPerson(person);
	}
	@GetMapping("/persons")
	public List<Person> getAllPersons(){
		return personServices.getAllPersons();
	}
	@GetMapping("persons/{pid}")
	public Person person(@PathVariable int pid) {
		return personServices.getPerson(pid);
	}
}

