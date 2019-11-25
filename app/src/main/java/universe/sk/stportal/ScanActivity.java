package universe.sk.stportal;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class ScanActivity extends AppCompatActivity implements View.OnClickListener {
    private Button scanBtn;
    private TextView contentText, scanSuccess;

    String fetchedId = "123456";
    int idInDB = Integer.parseInt(fetchedId);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_scan);

        scanBtn = findViewById(R.id.scan_button);
//        formatText = findViewById(R.id.scan_format);
        contentText = findViewById(R.id.scan_content);
        scanSuccess = findViewById(R.id.scan_success);

        scanBtn.setOnClickListener(this);
    }

    public void onClick(View v) {
        if (v.getId() == R.id.scan_button) {
            IntentIntegrator scanIntegrator = new IntentIntegrator(this);
            scanIntegrator.initiateScan();
        }
    }

    public void onActivityResult(int requestCode, int resultCode, Intent intent) {
        super.onActivityResult(requestCode, resultCode, intent);
        IntentResult scanningResult = IntentIntegrator.parseActivityResult(requestCode, resultCode, intent);
        if (scanningResult != null) {
            String scanContent = scanningResult.getContents();
            int scannedId = Integer.parseInt(scanContent);
    //        String scanFormat = scanningResult.getFormatName();
    //        formatText.setText("FORMAT: " + scanFormat);
            contentText.setText("ID: " + scannedId);
            if (scannedId == idInDB) {
                scanSuccess.setText(R.string.success);
                scanSuccess.setTextColor(getResources().getColor(R.color.green));
            } else {
                scanSuccess.setText(R.string.failure);
                scanSuccess.setTextColor(getResources().getColor(R.color.red));
            }
        } else {
            Toast toast = Toast.makeText(getApplicationContext(), "No scan data received!", Toast.LENGTH_SHORT);
            toast.show();
        }
    }

    @Override
    public void onPointerCaptureChanged(boolean hasCapture) {

    }
}