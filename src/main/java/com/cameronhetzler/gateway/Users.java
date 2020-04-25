package com.cameronhetzler.gateway;

import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

@Path("/users")
public class Users {

	@GET
	@Produces(MediaType.TEXT_HTML)
	public String getDir(@QueryParam("email") String email) {
		if (email == null)
			return "Connected";
		return email;
	}
	
	@POST
	@Produces(MediaType.APPLICATION_JSON)
	public String postDir(String body) {
		if (body == null)
			return "Connected";
		return body;
	}
}
