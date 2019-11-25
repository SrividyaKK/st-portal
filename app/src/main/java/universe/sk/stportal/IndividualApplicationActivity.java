package universe.sk.stportal;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class IndividualApplicationActivity extends AppCompatActivity implements View.OnClickListener {
    private TextView tvApplicantName, tvApplicantDOB, tvApplicantInstitution, tvApplicantInstLoc, tvApplicantCourse, tvApplicantYearOfGrad, tvApplicantAddress,tvApplicantRoutes;
    private Button btnVerify;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_individual_application);

        tvApplicantName = findViewById(R.id.tvApplicantName);
        tvApplicantDOB = findViewById(R.id.tvApplicantDOB);
        tvApplicantInstitution = findViewById(R.id.tvApplicantInstitution);
        tvApplicantInstLoc = findViewById(R.id.tvApplicantInstLoc);
        tvApplicantCourse = findViewById(R.id.tvApplicantCourse);
        tvApplicantYearOfGrad = findViewById(R.id.tvApplicantYearOfGrad);
        tvApplicantAddress = findViewById(R.id.tvApplicantAddress);
        tvApplicantRoutes = findViewById(R.id.tvApplicantRoutes);

        btnVerify = findViewById(R.id.btn_verify);

        btnVerify.setOnClickListener(this);

        // TODO: FETCH FROM DB

        tvApplicantName.setText("");
        tvApplicantDOB.setText("");
        tvApplicantInstitution.setText("");
        tvApplicantInstLoc.setText("");
        tvApplicantCourse.setText("");
        tvApplicantYearOfGrad.setText("");
        tvApplicantAddress.setText("");
        tvApplicantRoutes.setText("");

    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.btn_verify) {
            // TODO: Approve the details
        }
    }
}
