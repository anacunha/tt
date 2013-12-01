package com.pucrs.devsys.tf.persistence;

import java.util.List;




import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import com.pucrs.devsys.tf.db.AbstractModel;
@XmlRootElement
@Entity
public class Sponsor extends AbstractModel
{
	@Id
	@GeneratedValue( strategy = GenerationType.AUTO )
	@XmlElement
	private long id;
	@Column
	@XmlElement
	private String name;
	@ManyToMany
	private List<Event> events;
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public List<Event> getEvents() {
		return events;
	}
	public void setEvents(List<Event> events) {
		this.events = events;
	}

	
}
