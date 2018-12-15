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

    private RadioGroup radioSexGroup;
    private RadioButton radioSexButton;
    private Button submitButton;

    private AddStudentDetailsFormViewModel viewModel;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        viewModel = new AddStudentDetailsFormViewModel(getUid());
        ActivityAddStudentDetailsFormBinding binding = DataBindingUtil.setContentView(this, R.layout.activity_add_student_details_form);
        binding.setViewModel(viewModel);
        getLifecycle().addObserver(viewModel);
        //setContentView(R.layout.activity_add_student_details_form);

        //addListenerOnButton();

    }

    public void addListenerOnButton() {

        radioSexGroup = (RadioGroup) findViewById(R.id.radio_gender);
        /*btnDisplay = (Button) findViewById(R.id.btnDisplay);

        btnDisplay.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                // get selected radio button from radioGroup
                int selectedId = radioSexGroup.getCheckedRadioButtonId();

                // find the radiobutton by returned id
                radioSexButton = (RadioButton) findViewById(selectedId);

                Toast.makeText(AddStudentDetailsFormActivity.this,
                        radioSexButton.getText(), Toast.LENGTH_SHORT).show();

            }

        });*/

        radioSexGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {

            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {

                View radioButton = radioSexGroup.findViewById(checkedId);
                int index = radioSexGroup.indexOfChild(radioButton);

                // Add logic here

                switch (index) {
                    case 0: // first button

                        Toast.makeText(getApplicationContext(), "Selected button number " + index, Toast.LENGTH_LONG).show();
                        break;
                    case 1: // secondbutton

                        Toast.makeText(getApplicationContext(), "Selected button number " + index, Toast.LENGTH_LONG).show();
                        break;
                }
            }
        });

        submitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

    }
}
