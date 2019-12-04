package com.sudeep.springbootreactjsredux.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonFormat;
@Entity
public class Project {
    @Id
    @GeneratedValue
    private long id;
    @NotBlank(message = "project name is required")
    private String projectName;
    @NotBlank(message = "project idenfifier is required")
    @Size(min=4,max = 5,message = "please user 4 to 5 characters")
    @Column(updatable = false,unique = true)
    private String projectIdentifier;
    @NotBlank(message = " projecte description is require")
    private String description;
    @JsonFormat(pattern="yyyy-mm-dd")
    private Date start_data;
    @JsonFormat(pattern="yyyy-mm-dd")
    private Date end_data;
    @JsonFormat(pattern="yyyy-mm-dd")
    private Date created_At;
    @JsonFormat(pattern="yyyy-mm-dd")
    private Date updated_At;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Date getUpdated_At() {
        return updated_At;
    }

    public void setUpdated_At(Date updated_At) {
        this.updated_At = updated_At;
    }

    public Date getCreated_At() {
        return created_At;
    }

    public void setCreated_At(Date created_At) {
        this.created_At = created_At;
    }

    public Date getEnd_data() {
        return end_data;
    }

    public void setEnd_data(Date end_data) {
        this.end_data = end_data;
    }

    public Date getStart_data() {
        return start_data;
    }

    public void setStart_data(Date start_data) {
        this.start_data = start_data;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getProjectIdentifier() {
        return projectIdentifier;
    }

    public void setProjectIdentifier(String projectIdentifier) {
        this.projectIdentifier = projectIdentifier;
    }

    public String getProjectName() {
        return projectName;
    }

    public void setProjectName(String projectName) {
        this.projectName = projectName;
    }

    @PrePersist
    protected void onCreate() {
        this.setCreated_At(new Date());
    }

    @PreUpdate
    protected void onUpdate() {
        this.setUpdated_At(new Date());

    }

}