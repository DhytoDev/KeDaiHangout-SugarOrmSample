package org.kedai.sugar_orm.utils;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by Lenovo on 03/04/2016.
 */
public class Util {
    public static String getCurrentDate(){
        DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
        Date date = new Date();
        System.out.println(dateFormat.format(date)); //2014/08/06 15:59:48
        return dateFormat.format(date);
    }

    public static Long getNewId(){
        return System.currentTimeMillis();
    }
}
