package com.sudeep.springbootreactjsredux.service;

import com.sudeep.springbootreactjsredux.exception.ProjectIdException;
import com.sudeep.springbootreactjsredux.model.Backlog;
import com.sudeep.springbootreactjsredux.model.Project;
import com.sudeep.springbootreactjsredux.repository.BacklogRepository;
import com.sudeep.springbootreactjsredux.repository.ProjectRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProjectServiceImpl implements ProjectService {
    @Autowired
    private ProjectRepository projectRepository;
     @Autowired
    private BacklogRepository backlogRepository;

    @Override
    public Project saveOrUpdateProject(Project project) {
        try {

            if(project.getProjectIdentifier()==null){
                Backlog backlog = new Backlog();
                project.setBacklog(backlog);
                backlog.setProject(project);
                backlog.setProjectIdentifier(project.getProjectIdentifier().toUpperCase());
            }

            if(project.getProjectIdentifier()!=null){
                project.setBacklog(backlogRepository.findByProjectIdentifier(project.getProjectIdentifier().toUpperCase()));
            }

            // project.setProjectIdentifier(project.getProjectIdentifier().toUpperCase());
            return projectRepository.save(project);
        } catch (Exception e) {
            throw new ProjectIdException(
                    "project id:" + project.getProjectIdentifier().toUpperCase() + "already exists");
        }
    }

    @Override
    public Project findProjectByProjectIdentifier(String projectId) {
        Project project = projectRepository.findByProjectIdentifier(projectId);
        if (project == null) {
            throw new ProjectIdException("Project does not exist");
        }
        return project;
    }

    @Override
    public Iterable<Project> findAllProject() {
        return projectRepository.findAll();
    }

    @Override
    public void deleteProjectByIdentifier(String projectid) {
        Project project = projectRepository.findByProjectIdentifier(projectid.toUpperCase());
        if (project == null) {
            throw new ProjectIdException("Project does not exist");
        }
        projectRepository.delete(project);
    }
}