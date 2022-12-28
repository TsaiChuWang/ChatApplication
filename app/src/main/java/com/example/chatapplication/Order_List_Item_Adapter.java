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

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class Order_List_Item_Adapter extends RecyclerView.Adapter<Order_List_Item_Adapter.ViewHolder>{
    private Context activity;
    private ArrayList<String> productData,statusData;

    Order_List_Item_Adapter(Context activity,ArrayList<String> productData,ArrayList<String> statusData) {
        this.activity=activity;
        this.productData=productData;
        this.statusData=statusData;
    }

    class ViewHolder extends RecyclerView.ViewHolder{
        // 宣告元件
        private TextView product_Text;
        private TextView status_textView;
        private CardView order_cardView;
        ViewHolder(View itemView) {
            super(itemView);
            product_Text = (TextView) itemView.findViewById(R.id.product_Text);
            status_textView = (TextView) itemView.findViewById(R.id.status_textView);
            order_cardView=(CardView) itemView.findViewById(R.id.order_cardView);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent intent=new Intent(activity,Order_Detail_Activity.class);
                    activity.startActivity(intent);
                }
            });
        }
    }

    @Override
    public Order_List_Item_Adapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        // 連結項目布局檔list_item
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.order_item, parent, false);
        return new Order_List_Item_Adapter.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int index) {
        // 設置txtItem要顯示的內容
        holder.product_Text.setText(productData.get(index));
        holder.status_textView.setText(statusData.get(index));

        if(index%3==0){
            holder.order_cardView.setCardBackgroundColor(Color.parseColor("#D1654E"));
            holder.product_Text.setTextColor(Color.parseColor("#FFFFFF"));
            holder.status_textView.setTextColor(Color.parseColor("#FFFFFF"));
        }else if(index%3==1){
            holder.order_cardView.setCardBackgroundColor(Color.parseColor("#4F4F4F"));
            holder.product_Text.setTextColor(Color.parseColor("#FFFFFF"));
            holder.status_textView.setTextColor(Color.parseColor("#FFFFFF"));
        } else {
            holder.order_cardView.setCardBackgroundColor(Color.parseColor("#FAF4E1"));
            holder.product_Text.setTextColor(Color.parseColor("#4F4F4F"));
            holder.status_textView.setTextColor(Color.parseColor("#4F4F4F"));
        }
    }

    @Override
    public int getItemCount() {
        return productData.size();
    }
}
