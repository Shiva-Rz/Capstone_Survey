package com.post.service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.post.entity.Post;
import com.post.entity.Region;
import com.post.entity.RegionDTO;
import com.post.entity.User;
import com.post.repository.RegionRepo;
import com.post.repository.UserRepo;
 
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