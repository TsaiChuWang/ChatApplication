package com.example.chatapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    //進入聯絡人介面(ContactList_Activity)
    public void contact_imageButton_onClick(View view) {
        Intent intent=new Intent();
        intent.setClass(MainActivity.this,ContactList_Activity.class);
        startActivity(intent);
    }

    //進入聊天室清單介面(ContactList_Activity)
    public void chat_imageButton_onClick(View view) {
        Intent intent=new Intent();
        intent.setClass(MainActivity.this,ChatroomList_Activity.class);
        startActivity(intent);
    }
}