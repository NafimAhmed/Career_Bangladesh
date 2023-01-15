package com.nafim.jobportal;

public class Item
{
    String jobTitle,joblocation,vacancy, salary, employerName, deadLine, educationalQualification,jobResponsiblity;

    public Item(String jobTitle, String employerName, String deadLine,String joblocation, String vacancy, String salary, String educationalQualification,String jobResponsiblity) {
        this.jobTitle = jobTitle;
        this.employerName = employerName;
        this.deadLine = deadLine;
        this.joblocation=joblocation;
        this.vacancy=vacancy;
        this.salary=salary;
        this.jobResponsiblity=jobResponsiblity;
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
