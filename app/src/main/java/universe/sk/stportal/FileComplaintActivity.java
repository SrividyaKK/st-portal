package universe.sk.stportal;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class FileComplaintActivity extends AppCompatActivity implements View.OnClickListener {
//    EditText etBusNum;
    Button btnSubmit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_file_complaint);

        btnSubmit = findViewById(R.id.btnSubmitComplaint);

        btnSubmit.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        Toast.makeText(this, "Complaint logged", Toast.LENGTH_SHORT).show();
    }
}
