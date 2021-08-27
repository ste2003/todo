package com.redhat.training.todo.ui;

import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

import com.redhat.training.todo.model.Expte;
import com.redhat.training.todo.model.Hca;
import com.redhat.training.todo.service.HcaService;

@RequestScoped
@Named("hello")
public class HcaHello {
	
	@EJB
	private HcaService hcaService;
	
	private Long hca_numero;
	
	private String expte;
	
	public Hca findHca() {
				
		Expte expte = new Expte();
		expte.setOrg_codigo("3C1101");
		expte.setTcc_codigo("CXP");
		expte.setHca_numero((long) 12345);
		expte.setHca_anio(21);
		
		System.out.println( "Expte, " + expte);
		Hca hca = new Hca();
		hca = hcaService.find(expte);
		System.out.println("hca:" + hca);
		this.expte = hca.toString();
		return hca;
		
	}

	public Long getHca_numero() {
		return hca_numero;
	}

	public void setHca_numero(Long hca_numero) {
		this.hca_numero = hca_numero;
	}

	public String getExpte() {
		return expte;
	}

	public void setExpte(String expte) {
		this.expte = expte;
	}
}
