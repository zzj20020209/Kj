package com.zzj.vo;

public class YgVo {
    int yid;
    String image;
    String yname;
    String password;
    String sfz;
    String sex;
    String telephone;
    String mailbox;
    String ygdz;

    public YgVo(int yid, String image, String yname, String password, String sfz, String sex, String telephone, String mailbox,String ygdz) {
        this.yid = yid;
        this.image = image;
        this.yname = yname;
        this.password = password;
        this.sfz = sfz;
        this.sex = sex;
        this.telephone = telephone;
        this.mailbox = mailbox;
        this.ygdz=ygdz;
    }

    public YgVo(){}

    public int getYid() {
        return yid;
    }

    public void setYid(int yid) {
        this.yid = yid;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getYname() {
        return yname;
    }

    public void setYname(String yname) {
        this.yname = yname;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getSfz() {
        return sfz;
    }

    public void setSfz(String sfz) {
        this.sfz = sfz;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public String getMailbox() {
        return mailbox;
    }

    public void setMailbox(String mailbox) {
        this.mailbox = mailbox;
    }

    public String getYgdz() {
        return ygdz;
    }

    public void setYgdz(String ygdz) {
        this.ygdz = ygdz;
    }

    @Override
    public String toString() {
        return "YgVo{" +
                "yid=" + yid +
                ", image='" + image + '\'' +
                ", yname='" + yname + '\'' +
                ", password='" + password + '\'' +
                ", sfz='" + sfz + '\'' +
                ", sex='" + sex + '\'' +
                ", telephone='" + telephone + '\'' +
                ", mailbox='" + mailbox + '\'' +
                ", ygdz='" + ygdz + '\'' +
                '}';
    }
}
