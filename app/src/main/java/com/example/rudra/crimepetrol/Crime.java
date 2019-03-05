package com.example.rudra.crimepetrol;

public class Crime {
    private  String Cr_type, Cr_description,city;
    private int Cr_id;
    public Crime(int Cr_id, String Cr_type, String Cr_description, String city){
        this.Cr_id = Cr_id;
        this.Cr_type = Cr_type;
        this.Cr_description = Cr_description;
        this.city = city;
    }

    public int getCr_id() {
        return Cr_id;
    }

    public String getCr_type() {
        return Cr_type;
    }

    public String getCr_description() {
        return Cr_description;
    }

    public String getCity() {
        return city;
    }

    public void setCr_id(int cr_id) {
        Cr_id = cr_id;
    }

    public void setCr_type(String cr_type) {
        Cr_type = cr_type;
    }

    public void setCr_description(String cr_description) {
        Cr_description = cr_description;
    }

    public void setCity(String city) {
        this.city = city;
    }
}
