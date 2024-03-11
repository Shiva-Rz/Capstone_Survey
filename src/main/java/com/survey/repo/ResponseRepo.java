package com.survey.repo;

import org.springframework.data.repository.CrudRepository;

import com.survey.bean.Responses;

public interface ResponseRepo extends CrudRepository<Responses, Long> {

}
