package br.unisinos.aso.converter.json;

import org.springframework.stereotype.Component;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;

import br.unisinos.aso.model.Patient;
import br.unisinos.aso.transformer.TransformedInfo;

@Component
public class JSONConverter {

	public String convert(Patient patient, TransformedInfo transformed) {
		String patientJson = "";
		ObjectMapper mapper = new ObjectMapper();

		try {
			
			patientJson = mapper.writeValueAsString(patient);
			JsonNode readTree = mapper.readTree(patientJson);
			
			ObjectNode changedJSON = ((ObjectNode)readTree).put("chartUrl", transformed.getChartUrl());
			changedJSON = changedJSON.put("bloodPressureComparisonChartUrl", transformed.getBloodPressureComparisonChartUrl());
			
			patientJson = mapper.writeValueAsString(changedJSON);

		} catch (Exception e) {
			e.printStackTrace();
		}
		return patientJson;
	}
}