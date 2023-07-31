package com.example.m1;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class SymptomAdapter extends RecyclerView.Adapter<SymptomAdapter.SymptomViewHolder> {

    private List<model> symptomsList;
    private OnItemClickListener listener;

    public interface OnItemClickListener {
        void onItemClick(int position, boolean isChecked);
    }

    public SymptomAdapter(List<model> symptomsList, OnItemClickListener listener) {
        this.symptomsList = symptomsList;
        this.listener = listener;
    }

    @NonNull
    @Override
    public SymptomViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_symptom, parent, false);
        return new SymptomViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull SymptomViewHolder holder, int position) {


        model symptom = symptomsList.get(position);
//        String symptom = symptomsList.get(position);
        holder.bind(symptom.title);

    }

    @Override
    public int getItemCount() {
        return symptomsList.size();
    }

    class SymptomViewHolder extends RecyclerView.ViewHolder {

        private CheckBox checkBox;


        SymptomViewHolder(View itemView) {
            super(itemView);
            checkBox = itemView.findViewById(R.id.checkbox_symptom);

            checkBox.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    int position = getAdapterPosition();
                    if (position != RecyclerView.NO_POSITION) {
                        boolean isChecked = checkBox.isChecked();
                        listener.onItemClick(position, isChecked);
                    }
                }
            });
        }

        void bind(String symptom) {
            checkBox.setText(symptom);
            checkBox.setChecked(false);
        }
    }
}
