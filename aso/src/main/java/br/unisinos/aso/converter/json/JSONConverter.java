package br.unisinos.aso.converter.json;

import org.springframework.stereotype.Component;

import br.unisinos.aso.model.Patient;

import com.fasterxml.jackson.databind.ObjectMapper;

@Component
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