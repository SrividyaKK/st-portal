package universe.sk.stportal;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.media.Image;
import android.net.Uri;
import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;

import android.provider.ContactsContract;
import android.provider.MediaStore;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Gallery;
import android.widget.ImageView;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.io.File;
import java.lang.reflect.GenericArrayType;
import java.text.DateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import pub.devrel.easypermissions.EasyPermissions;

public class formActivity extends FragmentActivity implements DatePickerDialog.OnDateSetListener, EasyPermissions.PermissionCallbacks, View.OnClickListener {

    //File picker
    private Button btnChooseFile, submit;
    private TextView tvItemPath;
    Intent myFileIntent;


    //Gallery
    ImageView ivGallery;
    private static final int PICK_IMAGE = 100;
    Uri imageUri;
    //Gallery galleryPhoto;
    public static final String KEY_User_Doc1 = "doc1";
    //final int GALLERY_REQUEST = 221312;
    private String doc_image1 = "";
    private TextView login;
    private View rootView;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_form);

        btnChooseFile = (Button)findViewById(R.id.btn_choose_file);
        tvItemPath  = (TextView)findViewById(R.id.tv_file_path);
        ivGallery = (ImageView)findViewById(R.id.imageview);
        submit = (Button)findViewById(R.id.submit);
        final TextView date = (TextView) findViewById(R.id.DOB);
        date.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                DialogFragment datePicker = new DatePickerFragment();
                datePicker.show(getSupportFragmentManager(), "date picker");
            }
        });


        btnChooseFile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                myFileIntent = new Intent(Intent.ACTION_GET_CONTENT);
                myFileIntent.setType("*/*");
                startActivityForResult(myFileIntent, 10);
            }
        });

        ivGallery.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openGallery();
            }
        });

        submit.setOnClickListener(this);
    }

    @Override
    public void onDateSet(DatePicker datePicker, int i, int i1, int i2) {
        Calendar c = Calendar.getInstance();
        c.set(Calendar.YEAR, i);
        c.set(Calendar.MONTH, i1);
        c.set(Calendar.DAY_OF_MONTH, i2);
        String currentDateString = DateFormat.getDateInstance(DateFormat.FULL).format(c.getTime());
        TextView tv = (TextView) findViewById(R.id.DOB);
        tv.setText(currentDateString);
    }

    //File picker
    @Override
    public void onActivityResult(int requestcode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestcode, resultCode, data);
        switch (requestcode) {
            case 10:
                if (resultCode == RESULT_OK) {
                    String path = data.getData().getPath();
                    tvItemPath.setText(path);
                }
                break;
            case PICK_IMAGE:
                if (resultCode == RESULT_OK) {
                    imageUri = data.getData();
                    ivGallery.setImageURI(imageUri);
                }
        }
    }

    @Override
    public void onPermissionsGranted(int requestCode, List<String> perms) {
    //nothing
    }

    @Override
    public void onPermissionsDenied(int requestCode, List<String> perms) {
    //nothing
    }

    //GALLERY
    private void openGallery()
    {
        Intent gallery = new Intent(Intent.ACTION_PICK,MediaStore.Images.Media.INTERNAL_CONTENT_URI);
        startActivityForResult(gallery,PICK_IMAGE);
    }

    @Override
    public void onClick(View view) {
        JSONObject json = new JSONObject();
        try {
            json.put("supply", s);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        Runnable runnable = () -> {
            OkHttpClient client = new OkHttpClient.Builder().retryOnConnectionFailure(true).build();
            RequestBody requestBody = RequestBody.create(MediaType.parse("application/json; charset=utf-8"), json.toString());
            Request request = new Request.Builder()
                    .url(getResources().getString(R.string.base_api_url) + "/api/camps/c/" + id + "/stock")
                    .header("Content-Type", "application/json")
                    .header("Authorization", "Token " + GlobalStore.token)
                    .post(requestBody)
                    .build();
            try {
                Response response = client.newCall(request).execute();
                JSONObject res = new JSONObject(response.body().string());

            } catch (IOException | JSONException e) {
                e.printStackTrace();
            }
        };
        Thread async = new Thread(runnable);
        async.start();
        supplies.add(s);
        listAdapter.notifyItemInserted(supplies.size());
    }
}
