package com.redhat.training.todo.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.FetchType;

import java.util.HashSet;
import java.util.Set;

@Entity
public class Grupo {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	private String description;
	
	@OneToMany(mappedBy="grupo", fetch=FetchType.LAZY)
	private Set<Item> items = new HashSet<Item>();
	
	public Long getId() {
		return id;
	}

	/*
	 * public void setId(Long id) { this.id = id; }
	 */
	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	/*
	 * public Set<Item> getItems(){ return items; } public void setItems(Set<Item>
	 * items) { this.items = items; }
	 */
	
	@Override
	public boolean equals(Object o) {
		if (this == o) {return true;}
		if (o == null || getClass() !=o.getClass()) { return false; }
	
		Grupo grupo = (Grupo) o;
		
		return id.equals(grupo.id);
	}
	
	@Override
	public int hashCode() {
		return id.hashCode();
	}

}
