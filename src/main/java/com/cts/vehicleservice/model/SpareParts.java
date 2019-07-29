package com.cts.vehicleservice.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="SpareParts")
public class SpareParts {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer partId;
	private String description;
	private Integer price;
	private String partName;
	
	
	public String getPartName() {
		return partName;
	}
	public void setPartName(String partName) {
		this.partName = partName;
	}
	public Integer getpartId() {
		return partId;
	}
	public void setpartId(Integer partId) {
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
