package universe.sk.stportal;

import androidx.appcompat.app.AppCompatActivity;

import de.hdodenhof.circleimageview.CircleImageView;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;

public class IndividualApplicationActivity extends AppCompatActivity implements View.OnClickListener {
    private TextView tvApplicantName, tvApplicantEmail, tvApplicantDOB, tvApplicantInstitution, tvApplicantInstLoc, tvApplicantCourse, tvApplicantYearOfGrad, tvApplicantAddress,tvApplicantRoutes;
    private Button btnVerify;
    CircleImageView ivIndAppProfilePic;

    private String id;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_individual_application);

        tvApplicantName = findViewById(R.id.tvApplicantName);
        tvApplicantDOB = findViewById(R.id.tvApplicantDOB);
        tvApplicantEmail = findViewById(R.id.tvApplicantEmail);
        tvApplicantInstitution = findViewById(R.id.tvApplicantInstitution);
        tvApplicantInstLoc = findViewById(R.id.tvApplicantInstLoc);
        tvApplicantCourse = findViewById(R.id.tvApplicantCourse);
        tvApplicantYearOfGrad = findViewById(R.id.tvApplicantYearOfGrad);
        tvApplicantAddress = findViewById(R.id.tvApplicantAddress);
        tvApplicantRoutes = findViewById(R.id.tvApplicantRoutes);
        ivIndAppProfilePic = findViewById(R.id.ivIndAppProfilePic);

        btnVerify = findViewById(R.id.btn_verify);

        Bundle bundle = getIntent().getExtras(); // get the bundle
        String id = bundle.getString("id");
//        String name = bundle.getString("name");

        btnVerify.setOnClickListener(this);

        // TODO: FETCH FROM DB
        JSONObject json = new JSONObject();
        try {
            json.put("admno", id);
        } catch (JSONException e) {
            e.printStackTrace();
        }

        Runnable runnable = () -> {
            OkHttpClient client = new OkHttpClient.Builder().retryOnConnectionFailure(true).build();
            Request request = new Request.Builder()
                    .url(getResources().getString(R.string.base_api_url) + "/students/" + id)
                    .header("Content-Type", "application/json")
                    .build();

            try {
                Response response = client.newCall(request).execute();
                JSONObject res = new JSONObject(response.body().string());

                String appName = res.getString("firstName") + res.getString("lastName");
                String imgUrl = res.getString(res.getString("image"));
                Picasso.get()
                        .load(imgUrl).fit().centerCrop()
                        .placeholder(R.drawable.profile_pic_default)
                        .into(ivIndAppProfilePic);

                tvApplicantName.setText(appName);
                tvApplicantDOB.setText(res.getString("dob"));
                tvApplicantEmail.setText(res.getString("email"));
                tvApplicantInstitution.setText(res.getString("institution"));
                tvApplicantInstLoc.setText(res.getString("inst_loc"));
                tvApplicantCourse.setText(res.getString("course"));
                tvApplicantYearOfGrad.setText(res.getString("year"));
                tvApplicantAddress.setText(res.getString("address"));
                tvApplicantRoutes.setText(res.getString("routes"));
            } catch (IOException | JSONException e) {
                e.printStackTrace();
            }
        };

        Thread async = new Thread(runnable);
        async.start();

    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.btn_verify) {
            // TODO: Approve the details - send post request
        }
    }
}
