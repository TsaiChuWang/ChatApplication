package com.example.chatapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;

public class GroupBuyingList_Activity extends AppCompatActivity {
    private RecyclerView groupbuylist_view;
    private GroupBuyListItemAdapter adapter;
    private ArrayList<String> mData = new ArrayList<>();
    private ArrayList<String> statusData = new ArrayList<>();
    private ArrayList<String> dateData = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_group_buying_list);

        String[] mdata={"XX牌 洗衣精","OO牌 酒精","XX牌 維生素","QQ牌 行李箱","WW牌音響","FF牌 撲克牌","DD牌 軟糖"};
        String[] statusdata={"狀態:還在確認","狀態:還在確認","狀態:已經下單","狀態:收到貨","狀態:收到貨","狀態:收到貨","狀態:收到貨"};
        String[] datedata={"12/1","12/1","11/29","11/28","11/26","11/3","11/1"};
        // 準備資料，塞50個項目到ArrayList裡
        for(int i = 0; i < 7; i++) {
            mData.add(mdata[i]);
            statusData.add(statusdata[i]);
            dateData.add(datedata[i]);
        }

        // 連結元件
        groupbuylist_view = (RecyclerView) findViewById(R.id.groupbuylist_view);
        // 設置RecyclerView為列表型態
        groupbuylist_view.setLayoutManager(new LinearLayoutManager(this));
        // 設置格線
        groupbuylist_view.addItemDecoration(new DividerItemDecoration(this, DividerItemDecoration.VERTICAL));

        // 將資料交給adapter
        adapter = new GroupBuyListItemAdapter(GroupBuyingList_Activity.this,mData,statusData,dateData);
        // 設置adapter給recycler_view
        groupbuylist_view.setAdapter(adapter);
    }
}