package com.example.administrator.memo_20170217.db;

import org.litepal.crud.DataSupport;

/**
 * Created by Administrator on 2017/2/17 0017.
 */
public class Memo extends DataSupport {

    private int id;//便签的id号

    private String time;//创建便签的时间

    private String content;//便签的内容

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
