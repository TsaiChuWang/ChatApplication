package com.example.chatapplication;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.lifecycle.ViewModel;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class ChatRoom_List_Item_Adapter extends RecyclerView.Adapter<ChatRoom_List_Item_Adapter.ViewHolder>{
    private Context activity;
    private ArrayList<Contact> contactData;

    ChatRoom_List_Item_Adapter(Context activity,ArrayList<Contact> data) {
        this.activity=activity;
        contactData = data;
    }

    // 建立ViewHolder
    class ViewHolder extends RecyclerView.ViewHolder{
        // 宣告元件
        private TextView chatroom_Name_TextView;
        private TextView lastDialog_textView;
        private ImageView chatroom_Avator_imageView;
        private LinearLayout chatroom_Avator_LinearLayout;
        ViewHolder(View itemView) {
            super(itemView);
            chatroom_Avator_LinearLayout=(LinearLayout) itemView.findViewById(R.id.chatroom_Avator_LinearLayout);
            chatroom_Name_TextView = (TextView) itemView.findViewById(R.id.chatroom_Name_TextView);
            lastDialog_textView = (TextView) itemView.findViewById(R.id.lastDialog_textView);
            chatroom_Avator_imageView=(ImageView) itemView.findViewById(R.id.chatroom_Avator_imageView);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent intent=new Intent(activity,ChatRoom_Activity.class);
                    activity.startActivity(intent);
                }
            });
        }
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        // 連結項目布局檔list_item
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.chatroom_list_item, parent, false);
        return new ViewHolder(view);
    }

    @SuppressLint("ResourceAsColor")
    @Override
    public void onBindViewHolder(ViewHolder holder, int index) {
        // 設置txtItem要顯示的內容
        holder.chatroom_Name_TextView.setText(contactData.get(index).getContact_Name());
        holder.lastDialog_textView.setText(contactData.get(index).getLastDialog());
        holder.chatroom_Avator_imageView.setImageResource(contactData.get(index).getContact_imageResource());

        if(index%3==0){
            holder.chatroom_Avator_LinearLayout.setBackgroundColor(Color.parseColor("#D1654E"));
            holder.chatroom_Name_TextView.setTextColor(Color.parseColor("#FFFFFF"));
            holder.lastDialog_textView.setTextColor(Color.parseColor("#FFFFFF"));
        }else if(index%3==1){
            holder.chatroom_Avator_LinearLayout.setBackgroundColor(Color.parseColor("#4F4F4F"));
            holder.chatroom_Name_TextView.setTextColor(Color.parseColor("#FFFFFF"));
            holder.lastDialog_textView.setTextColor(Color.parseColor("#FFFFFF"));
        } else {
            holder.chatroom_Avator_LinearLayout.setBackgroundColor(Color.parseColor("#FAF4E1"));
            holder.chatroom_Name_TextView.setTextColor(Color.parseColor("#4F4F4F"));
            holder.lastDialog_textView.setTextColor(Color.parseColor("#4F4F4F"));
        }
    }

    @Override
    public int getItemCount() {
        return contactData.size();
    }
}
