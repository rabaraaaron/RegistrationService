package com.rabaraaq.project;

import java.net.URISyntaxException;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin
@Transactional
@RequestMapping("/api/registrations")
public class ServiceGateway {
	
	@Autowired
	RegistrationsMongoService mongoService;
	
	@GetMapping("/loaddata")
	@ResponseBody
	public ResponseEntity<?> loadData() {
		mongoService.loadData();
		return ResponseEntity.ok().build();	
	}
	
	@GetMapping("")
	@ResponseBody
	public List<Registration> getAllRegistrations() {
		return mongoService.getAllRegistrations();
	}
	
	@GetMapping("/{id}")
	@ResponseBody
	public Registration getRegistrationById(@PathVariable(value = "id") String id) {
		return mongoService.getRegistrationById(id).get();
	}
	
	@PostMapping("")
	@ResponseBody
	public ResponseEntity<?> createRegistration(@RequestBody Registration reg) throws URISyntaxException {
		mongoService.createRegistration(reg);
		return ResponseEntity.ok().build();
	}
	
	@PutMapping("/{id}")
	@ResponseBody
	public ResponseEntity<?> updateOrCreateRegistration(@PathVariable(value = "id") String id, @RequestBody Registration reg) throws URISyntaxException {
		mongoService.createRegistration(reg);
		return ResponseEntity.ok().build();	
	}
	
	@DeleteMapping("/{id}")
	@ResponseBody
	public ResponseEntity<?> deleteRegistration(@PathVariable(value = "id") String id) {
		mongoService.deleteRegistration(id);
		return ResponseEntity.ok().build();	
	}

}
