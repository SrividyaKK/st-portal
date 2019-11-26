package universe.sk.stportal;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ListView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Set;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class ViewComplaintActivity extends AppCompatActivity {
    ListView lvCompList;
    ArrayList<Complaint> complaints = new ArrayList<>();
    private ComplaintAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_complaint);

        lvCompList = findViewById(R.id.lvCompList);

        Set<String> busNums = new LinkedHashSet<>();
        Set<String> compDates = new LinkedHashSet<>();
        Set<String> compMsgs = new LinkedHashSet<>();

        adapter = new ComplaintAdapter(complaints, getApplicationContext());
        lvCompList.setAdapter(adapter);

        loadData();
    }

    public void loadData() {
        // TODO: LOAD DATA FROM DB
        Runnable runnable = () -> {
            OkHttpClient client = new OkHttpClient.Builder().retryOnConnectionFailure(true).build();
            Request request = new Request.Builder().url(R.string.base_api_url + "/").header("Content-Type", "application/json").build();

            try {
                Response response = client.newCall(request).execute();
                JSONArray json_arr = new JSONArray(response.body().string());
                String bNum, cDate, cMsg;
                complaints.clear();

                for (int i=0; i<json_arr.length(); i++) {
                    JSONObject res = json_arr.getJSONObject(i);
                    bNum = res.getString("busNumber");
                    cDate = res.getString("complaint_date");
                    cMsg = res.getString("message");
                    complaints.add(new Complaint(bNum, cDate, cMsg));
                }
                adapter.notifyDataSetChanged();
            } catch (JSONException | IOException e) {
                e.printStackTrace();
            }
        };

        Thread async = new Thread(runnable);
        async.start();
    }
}