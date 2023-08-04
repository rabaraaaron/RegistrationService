package com.rabaraaq.project;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RegistrationsMongoService {
	
	@Autowired
	RegistrationsMongoRepository mongoRepository;
	
	public void loadData() {
		Registration reg1 = new Registration("1", "1", "2023-01-17T00:00:00.000+0000", "My notes");
		Registration reg2 = new Registration("2", "2", "2023-01-17T00:00:00.000+0000", "My notes");
		mongoRepository.save(reg1);
		mongoRepository.save(reg2);
	}
	
	public List<Registration> getAllRegistrations() {
		return mongoRepository.findAll();
	}
	
	public Optional<Registration> getRegistrationById(String id) {
		return mongoRepository.findById(id);
	}
	
	public void createRegistration(Registration reg) {
		mongoRepository.insert(reg);
	}
	
	public void updateRegistration(Registration reg) {
		mongoRepository.save(reg);
	}
	
	public void deleteRegistration(String id) {
		mongoRepository.deleteById(id);
	}
	
}
