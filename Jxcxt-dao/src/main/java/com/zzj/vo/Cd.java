package com.zzj.vo;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Cd {
    int id;
    String text;
    String url;
    String iconCls;
    String state;
    int zid;
    Map<String,String> attributes=new HashMap<String,String>();
    //子菜单集合
    List<Cd> children=new ArrayList<Cd>();

    //子节点选中状态
    boolean checked;


    public Cd(int id, String text, String url, String iconCls, String state, int zid, Map<String, String> attributes,List<Cd> children,boolean checked) {
        this.id = id;
        this.text = text;
        this.url = url;
        this.iconCls = iconCls;
        this.state = state;
        this.zid = zid;
        this.attributes = attributes;
        this.children=children;
        this.checked=checked;
    }

    public Cd(){}

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getIconCls() {
        return iconCls;
    }

    public void setIconCls(String iconCls) {
        this.iconCls = iconCls;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public int getZid() {
        return zid;
    }

    public void setZid(int zid) {
        this.zid = zid;
    }

    public Map<String, String> getAttributes() {
        return attributes;
    }

    public void setAttributes(Map<String, String> attributes) {
        this.attributes = attributes;
    }

    public List<Cd> getChildren() {
        return children;
    }

    public void setChildren(List<Cd> children) {
        this.children = children;
    }

    public boolean isChecked() {
        return checked;
    }

    public void setChecked(boolean checked) {
        this.checked = checked;
    }

    @Override
    public String toString() {
        return "Cd{" +
                "id=" + id +
                ", text='" + text + '\'' +
                ", url='" + url + '\'' +
                ", iconCls='" + iconCls + '\'' +
                ", state='" + state + '\'' +
                ", zid=" + zid +
                ", attributes=" + attributes +
                ", children=" + children +
                ", checked=" + checked +
                '}';
    }
}
