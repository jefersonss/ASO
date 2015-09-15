package br.unisinos.aso.service;

import java.util.List;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

import br.unisinos.aso.model.Patient;

@Path("/patient")
public class PatientService {
	
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
		return null;
	}
}