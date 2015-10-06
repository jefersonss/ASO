package br.unisinos.aso.service;

import java.util.*;

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
	public Map<String, List<Patient>> getPatients(){
		List<Patient> patients = patientDAO.getPatients();
		Map<String, List<Patient>> patientsMap = new HashMap<String, List<Patient>>();
		
		for (Patient patient : patients) {
			if(patientsMap.containsKey(patient.getRoom()))
				patientsMap.get(patient.getRoom()).add(patient);
			else{
				List<Patient> patientList = new ArrayList<Patient>();
				patientList.add(patient);
				patientsMap.put(patient.getRoom(), patientList);
			}
		}
		
		return patientsMap;
	}
}