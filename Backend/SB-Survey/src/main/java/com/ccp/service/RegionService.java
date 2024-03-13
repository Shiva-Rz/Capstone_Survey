package com.ccp.service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ccp.bean.Region;
import com.ccp.repo.RegionRepo;

@Service
public class RegionService {

	@Autowired
	RegionRepo rgRepo;

	public boolean insert(Region region) {
		rgRepo.save(region);
		return true;
	}

	public boolean update(Region region) {
		rgRepo.save(region);
		return true;
	}

	public boolean delete(long regionId) {
		rgRepo.deleteById(regionId);
		return true;
	}

	public List<Region> getAllRegionDetails(){
		Iterator<Region> it=rgRepo.findAll().iterator();
		ArrayList<Region> list=new ArrayList<>();
		while(it.hasNext()) {
			list.add(it.next());
		}
		return list;
	}

//	public List<String> getRegionName() {
//		Iterator<String> it = rgRepo.groupByRegionName().iterator();
//		ArrayList<String> list = new ArrayList<>();
//		while (it.hasNext()) {
//			list.add(it.next());
//		}
//		return list;
//	}
}
