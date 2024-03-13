package com.ccp.repo;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.ccp.bean.Responses;

@Repository
public interface ResponseRepo extends CrudRepository<Responses, Long> {

}
