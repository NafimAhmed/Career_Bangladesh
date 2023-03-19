package com.careers.app;

public class Item3
{
    String jobTitle, employerName, deadLine, educationalQualification;

    public Item3(String jobTitle, String employerName, String deadLine, String educationalQualification) {
        this.jobTitle = jobTitle;
        this.employerName = employerName;
        this.deadLine = deadLine;
        this.educationalQualification = educationalQualification;

    }

    public String getJobTitle() {
        return jobTitle;
    }

    public String getEducationalQualification() {
        return educationalQualification;
    }

    public void setEducationalQualification(String educationalQualification) {
        this.educationalQualification = educationalQualification;
    }

    public void setJobTitle(String jobTitle) {
        this.jobTitle = jobTitle;
    }

    public String getEmployerName() {
        return employerName;
    }

    public void setEmployerName(String employerName) {
        this.employerName = employerName;
    }

    public String getDeadLine() {
        return deadLine;
    }

    public void setDeadLine(String deadLine) {
        this.deadLine = deadLine;
    }

}
