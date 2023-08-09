package com.rabaraaq.project;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.TimeZone;

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
		String date;
		if(reg.registration_date.contains("T")) {
			reg.setRegistration_date(reg.registration_date);
		} else {
			Long timestamp = Long.parseLong(reg.registration_date);
			DateFormat format = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSSZ");
			format.setTimeZone(TimeZone.getDefault());
			reg.setRegistration_date(format.format(new Date(timestamp)));
		}
		mongoRepository.insert(reg);
	}
	
	public void updateRegistration(Registration reg) {
		mongoRepository.save(reg);
	}
	
	public void deleteRegistration(String id) {
		mongoRepository.deleteById(id);
	}
	
}
