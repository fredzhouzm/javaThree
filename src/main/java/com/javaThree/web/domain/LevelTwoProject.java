package com.javaThree.web.domain;

/**
 * Created by Fred on 2015/5/1.
 */
public class LevelTwoProject {
    private String projectID;
    private String projectType;
    private String projectFatherID;
    private String projectName;
    private String projectAmount;

    public String getProjectID() {
        return projectID;
    }

    public void setProjectID(String projectID) {
        this.projectID = projectID;
    }

    public String getProjectType() {
        return projectType;
    }

    public void setProjectType(String projectType) {
        this.projectType = projectType;
    }

    public String getProjectFatherID() {
        return projectFatherID;
    }

    public void setProjectFatherID(String projectFatherID) {
        this.projectFatherID = projectFatherID;
    }

    public String getProjectName() {
        return projectName;
    }

    public void setProjectName(String projectName) {
        this.projectName = projectName;
    }

    public String getProjectAmount() {
        return projectAmount;
    }

    public void setProjectAmount(String projectAmount) {
        this.projectAmount = projectAmount;
    }
}
