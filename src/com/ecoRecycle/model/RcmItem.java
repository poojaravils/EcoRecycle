package com.ecoRecycle.model;

import javax.persistence.*;

import java.util.Date;

@Entity
@Table(name = "RcmItemMapping")
public class RcmItem {
	
	@Id 
	@GeneratedValue
	@Column(name = "id")
	private int id;
	
	@ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "rcmId") 
    private Rcm rcm;
	
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "itemId")
    private Item item;
     
    @Column(name = "pricePerLb")
    private double pricePerLb;
    
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

	public Rcm getRcm() {
		return rcm;
	}

	public void setRcm(Rcm rcm) {
		this.rcm = rcm;
	}

	public Item getItem() {
		return item;
	}

	public void setItem(Item item) {
		this.item = item;
	}

	public double getPricePerLb() {
		return pricePerLb;
	}

	public void setPricePerLb(double pricePerLb) {
		this.pricePerLb = pricePerLb;
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
