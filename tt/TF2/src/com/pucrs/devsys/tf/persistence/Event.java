package com.pucrs.devsys.tf.persistence;


import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import org.codehaus.jackson.map.annotate.JsonDeserialize;
import org.codehaus.jackson.map.annotate.JsonSerialize;

import com.pucrs.devsys.tf.db.AbstractModel;
import com.pucrs.devsys.tf.util.JsonDateDeserializerYYYYMMDD;
import com.pucrs.devsys.tf.util.JsonDateSerializerYYYYMMDD;

@XmlRootElement
@Entity(name="events")
public class Event extends AbstractModel
{
	@Id
	@GeneratedValue( strategy = GenerationType.AUTO )
	@XmlElement
	private long id;
	@Column
	@XmlElement
	private String title;
	@Column
	@XmlElement
	private String description;
	@Column
	@XmlElement
	private String edition;
	@Column
	@Temporal(TemporalType.DATE)
	@XmlElement
	private Date date;
	
	@OneToMany(mappedBy="event")
	@JoinColumn
	private List<Talk> talks; 

	@ManyToMany
	@JoinColumn
	private List<User> organizers; 
	
	@ManyToMany
	private List<Sponsor> sponsors;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getEdition() {
		return edition;
	}

	public void setEdition(String edition) {
		this.edition = edition;
	}

	@JsonSerialize(using = JsonDateSerializerYYYYMMDD.class)
	public Date getDate() {
		return date;
	}
	
	@JsonDeserialize(using = JsonDateDeserializerYYYYMMDD.class)
	public void setDate(Date date) {
		this.date = date;
	}

	public List<Talk> getTalks() {
		return talks;
	}

	public void setTalks(List<Talk> talks) {
		this.talks = talks;
	}

	public List<User> getOrganizers() {
		return organizers;
	}

	public void setOrganizers(List<User> organizers) {
		this.organizers = organizers;
	}

	public List<Sponsor> getSponsors() {
		return sponsors;
	}

	public void setSponsors(List<Sponsor> sponsors) {
		this.sponsors = sponsors;
	}
	
	
}
