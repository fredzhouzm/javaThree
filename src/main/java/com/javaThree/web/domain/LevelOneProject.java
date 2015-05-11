package com.javaThree.web.domain;

import java.util.List;

/**
 * Created by Fred on 2015/5/1.
 */
public class LevelOneProject {
    private String projectID;
    private String projectType;
    private String projectName;
    private String projectAmount;
    private int projectChildren;
    private List<LevelTwoProject> levelTwoProjectList;

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

    public int getProjectChildren() {
        return projectChildren;
    }

    public void setProjectChildren(int projectChildren) {
        this.projectChildren = projectChildren;
    }

    public List<LevelTwoProject> getLevelTwoProjectList() {
        return levelTwoProjectList;
    }

    public void setLevelTwoProjectList(List<LevelTwoProject> levelTwoProjectList) {
        this.levelTwoProjectList = levelTwoProjectList;
    }
}
