package com.cameronhetzler.gateway;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

@Path("/plans")
public class Plans {

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public String getDir(
			@QueryParam("id") String id,
			@QueryParam("service") String service) {
		if (id == null)
			return "Connected";
		return id;
	}
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/proposed")
	public String getProposed(
			@QueryParam("id") String id) {
		if (id == null)
			return "Connected";
		return id;
	}
}
