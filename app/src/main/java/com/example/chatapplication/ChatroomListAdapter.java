package com.example.chatapplication;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class ChatroomListAdapter extends RecyclerView.Adapter<ChatroomListAdapter.ViewHolder>{
    private List<String> mData;
    private List<String> lastChatData;
    private static Context mContext;

    ChatroomListAdapter(Context mContext,List<String> data,List<String> lastChatData) {
        mData = data;
        this.mContext=mContext;
        this.lastChatData=lastChatData;
    }

    // 建立ViewHolder
    class ViewHolder extends RecyclerView.ViewHolder{
        // 宣告元件
        private TextView chatName_textView,lastChat_textView;
        private ImageView imageView;

        ViewHolder(View itemView) {
            super(itemView);

            chatName_textView = (TextView) itemView.findViewById(R.id.chatName_textView);
            lastChat_textView = (TextView) itemView.findViewById(R.id.lastChat_textView);
            imageView=(ImageView) itemView.findViewById(R.id.imageView);
        }
    }

    @Override
    public ChatroomListAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        // 連結項目布局檔list_item
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.chatroomlistitem, parent, false);

        return new ChatroomListAdapter.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ChatroomListAdapter.ViewHolder holder, @SuppressLint("RecyclerView") int position) {
        // 設置txtItem要顯示的內容
        holder.chatName_textView.setText(mData.get(position));
        holder.lastChat_textView.setText(lastChatData.get(position));
        holder.imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(mContext,mData.get(position).toString(),Toast.LENGTH_LONG).show();
            }
        });
        holder.chatName_textView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(mContext,mData.get(position).toString(),Toast.LENGTH_LONG).show();
            }
        });
        holder.lastChat_textView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(mContext,mData.get(position).toString(),Toast.LENGTH_LONG).show();
            }
        });
    }

    @Override
    public int getItemCount() {
        return mData.size();
    }
}
