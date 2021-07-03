package com.heima.demo01_char_buffer;

import java.io.*;
import java.util.*;

public class BufferWriterDemo02 {
    public static void main(String[] args)  {
        List<String> listNum = new ArrayList<>();
        Collections.addAll(listNum,"一","二","三","四","五","陆","柒","八","九","十","十一","十二");
        try (
                FileReader fr = new FileReader("jinjieDay11_bufferedStream/src/test11.txt");
                FileWriter fw = new FileWriter("jinjieDay11_bufferedStream/src/test12.txt");
                BufferedReader br = new BufferedReader(fr);
                BufferedWriter bw = new BufferedWriter(fw);
        ){
            List<String> list = new ArrayList<>();
            String  str;
            while ((str = br.readLine()) != null){
                list.add(str);
               /* bw.write(str);
                bw.newLine();*/
            }
            Collections.sort(list, new Comparator<String>() {
                @Override
                public int compare(String o1, String o2) {
                    return  listNum.indexOf(o1.substring(0,o1.indexOf("."))) -   listNum.indexOf(o2.substring(0,o2.indexOf(".")));
                }
            });
            for (String s : list) {
                bw.write(s);
                bw.newLine();
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
