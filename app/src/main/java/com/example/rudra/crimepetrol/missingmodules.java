package com.example.rudra.crimepetrol;

public class missingmodules {
    private  String Mi_name, city, Birthdate, lastseen, mi_add;
    private int Mi_id;
    public missingmodules(int Mi_id, String Mi_name, String city, String Birthdate, String lastseen, String mi_add) {
        this.Mi_id = Mi_id;
        this.Mi_name = Mi_name;
        this.city = city;
        this.Birthdate = Birthdate;
        this.lastseen = lastseen;
        this.mi_add = mi_add;
    }

    public int getMi_id() {
        return Mi_id;
    }

    public String getMi_name() {
        return Mi_name;
    }

    public String getCity() {
        return city;
    }

    public String getBirthdate() {
        return Birthdate;
    }

    public String getLastseen() {
        return lastseen;
    }

    public String getMi_add() {
        return mi_add;
    }

    public void setMi_id(int mi_id) {
        Mi_id = mi_id;
    }

    public void setMi_name(String mi_name) {
        Mi_name = mi_name;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public void setBirthdate(String birthdate) {
        Birthdate = birthdate;
    }

    public void setLastseen(String lastseen) {
        this.lastseen = lastseen;
    }

    public void setMi_add(String mi_add) {
        this.mi_add = mi_add;
    }
}
