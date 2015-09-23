package br.unisinos.aso.converter.json;

import br.unisinos.aso.model.Patient;

import com.fasterxml.jackson.databind.ObjectMapper;

public class JSONConverter {

	public String convert(Patient patient) {
		String patientJson = "";
		ObjectMapper mapper = new ObjectMapper();

		try {

			patientJson = mapper.writeValueAsString(patient);

		} catch (Exception e) {
			e.printStackTrace();
		}
		return patientJson;
	}
}