package com.example.chatapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.os.Looper;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.Toast;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.util.ArrayList;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

public class ChatRoom_List_Activity extends AppCompatActivity {
    private RecyclerView recycler_view;
    private ChatRoom_List_Item_Adapter adapter;
    private ArrayList<JSONObject> chatRoomData = new ArrayList<>();
    private ArrayList<Contact> contacts=new ArrayList<>();

    private EditText search_ContactName_editTextTextPersonName;
    private ImageButton search_ChatRoom_imageButton;
    String _id="4010634894740186";
    private int contactlength=0;
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chat_room_list);

        try {
            getContactInit(_id);
        } catch (JSONException e) {
            e.printStackTrace();
        }

        setRecycler_viewInit();

        search_ContactName_editTextTextPersonName=findViewById(R.id.search_ContactName_editTextTextPersonName);
        search_ChatRoom_imageButton=findViewById(R.id.search_ChatRoom_imageButton);
    }

    public void getContactInit(String _id) throws JSONException {
        OkHttpClient client = new OkHttpClient().newBuilder()
                .build();
        MediaType mediaType = MediaType.parse("application/json");
        RequestBody body = RequestBody.create(mediaType, "{ \n\n    \"_id\": \""+_id+"\"\n}");
        Request request = new Request.Builder()
                .url("http://192.168.2.101:9001/get_contact_data")
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
                    JSONObject jsonObject = new JSONObject(result);
                    JSONObject data = jsonObject.getJSONObject("data");
                    int length=Integer.parseInt(data.getString("length"));
                    contactlength=length;
                    Log.d("data",""+length);
                    JSONArray array=data.getJSONArray("contacts");
                    for(int i=0;i<length;i++){
                        chatRoomData.add(array.getJSONObject(i));
                        Log.d("data", chatRoomData.get(i).getString("_id"));
                        Log.d("data", chatRoomData.get(i).getString("lastDialog"));
                        Log.d("data", chatRoomData.get(i).getString("name"));
                        Log.d("data", chatRoomData.get(i).getString("password"));
                        Log.d("data", chatRoomData.get(i).getString("phoneNumber"));
                        Log.d("data", chatRoomData.get(i).getString("sex"));
                    }
                    for(int i=0;i<contactlength;i++){
                        Contact contact=new Contact(chatRoomData.get(i));
                        contacts.add(contact);
                    }
                } catch (Exception e) {
                    Log.d("Error",""+e);
                }
            }
        });


    }

    private void setRecycler_viewInit(){
        recycler_view = (RecyclerView) findViewById(R.id.chatroom_list);
        recycler_view.setLayoutManager(new LinearLayoutManager(this));
        recycler_view.addItemDecoration(new DividerItemDecoration(this, DividerItemDecoration.VERTICAL));
        adapter = new ChatRoom_List_Item_Adapter(ChatRoom_List_Activity.this,contacts);
        for (int i = 0; i < recycler_view.getItemDecorationCount(); i++) {
            if (recycler_view.getItemDecorationAt(i) instanceof DividerItemDecoration)
                recycler_view.removeItemDecorationAt(i);
        }
        recycler_view.setAdapter(adapter);
    }

    public void search_ChatRoom_imageButton_onClick(View view) {
        String text=search_ContactName_editTextTextPersonName.getText().toString();
        adapter.notifyItemRemoved(0);
        adapter .notifyItemRangeChanged( 0 , adapter .getItemCount()) ;
    }
}