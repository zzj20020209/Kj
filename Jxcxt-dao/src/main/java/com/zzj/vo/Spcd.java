package com.zzj.vo;

public class Spcd {
    int id;
    String spcd;

    public Spcd(int id, String spcd) {
        this.id = id;
        this.spcd = spcd;
    }

    public Spcd(){}

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getSpcd() {
        return spcd;
    }

    public void setSpcd(String spcd) {
        this.spcd = spcd;
    }

    @Override
    public String toString() {
        return "Spcd{" +
                "id=" + id +
                ", spcd='" + spcd + '\'' +
                '}';
    }
}
