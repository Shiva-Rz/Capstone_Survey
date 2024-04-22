package com.post.controller;

 
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.post.entity.Region;
import com.post.entity.RegionDTO;
import com.post.service.RegionService;
 
@RestController
@CrossOrigin("http://localhost:4200/")
public class RegionController {
 
    @Autowired
    private RegionService regionService;
 
    @PostMapping("/insertRegions")
    public void performInsert(@RequestBody Region region) {
        regionService.saveOrUpdateRegion(region);
    }
 
    @PutMapping("/updateRegions")
    public void performUpdate(@RequestBody Region region) {
        regionService.saveOrUpdateRegion(region);
    }
 
    @DeleteMapping("/deleteRegions/{regionId}")
    public void performDelete(@PathVariable Long regionId) {
        regionService.deleteRegionById(regionId);
    }
    
    
    @GetMapping("/findAllRegions") 
    public List<RegionDTO> viewAllRegions() {
        return regionService.getAllRegions();
    }
    
    @GetMapping("/findRegions/{regionId}")
    public List<RegionDTO> performFind(@PathVariable Long regionId) {
        return regionService.findRegionById(regionId);
    }
}