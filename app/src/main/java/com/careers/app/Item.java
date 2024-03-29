package com.careers.app;

public class Item
{
    String jobTitle,id,Poster_Email,Job_Catagory;
    String jobDescription;
    String joblocation;
    String vacancy;
    String salary;
    String employerName;
    String deadLine;
    String educationalQualification;
    String jobResponsiblity;

    public String getLogoURL() {
        return logoURL;
    }

    public void setLogoURL(String logoURL) {
        this.logoURL = logoURL;
    }

    String logoURL;

    public Item(String id,String Poster_Email,String Job_Catagory,String jobTitle, String employerName,String jobDescription, String deadLine,String joblocation, String vacancy, String salary, String educationalQualification,String jobResponsiblity,String logoURL) {
        this.jobTitle = jobTitle;
        this.employerName = employerName;
        this.deadLine = deadLine;
        this.joblocation=joblocation;
        this.vacancy=vacancy;
        this.jobDescription=jobDescription;
        this.salary=salary;
        this.logoURL=logoURL;
        this.jobResponsiblity=jobResponsiblity;
        this.educationalQualification = educationalQualification;
        this.id=id;
        this.Poster_Email=Poster_Email;
        this.Job_Catagory=Job_Catagory;

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
