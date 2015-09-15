package br.unisinos.aso.service;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

@Path("aso")
public class ASOService {
	
	@Path("/aggregateInfo")
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	public void aggregateMiscelaneousInfo(String patientData){
		
	}
	
	@Path("/retrieve/{id}")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public String retrievePatientOnthology(@PathParam("id") String patientId){
		return null;
	}
}