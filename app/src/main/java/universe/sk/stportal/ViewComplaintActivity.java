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
        // read the contacts from sharedPreferences

        // TODO: LOAD DATA FROM DB
        Set<String> busNums = new LinkedHashSet<>();

        String name, number;
        Iterator<String> itrNames = busNums.iterator();
//        Iterator<String> itrNumbers = contactNumbers.iterator();
//
//        complaints.clear();
//
//        while (itrNames.hasNext()) {
//            name = itrNames.next();
//            number = itrNumbers.next();
//            contacts.add(new Contact(name, number));
//        }
        adapter.notifyDataSetChanged();
    }
}