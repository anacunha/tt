package com.pucrs.devsys.tf.rest;

import javax.ws.rs.Path;

import com.pucrs.devsys.tf.db.AbstractCRUD;
import com.pucrs.devsys.tf.persistence.Sponsor;

@Path("sponsors")
public class SponsorService extends AbstractCRUD<Sponsor> {

}
