package com.google.firebase.quickstart.database.java;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.google.firebase.quickstart.database.R;
import com.google.firebase.quickstart.database.databinding.ActivityViewStudentDetailsBinding;

public class ViewStudentDetailsActivity extends BaseActivity {

    private ViewStudentDetailsViewModel viewModel;

    RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        viewModel = new ViewStudentDetailsViewModel("gjkkhj");
        ActivityViewStudentDetailsBinding binding = DataBindingUtil.setContentView(this, R.layout.activity_view_student_details);
        recyclerView = binding.recyclerView;
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        binding.setViewModel(viewModel);
        getLifecycle().addObserver(viewModel);
    }
}
