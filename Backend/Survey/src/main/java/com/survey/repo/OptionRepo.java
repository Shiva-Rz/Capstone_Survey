package com.survey.repo;

import org.springframework.data.repository.CrudRepository;

import com.survey.bean.Options;

public interface OptionRepo extends CrudRepository<Options, Long> {

}
