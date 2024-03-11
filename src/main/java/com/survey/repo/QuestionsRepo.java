package com.survey.repo;

import org.springframework.data.repository.CrudRepository;

import com.survey.bean.Questions;

public interface QuestionsRepo extends CrudRepository<Questions, Long> {

}
