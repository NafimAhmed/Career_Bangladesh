package com.careers.app;

public class ItemEmployer {
    String jobTitle,jobId,numb_CV,employerEmail,jobPostingDate,location,vacancy,salary, employerName, deadLine, educationalQualification, jobResponsiblity,jobDescription;

    public ItemEmployer(String jobId,String jobTitle,String employerEmail,String jobPostingDate,String location,String vacancy,String salary, String employerName, String deadLine, String educationalQualification, String jobResponsiblity,String numb_CV,String jobDescription) {
        this.jobTitle = jobTitle;
        this.employerName = employerName;
        this.deadLine = deadLine;
        this.educationalQualification = educationalQualification;
        this.location=location;
        this.vacancy=vacancy;
        this.jobPostingDate=jobPostingDate;
        this.salary=salary;
        this.numb_CV=numb_CV;
        this.jobDescription=jobDescription;
        this.jobResponsiblity=jobResponsiblity;
        this.employerEmail=employerEmail;
        this.jobId=jobId;

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
