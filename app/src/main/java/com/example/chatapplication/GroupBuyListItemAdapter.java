package com.example.chatapplication;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class GroupBuyListItemAdapter extends RecyclerView.Adapter<GroupBuyListItemAdapter.ViewHolder>{
    private List<String> mData;
    private List<String> statusData;
    private List<String> dateData;
    private static Context mContext;

    GroupBuyListItemAdapter(Context mContext,List<String> data,List<String> statusData,List<String> dateData) {
        mData = data;
        this.mContext=mContext;
        this.statusData=statusData;
        this.dateData=dateData;
    }

    // 建立ViewHolder
    class ViewHolder extends RecyclerView.ViewHolder{
        // 宣告元件
        private TextView buyDate_textView;
        private TextView buygoods_textView;
        private TextView buystatus_textView;

        ViewHolder(View itemView) {
            super(itemView);

            buyDate_textView = (TextView) itemView.findViewById(R.id.buyDate_textView);
            buygoods_textView = (TextView) itemView.findViewById(R.id.buygoods_textView);
            buystatus_textView = (TextView) itemView.findViewById(R.id.buystatus_textView);
        }
    }

    @Override
    public GroupBuyListItemAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        // 連結項目布局檔list_item
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.groupbuylistitem, parent, false);

        return new GroupBuyListItemAdapter.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(GroupBuyListItemAdapter.ViewHolder holder, int position) {
        // 設置txtItem要顯示的內容
        holder.buyDate_textView.setText(dateData.get(position));
        holder.buygoods_textView.setText(mData.get(position));
        holder.buystatus_textView.setText(statusData.get(position));

        holder.buyDate_textView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(mContext,mData.get(position).toString(), Toast.LENGTH_LONG).show();
            }
        });
        holder.buygoods_textView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(mContext,mData.get(position).toString(),Toast.LENGTH_LONG).show();
            }
        });
        holder.buystatus_textView.setOnClickListener(new View.OnClickListener() {
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
