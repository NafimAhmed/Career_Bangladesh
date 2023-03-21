package com.careers.app;

public class Applicant_Item
{
    String CVId,name,email;

    public Applicant_Item(String CVId, String name, String email) {
        this.CVId = CVId;
        this.name = name;
        this.email = email;
    }

    public String getCVId() {
        return CVId;
    }

    public void setCVId(String CVId) {
        this.CVId = CVId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
