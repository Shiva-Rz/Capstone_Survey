package com.relevantz.ccp.controller;
 
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.*;

import com.relevantz.ccp.dto.RegionDTO;
import com.relevantz.ccp.model.Region;
import com.relevantz.ccp.service.RegionService;

import java.util.List;
 
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