package com.example.administrator.memo_20170217.util;

import com.example.administrator.memo_20170217.db.Memo;

import org.litepal.crud.DataSupport;
import org.litepal.tablemanager.Connector;

import java.util.Calendar;
import java.util.List;

/**
 * Created by Administrator on 2017/2/17 0017.
 */
public class Utils {

    /**将创建的便签存储到数据库当中*/
    public static void saveContent(String content) {
        Connector.getDatabase();
        Calendar calendar = Calendar.getInstance();
        int year = calendar.get(Calendar.YEAR);
        int month = calendar.get(Calendar.MONTH) + 1;
        int day = calendar.get(Calendar.DAY_OF_MONTH);
        int hour = calendar.get(Calendar.HOUR_OF_DAY);
        int minute = calendar.get(Calendar.MINUTE);
        String time = year + "年" + (month >= 10 ? month + "" : "0" + month) + "月" +
                (day >= 10 ? day + "" : "0" + day) + "日 " + (hour >= 10 ? hour + "" : "0" + hour) +
                ":" + (minute >= 10 ? minute + "" : "0" + minute);
        Memo memo = new Memo();
        memo.setTime(time);
        memo.setContent(content);
        memo.save();
    }

    /**从数据库中查询全部内容*/
    public static List<Memo> queryContentAll(){
        return DataSupport.findAll(Memo.class);
    }

    /**从数据库中查询某条数据*/
    public static List<Memo> queryCertainContent(int id){
        return DataSupport.where("id = ?", "" + id).find(Memo.class);
    }

    /**删除数据库中的某条数据*/
    public static void deleteCertainContent(int id){
        DataSupport.deleteAll(Memo.class, "id = ?", "" + id);
    }

    /**修改数据库中的某一条数据*/
    public static void updateCertainContent(int id, String content){
        Memo memo = new Memo();
        Calendar calendar = Calendar.getInstance();
        int year = calendar.get(Calendar.YEAR);
        int month = calendar.get(Calendar.MONTH) + 1;
        int day = calendar.get(Calendar.DAY_OF_MONTH);
        int hour = calendar.get(Calendar.HOUR_OF_DAY);
        int minute = calendar.get(Calendar.MINUTE);
        String time = year + "年" + (month >= 10 ? month + "" : "0" + month) + "月" +
                (day >= 10 ? day + "" : "0" + day) + "日 " + (hour >= 10 ? hour + "" : "0" + hour) +
                ":" + (minute >= 10 ? minute + "" : "0" + minute);
        memo.setTime(time);
        memo.setContent(content);
        memo.updateAll("id = ?", "" + id);
    }

}
