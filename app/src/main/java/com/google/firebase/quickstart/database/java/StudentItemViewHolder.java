package com.google.firebase.quickstart.database.java;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.google.firebase.quickstart.database.R;
import com.google.firebase.quickstart.database.databinding.ItemStudentBinding;
import com.google.firebase.quickstart.database.java.models.Post;
import com.google.firebase.quickstart.database.java.models.ShelterHome;

public class StudentItemViewHolder extends RecyclerView.ViewHolder {

    ItemStudentBinding binding;

    public TextView titleView;

    public StudentItemViewHolder(View binding) {
        super(binding);
        titleView = binding.findViewById(R.id.student_name);
    }

    public void bindToPost(ShelterHome itemViewModel) {
        titleView.setText(itemViewModel.name);
    }
    /*public void bind(StudentItemViewModel itemViewModel, ViewStudentDetailsViewModel cartViewModel) {
        binding.setItemViewModel(itemViewModel);
        binding.setViewModel(cartViewModel);
        binding.executePendingBindings();
    }*/
}
