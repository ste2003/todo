package com.redhat.training.todo.rest;

import java.util.List;

import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

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
		return itemService.getAllItems();
	}
	

}
