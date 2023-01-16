package com.nafim.jobportal;

public class ItemEmployer {
    String jobTitle,numb_CV,location,vacancy,salary, employerName, deadLine, educationalQualification, jobResponsiblity;

    public ItemEmployer(String jobTitle,String location,String vacancy,String salary, String employerName, String deadLine, String educationalQualification, String jobResponsiblity,String numb_CV) {
        this.jobTitle = jobTitle;
        this.employerName = employerName;
        this.deadLine = deadLine;
        this.educationalQualification = educationalQualification;
        this.location=location;
        this.vacancy=vacancy;
        this.salary=salary;
        this.numb_CV=numb_CV;
        this.jobResponsiblity=jobResponsiblity;

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
