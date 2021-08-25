package com.redhat.training.todo.data;

import java.util.List;
import java.util.logging.Logger;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import com.redhat.training.todo.model.Grupo;
import com.redhat.training.todo.model.Item;

@ApplicationScoped
public class GrupoRepository {
	@Inject
	private Logger log;
	
	private List<Grupo> myGrupoList;
	
	@Inject
	private EntityManager em;
	
	public void addGrupo(Grupo grupo) {
		em.persist(grupo);
	}
	
	/*
	 * @PostConstruct public void seedTodoList() {
	 * log.info("Seeding TODO List cache..."); myItemList = new ArrayList<Item>();
	 * myItemList.add(new Item((long)1, "Buy Milk")); myItemList.add(new
	 * Item((long)2, "Buy Eggs")); myItemList.add(new Item((long)3, "Send EMail"));
	 * }
	 * 
	 * public void addItem(Item item) { myItemList.add(item); }
	 */
	
	public List<Grupo> getAllGrupos(){
		/*
		 * if (myItemList == null) { myItemList = new ArrayList<Item>(); }
		 */
		TypedQuery<Grupo> query = em.createQuery("SELECT g FROM Grupo g", Grupo.class);
		//return myItemList;
		return query.getResultList();
	}
	public List<Grupo> getAllGruposxId(Long id){
		
		TypedQuery<Grupo> query = em.createQuery("SELECT g FROM Grupo g", Grupo.class);
		//return myItemList;
		return query.getResultList();
	}
	
	public Grupo getGrupo(Long id) {
		Grupo testGrupo = null;
		for (int i = 0; i < myGrupoList.size(); i++) {
			if (myGrupoList.get(i).getId() == id) {
				testGrupo = myGrupoList.get(i);
			}
		}
		return testGrupo;
	}
	
	public int getGrupoCount() {
		return myGrupoList.size();
	}
}
