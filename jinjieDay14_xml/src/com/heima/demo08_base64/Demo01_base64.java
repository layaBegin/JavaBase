package com.heima.demo08_base64;

import java.net.URLDecoder;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.util.Base64;

public class Demo01_base64 {
    public static void main(String[] args) {

        /*String s = URLEncoder.encode("和你人很好");
        System.out.println(s);
        String decode = URLDecoder.decode("%E5%92%8C%E4%BD%A0%E4%BA%BA%E5%BE%88%E5%A5%BD");
        System.out.println(decode);*/

        /*String string = Base64.getEncoder().encodeToString("黑马程序元".getBytes(StandardCharsets.UTF_8));
        System.out.println(string);
        byte[] decode = Base64.getDecoder().decode(string);
        System.out.println(new String(decode));*/

        /*String string1 = Base64.getUrlEncoder().encodeToString("而同样是大哥".getBytes(StandardCharsets.UTF_8));
        System.out.println(string1);//6ICM5ZCM5qC35piv5aSn5ZOl
        byte[] decode = Base64.getUrlDecoder().decode(string1);
        System.out.println(new String(decode));*/

        String string = Base64.getMimeEncoder().encodeToString("aerrrg".getBytes(StandardCharsets.UTF_8));
        System.out.println(string);
        byte[] decode = Base64.getMimeDecoder().decode(string);
        System.out.println(new String(decode));
        


    }
}
