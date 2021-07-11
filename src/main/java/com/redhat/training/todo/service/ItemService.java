package com.redhat.training.todo.service;

import java.util.List;
import java.util.logging.Logger;

import javax.ejb.Stateless;
import javax.inject.Inject;

import com.redhat.training.todo.data.ItemRepository;
import com.redhat.training.todo.model.Item;

@Stateless
public class ItemService {
	
	//@Inject
	//private Logger log;
	
	 @Inject
	 ItemRepository itemRepository;
	
	public void register(Item item) throws Exception {
		//log.info("Adding new task: " + item.getDescription());
		item.setId((long) (itemRepository.getItemCount() + 1));
		
		itemRepository.addItem(item);
	}
	
	public Item find(Long id) {
		return itemRepository.getItem(id);
	}
	
	public List<Item> getAllItems(){
		//log.info("Fetching all TODO items...");
		return itemRepository.getAllItems();
	}
	
}
