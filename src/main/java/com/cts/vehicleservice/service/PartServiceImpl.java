package com.cts.vehicleservice.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cts.vehicleservice.dao.PartRepository;
import com.cts.vehicleservice.model.SpareParts;
@Service
public class PartServiceImpl implements PartService {

	
	
		@Autowired
		private PartRepository partRepo;
		
		@Override
		public SpareParts addPart(SpareParts spareparts) {
			System.out.println("Inside crud repo...");
			
			if(spareparts!=null ) {
				System.out.println("New part...");
				
				try {
					spareparts=partRepo.save(spareparts);
				} catch (Exception e) {
				
					e.printStackTrace();
				}
			}
			return spareparts;
		}

		
		 @Override public boolean deletePart(Integer partId) {
			 boolean isDeleted=false;
		 if(null!=partId && partRepo.existsById(partId)) 
		 {
		  partRepo.deleteById(partId); isDeleted=true; }
		  
		  return isDeleted; }
		 

		@Override
		public SpareParts getPart(Integer partId) {
			
			System.out.println("*******IN SERVICE IMPL**********");
			
			SpareParts spareparts=null;
			if (partRepo.existsById(partId)) {
				spareparts=partRepo.findById(partId).get();
				
			}
			
			return spareparts;
		}

		@Override
		public List<SpareParts> getAllparts() {
			
			return partRepo.findAll();
		}

		@Override
		public SpareParts savePart(SpareParts spareparts) {
		
				System.out.println("Inside crud repo...");
				if(spareparts!=null ) {
					System.out.println("New Part...");
					
					try {
						spareparts=partRepo.save(spareparts);
					} catch (Exception e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
				return spareparts;
			}
		}


		

		
		


