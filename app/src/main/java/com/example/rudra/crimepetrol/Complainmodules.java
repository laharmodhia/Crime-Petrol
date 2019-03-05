package com.example.rudra.crimepetrol;

public class Complainmodules {
    private  String C_type, C_description,city;
    private int C_id;
    public Complainmodules(int C_id, String C_type, String C_description, String city) {
        this.C_id = C_id;
        this.C_type = C_type;
        this.C_description = C_description;
        this.city = city;
    }

    public int getC_id() {
        return C_id;
    }

    public String getC_type() {
        return C_type;
    }

    public String getC_description() {
        return C_description;
    }

    public String gecity() {
        return city;
    }

    public void setC_id(int c_id) {
        C_id = c_id;
    }

    public void setC_type(String c_type) {
        C_type = c_type;
    }

    public void setC_description(String c_description) {
        C_description = c_description;
    }

    public void setCity(String city) {
        this.city = city;
    }
}
