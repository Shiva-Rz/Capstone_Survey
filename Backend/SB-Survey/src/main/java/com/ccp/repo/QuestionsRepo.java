package com.ccp.repo;

import org.springframework.data.repository.CrudRepository;

import com.ccp.bean.Questions;

public interface QuestionsRepo extends CrudRepository<Questions, Long> {

}
