package com.example.chatapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;

public class ChatroomList_Activity extends AppCompatActivity {
    private RecyclerView chatroomList_view;
    private ChatroomListAdapter adapter;
    private ArrayList<String> mData = new ArrayList<>();
    private ArrayList<String> lastChatData = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chatroom_list);

        String[] names={"謝佳燕", "夏真蓁", "李文妏", "黎忠凌", "黎峻豪", "許念星", "弓梅燦", "陳勇豪", "鄭怡君", "蔡佳忠", "李欣林", "陳紹中", "蔡陽屏", "劉妙霖", "王雅雯", "蔡雅晴", "郭韻婷", "陳逸彬", "吳政念", "陳致揚", "楊桂潔", "郭彥博", "洪佩琪", "陳志音", "楊昕皓", "吳建平", "周新瑜", "蘇函紹", "羅平玄", "楊志堯", "廖玟芸", "吳承俐", "黃則臻", "孫典興", "陳怡君", "陳淑隆", "楊敬穎"," 黃翔佳", "李晏東", "張俊宏", "陳柔伯", "張哲琳", "王怡哲", "謝孟倫", "陳怡潔", "鄭憲傑", "蔡曉薇", "陳建中", "李培寧", "陳筱霞", "陳雅茹", "馬宥潔", "宋筱聖", "劉冰男", "張俊宏", "蔡孟惠", "黃慧倫", "蘇綠榮", "王軍裕", "張欣怡", "陳怡如", "王怡菁", "李佳蓉", "方順任", "陳建梅", "孫家偉", "王昱貞", "盧美惠", "黃心香", "李怡君", "鄭淑郁", "陳怡秋", "黃平鈺", "林茹友", "陳淑萍", "林惠敏", "李素綸", "張秀春", "毛韻源", "陳美婷", "李賢韻", "張家鑫", "朱佳容", "林亭真", "謝星玫", "周水軍", "陳宜如", "張志英", "梁台蓉", "蔡雲昌", "宋曜宇", "林秋芳", "黃桂諭", "吳中恭", "賴軍奇", "黃恆孝", "陳曉行", "李文桂", "林建宇", "洪珮潔"};
//        String[] lastChats=new String[100];
        // 準備資料，塞50個項目到ArrayList裡
        for(int i = 0; i < 100; i++) {
            mData.add(names[i]);
            lastChatData.add("這是跟"+names[i]+"的聊天室!");
        }
        // 連結元件
        chatroomList_view = (RecyclerView) findViewById(R.id.chatroomList_view);
        // 設置RecyclerView為列表型態
        chatroomList_view.setLayoutManager(new LinearLayoutManager(this));
        // 設置格線
        chatroomList_view.addItemDecoration(new DividerItemDecoration(this, DividerItemDecoration.VERTICAL));

        // 將資料交給adapter
        adapter = new ChatroomListAdapter(ChatroomList_Activity.this,mData,lastChatData);
        // 設置adapter給recycler_view
        chatroomList_view.setAdapter(adapter);
    }
}