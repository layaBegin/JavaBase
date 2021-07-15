package com.heima.demo01_xml;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

import java.io.File;
import java.util.List;

/**
 * xpath 也依赖dom4j jar包
 */
public class Demo03_xpath {
    public static void main(String[] args) throws DocumentException {
        SAXReader reader = new SAXReader();
        Document document = reader.read(new File("jinjieDay14_xml/src/student_Dom.xml"));
        Element rootElement = document.getRootElement();
        List<Element> list = rootElement.selectNodes("./student/name");
        for (Element element : list) {
            System.out.println(element.getText());
        }

    }
}
