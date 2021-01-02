package com.example.demo.model;

public class TeacherInfo extends Teacher {

    public String getProfile() {
        return profile;
    }

    public void setProfile(String profile) {
        this.profile = profile;
    }

    public String getExperience() {
        return experience;
    }

    public void setExperience(String experience) {
        this.experience = experience;
    }



    private  String profile;
    private  String experience;

    public String getSuccessfulCase() {
        return successfulCase;
    }

    public void setSuccessfulCase(String successfulCase) {
        this.successfulCase = successfulCase;
    }

    private  String successfulCase;

}
