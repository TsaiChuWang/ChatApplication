package com.example.chatapplication;

import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class Contact_List_Item_Adapter extends RecyclerView.Adapter<Contact_List_Item_Adapter.ViewHolder> {

    private List<Contact> contactData;

    Contact_List_Item_Adapter(List<Contact> data) {
        contactData = data;
    }

    // 建立ViewHolder
    class ViewHolder extends RecyclerView.ViewHolder{
        // 宣告元件
        private TextView contact_Name_Text,contact_phonenumber_Text;
        private ImageView contact_list_Avator_imageView;
        private CardView contact_CardView;
        ViewHolder(View itemView) {
            super(itemView);
            contact_Name_Text = (TextView) itemView.findViewById(R.id.contact_Name_Text);
            contact_list_Avator_imageView=(ImageView) itemView.findViewById(R.id.contact_list_Avator_imageView);
            contact_phonenumber_Text= (TextView) itemView.findViewById(R.id.contact_phonenumber_Text);
            contact_CardView=(CardView) itemView.findViewById(R.id.contact_CardView);
        }
    }

    @Override
    public Contact_List_Item_Adapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        // 連結項目布局檔list_item
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.contact_item, parent, false);
        return new Contact_List_Item_Adapter.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(Contact_List_Item_Adapter.ViewHolder holder, int position) {
        // 設置txtItem要顯示的內容
        holder.contact_Name_Text.setText(contactData.get(position).getContact_Name());
        holder.contact_phonenumber_Text.setText(contactData.get(position).getContact_PhoneNumber());
        holder.contact_list_Avator_imageView.setImageResource(Contact.returnImageResource(contactData.get(position).get_id()));

        if(position%3==0){
            holder.contact_CardView.setCardBackgroundColor(Color.parseColor("#D1654E"));
            holder.contact_Name_Text.setTextColor(Color.parseColor("#FFFFFF"));
            holder.contact_phonenumber_Text.setTextColor(Color.parseColor("#FFFFFF"));
        }else if(position%3==1){
            holder.contact_CardView.setCardBackgroundColor(Color.parseColor("#4F4F4F"));
            holder.contact_Name_Text.setTextColor(Color.parseColor("#FFFFFF"));
            holder.contact_phonenumber_Text.setTextColor(Color.parseColor("#FFFFFF"));
        } else {
            holder.contact_CardView.setCardBackgroundColor(Color.parseColor("#FAF4E1"));
            holder.contact_Name_Text.setTextColor(Color.parseColor("#4F4F4F"));
            holder.contact_phonenumber_Text.setTextColor(Color.parseColor("#4F4F4F"));
        }
    }

    @Override
    public int getItemCount() {
        return contactData.size();
    }
}

