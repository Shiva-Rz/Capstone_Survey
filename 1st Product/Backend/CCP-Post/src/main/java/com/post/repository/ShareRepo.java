package com.post.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.post.entity.Share;

public interface ShareRepo extends JpaRepository<Share, Long> {

}
