package com.pucrs.devsys.tf.persistence;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import com.pucrs.devsys.tf.db.AbstractModel;

@XmlRootElement
@Entity(name="resources")
public class Resource extends AbstractModel
{
	@Id
	@GeneratedValue( strategy = GenerationType.AUTO )
	@XmlElement
	private long id;
	@Column
	@XmlElement
	private String link;
	@Column
	@XmlElement
	private String name;
	@Lob
	@Column
	private byte[] content;
	
	@ManyToOne
	private Talk talk;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}
	
	
	

	public byte[] getContent() {
		return content;
	}

	public void setContent(byte[] content) {
		this.content = content;
	}

	public String getLink() {
		return link;
	}

	public void setLink(String link) {
		this.link = link;
	}

	public Talk getTalk() {
		return talk;
	}

	public void setTalk(Talk talk) {
		this.talk = talk;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	

	
}
