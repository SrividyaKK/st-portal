package universe.sk.stportal;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.widget.ListView;

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
        // TODO: LOAD DATA FROM DB
        Runnable runnable = () -> {
            OkHttpClient client = new OkHttpClient.Builder().retryOnConnectionFailure(true).build();
            Request request = new Request.Builder().url(R.string.base_api_url + "/").header("Content-Type", "application/json").build();

            try {
                Response response = client.newCall(request).execute();
                JSONObject res = new JSONObject(response.body().string());
                System.out.println("res: " + res);
            } catch (JSONException | IOException e) {
                e.printStackTrace();
            }
        };
        Set<String> busNums = new LinkedHashSet<>();
        Set<String> compDates = new LinkedHashSet<>();
        Set<String> compMsgs = new LinkedHashSet<>();

        String bNum, cDate, cMsg;
        Iterator<String> itrBusNums = busNums.iterator();
        Iterator<String> itrCompDates = compDates.iterator();
        Iterator<String> itrCompMsgs = compMsgs.iterator();

        complaints.clear();

        while (itrBusNums.hasNext()) {
            bNum = itrBusNums.next();
            cDate = itrCompDates.next();
            cMsg = itrCompMsgs.next();
            complaints.add(new Complaint(bNum, cDate, cMsg));
        }

        adapter.notifyDataSetChanged();
    }
}