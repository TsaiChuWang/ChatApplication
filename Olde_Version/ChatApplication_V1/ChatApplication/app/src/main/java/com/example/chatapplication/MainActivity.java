package com.example.chatapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.content.Intent;
import android.os.Bundle;
import android.os.Looper;
import android.text.method.HideReturnsTransformationMethod;
import android.text.method.PasswordTransformationMethod;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import java.io.IOException;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

public class MainActivity extends AppCompatActivity {
    RadioButton enroll_show_radioButton,enroll_hide_radioButton;
    EditText enoll_phoneNumber_editText,enoll_password_editTextTextPassword;
    RadioGroup enroll_radioGroup;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

//        getSupportActionBar().hide(); //隱藏標題
//        getWindow().getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_FULLSCREEN); //隱藏狀態

        enroll_show_radioButton=findViewById(R.id.enroll_show_radioButton);
        enroll_hide_radioButton=findViewById(R.id.enroll_hide_radioButton);
        enoll_phoneNumber_editText=findViewById(R.id.enoll_phoneNumber_editText);
        enoll_password_editTextTextPassword=findViewById(R.id.enoll_password_editTextTextPassword);
        enroll_radioGroup=findViewById(R.id.enroll_radioGroup);

        enroll_radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener()
        {
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                RadioButton rb=(RadioButton)findViewById(checkedId);
                if( rb.getText().equals("顯示")){
                    enoll_password_editTextTextPassword.setTransformationMethod(HideReturnsTransformationMethod.getInstance());
                }else{
                    enoll_password_editTextTextPassword.setTransformationMethod(PasswordTransformationMethod.getInstance());
                }
            }
        });
    }

    public void register_onclick(View view) {
//        Intent intent=new Intent(MainActivity.this,Register_Activity.class);

        Intent intent=new Intent(MainActivity.this,ContactLists_Activity.class);
        startActivity(intent);
    }


    public void enroll_button_onclick(View view) {
        String phoneNumber=enoll_phoneNumber_editText.getText().toString();
        String password=enoll_password_editTextTextPassword.getText().toString();

        OkHttpClient client = new OkHttpClient().newBuilder()
                .build();
        MediaType mediaType = MediaType.parse("application/json");
        RequestBody body = RequestBody.create(mediaType, "{ \n\n    \"phoneNumber\": \""+phoneNumber+"\",\n    \"password\":  \""+password+"\"\n}");
        Request request = new Request.Builder()
                .url("http://192.168.2.101:9001/enroll")
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
                    if(result.equals("FAILED")){
                        Looper.prepare();
                        Toast.makeText(MainActivity.this, "登入失敗", Toast.LENGTH_SHORT).show();
                        Looper.loop();
                    }else{
                        Bundle bundle=new Bundle();
                        bundle.putString("_id",result);

                        Intent intent=new Intent(MainActivity.this,MainMenuActivity.class);
                        intent.putExtras(bundle);
                        startActivity(intent);
                    }
                } catch (Exception e) {
                    Log.d("Error",""+e);
                }
            }
        });
    }
}