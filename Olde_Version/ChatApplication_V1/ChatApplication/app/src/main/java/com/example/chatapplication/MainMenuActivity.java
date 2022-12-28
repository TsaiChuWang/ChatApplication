package com.example.chatapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Looper;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import org.json.JSONArray;
import org.json.JSONObject;

import java.io.IOException;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

public class MainMenuActivity extends AppCompatActivity {
    Bundle bundle;
    Intent intent;
    String name,phoneNumber;
    TextView mainmenu_name_textView,mainmenu_phoneNumber_textView;
    ImageView mainmenu_avator_imageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_menu);

        intent=this.getIntent();
        bundle = intent.getExtras();

        String _id = bundle.getString("_id");
        Log.v("_id",_id);
        mainmenu_avator_imageView= findViewById(R.id.mainmenu_avator_imageView);
        mainmenu_name_textView = findViewById(R.id.mainmenu_name_textView);
        mainmenu_phoneNumber_textView = findViewById(R.id.mainmenu_phoneNumber_textView);

        OkHttpClient client = new OkHttpClient().newBuilder()
                .build();
        MediaType mediaType = MediaType.parse("application/json");
        RequestBody body = RequestBody.create(mediaType, "{ \n\n    \"_id\": \""+_id+"\"\n}");
        Request request = new Request.Builder()
                .url("http://192.168.2.101:9001/get_user_data")
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
                    JSONObject jsonObject = new JSONObject(result);
                    Log.d("Response",""+jsonObject.getString("name"));
                    name=""+jsonObject.getString("name");
                    Log.d("Response",""+jsonObject.getString("phoneNumber"));
                    phoneNumber="0"+jsonObject.getString("phoneNumber");

//                    if(name.equals("王采筑")){
                        mainmenu_avator_imageView.setImageResource(Contact.returnImageResource(_id));
                        mainmenu_avator_imageView.setVisibility(View.VISIBLE);
//                    }
                    mainmenu_name_textView.setText(name);
                    mainmenu_phoneNumber_textView.setText(phoneNumber);
                } catch (Exception e) {
                    Log.d("Error",""+e);
                }
            }
        });



    }


    public void contact_imageButton_onclick(View view) {
        Intent intent=new Intent(MainMenuActivity.this,ContactLists_Activity.class);
        startActivity(intent);
    }

    public void chat_imageButton_imageButton_onclick(View view) {
        Intent intent=new Intent(MainMenuActivity.this,ChatRoom_List_Activity.class);
        startActivity(intent);
    }
}