package universe.sk.stportal;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Set;

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
        Set<String> compCounts = new LinkedHashSet<>();
        Set<String> compMsgs = new LinkedHashSet<>();

        adapter = new ComplaintAdapter(complaints, getApplicationContext());
        lvCompList.setAdapter(adapter);

        loadData();
    }

    public void loadData() {
        // TODO: LOAD DATA FROM DB
        Set<String> busNums = new LinkedHashSet<>();
        Set<String> compCounts = new LinkedHashSet<>();
        Set<String> compMsgs = new LinkedHashSet<>();

        String bNum, cCount, cMsg;
        Iterator<String> itrBusNums = busNums.iterator();
        Iterator<String> itrCompCounts = compCounts.iterator();
        Iterator<String> itrCompMsgs = compMsgs.iterator();

        complaints.clear();

        while (itrBusNums.hasNext()) {
            bNum = itrBusNums.next();
            cCount = itrCompCounts.next();
            cMsg = itrCompMsgs.next();
            complaints.add(new Complaint(bNum, cCount, cMsg));
        }

        adapter.notifyDataSetChanged();
    }
}