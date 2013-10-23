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
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import com.pucrs.devsys.tf.db.AbstractModel;

@XmlRootElement
@Entity(name="talks")
public class Talk extends AbstractModel
{
	@Id
	@GeneratedValue( strategy = GenerationType.AUTO )
	@XmlElement
	private long id;
	@Column
	@XmlElement
	private String titulo;
	@Column
	@XmlElement
	private String descricao;
	@Column
	@XmlElement
	@Temporal(TemporalType.DATE)
	private Date startTime;
	
	@JoinColumn
	@XmlElement
	private TalkType type;
	
	@ManyToOne
	@JoinColumn
	private Event event;
	
	@ManyToMany
	private List<User> participants;
	
	@JoinColumn
	private User responsible;	
	
	@OneToMany(mappedBy="talk")
	private List<Resource> resources;
}
