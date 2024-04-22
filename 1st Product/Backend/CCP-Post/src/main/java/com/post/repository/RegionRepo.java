package com.post.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.post.entity.Region;


@Repository
public interface RegionRepo extends JpaRepository<Region, Long> {
}
