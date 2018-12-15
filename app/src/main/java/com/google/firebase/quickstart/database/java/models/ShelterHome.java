package com.google.firebase.quickstart.database.java.models;

import com.google.firebase.database.Exclude;
import com.google.firebase.database.IgnoreExtraProperties;

import java.util.HashMap;
import java.util.Map;

@IgnoreExtraProperties
public class ShelterHome {

    public String uid;
    public String name;
    public String dob;
    public String gender;
    public String contactNumber;
    public String admissionNumber;
    public String dateOfAdmission;
    public String referredBy;
    public String rehabilitionMode;
    public String problemStatement;
    public String intervention;
    public String dateOfLeaving;
    public String currentStatus;

    public ShelterHome() {

    }

    public ShelterHome(String uid, String name, String dob, String gender, String contactNumber, String admissionNumber, String dateOfAdmission, String referredBy, String rehabilitionMode, String problemStatement, String intervention, String dateOfLeaving, String currentStatus) {
        this.uid = uid;
        this.name = name;
        this.dob = dob;
        this.gender = gender;
        this.contactNumber = contactNumber;
        this.admissionNumber = admissionNumber;
        this.dateOfAdmission = dateOfAdmission;
        this.referredBy = referredBy;
        this.rehabilitionMode = rehabilitionMode;
        this.problemStatement = problemStatement;
        this.intervention = intervention;
        this.dateOfLeaving = dateOfLeaving;
        this.currentStatus = currentStatus;
    }

    @Exclude
    public Map<String, Object> toMap() {
        HashMap<String, Object> result = new HashMap<>();
        result.put("uid", uid);
        result.put("name", name);
        result.put("dob", dob);
        result.put("gender", gender);
        result.put("contactNumber", contactNumber);
        result.put("dateOfAdmission", dateOfAdmission);
        result.put("referredBy", referredBy);
        result.put("rehabilitionMode", rehabilitionMode);
        result.put("problemStatement", problemStatement);
        result.put("dateOfLeaving", dateOfLeaving);
        result.put("currentStatus", currentStatus);

        return result;
    }
}


