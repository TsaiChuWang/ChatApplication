package com.example.chatapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;

public class Group_Buy_List_Item_Activity extends AppCompatActivity {
    private ArrayList<String> productData,statusData;
    private RecyclerView recycler_view;
    private Order_List_Item_Adapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_group_buy_list_item);
        initDataset();
        recycler_view = (RecyclerView) findViewById(R.id.order_list);
        recycler_view.setLayoutManager(new LinearLayoutManager(this));
        recycler_view.addItemDecoration(new DividerItemDecoration(this, DividerItemDecoration.VERTICAL));
        adapter = new Order_List_Item_Adapter(Group_Buy_List_Item_Activity.this,productData,statusData);
        for (int i = 0; i < recycler_view.getItemDecorationCount(); i++) {
            if (recycler_view.getItemDecorationAt(i) instanceof DividerItemDecoration)
                recycler_view.removeItemDecorationAt(i);
        }
        recycler_view.setAdapter(adapter);
    }

    private void initDataset(){
        productData=new ArrayList<String>();
        productData.add("Roborock S7 MaxV Ultra");
        productData.add("【MUJI 無印良品】鋁製衣架(3支組)");
        productData.add("耐壓收納箱/大(約50L)");
        productData.add("女棉混足口寬鬆舒適直角襪_深米(23~25cm)");
        productData.add("水洗棉帆布羽毛獨立筒沙發凳套");
        productData.add("聚丙烯檔案盒.標準型.A4用.白灰");
        productData.add("再生尼龍可折收納袋S.淺灰");
        productData.add("男美麗諾羊毛中密織圓領針織衫_深藍");
        productData.add("行動無水香氛機(黑色收納袋)");
        productData.add("敏感肌化妝水(清爽型)400ml");

        statusData=new ArrayList<String>();
        statusData.add("12/14 開放下訂單");
        statusData.add("12/13 付款階段");
        statusData.add("11/26 已經到貨");
        statusData.add("10/05 開放下訂單");
        statusData.add("10/15 開放下訂單");
        statusData.add("09/09 付款階段");
        statusData.add("10/05 付款階段");
        statusData.add("09/10 已經到貨");
        statusData.add("08/21 已經到貨");
        statusData.add("11/16 開放下訂單");
    }
}