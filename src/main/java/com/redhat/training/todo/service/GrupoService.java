package com.redhat.training.todo.service;

import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;

import com.redhat.training.todo.data.GrupoRepository;
import com.redhat.training.todo.data.ItemRepository;
import com.redhat.training.todo.model.Grupo;
import com.redhat.training.todo.model.Item;

@Stateless
public class GrupoService {
	 @Inject
	 GrupoRepository grupoRepository;
	
	public void register(Grupo grupo) throws Exception {
		//log.info("Adding new task: " + item.getDescription());
		//item.setId((long) (itemRepository.getItemCount() + 1));
		
		grupoRepository.addGrupo(grupo);
	}
	
	public Grupo find(Long id) {
		return grupoRepository.getGrupo(id);
	}
	
	public List<Grupo> getAllGrupos(){
		//log.info("Fetching all TODO items...");
		return grupoRepository.getAllGrupos();
	}
	public List<Grupo> getGruposxId(Long id){
		//log.info("Fetching all TODO items...");
		return grupoRepository.getAllGruposxId(id);
	}
}
