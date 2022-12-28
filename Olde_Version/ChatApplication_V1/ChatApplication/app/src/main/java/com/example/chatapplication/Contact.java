package com.example.chatapplication;

import org.json.JSONException;
import org.json.JSONObject;

public class Contact {
    private String _id;
    private String contact_Name;
    private String contact_PhoneNumber;
    private String lastDialog;
    private String contact_sex;
    private int contact_imageResource;

    public Contact(String _id){
        this._id=_id;
    }

    public Contact(JSONObject jsonObject) throws JSONException {
        this._id=jsonObject.getString("_id");
        this.contact_Name=jsonObject.getString("name");
        this.contact_PhoneNumber=jsonObject.getString("phoneNumber");
        this.lastDialog=jsonObject.getString("lastDialog");
        this.contact_sex=jsonObject.getString("sex");

        this.contact_imageResource=returnImageResource(this._id);
    }

    public void setName(String name){
        this.contact_Name=name;
    }

    public void setPhoneNumber(String phoneNumber){
        this.contact_PhoneNumber=phoneNumber;
    }

    public void setimageResource(int imageResource){
        this.contact_imageResource=imageResource;
    }

    public void setLastDialog(String lastDialog){ this.lastDialog=lastDialog; }

    public void setFromJsonObject(JSONObject jsonObject) throws JSONException {
        this._id=jsonObject.getString("_id");
        this.contact_Name=jsonObject.getString("name");
        this.contact_PhoneNumber=jsonObject.getString("phoneNumber");
        this.lastDialog=jsonObject.getString("lastDialog");
        this.contact_sex=jsonObject.getString("sex");
    }

    public String getContact_Name(){return this.contact_Name;}

    public String getContact_PhoneNumber(){return this.contact_PhoneNumber;}

    public String get_id(){return this._id;}
    public int getContact_imageResource(){return this.contact_imageResource;}

    public String getLastDialog(){return this.lastDialog; }

    public static int returnImageResource(String _id){
        switch (_id){
            case "4010634894740186":
                return  R.drawable.tsaichu;
            case "5451150284365475":
                return  R.drawable.dianhui;
            case "2978655431084744":
                return  R.drawable.xianglong;
            case "1934773646847715":
                return R.drawable.junwei;
            case "1485990011087015":
                return R.drawable.yisheng;
            case "8934246435579016":
                return R.drawable.fu;
            case "8257679557013767":
                return R.drawable.coco;
            case "9488128152140258":
                return R.drawable.test;
            case "9488128152140257":
                return R.drawable.meili;
            case "9488128152140256":
                return R.drawable.fish;
            default:
                return R.drawable.other;
        }
    }
}
