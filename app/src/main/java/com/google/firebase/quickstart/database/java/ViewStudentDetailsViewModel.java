package com.google.firebase.quickstart.database.java;

import android.arch.lifecycle.LifecycleObserver;
import android.databinding.ObservableBoolean;
import android.databinding.ObservableField;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.google.firebase.quickstart.database.java.models.ShelterHome;

import java.util.HashMap;
import java.util.Map;

public class ViewStudentDetailsViewModel implements LifecycleObserver {

    public ObservableField<String> name = new ObservableField<>();
    public ObservableField<String> dob = new ObservableField<>();
    public ObservableField<String> gender = new ObservableField<>();
    public ObservableField<String> contactNumber = new ObservableField<>();
    public ObservableField<String> admissionNumber = new ObservableField<>();
    public ObservableField<String> dateOfAdmission = new ObservableField<>();
    public ObservableField<String> referredBy = new ObservableField<>();
    public ObservableField<String> rehabilitationMode = new ObservableField<>();
    public ObservableField<String> problemStatement = new ObservableField<>();
    public ObservableField<String> dateOfLeaving = new ObservableField<>();
    public ObservableField<String> intervention = new ObservableField<>();
    public ObservableField<String> currentStatus = new ObservableField<>();
    public ObservableBoolean isSubmitButtonEnabled = new ObservableBoolean(false);

    private final String uid;
    private final DatabaseReference reference;

    public ViewStudentDetailsViewModel(String uid) {
        this.uid = uid;
        reference = FirebaseDatabase.getInstance().getReference().child("Shelterhome").child(uid);
        reference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                ShelterHome home = dataSnapshot.getValue(ShelterHome.class);
                name.set(home.name);
                gender.set(home.gender);
                contactNumber.set(home.contactNumber);
                admissionNumber.set(home.admissionNumber);
                dateOfAdmission.set(home.dateOfAdmission);
                referredBy.set(home.referredBy);
                rehabilitationMode.set(home.rehabilitionMode);
                dateOfLeaving.set(home.dateOfLeaving);
                intervention.set(home.intervention);
                currentStatus.set(home.currentStatus);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
    }

    public void updateFields() {
        ShelterHome home1 = new ShelterHome(
                uid,
                name.get(),
                dob.get(),
                gender.get(),
                contactNumber.get(),
                admissionNumber.get(),
                dateOfAdmission.get(),
                referredBy.get(),
                rehabilitationMode.get(),
                problemStatement.get(),
                intervention.get(),
                dateOfLeaving.get(),
                currentStatus.get());
        Map<String, Object> values = home1.toMap();

        /*Map<String, Object> childUpdates = new HashMap<>();
        childUpdates.put("/Shelterhome/" + uid, values);*/
        reference.updateChildren(values);
    }
}
