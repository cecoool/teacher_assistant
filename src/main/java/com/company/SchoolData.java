
package com.company;
public class SchoolData {
    public String getGrades() {
        return grades;
    }

    public void setGrades(String grades) {
        this.grades = grades;
    }

    public String getPresences() {
        return presences;
    }

    public void setPresences(String presences) {
        this.presences = presences;
    }

    public String getProjectTopic() {
        return projectTopic;
    }

    public void setProjectTopic(String projectTopic) {
        this.projectTopic = projectTopic;
    }

    private String grades;
    private String presences;
    private String projectTopic;

    public SchoolData(String grades, String presences, String projectTopic) {
        this.grades = grades;
        this.presences = presences;
        this.projectTopic = projectTopic;
    }
}