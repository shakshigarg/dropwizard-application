package com.dropwizard.application.resources;

import com.dropwizard.application.api.ServiceRequest;
import com.dropwizard.application.api.ServiceResponse;
import com.dropwizard.application.exception.ServiceException;
import com.dropwizard.application.service.Service;

import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.*;


@Path("/api")
@Produces(MediaType.APPLICATION_JSON)
public class ApiResource {
    Service service;

    @Inject
    public ApiResource() {
        service = new Service();
    }

    @POST
    @Path("/start-tracking")
    @Consumes(MediaType.APPLICATION_JSON)
    public ServiceResponse startTracking(ServiceRequest serviceRequest) {
        service.startTracking(serviceRequest.getId(), serviceRequest.getHerTags());
        return new ServiceResponse("200", "Entity is being tracked.");
    }

    @POST
    @Path("/stop-tracking")
    public ServiceResponse stopTracking(ServiceRequest serviceRequest) {
        try {
            service.stopTracking(serviceRequest.getId());
            return new ServiceResponse("200", String.format("Stopped tracking the entity %d", serviceRequest.getId()));
        } catch (ServiceException e) {
            return new ServiceResponse(e.getStatus(), e.getMessage());
        }
    }

    @POST
    @Path("/get-count")
    public ServiceResponse getCount(ServiceRequest serviceRequest) {
        int count = service.getCount(serviceRequest.getHerTags());
        return new ServiceResponse("200", String.format("Count for the tags is %d", count));
    }
}
