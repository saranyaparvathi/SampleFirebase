package com.google.firebase.quickstart.database.java;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import com.google.firebase.quickstart.database.databinding.ItemStudentBinding;

import java.util.ArrayList;
import java.util.List;

public class StudentItemAdapter extends RecyclerView.Adapter<StudentItemViewHolder> {

    private List<StudentItemViewModel> studentItemViewModelList;
    private ViewStudentDetailsViewModel viewStudentDetailsViewModel;
    private StudentItemViewHolder cartItemViewHolder;

    public StudentItemAdapter(ViewStudentDetailsViewModel viewStudentDetailsViewModel) {
        this.viewStudentDetailsViewModel = viewStudentDetailsViewModel;
        studentItemViewModelList = new ArrayList<>();
    }

    @NonNull
    @Override
    public StudentItemViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        LayoutInflater layoutInflater = LayoutInflater.from(viewGroup.getContext());
        ItemStudentBinding itemCartBinding = ItemStudentBinding.inflate(layoutInflater, viewGroup, false);
        //return new StudentItemViewHolder(itemCartBinding);
        return null;
    }

    @Override
    public void onBindViewHolder(@NonNull StudentItemViewHolder holder, int i) {
        cartItemViewHolder = holder;
        StudentItemViewModel cartItemViewModel = getItemForPosition(i);
        //holder.bind(cartItemViewModel, viewStudentDetailsViewModel);
        //holder.bind(cartItemViewModel, viewStudentDetailsViewModel);
    }

    @Override
    public int getItemCount() {
        return (null != studentItemViewModelList ? studentItemViewModelList.size() : 0);
    }

    @Override
    public int getItemViewType(int position) {
        return 0;
    }

    public void setItems(List<StudentItemViewModel> itemViewModelList) {
        this.studentItemViewModelList.clear();
        this.studentItemViewModelList.addAll(itemViewModelList);
        notifyDataSetChanged();
    }

    private StudentItemViewModel getItemForPosition(int position) {
        return studentItemViewModelList.get(position);
    }
}
