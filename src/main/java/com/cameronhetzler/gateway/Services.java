package com.cameronhetzler.gateway;

import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

@Path("/services")
public class Services {

	@GET
	@Produces(MediaType.TEXT_HTML)
	public String getDir(@QueryParam("name") String name) {
		if (name == null)
			return "Connected";
		return name;
	}
	
	@POST
	@Produces(MediaType.APPLICATION_JSON)
	public String postDir(String body) {
		if (body == null)
			return "Connected";
		return body;
	}
}
