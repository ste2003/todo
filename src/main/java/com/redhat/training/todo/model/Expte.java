package com.redhat.training.todo.model;

import java.io.Serializable;

import javax.persistence.Embeddable;

@Embeddable
public class Expte implements Serializable{
	
	private String org_codigo;
	
	private Long hca_numero;
	
	private String tcc_codigo;
		
	private Integer hca_anio;
	
	public Expte() {
		// TODO Auto-generated constructor stub
	}

	public Long getHca_numero() {
		return hca_numero;
	}

	@Override
	public String toString() {
		return "Expte [org_codigo=" + org_codigo + ", hca_numero=" + hca_numero + ", tcc_codigo=" + tcc_codigo
				+ ", hca_anio=" + hca_anio + "]";
	}

	public void setHca_numero(Long hca_numero) {
		this.hca_numero = hca_numero;
	}

	public String getTcc_codigo() {
		return tcc_codigo;
	}

	public void setTcc_codigo(String tcc_codigo) {
		this.tcc_codigo = tcc_codigo;
	}

	public Integer getHca_anio() {
		return hca_anio;
	}

	public void setHca_anio(Integer hca_anio) {
		this.hca_anio = hca_anio;
	}
	

	@Override
	public boolean equals(Object o) {
		if (this == o) {return true;}
		if (o == null || getClass() !=o.getClass()) { return false; }
	
		Expte expte = (Expte) o;
		
		return org_codigo.equals(expte.org_codigo) & tcc_codigo.equals(expte.tcc_codigo) & hca_numero.equals(expte.hca_numero) & hca_anio.equals(expte.hca_anio);
	}

	@Override
	public int hashCode() {
		return hca_numero.hashCode();
	}

	public String getOrg_codigo() {
		return org_codigo;
	}

	public void setOrg_codigo(String org_codigo) {
		this.org_codigo = org_codigo;
	}

}
