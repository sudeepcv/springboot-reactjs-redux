package com.sudeep.springbootreactjsredux.repository;

import com.sudeep.springbootreactjsredux.model.Project;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProjectRepository extends CrudRepository<Project, Long> {
    Project findByProjectIdentifier(String projectIdentifier);
    Iterable<Project> findAll();

}