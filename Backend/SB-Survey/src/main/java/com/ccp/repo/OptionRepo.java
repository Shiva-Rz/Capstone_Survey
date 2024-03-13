package com.ccp.repo;

import org.springframework.data.repository.CrudRepository;

import com.ccp.bean.Options;

public interface OptionRepo extends CrudRepository<Options, Long> {

}
