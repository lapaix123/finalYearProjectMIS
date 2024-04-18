/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author lapaix
 */
public class ConfirmedProject {
    private int confirmedProjectId;
    private int projectId;
    private String status;
    private String comments;

    public ConfirmedProject() {
    }

    public ConfirmedProject(int confirmedProjectId) {
        this.confirmedProjectId = confirmedProjectId;
    }

    public int getConfirmedProjectId() {
        return confirmedProjectId;
    }

    public void setConfirmedProjectId(int confirmedProjectId) {
        this.confirmedProjectId = confirmedProjectId;
    }

    public int getProjectId() {
        return projectId;
    }

    public void setProjectId(int projectId) {
        this.projectId = projectId;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getComments() {
        return comments;
    }

    public void setComments(String comments) {
        this.comments = comments;
    }
    
}
