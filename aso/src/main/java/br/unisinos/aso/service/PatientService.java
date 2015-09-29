package br.unisinos.aso.service;

import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.unisinos.aso.converter.json.JSONConverter;
import br.unisinos.aso.dao.PatientDAO;
import br.unisinos.aso.model.Patient;

@Path("/patient")
@Service
public class PatientService {
	
	@Autowired
	private PatientDAO patientDAO;
	@Autowired
	private JSONConverter jsonConverter;
	
	@Path("/save")
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	public void savePatient(Patient jsonPatient){
		
	}
	
	@Path("/search/{name}")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<String> searchPatientByName(@PathParam("name") String name){
		return null;
	}
	
	@Path("{id}")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Patient getPatientById(@PathParam("id") String id){
		return null;
	}
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<String> getPatients(){
		List<Patient> patients = patientDAO.getPatients();
		List<String> patientsJson = new ArrayList<String>();
		for (Patient patient : patients) {
			patientsJson.add(jsonConverter.convert(patient));
		}
		return patientsJson;
	}
}