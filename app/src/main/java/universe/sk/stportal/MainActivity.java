package universe.sk.stportal;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private Button verify, login;
    private TextView signUp;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        verify = findViewById(R.id.custom_btn);
        login = findViewById(R.id.btn_login);
        signUp = findViewById(R.id.signUp);
        verify.setOnClickListener(this);
        login.setOnClickListener(this);
        signUp.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        if(view.getId() == R.id.custom_btn)
        {
            Intent intent = new Intent(this,ScanActivity.class);
            IntentIntegrator scanIntegrator = new IntentIntegrator(this);
            scanIntegrator.initiateScan();
            //startActivity(intent);
        }

        if(view.getId() == R.id.signUp)
        {
            Intent intent = new Intent(this,studentRegActivity.class);
            startActivity(intent);
        }

        if(view.getId() == R.id.btn_login)
        {
            Intent intent  = new Intent(this, formActivity.class);
            startActivity(intent);
        }

    }
}
