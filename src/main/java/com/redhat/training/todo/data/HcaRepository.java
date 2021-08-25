package com.redhat.training.todo.data;

import java.util.List;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import com.redhat.training.todo.model.Expte;
import com.redhat.training.todo.model.Hca;

@ApplicationScoped
public class HcaRepository {
	
	private List<Hca> myHcaList;
	
	@Inject
	private EntityManager em;
	
	public void iniciarDb() {		
		Hca hca1 ;
		hca1 = new Hca();
		
		hca1.setCaratula("Caratula 1");
		System.out.println("caratula: " + hca1.getCaratula());
		Expte expte = new Expte();
		expte.setOrg_codigo("3C1101");
		expte.setTcc_codigo("CXP");
		expte.setHca_numero((long) 12345);
		expte.setHca_anio(21);
		hca1.setExpte(expte);
		System.out.println("expte: " + hca1.getExpte());
		em.persist(hca1);
	}
	public void addHca(Hca hca) {
		em.persist(hca);
	}

	public List<Hca> getAllHcas(){
		/*
		 * if (myItemList == null) { myItemList = new ArrayList<Item>(); }
		 */
		TypedQuery<Hca> query = em.createQuery("SELECT h FROM Hca h", Hca.class);
		
		return query.getResultList();
	}
	public Hca getHca(Long hca_numero) {
		/*
		 * Hca testHca = null; for (int i = 0; i < myHcaList.size(); i++) { if
		 * (myHcaList.get(i).getHca_numero() == hca_numero) { testHca =
		 * myHcaList.get(i); } } return testHca;
		 */
		return em.find(Hca.class, hca_numero);
	}
}
