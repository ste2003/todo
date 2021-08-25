package com.redhat.training.todo.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
@Entity
public class Item   {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	private String description;
	
	private Boolean done = false;
	
	@ManyToOne()
	@JoinColumn(name="grupo")
	private Grupo grupo;
	
	public Item(Long id, String description) {
		this.id = id;
		this.description = description;
	}
	
	public Item() {
		
	}
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

	public Boolean getDone() {
		return done;
	}

	public void setDone(Boolean done) {
		this.done = done;
	}
	public void setGrupo(Grupo grupo) {
		this.grupo = grupo;
	}
	
	public Grupo getGrupo() {
		return grupo;
	}
	@Override
	public boolean equals(Object o) {
		if (this == o) {return true;}
		if (o == null || getClass() !=o.getClass()) { return false; }
	
		Item item = (Item) o;
		
		return id.equals(item.id);
	}
	
	@Override
	public int hashCode() {
		return id.hashCode();
	}
}
