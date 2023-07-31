package com.example.m1;

import static android.content.ContentValues.TAG;

import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class SecondActivity extends AppCompatActivity {
    TextView selectedSymptomsTextView;
    private final ArrayList<AllDataModel> allDataModelArrayList = new ArrayList<>();
    List<AllDataModel> dataModelList = new ArrayList<>();
    AllDataAdapter adapter;
    RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        recyclerView = (RecyclerView) findViewById(R.id.recyclerview);
        adapter = new AllDataAdapter(allDataModelArrayList,SecondActivity.this );

        // Set the adapter to the RecyclerView
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        loadData();

//        selectedSymptomsTextView = findViewById(R.id.selected_symptoms_text_view);

        // Retrieve the selected symptom IDs from the intent
        ArrayList<String> selectedIds = getIntent().getStringArrayListExtra("selectedIds");
        if (selectedIds != null && !selectedIds.isEmpty()) {
            // Use the selectedIds array to display the selected symptoms
            StringBuilder selectedSymptomsText = new StringBuilder("Selected IDs:\n");
            for (String id : selectedIds) {
                selectedSymptomsText.append(id).append("\n");
            }
            Toast.makeText(this, selectedSymptomsText, Toast.LENGTH_SHORT).show();
//            selectedSymptomsTextView.setText(selectedSymptomsText.toString());
        } else {
            // Handle the case when no symptoms are selected
//            selectedSymptomsTextView.setText("No symptoms selected.");
        }
    }

    private void loadData() {
        String url = "http://dev.mimblu.com/mimblu-yii2-1552/api/plan/all";

        StringRequest sr = new StringRequest(Request.Method.POST, url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {

                Log.i(TAG, "onResponse: " + response);
                try {
                    // Parse the JSON response into a JSONArray
                    JSONObject jsonObject = new JSONObject(response);
                    JSONArray jsonArray = jsonObject.getJSONArray("list");

                    allDataModelArrayList.clear(); // Clear the list before adding new data

                    for (int i = 0; i < jsonArray.length(); i++) {
                        JSONObject object = jsonArray.getJSONObject(i);
                        allDataModelArrayList.add(new AllDataModel(object.getString("title"),
                                object.getString("id"),

                                object.getString("plan_id"), object.getString("company_name"), object.getString("company_name"), object.getString("description"), object.getString("video_description"),

                                object.getString("duration"), object.getString("weekly_price"), object.getString("discounted_price"), object.getString("discounted_price_calculated"), object.getString("tax_price"), object.getString("tax_percentage"),
                                object.getString("final_price"), object.getString("total_price"), object.getString("incentive_days"), object.getString("no_of_free_trial_days"), object.getString("no_of_video_session"), object.getString("plan_type"), object.getString("created_by_id")

                        ));
                    }
//                    recyclerView.setHasFixedSize(true);
//                    LinearLayoutManager layoutManager = new LinearLayoutManager(SecondActivity.this, LinearLayoutManager.VERTICAL, false);
//                    recyclerView.setLayoutManager(layoutManager);
//
//                 adapter=new AllDataAdapter(dataModelList,this);
//                    //shimmerRecycler.setAdapter(adapter);
//                    recyclerView.setAdapter(adapter);

                    // Notify the adapter that data has changed
                    adapter.notifyDataSetChanged();

                } catch (JSONException e) {
                    e.printStackTrace();
                    Toast.makeText(SecondActivity.this, "Error parsing data", Toast.LENGTH_SHORT).show();
                }

            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(SecondActivity.this, "data not fecthced", Toast.LENGTH_SHORT).show();

            }
        }) {


        };
        RequestQueue queue = Volley.newRequestQueue(this);
        queue.add(sr);

    }
}