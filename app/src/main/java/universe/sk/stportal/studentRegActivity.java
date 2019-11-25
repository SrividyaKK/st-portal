package universe.sk.stportal;

import android.content.Intent;
import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import de.hdodenhof.circleimageview.CircleImageView;

public class studentRegActivity extends AppCompatActivity implements View.OnClickListener {

    private TextView login;
    private EditText passwd, confirm_passwd;
    private Button signUp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_student_reg);

        login = findViewById(R.id.login);
        passwd = findViewById(R.id.password);
        confirm_passwd = findViewById(R.id.confirm_password);
        signUp = findViewById(R.id.btn_signUp);

        signUp.setOnClickListener(this);
        login.setOnClickListener(this);
    }


    @Override
    public void onClick(View view) {
        if(view.getId() == R.id.login)
        {
            Intent intent = new Intent(this, MainActivity.class);
            startActivity(intent);
        }

        if (view.getId() == R.id.btn_signUp)
        {
            if (passwd.equals(confirm_passwd))
            {
                Toast.makeText(this, "Password do not match.", Toast.LENGTH_SHORT).show();
            }
        }
    }

}
