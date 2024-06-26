package com.relevantz.ccp.service;

import java.util.ArrayList;

import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.relevantz.ccp.dto.RegionDTO;
import com.relevantz.ccp.model.Region;
import com.relevantz.ccp.repository.RegionRepo;

@Service
public class RegionService {

//	@Autowired
//	RegionRepo rgRepo;
	
	@Autowired
    private RegionRepo regionRepo;

	public boolean insert(Region region) {
		regionRepo.save(region);
		return true;
	}

	public boolean update(Region region) {
		regionRepo.save(region);
		return true;
	}

	public boolean delete(long regionId) {
		regionRepo.deleteById(regionId);
		return true;
	}

	public List<Region> getAllRegionDetails() {
		Iterator<Region> it = regionRepo.findAll().iterator();
		ArrayList<Region> list = new ArrayList<>();
		while (it.hasNext()) {
			list.add(it.next());
		}
		return list;
	}

	public List<Region> getRegionName() {
		Iterator<Region> it = regionRepo.groupByRegionName().iterator();
		ArrayList<Region> list = new ArrayList<>();
		while (it.hasNext()) {
			list.add(it.next());
		}
		return list;
	}
	
	public boolean saveOrUpdateRegion(Region region) {
        regionRepo.save(region);
        return true;
    }
 
    public boolean deleteRegionById(Long regionId) {
        regionRepo.deleteById(regionId);
        return true;
    }
    public List<RegionDTO> findRegionById(Long regionId) {
        Region region=regionRepo.findById(regionId).get();
        List<RegionDTO> regionList=new ArrayList<>() ;
        RegionDTO regiondto=new RegionDTO();
        regiondto.setRegionId(region.getRegionId());
    	regiondto.setRegionName(region.getRegionName());
    	regiondto.setRegionLocation(region.getRegionLocation());
    	regiondto.setRegionTimezone(region.getRegionTimezone());
    	regionList.add(regiondto);
        return regionList;
    }
 
//    public List<Region> getAllRegions() {
//        return regionRepo.findAll();
//    }
    public List<RegionDTO> getAllRegions() {
        Iterator<Region> iterator = regionRepo.findAll().iterator();
        List<RegionDTO> userList = new ArrayList<>();
        while (iterator.hasNext()) {
        	Region region=iterator.next();
        	RegionDTO regiondto=new RegionDTO();
        	regiondto.setRegionId(region.getRegionId());
        	regiondto.setRegionName(region.getRegionName());
        	regiondto.setRegionLocation(region.getRegionLocation());
        	regiondto.setRegionTimezone(region.getRegionTimezone());

            userList.add(regiondto);
        }
        return userList;
    }

}
