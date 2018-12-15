package com.google.firebase.quickstart.database;

import android.arch.lifecycle.Lifecycle;
import android.arch.lifecycle.LifecycleObserver;
import android.arch.lifecycle.OnLifecycleEvent;
import android.databinding.ObservableBoolean;
import android.databinding.ObservableField;
import android.support.annotation.NonNull;
import android.util.Log;
import android.view.View;
import android.widget.RadioButton;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.google.firebase.quickstart.database.java.models.ShelterHome;
import com.google.firebase.quickstart.database.java.models.User;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import static android.support.constraint.Constraints.TAG;

public class AddStudentDetailsFormViewModel implements LifecycleObserver {

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

    public AddStudentDetailsFormViewModel(String uid) {
        this.uid = uid;
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_RESUME)
    public void init() {
        System.out.println("Name" + name.get());
        name.set("Hiiii");
    }

    public void submitData() {
        final DatabaseReference reference = FirebaseDatabase.getInstance().getReference();

        reference.child("users").child(uid)
                .addListenerForSingleValueEvent(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                        User user = dataSnapshot.getValue(User.class);

                        if (user == null) {
                            Log.e(TAG, "User " + uid + " is unexpectedly null");
                        } else {
                            addDataInDatabase(reference);
                        }
                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError databaseError) {
                        Log.w(TAG, "getUser:onCancelled", databaseError.toException());
                    }
                });
    }

    public void onRadioButtonClicked(View view) {
        boolean checked = ((RadioButton) view).isChecked();

        switch (view.getId()) {
            case R.id.radio_male:
                if (checked)
                    gender.set("Male");
                break;
            case R.id.radio_female:
                if (checked)
                    gender.set("Female");
                break;
            case R.id.rehabilitation_1:
                if (checked)
                    rehabilitationMode.set("Rehabilitation");
                break;
            case R.id.reintegration:
                if (checked)
                    rehabilitationMode.set("Reintegration");
                break;
        }
    }

    public void validateToEnableSave() {
        isSubmitButtonEnabled.set(isFieldsNonEmpty() && isValidDateFormats());
    }

    private boolean isValidDateFormats() {
        if (dob.get().trim().equals(""))
            return false;
        SimpleDateFormat sdfrmt = new SimpleDateFormat("dd/MM/yyyy");
        try
        {
            Date javaDate = sdfrmt.parse(dob.get());
            System.out.println(dob.get()+" is valid date format");
        }
        catch (ParseException e)
        {
            System.out.println(dob.get() +" is Invalid Date format");
            return false;
        }
        return true;
    }

    private boolean isFieldsNonEmpty() {
        return name.get() != null && !name.get().isEmpty() && admissionNumber.get() != null && !admissionNumber.get().isEmpty();
    }

    private void addDataInDatabase(DatabaseReference reference) {
        String key = reference.child("Shelterhome").push().getKey();
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

        Map<String, Object> childUpdates = new HashMap<>();
        childUpdates.put("/Shelterhome/" + key, values);
        reference.updateChildren(childUpdates);
    }
}
