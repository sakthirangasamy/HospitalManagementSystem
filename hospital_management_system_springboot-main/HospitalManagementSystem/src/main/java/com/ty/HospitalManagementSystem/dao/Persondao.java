package com.ty.HospitalManagementSystem.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ty.HospitalManagementSystem.dto.Person;
import com.ty.HospitalManagementSystem.repo.PersonRepo;

@Repository
public class Persondao {

	@Autowired
	private PersonRepo repo;

	public Person savePerson(Person person) {
		return repo.save(person);

	}

	public Person updatePerson(int id, Person person) {
		if (repo.findById(id).isPresent()) {
			person.setId(id);
			return repo.save(person);
		} else {
			return null;
		}

	}

	public Person deletePerson(int id) {
		if (repo.findById(id).isPresent()) {
			Person person = repo.findById(id).get();
			repo.deleteById(id);
			return person;
		} else {
			return null;
		}

	}

	public Person getpersonbyid(int id) {
		if (repo.findById(id).isPresent()) {
			return repo.findById(id).get();
		} else {
			return null;
		}

	}
}
