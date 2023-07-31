package com.example.m1;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

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

public class MainActivity extends AppCompatActivity implements SymptomAdapter.OnItemClickListener {

    private static final String TAG = "MainActivity";
    private final ArrayList<model> modelArrayList = new ArrayList<>();

    RecyclerView recyclerView;
    SymptomAdapter adapter;
    Button submit;
    List<String> selectedSymptoms;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.recycler_view);
        submit = findViewById(R.id.btn_submit);

        selectedSymptoms = new ArrayList<>();

        // Create the adapter
        adapter = new SymptomAdapter(modelArrayList, this);

        // Set the adapter to the RecyclerView
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        // Fetch symptoms data from the API and populate the RecyclerView
        fetchSymptomsData();

        // Initial state of the button (disabled)
        submit.setEnabled(false);
        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onSubmitClicked();
            }
        });
    }

    private void fetchSymptomsData() {
        String url = "http://dev.mimblu.com/mimblu-yii2-1552/api/user/symptoms";

        StringRequest stringRequest = new StringRequest(
                Request.Method.GET,
                url,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        Log.i(TAG, "onResponse: " + response);
                        try {
                            // Parse the JSON response into a JSONArray
                            JSONObject jsonObject = new JSONObject(response);
                            JSONArray jsonArray = jsonObject.getJSONArray("list");

                            modelArrayList.clear(); // Clear the list before adding new data

                            for (int i = 0; i < jsonArray.length(); i++) {
                                JSONObject object = jsonArray.getJSONObject(i);
                                modelArrayList.add(new model(object.getString("title"),
                                        object.getString("id")));
                            }

                            // Notify the adapter that data has changed
                            adapter.notifyDataSetChanged();

                        } catch (JSONException e) {
                            e.printStackTrace();
                            Toast.makeText(MainActivity.this, "Error parsing data", Toast.LENGTH_SHORT).show();
                        }
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Toast.makeText(MainActivity.this, "Error fetching data", Toast.LENGTH_SHORT).show();
                        Log.e("API Error", "Error fetching data: " + error.toString());
                    }
                }
        );

        // Add the request to the RequestQueue.
        RequestQueue requestQueue = Volley.newRequestQueue(this);
        requestQueue.add(stringRequest);
    }

    private void updateButtonState() {
        // Enable or disable the button based on selection
        submit.setEnabled(!selectedSymptoms.isEmpty());
    }

    private void onSubmitClicked() {
        String idsSelected = "Selected IDs:\n";
        for (String symptom : selectedSymptoms) {
            model symptomModel = findSymptomById(symptom);
            if (symptomModel != null) {
                idsSelected += symptomModel.getId() + "\n";
            }
        }
        Intent intent = new Intent(this, SecondActivity.class);
        intent.putStringArrayListExtra("selectedIds", (ArrayList<String>) selectedSymptoms);
        startActivity(intent);
        Toast.makeText(this, idsSelected, Toast.LENGTH_SHORT).show();

        // Reset selected items
        selectedSymptoms.clear();
        adapter.notifyDataSetChanged();
        updateButtonState();
    }

    private model findSymptomById(String symptomId) {
        for (model symptom : modelArrayList) {
            if (symptom.getId().equals(symptomId)) {
                return symptom;
            }
        }
        return null; // Return null if the symptom with the given ID is not found
    }

    @Override
    public void onItemClick(int position, boolean isChecked) {
        model symptom = modelArrayList.get(position);
        if (isChecked) {
            selectedSymptoms.add(symptom.getId());
        } else {
            selectedSymptoms.remove(symptom.getId());
        }
        updateButtonState();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        int id = item.getItemId();

        if (id == R.id.done) {
            onSubmitClicked();
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
