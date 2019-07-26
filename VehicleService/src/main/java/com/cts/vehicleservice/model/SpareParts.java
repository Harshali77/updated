package com.cts.vehicleservice.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;



import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="SpareParts")
public class SpareParts {
	
	@Id
	private String partId;
	private String description;
	private Integer price;
	
	
	
	public String getpartId() {
		return partId;
	}
	public void setpartId(String partId) {
		this.partId = partId;
	}
	public String getdescription() {
		return description;
	}
	public void setdescription(String description) {
		this.description = description;
	}
	public Integer getprice() {
		return price;
	}
	public void setprice(Integer price) {
		this.price = price;
	}
	


}
