package com.careers.app;

import com.google.gson.annotations.SerializedName;

//public class Saved_Job_post


//import java.time.LocalDate;

public class Saved_Job_post {
    private String id;
    private String email;
    private String postersName;
    private String category;
    private String jobTitle;
    private String companyLogo;
    private String organization;
    private String orgaType;
    private String location;
    private String vacancies;
    private String education;
    private String experience;
    private String postDate;
    private String deadLine;
    private String applyStatus;
    private String employmentStatus;
    private String businessDescription;
    private String jobLevel;
    private String workPlace;
    private String jobContext;
    private String jobResponst;
    private String salaryFrom;
    private String salaryTo;
    private String yearlyBonus;
    private String salaryReview;
    private String others;
    private Object companySize;
    private String status;


    public Saved_Job_post(String id, String email, String postersName, String category,
                          String jobTitle, String companyLogo, String organization, String orgaType,
                          String location, String vacancies, String education, String experience,
                          String postDate, String deadLine, String applyStatus, String employmentStatus,
                          String businessDescription, String jobLevel, String workPlace, String jobContext, String jobResponst,
                          String salaryFrom, String salaryTo, String yearlyBonus, String salaryReview,
                          String others, Object companySize, String status)
    {
        this.id = id;
        this.email = email;
        this.postersName = postersName;
        this.category = category;
        this.jobTitle = jobTitle;
        this.companyLogo = companyLogo;
        this.organization = organization;
        this.orgaType = orgaType;
        this.location = location;
        this.vacancies = vacancies;
        this.education = education;
        this.experience = experience;
        this.postDate = postDate;
        this.deadLine = deadLine;
        this.applyStatus = applyStatus;
        this.employmentStatus = employmentStatus;
        this.businessDescription = businessDescription;
        this.jobLevel = jobLevel;
        this.workPlace = workPlace;
        this.jobContext = jobContext;
        this.jobResponst = jobResponst;
        this.salaryFrom = salaryFrom;
        this.salaryTo = salaryTo;
        this.yearlyBonus = yearlyBonus;
        this.salaryReview = salaryReview;
        this.others = others;
        this.companySize = companySize;
        this.status = status;
    }

    public String getID() { return id; }
    public void setID(String value) { this.id = value; }

    public String getEmail() { return email; }
    public void setEmail(String value) { this.email = value; }

    public String getPostersName() { return postersName; }
    public void setPostersName(String value) { this.postersName = value; }

    public String getCategory() { return category; }
    public void setCategory(String value) { this.category = value; }

    public String getJobTitle() { return jobTitle; }
    public void setJobTitle(String value) { this.jobTitle = value; }

    public String getCompanyLogo() { return companyLogo; }
    public void setCompanyLogo(String value) { this.companyLogo = value; }

    public String getOrganization() { return organization; }
    public void setOrganization(String value) { this.organization = value; }

    public String getOrgaType() { return orgaType; }
    public void setOrgaType(String value) { this.orgaType = value; }

    public String getLocation() { return location; }
    public void setLocation(String value) { this.location = value; }

    public String getVacancies() { return vacancies; }
    public void setVacancies(String value) { this.vacancies = value; }

    public String getEducation() { return education; }
    public void setEducation(String value) { this.education = value; }

    public String getExperience() { return experience; }
    public void setExperience(String value) { this.experience = value; }

    public String getPostDate() { return postDate; }
    public void setPostDate(String value) { this.postDate = value; }

    public String getDeadLine() { return deadLine; }
    public void setDeadLine(String value) { this.deadLine = value; }

    public String getApplyStatus() { return applyStatus; }
    public void setApplyStatus(String value) { this.applyStatus = value; }

    public String getEmploymentStatus() { return employmentStatus; }
    public void setEmploymentStatus(String value) { this.employmentStatus = value; }

    public String getBusinessDescription() { return businessDescription; }
    public void setBusinessDescription(String value) { this.businessDescription = value; }

    public String getJobLevel() { return jobLevel; }
    public void setJobLevel(String value) { this.jobLevel = value; }

    public String getWorkPlace() { return workPlace; }
    public void setWorkPlace(String value) { this.workPlace = value; }

    public String getJobContext() { return jobContext; }
    public void setJobContext(String value) { this.jobContext = value; }

    public String getJobResponst() { return jobResponst; }
    public void setJobResponst(String value) { this.jobResponst = value; }

    public String getSalaryFrom() { return salaryFrom; }
    public void setSalaryFrom(String value) { this.salaryFrom = value; }

    public String getSalaryTo() { return salaryTo; }
    public void setSalaryTo(String value) { this.salaryTo = value; }

    public String getYearlyBonus() { return yearlyBonus; }
    public void setYearlyBonus(String value) { this.yearlyBonus = value; }

    public String getSalaryReview() { return salaryReview; }
    public void setSalaryReview(String value) { this.salaryReview = value; }

    public String getOthers() { return others; }
    public void setOthers(String value) { this.others = value; }

    public Object getCompanySize() { return companySize; }
    public void setCompanySize(Object value) { this.companySize = value; }

    public String getStatus() { return status; }
    public void setStatus(String value) { this.status = value; }
}
