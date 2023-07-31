package com.example.m1;


import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.android.volley.Response;

import java.util.List;

public class AllDataAdapter extends RecyclerView.Adapter<AllDataAdapter.SymptomViewHolder> {
//    private List<model> symptomsList;
    private List<AllDataModel> allDataModelList;
    private OnItemClickListener listener;
Context context;
    public interface OnItemClickListener {
        void onItemClick(int position, boolean isChecked);
    }

    public AllDataAdapter(List<AllDataModel> allDataModelList, Context context) {
        this.allDataModelList = allDataModelList;
        this.context = context;
    }

    @NonNull
    @Override
    public SymptomViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.alldatarecycle, parent, false);
        return new SymptomViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull SymptomViewHolder holder, int position) {


        AllDataModel model = allDataModelList.get(position);
        holder.title.setText(model.getTitle());
        holder.planvalidity.setText(model.plan_type);
        holder.description.setText(model.getDescription());
        holder.videodescription.setText(model.getVideo_description());
        holder.weeklyprice.setText(model.getWeekly_price());
        holder.discountedprice.setText(model.getDiscounted_price());
        holder.finalprice.setText(model.getFinal_price());



    }

    @Override
    public int getItemCount() {
        return allDataModelList.size();
    }

    class SymptomViewHolder extends RecyclerView.ViewHolder {

        private CheckBox checkBox;
        TextView title,planvalidity,description,videodescription,weeklyprice,discountedprice,finalprice;


        SymptomViewHolder(View itemView) {
            super(itemView);
            title = itemView.findViewById(R.id.titlee);
            planvalidity = itemView.findViewById(R.id.planvalidity);
            description = itemView.findViewById(R.id.description);
            videodescription = itemView.findViewById(R.id.video_desciption);
            weeklyprice = itemView.findViewById(R.id.weeklyprice);
            discountedprice = itemView.findViewById(R.id.discountedprice);
            finalprice = itemView.findViewById(R.id.finalprice);


        }


    }
}
