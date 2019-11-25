package universe.sk.stportal;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

public class IndividualApplicationActivity extends AppCompatActivity {
    private TextView tvApplicantName;
    private Button btnVerify;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_individual_application);
    }
}
