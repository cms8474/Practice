package test7.sub1;

import java.util.ArrayList;

public class Doctor {
	private String			name;
	private String			id;
	private String			special;
	private ArrayList<Patient> patients;

	public Doctor(String name, String id, String special) {
		super();
		this.name = name;
		this.id = id;
		this.special = special;
		this.patients = new ArrayList<>();
	}
	
	public void addPatient(Patient patient) {
		this.patients.add(patient);
	}

	@Override
	public String toString() {
		return "Doctor [name=" + name + ", id=" + id + ", special=" + special + "]";
	}
	
}
