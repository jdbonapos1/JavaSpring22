package com.qa.demo.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.qa.demo.domain.Person;

@Repository
public interface PersonRepo extends JpaRepository<Person, Integer> {

	List<Person> findByNameIgnoreCase(String name);
	List<Person> findByAge(Integer age);
	
	
}
