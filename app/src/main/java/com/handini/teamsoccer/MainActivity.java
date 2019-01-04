package com.handini.teamsoccer;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity {
    @BindView(R.id.recycle_view)
    RecyclerView recyclerView;
    ListTeamAdapter adapter;
    private ArrayList<TeamItem> teamItemList;
    String TAG = "TEST";

    private static String URL = "https://www.thesportsdb.com/api/v1/json/1/search_all_teams.php?s=Soccer&c=Spain";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        adapter = new ListTeamAdapter(this);
        teamItemList = new ArrayList<TeamItem>();
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        Load();
    }

    private void Load() {
        StringRequest stringRequest = new StringRequest(Request.Method.GET, URL, new Response.Listener<String>() {

            @Override
            public void onResponse(String response) {
                try {
                    JSONObject object = new JSONObject(response);
                    JSONArray teamArray = object.getJSONArray("teams");
                    for (int i = 0; i < teamArray.length(); i++) {
                        JSONObject teamObject = teamArray.getJSONObject(i);
                        TeamItem teamItem = new TeamItem(teamObject.getString("strTeam"),
                                teamObject.getString("strAlternate"),
                                teamObject.getString("strLeague"),
                                teamObject.getString("strManager"),
                                teamObject.getString("strStadium"),
                                teamObject.getString("strStadiumThumb"),
                                teamObject.getString("strStadiumDescription"),
                                teamObject.getString("strDescriptionEN"),
                                teamObject.getString("strTeamBadge") );
                        Log.d("text", "onResponse: "+teamItem.getStrTeam());
                        teamItemList.add(teamItem);
                    }

                    adapter.setTeamItems(teamItemList);
                    adapter.notifyDataSetChanged();
                    recyclerView.setAdapter(adapter);

                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(MainActivity.this, "Error", Toast.LENGTH_SHORT).show();
            }
        });
        RequestQueue requestQueue = Volley.newRequestQueue(MainActivity.this);
        requestQueue.add(stringRequest);
    }
}
