package com.example.chatapplication;

import org.json.JSONException;
import org.json.JSONObject;

public class Dialog {
    private String time;
    private String text;
    private int from;

    public Dialog(){}

    public Dialog(JSONObject jsonObject) throws JSONException {
        this.time=jsonObject.getString("time").toString();
        this.text=jsonObject.getString("text").toString();
        this.from=jsonObject.getInt("from");
    }

    public void setTime(String time){this.time=time;}

    public void setText(String text){this.text=text;}

    public void setFrom(int form){this.from=form;}

    public String getTime(){return  this.time; }

    public String getText(){return this.text; }

    public int getFrom(){return  this.from; }
}
