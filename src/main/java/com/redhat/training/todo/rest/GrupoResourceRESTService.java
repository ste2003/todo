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

import com.redhat.training.todo.model.Grupo;
import com.redhat.training.todo.model.Item;
import com.redhat.training.todo.service.GrupoService;
import com.redhat.training.todo.service.ItemService;

@Path("/grupos")
@RequestScoped
public class GrupoResourceRESTService {
	
	@EJB
	GrupoService grupoService;
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<Grupo> listAllGrupos(){
		System.out.println("en get*********************");
		return grupoService.getAllGrupos();
	}
	
	@GET
	@Path("grupo/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public List<Grupo> listGruposxId(@PathParam("id") Long id){
		System.out.println("en get x grupo *********************");
		return grupoService.getGruposxId(id);
	}
	
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response createGrupo(Grupo grupo) {
		Response.ResponseBuilder builder = null;
		
		try {
			//if (item.getId() == null) {
				System.out.println("en el try********");
				grupoService.register(grupo);
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
}
