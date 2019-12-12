package com.sudeep.springbootreactjsredux.service;

import javax.validation.Valid;

import com.sudeep.springbootreactjsredux.model.Project;

public interface ProjectService {

	Project saveOrUpdateProject(@Valid Project project);

    Project findProjectByIdentifier(String projectId);

    Iterable<Project> findAllProjects();

    void deleteProjectByIdentifier(String projectId);



}