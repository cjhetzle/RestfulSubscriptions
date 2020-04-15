package com.cameronhetzler.gateway;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/invoices")
public class Invoices {

	@GET
	@Produces(MediaType.TEXT_HTML)
	public String testDir() {
		return "Connected";
	}
}
