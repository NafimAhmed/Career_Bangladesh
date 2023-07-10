package com.careers.app;

public class Apply_Job {
    String jobId,email,name,postersEmail,expectedSalary,jobTitle,organization,catagory,applicationDate;

    public Apply_Job(String jobId, String email, String name, String postersEmail, String expectedSalary, String jobTitle, String organization, String catagory, String applicationDate) {
        this.jobId = jobId;
        this.email = email;
        this.name = name;
        this.postersEmail = postersEmail;
        this.expectedSalary = expectedSalary;
        this.jobTitle = jobTitle;
        this.organization = organization;
        this.catagory = catagory;
        this.applicationDate = applicationDate;
    }

    public String getJobId() {
        return jobId;
    }

    public void setJobId(String jobId) {
        this.jobId = jobId;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPostersEmail() {
        return postersEmail;
    }

    public void setPostersEmail(String postersEmail) {
        this.postersEmail = postersEmail;
    }

    public String getExpectedSalary() {
        return expectedSalary;
    }

    public void setExpectedSalary(String expectedSalary) {
        this.expectedSalary = expectedSalary;
    }

    public String getJobTitle() {
        return jobTitle;
    }

    public void setJobTitle(String jobTitle) {
        this.jobTitle = jobTitle;
    }

    public String getOrganization() {
        return organization;
    }

    public void setOrganization(String organization) {
        this.organization = organization;
    }

    public String getCatagory() {
        return catagory;
    }

    public void setCatagory(String catagory) {
        this.catagory = catagory;
    }

    public String getApplicationDate() {
        return applicationDate;
    }

    public void setApplicationDate(String applicationDate) {
        this.applicationDate = applicationDate;
    }
}
