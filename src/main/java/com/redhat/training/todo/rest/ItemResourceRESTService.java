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
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.redhat.training.todo.service.ItemService;
import com.redhat.training.todo.model.Item;

@Path("/items")
@RequestScoped
public class ItemResourceRESTService {
	
	@EJB
	ItemService itemService;
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<Item> listAllItems(){
		System.out.println("en get*********************");
		return itemService.getAllItems();
	}
	
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response createItem(Item item) {
		Response.ResponseBuilder builder = null;
		
		try {
			//if (item.getId() == null) {
				System.out.println("en el try********");
				itemService.register(item);
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
