package universe.sk.stportal;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import org.json.JSONException;
import org.json.JSONObject;
import org.w3c.dom.Text;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.net.HttpURLConnection;
import java.net.URL;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private EditText email, password;
    private Button verify, login;
    private TextView signUp;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        email = findViewById(R.id.username);
        password = findViewById(R.id.password);

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
            startActivity(intent);
            //Intent intent = new Intent(this, ScanActivity.class);
            //IntentIntegrator scanIntegrator = new IntentIntegrator(this);
            //scanIntegrator.initiateScan();
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

//    public void senddatatoserver(View v) {
//        //function in the activity that corresponds to the layout button
//        String username, passwd;
//        username = email.getText().toString();
//        passwd = password.getText().toString();
//        final JSONObject post_dict = new JSONObject();
//
//        try {
//            post_dict.put("username", username);
//            post_dict.put("email", email);
//
//        } catch (JSONException e) {
//            e.printStackTrace();
//        }
//        if (post_dict.length() > 0) {
//            new SendJsonDataToServer().execute(String.valueOf(post_dict));
//            //call to async class
//        }
//        //add background inline class here
//        class SendJsonDataToServer extends AsyncTask<String, String, String> {
//            @Override
//            protected String doInBackground(String... strings) {
//                String JsonResponse = null;
//                String JsonDATA = params[0];
//                HttpURLConnection urlConnection = null;
//                BufferedReader reader = null;
//                try {
//                    URL url = new URL("http://appliedinformatics.com/trialx");
//                    urlConnection = (HttpURLConnection) url.openConnection();
//                    urlConnection.setDoOutput(true);
//                    // is output buffer writter
//                    urlConnection.setRequestMethod("POST");
//                    urlConnection.setRequestProperty("Content-Type", "application/json");
//                    urlConnection.setRequestProperty("Accept", "application/json");
//                    //set headers and method
//                    Writer writer = new BufferedWriter(new OutputStreamWriter(urlConnection.getOutputStream(), "UTF-8"));
//                    writer.write(JsonDATA);
//                    // json data
//                    writer.close();
//                    InputStream inputStream = urlConnection.getInputStream();
//                    //input stream
//                    StringBuffer buffer = new StringBuffer();
//                    if (inputStream == null) {
//                        // Nothing to do.
//                        return null;
//                    }
//                    reader = new BufferedReader(new InputStreamReader(inputStream));
//
//                    String inputLine;
//                    while ((inputLine = reader.readLine()) != null)
//                        buffer.append(inputLine + "\n");
//                    if (buffer.length() == 0) {
//                        // Stream was empty. No point in parsing.
//                        return null;
//                    }
//                    JsonResponse = buffer.toString();
//                    //response data
//                    Log.i(TAG,JsonResponse);
//                    try {
//                        //send to post execute
//                        return JsonResponse;
//                    } catch (JSONException e) {
//                        e.printStackTrace();
//                    }
//                    return null;
//
//
//
//                } catch (IOException e) {
//                    e.printStackTrace();
//                }
//                finally {
//                    if (urlConnection != null) {
//                        urlConnection.disconnect();
//                    }
//                    if (reader != null) {
//                        try {
//                            reader.close();
//                        } catch (final IOException e) {
//                            Log.e(TAG, "Error closing stream", e);
//                        }
//                    }
//                }
//                return null;
//            }
//            }
//        }
    //}

//    class SendDataToServer extends AsyncTask<String,String,String> {
//
//        @Override
//        protected String doInBackground(String... params) {
//        }
//        @Override
//        protected void onPostExecute(String s) {
//        }
//
//    }
    //}
}



