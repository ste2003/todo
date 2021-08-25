package com.redhat.training.todo.model;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
@Entity
public class Hca   {	
	
	@EmbeddedId
	private Expte expte;
	
	private String caratula;		
	/*
	 * public Hca(String tcc_codigo, Long hca_numero, int anio) { this.tcc_codigo =
	 * tcc_codigo; this.hca_numero = hca_numero; this.anio = anio; }
	 * @Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	 */	
	public Hca() {
		
	}

	public Expte getExpte() {
		return expte;
	}
	public void setExpte(Expte expte) {
		this.expte = expte;
		//expte.setOrg_codigo("3C1101");
		
		//this.expte.setOrg_codigo("3C1101");
		
		/*
		 * this.expte.setTcc_codigo("CXP"); Long hca_numero = (long) 12345;
		 * this.expte.setHca_numero(hca_numero); //System.out.println(hca_anio);
		 * this.expte.setHca_anio(21); System.out.println("Hca: " + this.expte);
		 */
	}
	@Override
	public String toString() {
		return "Hca [expte=" + expte + ", caratula=" + caratula + "]";
	}

	public String getCaratula() {
		return caratula;
	}

	public void setCaratula(String caratula) {
		this.caratula = caratula;
	}
	
	
	
}
