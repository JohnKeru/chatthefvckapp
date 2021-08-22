package com.chatvp.person;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Person {
	@Id
	private int pid;
	private String name;
	
	public Person() {
		super();
	}
	public Person(int pid, String name) {
		super();
		this.pid = pid;
		this.name = name;
	}
	public int getPid() {
		return pid;
	}
	public void setPid(int pid) {
		this.pid = pid;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
}
