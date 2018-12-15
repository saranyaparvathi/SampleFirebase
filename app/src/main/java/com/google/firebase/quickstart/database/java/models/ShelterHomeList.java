package com.google.firebase.quickstart.database.java.models;

import java.util.ArrayList;
import java.util.List;

public class ShelterHomeList {

    private List<ShelterHome> shelterHomeList;

    public ShelterHomeList(List<ShelterHome> shelterHomes) {
        shelterHomeList = new ArrayList<>();
        shelterHomeList = shelterHomes;
    }

    public List<ShelterHome> getShelterHomeList() {
        return shelterHomeList;
    }
}
