package com.ccp.controller;

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

import com.ccp.bean.Reaction;
import com.ccp.bean.Region;
import com.ccp.service.ReactionService;
import com.ccp.service.RegionService;

@RestController
@CrossOrigin("http://localhost:4200")
public class RegionController {

	@Autowired
	RegionService rgService;

	@PostMapping("/region")
	public String performInsert(@RequestBody Region region) {
		rgService.insert(region);
		return "Record Inserted";

	}

	@PutMapping("/region")
	public String performUpdate(@RequestBody Region region) {
		rgService.update(region);
		return "Record Updated";
	}

	@DeleteMapping("/region/{regionId}")
	public void performDelete(@PathVariable("regionId") long regionId) {
		rgService.delete(regionId);
	}

//	@GetMapping("/region")
//	public List<Region> viewAllRegionDetails() {
//		return rgService.getAllRegionDetails();
//	}

	@GetMapping("/getregion")
	public List<Region> getRegionName() {
		return rgService.getAllRegionDetails();
	}

}
