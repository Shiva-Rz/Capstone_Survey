package com.rts.ccp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.rts.ccp.bean.Region;

@Repository
public interface RegionRepo extends JpaRepository<Region, Long> {
}