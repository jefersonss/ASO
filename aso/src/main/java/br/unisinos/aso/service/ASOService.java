package br.unisinos.aso.service;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

import br.unisinos.aso.dao.PatientDAO;
import br.unisinos.aso.hl7.converter.Converter;
import br.unisinos.aso.model.Patient;

@Path("aso")
public class ASOService {
	
	@Path("/aggregateInfo")
	@POST
	@Consumes(MediaType.TEXT_PLAIN)
	public void aggregateMiscelaneousInfo(String patientData){
		Converter hl7Converter = new Converter();
		Patient patient = hl7Converter.convertFromHL7ToPatientObj(patientData);
		PatientDAO patientDAO = new PatientDAO();
		patientDAO.updatePatient(patient);
	}
	
	@Path("/retrieve/{id}")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public String retrievePatientOnthology(@PathParam("id") String patientId){
		return null;
	}
}