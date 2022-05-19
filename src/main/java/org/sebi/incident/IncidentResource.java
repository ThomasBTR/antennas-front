package org.sebi.incident;

import java.util.List;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;

import org.eclipse.microprofile.config.inject.ConfigProperty;
import org.eclipse.microprofile.rest.client.inject.RestClient;

@Path("rest/incidents")
public class IncidentResource{
    
    @Inject
    @RestClient
    IncidentWebResouce incidentWebResouce;

    @ConfigProperty(name = "secret.apiKey", defaultValue = "koukou")
    private String apiKey;


    @GET
    public List<Incident> getIncidents(){
       return incidentWebResouce.getIncidents(apiKey);
    } 
}
