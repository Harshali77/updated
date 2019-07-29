package com.cts.vehicleservice.service;

import java.util.List;

import com.cts.vehicleservice.model.SpareParts;

public interface PartService {
	SpareParts addPart(SpareParts spareparts);
	boolean deletePart(Integer partId);
	SpareParts getPart(Integer partId);
	List<SpareParts>getAllparts();
	SpareParts savePart(SpareParts spareparts);


}
