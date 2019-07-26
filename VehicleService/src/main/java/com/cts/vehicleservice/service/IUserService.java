package com.cts.vehicleservice.service;

import java.util.List;

import com.cts.vehicleservice.model.SpareParts;
import com.cts.vehicleservice.model.User;

public interface IUserService {
	SpareParts savePart(SpareParts SpareParts);
	boolean deletePart(String partId);
	SpareParts getPart(String partId);
	List<SpareParts>getAllParts();

}
