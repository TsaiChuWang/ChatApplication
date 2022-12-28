package com.example.chatapplication;

import android.content.Context;
import android.graphics.Color;
import android.util.Log;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class Dialog_Adapter extends RecyclerView.Adapter<Dialog_Adapter.ViewHolder>{
    private Context activity;
    private int contactAvator;
    private ArrayList<Dialog> dialogs;

    Dialog_Adapter(Context activity,ArrayList<Dialog> dialogs,int contactAvator) {
        this.dialogs = dialogs;
        this.activity=activity;
        this.contactAvator=contactAvator;
    }

    // 建立ViewHolder
    class ViewHolder extends RecyclerView.ViewHolder{
        // 宣告元件
        private TextView dialog_Text;
        private ImageView chat_Contact_Avator_imageView;
        private LinearLayout chat_Dialog_LinearLayout;
        private CardView chat_Dialog_Avator_CardView,chat_Dialog_Text_CardView;
        ViewHolder(View itemView) {
            super(itemView);
            dialog_Text = (TextView) itemView.findViewById(R.id.dialog_Text);
            chat_Contact_Avator_imageView=(ImageView) itemView.findViewById(R.id.chat_Contact_Avator_imageView);
            chat_Dialog_LinearLayout=(LinearLayout) itemView.findViewById(R.id.chat_Dialog_LinearLayout);
            chat_Dialog_Avator_CardView=(CardView) itemView.findViewById(R.id.chat_Dialog_Avator_CardView);
            chat_Dialog_Text_CardView=(CardView) itemView.findViewById(R.id.chat_Dialog_Text_CardView);
        }
    }

    @Override
    public Dialog_Adapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        // 連結項目布局檔list_item
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.dialog_item, parent, false);
        return new Dialog_Adapter.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(Dialog_Adapter.ViewHolder holder, int position) {
        holder.dialog_Text.setText(dialogs.get(position).getText());
        holder.chat_Contact_Avator_imageView.setImageResource(contactAvator);
        Log.d("tringaa", String.valueOf(dialogs.get(position).getFrom()));
        if(String.valueOf(dialogs.get(position).getFrom()).equals("0")){
            Log.d("tringaa", "=0");
            holder.chat_Dialog_Text_CardView.setCardBackgroundColor(Color.parseColor("#D1654E"));
            holder.dialog_Text.setTextColor(Color.parseColor("#FAF4E1"));
            holder.chat_Dialog_LinearLayout.setGravity(Gravity.LEFT);
            holder.chat_Contact_Avator_imageView.setVisibility(View.VISIBLE);
            holder.chat_Dialog_Avator_CardView.setVisibility(View.VISIBLE);
        }
        if(String.valueOf(dialogs.get(position).getFrom()).equals("1")){
            Log.d("tringaa", "=1");
            holder.chat_Dialog_Text_CardView.setCardBackgroundColor(Color.parseColor("#FAF4E1"));
            holder.chat_Dialog_LinearLayout.setGravity(Gravity.RIGHT);
            holder.chat_Contact_Avator_imageView.setVisibility(View.GONE);
            holder.chat_Dialog_Avator_CardView.setVisibility(View.GONE);
        }
    }

    @Override
    public int getItemCount() {
        return dialogs.size();
    }
}
