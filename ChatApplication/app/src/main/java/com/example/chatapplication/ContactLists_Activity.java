package com.example.chatapplication;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.DialogInterface;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

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

public class ContactLists_Activity extends AppCompatActivity {
    private RecyclerView recycler_view;
    private Contact_List_Item_Adapter adapter;
    private ArrayList<JSONObject> contactJsonData = new ArrayList<>();
    public ArrayList<Contact> contactData = new ArrayList<>();
    FloatingActionButton add_Contact_FloatingActionButton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contact_lists);

        String _id="4010634894740186";
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

                    Log.d("datalength",""+length);
                    JSONArray arrayContact=data.getJSONArray("contacts");
                    for(int i=0;i<length;i++){
                        contactJsonData.add(arrayContact.getJSONObject(i));
                        Log.d("datalength",contactJsonData.get(i).getString("name"));
                        Log.d("datalength",contactJsonData.get(i).getString("phoneNumber"));
                    }
                    for(int i=0;i<length;i++){
                        Contact contact=new Contact(contactJsonData.get(i));
                        contactData.add(contact);
                    }
                } catch (Exception e) {
                    Log.d("Error",""+e);
                }
            }
        });
        recycler_view = (RecyclerView) findViewById(R.id.contact_lists);
        recycler_view.setLayoutManager(new LinearLayoutManager(this));
        adapter = new Contact_List_Item_Adapter(contactData, ContactLists_Activity.this);
        recycler_view.setAdapter(adapter);

        Log.d("datalengths",String.valueOf( contactData.size()));

        add_Contact_FloatingActionButton=findViewById(R.id.add_Contact_FloatingActionButton);
        add_Contact_FloatingActionButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AlertDialog.Builder builder = new AlertDialog.Builder(ContactLists_Activity.this);
                final EditText editText = new EditText(ContactLists_Activity.this); //final一個editText
                builder.setView(editText);
                builder.setTitle("請輸入好友電話號碼");
                builder.setPositiveButton("確定", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        if(editText.getText().toString().equals("0937997952")){
//
                            Contact contact=new Contact("9488128152140255");
                            contact.setName("新增測試用戶");
                            contact.setPhoneNumber("0937997952");
                            contactData.add(contact);
                            adapter.notifyItemInserted(contactData.size()-1);
                            Toast.makeText(ContactLists_Activity.this, "新增測試用戶 已加到好友", Toast.LENGTH_SHORT).show();
                        }else{
                            Toast.makeText(ContactLists_Activity.this, "您所查詢的用戶不存在", Toast.LENGTH_SHORT).show();
                        }
                    }
                });
                builder.setNegativeButton("取消", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        Toast.makeText(ContactLists_Activity.this, "取消添加好友", Toast.LENGTH_SHORT).show();
                    }
                });
                builder.create().show();
            }
        });
    }
}