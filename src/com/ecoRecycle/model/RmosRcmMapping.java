package com.ecoRecycle.model;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "RmosRcmMapping")
public class RmosRcmMapping {
	
	@Id 
	@GeneratedValue
	@Column(name = "id")
	private int id;
	
	@ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "rmosId") 
    private Rmos rmos;
	
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "rcmId")
    private Rcm rcm;
	
	@Column(name = "isValid")
    private boolean isValid;
	
    @Column(name = "createDateTime")
	private Date createDateTime;
	
	@Column(name = "updateDateTime")
	private Date updateDateTime;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Rmos getRmos() {
		return rmos;
	}

	public void setRmos(Rmos rmos) {
		this.rmos = rmos;
	}

	public Rcm getRcm() {
		return rcm;
	}

	public void setRcm(Rcm rcm) {
		this.rcm = rcm;
	}

	public boolean isValid() {
		return isValid;
	}

	public void setValid(boolean isValid) {
		this.isValid = isValid;
	}

	public Date getCreateDateTime() {
		return createDateTime;
	}

	public void setCreateDateTime(Date createDateTime) {
		this.createDateTime = createDateTime;
	}

	public Date getUpdateDateTime() {
		return updateDateTime;
	}

	public void setUpdateDateTime(Date updateDateTime) {
		this.updateDateTime = updateDateTime;
	}
}
