package universe.sk.stportal;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Set;

public class ApplicationListActivity extends AppCompatActivity {

    ListView lvFormList;
    ArrayList<Application> applications = new ArrayList<>();
    private ApplicationAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_application_list);

        lvFormList = findViewById(R.id.lvFormList);

        Set<String> AdminNum = new LinkedHashSet<>();
        Set<String> Name = new LinkedHashSet<>();
        Set<String>  Status= new LinkedHashSet<>();

        adapter = new ApplicationAdapter(applications, getApplicationContext());
        lvFormList.setAdapter(adapter);
        //TODO: ADD ONCLICK LISTENER
        //lvFormList.setOnItemClickListener(AdapterView<10> adapterView, View view);
        loadData();
    }
    public void loadData() {
        // TODO: LOAD DATA FROM DB
        Set<String> adminNum = new LinkedHashSet<>();
        Set<String> name = new LinkedHashSet<>();
        Set<String> status = new LinkedHashSet<>();

        //TODO: PASS ID TO IndividualActivity
//        String bNum, cCount, cMsg;
//        Iterator<String> itrBusNums = busNums.iterator();
//        Iterator<String> itrCompCounts = compCounts.iterator();
//        Iterator<String> itrCompMsgs = compMsgs.iterator();
//
//        complaints.clear();
//
//        while (itrBusNums.hasNext()) {
//            bNum = itrBusNums.next();
//            cCount = itrCompCounts.next();
//            cMsg = itrCompMsgs.next();
//            complaints.add(new Complaint(bNum, cCount, cMsg));
//        }

        adapter.notifyDataSetChanged();
    }
}