package com.rabaraaq.project;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection="registrations")
public class Registration{
	
	@Id
	public String id;
	public String event_id, customer_id, registration_date, notes;

	public Registration() {}
	
	public Registration(String eventId, String customerId, String registrationDate, String notes) {
		event_id = eventId;
		customer_id = customerId;
		registration_date = registrationDate;
		this.notes = notes;
	}

	public String getEvent_id() {
		return event_id;
	}

	public void setEvent_id(String event_id) {
		this.event_id = event_id;
	}

	public String getCustomer_id() {
		return customer_id;
	}

	public void setCustomer_id(String customer_id) {
		this.customer_id = customer_id;
	}

	public String getRegistration_date() {
		return registration_date;
	}

	public void setRegistration_date(String registration_date) {
		this.registration_date = registration_date;
	}

	public String getNotes() {
		return notes;
	}

	public void setNotes(String notes) {
		this.notes = notes;
	}
	
	
}
