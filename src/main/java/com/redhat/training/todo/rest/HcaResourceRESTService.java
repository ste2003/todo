package com.redhat.training.todo.rest;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.redhat.training.todo.model.Hca;
import com.redhat.training.todo.model.Item;
import com.redhat.training.todo.service.HcaService;



@Path("/hcas")
@RequestScoped
public class HcaResourceRESTService {

	@EJB
	HcaService hcaService;
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<Hca> listAllHcas(){
		System.out.println("en get*********************");
		return hcaService.getAllHcas();
	}
	@GET
	@Path("hca/{hca_numero}") 
	@Produces(MediaType.APPLICATION_JSON)
	public Hca getHca(@PathParam("hca_numero") Long hca_numero){
		System.out.println("en get x id *********************" + hca_numero);
		return hcaService.find(hca_numero);
	}
	
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response createHca(Hca hca) {
		Response.ResponseBuilder builder = null;
		
		try {
			//if (item.getId() == null) {
				System.out.println("en el try********");
				hcaService.register(hca);
				builder = Response.ok();
			//} else {Response.ok();}
		} catch (Exception e) {
			System.out.println("ERROR !!!!!!!!!********");
			Map<String, String> responseObj = new HashMap<String, String>();
			responseObj.put("error", e.getMessage());
			builder = Response.status(Response.Status.BAD_REQUEST).entity(responseObj);
		}
		return builder.build();
	}
	@GET	
	@Path("iniciardb")
	public Response iniciarHca() {
		Response.ResponseBuilder builder = null;		
		try {
				System.out.println("en el iniciar db********");
				hcaService.iniciarDb();
				builder = Response.ok();
		} catch (Exception e) {
			System.out.println("ERROR en iniciarDB!!!!!!!!!********");
			Map<String, String> responseObj = new HashMap<String, String>();
			responseObj.put("error", e.getMessage());
			builder = Response.status(Response.Status.BAD_REQUEST).entity(responseObj);
		}
		return builder.build();
	}
}
