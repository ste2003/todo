package com.redhat.training.todo.service;

import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;

import com.redhat.training.todo.data.HcaRepository;
import com.redhat.training.todo.data.ItemRepository;
import com.redhat.training.todo.model.Hca;
import com.redhat.training.todo.model.Item;

@Stateless
public class HcaService {

	@Inject
	 HcaRepository hcaRepository;
	
	public Hca find(Long hca_numero) {
		return hcaRepository.getHca(hca_numero);
	}
	
	public List<Hca> getAllHcas(){
		//log.info("Fetching all TODO items...");
		return hcaRepository.getAllHcas();
	}
	public void iniciarDb() throws Exception {
		hcaRepository.iniciarDb();
		
	}
	public void register(Hca hca) throws Exception {		
		
		hcaRepository.addHca(hca);
	}
	
}
