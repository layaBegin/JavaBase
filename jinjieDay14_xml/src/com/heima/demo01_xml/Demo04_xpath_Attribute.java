package com.heima.demo01_xml;

import org.dom4j.*;
import org.dom4j.io.SAXReader;

import java.io.File;
import java.util.List;

/**
 * xpath 也依赖dom4j jar包
 */
public class Demo04_xpath_Attribute {
    public static void main(String[] args) throws DocumentException {
        SAXReader reader = new SAXReader();
        Document document = reader.read(new File("jinjieDay14_xml/src/student.xml"));
        /**
         * 属性检索
         */
        List<Attribute> list = document.selectNodes("//@id");
        for (Attribute attribute : list) {
            System.out.println(attribute.getText());
        }

        // //元素[@属性]
        List<Node> list1 = document.selectNodes("//student[@id]");
        for (Node node : list1) {
            System.out.println(node.getName());
        }

        System.out.println("-----------");
        // //元素[@属性 = 值]
        List<Node> list2 = document.selectNodes("//student[@id = 1]");
        for (Node node : list2) {
            System.out.println(node.getName());
        }
    }
}
