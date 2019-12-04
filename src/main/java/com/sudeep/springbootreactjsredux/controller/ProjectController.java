package com.sudeep.springbootreactjsredux.controller;

import javax.validation.Valid;

import com.sudeep.springbootreactjsredux.model.Project;
import com.sudeep.springbootreactjsredux.service.MapValidationError;
import com.sudeep.springbootreactjsredux.service.ProjectService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/project")
public class ProjectController {
    @Autowired
    private ProjectService projectService;
    @Autowired
    private MapValidationError mapValidationError;

    @PostMapping("")
    public ResponseEntity<?> createNewProjecct(@Valid @RequestBody Project project, BindingResult result) {
        ResponseEntity<?> errorMap = mapValidationError.mapValidationService(result);
        if (errorMap != null) {
            return errorMap;
        }
        Project savedProject = projectService.saveOrUpdateProject(project);
        return new ResponseEntity<Project>(savedProject, HttpStatus.CREATED);
    }

    @GetMapping("/{projectId}")
    public ResponseEntity<?> getProjectById(@PathVariable String projectId) {
        Project project = projectService.findProjectByProjectIdentifier(projectId);
        return new ResponseEntity<Project>(project, HttpStatus.OK);
    }

    @GetMapping("all")
    public Iterable<Project> getAllProject() {
        return projectService.findAllProject();
    }

    @DeleteMapping("/{projectid}")
    public ResponseEntity<?> delteProject(@PathVariable String projectid) {
        projectService.deleteProjectByIdentifier(projectid);
        return new ResponseEntity<String>("Project with id:" + projectid + " was deleted",HttpStatus.OK);
    }

}