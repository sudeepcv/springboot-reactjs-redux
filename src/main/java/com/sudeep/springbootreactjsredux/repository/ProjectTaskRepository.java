package com.sudeep.springbootreactjsredux.repository;

import com.sudeep.springbootreactjsredux.model.ProjectTask;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProjectTaskRepository extends CrudRepository<ProjectTask, Long> {
}