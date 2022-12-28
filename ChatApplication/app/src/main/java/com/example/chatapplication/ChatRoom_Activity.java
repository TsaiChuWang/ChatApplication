package com.example.chatapplication;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.graphics.Canvas;
import android.os.Bundle;
import android.text.format.Time;
import android.util.Log;
import android.view.View;
import android.widget.EditText;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

public class ChatRoom_Activity extends AppCompatActivity {
    private RecyclerView recycler_view;
//    private MyAdapter adapter;
    private ArrayList<String> mData = new ArrayList<>();

    private Dialog_Adapter adapter;
    private ArrayList<Dialog> dialogData = new ArrayList<>();;
    private int dialogLength=0;
    private String contact_id="5451150284365475";

    private EditText mesdsage_editText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chat_room);

        try {
            getDialogInit("4010634894740186",contact_id);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        mesdsage_editText=findViewById(R.id.mesdsage_editText);
        recycler_view = (RecyclerView) findViewById(R.id.dialog_chat);
        recycler_view.setLayoutManager(new LinearLayoutManager(this));
        recycler_view.addItemDecoration(new DividerItemDecoration(this, DividerItemDecoration.VERTICAL));
        adapter = new Dialog_Adapter(ChatRoom_Activity.this,dialogData,Contact.returnImageResource(contact_id));
        for (int i = 0; i < recycler_view.getItemDecorationCount(); i++) {
            if (recycler_view.getItemDecorationAt(i) instanceof DividerItemDecoration)
                recycler_view.removeItemDecorationAt(i);
        }
        recycler_view.setAdapter(adapter);
    }

    public void getDialogInit(String _id,String contact_id) throws JSONException {
        OkHttpClient client = new OkHttpClient().newBuilder()
                .build();
        MediaType mediaType = MediaType.parse("application/json");
        RequestBody body = RequestBody.create(mediaType, "{ \n\n    \"_id\": \""+_id+"\",\"contact_id\":"+contact_id+"\n}");
        Request request = new Request.Builder()
                .url("http://192.168.2.101:9001/get_dialog_data")
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
                    dialogLength=length;
                    Log.d("data",""+length);
                    JSONArray array=data.getJSONArray("dialogs");

                    for(int i=0;i<length;i++){
                        Log.d("data", array.getJSONObject(i).getString("time"));
                        Log.d("data", array.getJSONObject(i).getString("text"));
                        Log.d("data", String.valueOf(array.getJSONObject(i).getInt("from")));

                        Dialog dialog=new Dialog(array.getJSONObject(i));
                        dialogData.add(dialog);
                    }
                } catch (Exception e) {
                    Log.d("Error",""+e);
                }
            }
        });
    }

    public void send_Dialog_button_onclick(View view) throws JSONException {

        Log.d("tringaa", "send_Dialog_button_onclick: 沒有喔");
        Dialog dialog=new Dialog();
        dialog.setText("沒有喔");
        dialog.setFrom(1);

        dialogData.add(dialog);
        Log.d("triaca", String.valueOf(dialogData.size()-1));
        adapter.notifyItemInserted(dialogData.size()-1);
//        dialogLength+=1;
        mesdsage_editText.setText("");
//        Dialog dialogb=new Dialog();
//        dialogb.setText("好喔謝謝");
//        dialogb.setFrom(0);
        if(dialogData.size()-1==17){
            Dialog dialogb=new Dialog();
            dialogb.setText("好喔謝謝");
            dialogb.setFrom(0);
            dialogData.add(dialogb);
            adapter.notifyItemInserted(dialogData.size()-1);
        }
//        dialogData.add(dialogb);
//        adapter.notifyItemInserted(dialogLength);
//        dialogLength+=1;
//        mesdsage_editText.setText("");
//        if(String.valueOf(mesdsage_editText.getText()).equals("沒有喔")){
//            Log.d("tringaa", "send_Dialog_button_onclick: 沒有喔");
//            Dialog dialog=new Dialog();
//            dialog.setText(String.valueOf(mesdsage_editText.getText()));
//            dialog.setFrom(1);
//
//            dialogData.add(dialog);
//            adapter.notifyItemInserted(dialogLength);
//            dialogLength+=1;
//
//            mesdsage_editText.setText("");
//        }




    }
}