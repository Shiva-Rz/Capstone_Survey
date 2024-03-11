package com.survey.repo;

import org.springframework.data.repository.CrudRepository;

import com.survey.bean.Project;

public interface ProjectRepo extends CrudRepository<Project, Long> {

}
