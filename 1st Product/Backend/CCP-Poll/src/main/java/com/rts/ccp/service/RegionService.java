package com.rts.ccp.service;
 
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rts.ccp.bean.Department;
import com.rts.ccp.bean.Region;
import com.rts.ccp.dto.RegionDTO;
import com.rts.ccp.repository.RegionRepo;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
 
@Service
public class RegionService {
 
    @Autowired
    private RegionRepo regionRepo;
 
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