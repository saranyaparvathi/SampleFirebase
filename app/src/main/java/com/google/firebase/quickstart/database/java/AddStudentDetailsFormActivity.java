package com.google.firebase.quickstart.database.java;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import com.google.firebase.quickstart.database.AddStudentDetailsFormViewModel;
import com.google.firebase.quickstart.database.R;
import com.google.firebase.quickstart.database.databinding.ActivityAddStudentDetailsFormBinding;

public class AddStudentDetailsFormActivity extends BaseActivity {

    private AddStudentDetailsFormViewModel viewModel;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        viewModel = new AddStudentDetailsFormViewModel(getUid());
        ActivityAddStudentDetailsFormBinding binding = DataBindingUtil.setContentView(this, R.layout.activity_add_student_details_form);
        binding.setViewModel(viewModel);
        getLifecycle().addObserver(viewModel);
    }
}
