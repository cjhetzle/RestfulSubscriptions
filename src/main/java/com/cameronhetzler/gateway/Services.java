package com.cameronhetzler.gateway;

import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.Consumes;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.cameronhetzler.data.model.Service;

@Path("/services")
public class Services {

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Service[] getServices() {
		Service[] services = new Service[] {
				new Service(
						"6ccb0576-842f-11ea-8332-f83441083c1f",
						"Netflix",
						8.99,
						"https://assets.nflxext.com/us/ffe/siteui/common/icons/nficon2016.png",
						"ff0000"
					),
				new Service(
						"6ccf9935-842f-11ea-9d50-f83441083c1f",
						"crunchyroll",
						7.99,
						"https://www.crunchyroll.com/favicons/favicon-16x16.png",
						"ffa500"
					),
				new Service(
						"6ccf9934-842f-11ea-86f9-f83441083c1f",
						"Spotify",
						9.99,
						"https://open.scdn.co/cdn/images/favicon16.19fc3918.png",
						"1DB954"
					),
				new Service(
						"6ccfc04a-842f-11ea-9a7a-f83441083c1f",
						"Nintendo Online",
						2.92,
						"ttps://www.nintendo.com/etc.clientlibs/noa/clientlibs/clientlib-ncom/resources/images/latam/favicon.ico",
						"e4000f"
					)
				
		};
		return services;
	}
	
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	public Response subscribeToServices(Service[] services) {
		try {
			return Response.status(200).build();
		}
		catch (Exception e) {
			return Response.status(500).build();
		}
	}
}
