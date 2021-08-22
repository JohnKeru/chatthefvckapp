package com.chatvp.person;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PersonServices {
	@Autowired
	private PersonRepository repository;
	
	public List<Person> getAllPersons(){
		return repository.findAll();
	}
	public Person getPerson(int pid) {
		return repository.findById(pid).get();
	}
	public Person postPerson(Person person) {
		return repository.save(person);
	}
}
