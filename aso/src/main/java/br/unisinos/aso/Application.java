package br.unisinos.aso;

import org.glassfish.jersey.jackson.JacksonFeature;
import org.glassfish.jersey.server.ResourceConfig;
import org.glassfish.jersey.server.spring.scope.RequestContextFilter;

import br.unisinos.aso.service.ASOService;


public class Application extends ResourceConfig {
	
	public Application() {
		register(RequestContextFilter.class);
		register(ASOService.class);
		register(JacksonFeature.class);	
	}
}