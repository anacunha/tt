package com.pucrs.devsys.tf.persistence;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import com.pucrs.devsys.tf.db.AbstractModel;

@XmlRootElement
@Entity(name="talktypes")
public class TalkType extends AbstractModel
{
	@Id
	@GeneratedValue( strategy = GenerationType.AUTO )
	@XmlElement
	private long id;
	@Column
	@XmlElement
	private String decricao;
}
