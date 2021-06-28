package com.heima.exception;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 编译时异常，写代码的时候就会报错，提示用try catch
 * 运行时异常，RuntimeException 编译不报错
 */
public class Demo_Exception {
    public static void main(String[] args) {
        /*System.out.println("----程序开始");
        parseTime("2034-03-24 15:33:00");
        System.out.println("---程序结束");*/


        //自定义编译时异常
        /*System.out.println("---start");
        try {
            checkAge(200);
        } catch (customAgeIlleagalException e) {
            e.printStackTrace();
        }
        System.out.println("----end");*/

        //运行时异常
        checkSex("ioo");

    }

    public  static  void  parseTime(String date){
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        try {
            Date d = dateFormat.parse(date);
            InputStream stream = new FileInputStream("F:/d.png");
        } catch (ParseException | FileNotFoundException e) {
            e.printStackTrace();
        } finally {
        }
    }


    public static void checkAge(int age) throws customAgeIlleagalException {
        if (age <=0 || age >=150){
            throw new customAgeIlleagalException("年龄异常");
        }else{
            System.out.println("age:"+age);
        }
    }

    public static void checkSex(String sex) throws customAgeIlleagalRuntimeException {
        if (sex != "男" && sex != "女"){
            throw new customAgeIlleagalRuntimeException("性别异常");
        }else{
            System.out.println("sex:"+sex);
        }
    }
}
