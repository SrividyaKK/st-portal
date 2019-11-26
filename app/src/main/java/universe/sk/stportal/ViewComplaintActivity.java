package universe.sk.stportal;

import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.Set;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class ViewComplaintActivity extends AppCompatActivity {
    ListView lvCompList;
    public ArrayList<Complaint> complaints = new ArrayList<>();
    ComplaintAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_complaint);
        getSupportActionBar().setBackgroundDrawable(new ColorDrawable(getResources().getColor(R.color.dark_blue)));
        lvCompList = findViewById(R.id.lvCompList);

        Set<String> busNums = new LinkedHashSet<>();
        Set<String> compDates = new LinkedHashSet<>();
        Set<String> compMsgs = new LinkedHashSet<>();

        adapter = new ComplaintAdapter(complaints, getApplicationContext());
        lvCompList.setAdapter(adapter);

        loadData();
    }

    public void loadData() {
        Handler handler = new Handler() {
            @Override
            public void handleMessage(Message msg) {
                adapter.notifyDataSetChanged();
            }
        };

        // TODO: LOAD DATA FROM DB
        Runnable runnable = () -> {
            OkHttpClient client = new OkHttpClient.Builder().retryOnConnectionFailure(true).build();
            Request request = new Request.Builder().url(getResources().getString(R.string.base_api_url) + "/complaint").header("Content-Type", "application/json").build();
            complaints.add(new Complaint("kl1234", "23-10-2019", "hello"));
            try {
                Response response = client.newCall(request).execute();
                JSONArray json_arr = new JSONArray(response.body().string());
                System.out.println("json_arr: " + json_arr);
                String bNum, cDate, cMsg;
//                complaints.clear();

                for (int i = 0; i < json_arr.length(); i++) {
                    JSONObject res = json_arr.getJSONObject(i);
                    System.out.println("res: " + res);
                    bNum = res.getString("busNumber");
                    System.out.println("Bus num: " + bNum);
                    cDate = res.getString("complaint_date");
                    cMsg = res.getString("message");
                    complaints.add(i, new Complaint(bNum, cDate, cMsg));
                    System.out.println("Complaints: " + complaints);
                }
            } catch (JSONException | IOException e) {
                e.printStackTrace();
            }
            handler.sendEmptyMessage(0);
        };

        Thread async = new Thread(runnable);
        async.start();
    }
}