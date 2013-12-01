package com.pucrs.devsys.tf.rest;

import javax.ws.rs.Path;

import com.pucrs.devsys.tf.db.AbstractCRUD;
import com.pucrs.devsys.tf.persistence.Talk;

@Path("talks")
public class TalkService extends AbstractCRUD<Talk>{

}
