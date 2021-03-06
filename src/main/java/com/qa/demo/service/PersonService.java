package com.qa.demo.service;


import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import com.qa.demo.domain.Person;
import com.qa.demo.repo.PersonRepo;

@Service // stores the main business logic of the application
public class PersonService implements ServiceIF<Person>{

	private PersonRepo repo;
	
	@Autowired
	public PersonService(PersonRepo repo) {
		super();
		this.repo=repo;
	}

//CRUD	
	// INSERT INTO Person;
	public Person createPerson(Person p) {
		Person created = this.repo.save(p);
		return created;
	}
   // SELECT * FROM Person;
	public List<Person> getAll() {
		return this.repo.findAll();
	}
    // SELECT * FROM Person WHERE ID =
	public Person getOne(Integer id) {
		Optional<Person> found = this.repo.findById(id);
		return found.get();
	}

	// UPDATE
	public Person replace(Integer id, Person newPerson) {
		Person existing = this.repo.findById(id).get();
		existing.setAge(newPerson.getAge());
		existing.setHeight(newPerson.getHeight());
		existing.setName(newPerson.getName());
		Person updated = this.repo.save(existing);
		return updated;
	}

	// DELETE FROM PERSON WHERE ID =
	public void remove(@PathVariable Integer id) {
		this.repo.deleteById(id);
	}
		
	// SELECT * FROM Person WHERE name= 
	public List<Person> getPeepsByName(String name) {
		List<Person> found = this.repo.findByNameIgnoreCase(name);
		return found;
	}
	// SELECT * FROM Person WHERE age= 
	public List<Person> getPeepsByAge(Integer age) {
		List<Person> found = this.repo.findByAge(age);
		return found;
	}

	@Override
	public Person create(Person t) {
		// TODO Auto-generated method stub
		return null;
	}
	
	}
