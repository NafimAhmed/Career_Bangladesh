package com.careers.app;

public class JobseekerPersonal_detail {
String email,name,skill,fathersname,mothersname,nationality,
        nationalId,phone,birthDate,religion,gender,marilalStatus,
        image,presentAddress,permanentAddress,careerObjective;

    public JobseekerPersonal_detail(String email, String name, String skill, String fathersname,
                                    String mothersname, String nationality, String nationalId, String phone,
                                    String birthDate, String religion, String gender, String marilalStatus,
                                    String image, String presentAddress, String permanentAddress, String careerObjective) {
        this.email = email;
        this.name = name;
        this.skill = skill;
        this.fathersname = fathersname;
        this.mothersname = mothersname;
        this.nationality = nationality;
        this.nationalId = nationalId;
        this.phone = phone;
        this.birthDate = birthDate;
        this.religion = religion;
        this.gender = gender;
        this.marilalStatus = marilalStatus;
        this.image = image;
        this.presentAddress = presentAddress;
        this.permanentAddress = permanentAddress;
        this.careerObjective = careerObjective;
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

    public String getSkill() {
        return skill;
    }

    public void setSkill(String skill) {
        this.skill = skill;
    }

    public String getFathersname() {
        return fathersname;
    }

    public void setFathersname(String fathersname) {
        this.fathersname = fathersname;
    }

    public String getMothersname() {
        return mothersname;
    }

    public void setMothersname(String mothersname) {
        this.mothersname = mothersname;
    }

    public String getNationality() {
        return nationality;
    }

    public void setNationality(String nationality) {
        this.nationality = nationality;
    }

    public String getNationalId() {
        return nationalId;
    }

    public void setNationalId(String nationalId) {
        this.nationalId = nationalId;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(String birthDate) {
        this.birthDate = birthDate;
    }

    public String getReligion() {
        return religion;
    }

    public void setReligion(String religion) {
        this.religion = religion;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getMarilalStatus() {
        return marilalStatus;
    }

    public void setMarilalStatus(String marilalStatus) {
        this.marilalStatus = marilalStatus;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getPresentAddress() {
        return presentAddress;
    }

    public void setPresentAddress(String presentAddress) {
        this.presentAddress = presentAddress;
    }

    public String getPermanentAddress() {
        return permanentAddress;
    }

    public void setPermanentAddress(String permanentAddress) {
        this.permanentAddress = permanentAddress;
    }

    public String getCareerObjective() {
        return careerObjective;
    }

    public void setCareerObjective(String careerObjective) {
        this.careerObjective = careerObjective;
    }
}
