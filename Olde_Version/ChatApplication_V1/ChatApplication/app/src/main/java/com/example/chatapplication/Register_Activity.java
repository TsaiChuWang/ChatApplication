package com.example.chatapplication;

import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import android.app.Activity;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.util.Base64;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RadioButton;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.FormBody;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;
import okhttp3.logging.HttpLoggingInterceptor;

public class Register_Activity extends AppCompatActivity {
    int SELECT_PICTURE = 200;
    ImageView register_avator_imageView;
    EditText register_editTextPhone,register_name_editText,register_editTextTextPassword;
    RadioButton register_male_radioButton,register_female_radioButton,register_unknown_radioButton;
    String encoded;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

//        getSupportActionBar().hide(); //隱藏標題
//        getWindow().getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_FULLSCREEN); //隱藏狀態

        register_avator_imageView = findViewById(R.id.register_avator_imageView);
        register_editTextPhone=findViewById(R.id.register_editTextPhone);
        register_name_editText=findViewById(R.id.register_name_editText);
        register_editTextTextPassword=findViewById(R.id.register_editTextTextPassword);
        register_male_radioButton=findViewById(R.id.register_male_radioButton);
        register_female_radioButton=findViewById(R.id.register_female_radioButton);
        register_unknown_radioButton=findViewById(R.id.register_unknown_radioButton);
    }


    public void register_avator_imageView_onvlick(View view) {
        imageChooser();
    }

    private void imageChooser()
    {
        Intent i = new Intent();
        i.setType("image/*");
        i.setAction(Intent.ACTION_GET_CONTENT);

        launchSomeActivity.launch(i);
    }

    ActivityResultLauncher<Intent> launchSomeActivity
            = registerForActivityResult(
            new ActivityResultContracts
                    .StartActivityForResult(),
            result -> {
                if (result.getResultCode()
                        == Activity.RESULT_OK) {
                    Intent data = result.getData();
                    // do your operation from here....
                    if (data != null
                            && data.getData() != null) {
                        Uri selectedImageUri = data.getData();
                        Bitmap selectedImageBitmap = null;
                        try {
                            selectedImageBitmap
                                    = MediaStore.Images.Media.getBitmap(
                                    this.getContentResolver(),
                                    selectedImageUri);
                        }
                        catch (IOException e) {
                            e.printStackTrace();
                        }
                        register_avator_imageView.setImageBitmap(selectedImageBitmap);
                        encoded = convert(selectedImageBitmap);
                    }
                }
            });

    public void register_button_onclick(View view) {
        String name=register_name_editText.getText().toString();
        String phoneNumber=register_editTextPhone.getText().toString();
        String password=register_editTextTextPassword.getText().toString();
        String sex;
        if(register_unknown_radioButton.isChecked())
            sex="None";
        else
            sex=register_male_radioButton.isChecked()?"Male":"Female";
//        Log.v(" encoded", encoded);
        OkHttpClient client = new OkHttpClient().newBuilder()
                .build();
        MediaType mediaType = MediaType.parse("application/json");
        RequestBody body = RequestBody.create(mediaType, "{ \n    \"name\":\""+name+"\",\n    \"phoneNumber\": \""+phoneNumber+"\",\n    \"password\":  \""+password+"\",\n    \"image\": \""+"encoded.toString()"+"\",\n    \"sex\": \""+sex+"\"\n}");
        Request request = new Request.Builder()
                .url("http://192.168.2.101:9001/register")
                .method("POST", body)
                .addHeader("Content-Type", "application/json")
                .build();
        Call call =client.newCall(request);
        call.enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
                Log.d("OkHttp result:", e.getMessage());
            }

            @Override
            public void onResponse(Call call, Response response){
                try {
                    String result = response.body().string();
                    Log.d("Response",""+result);
                    Bundle bundle=new Bundle();
                    bundle.putString("_id",result);

                    Intent intent=new Intent(Register_Activity.this,MainMenuActivity.class);
                    intent.putExtras(bundle);
                    startActivity(intent);
                } catch (Exception e) {
                    Log.d("Error",""+e);
                }
            }
        });
    }

    public static String convert(Bitmap bitmap)
    {
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        bitmap.compress(Bitmap.CompressFormat.JPEG, 100, outputStream);

        return Base64.encodeToString(outputStream.toByteArray(), Base64.URL_SAFE);
    }
}