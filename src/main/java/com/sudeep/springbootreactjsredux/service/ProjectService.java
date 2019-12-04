package com.sudeep.springbootreactjsredux.service;

import com.sudeep.springbootreactjsredux.model.Project;

public interface ProjectService {

    Project saveOrUpdateProject(Project project);

	Project findProjectByProjectIdentifier(String projectId);

    Iterable<Project> findAllProject();

    void deleteProjectByIdentifier(String projectid);

}