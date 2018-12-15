package com.google.firebase.quickstart.database.java;

import android.databinding.BaseObservable;

public class StudentItemViewModel extends BaseObservable {

    private String name;

    public StudentItemViewModel(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
