package universe.sk.stportal;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
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
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.application_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        Intent intent;
        switch (item.getItemId()){
            case R.id.item1:
                intent = new Intent(ApplicationListActivity.this, ViewComplaintActivity.class);
                startActivity(intent);
                break;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_application_list);
        getSupportActionBar().setBackgroundDrawable(new ColorDrawable(getResources().getColor(R.color.dark_blue)));

        lvFormList = findViewById(R.id.lvFormList);

        Set<String> AdminNum = new LinkedHashSet<>();
        Set<String> Name = new LinkedHashSet<>();
        Set<String>  Status= new LinkedHashSet<>();

        adapter = new ApplicationAdapter(applications, getApplicationContext());
        lvFormList.setAdapter(adapter);
        //TODO: ADD ONCLICK LISTENER
        //lvFormList.setOnItemClickListener(AdapterView<10> adapterView, View view);
        //loadData();

    }
    public void loadData() {

        // TODO: FETCH DATA FROM DB
        Set<String> adminNum = new LinkedHashSet<>();
        Set<String> name = new LinkedHashSet<>();
        Set<String> status = new LinkedHashSet<>();

        //TODO: PASS ID AND NAME TO IndividualActivity
        Intent intent = getIntent();
        Bundle bundle = new Bundle();
        bundle.putString("adminNum", String.valueOf(adminNum));
        bundle.putString("name", String.valueOf(name));
        intent.putExtras(bundle);
        startActivity(intent);

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