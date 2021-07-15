package com.heima.demo01_xml;

import org.dom4j.Attribute;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

import java.io.File;
import java.util.List;

public class Demo01_dom4j {
    public static void main(String[] args) throws DocumentException {
        SAXReader reader = new SAXReader();
        Document document = reader.read(new File("jinjieDay14_xml/src/student_Dom.xml"));
        Element rootElement = document.getRootElement();
        List<Element> elements = rootElement.elements();
        for (Element element : elements) {
            Attribute id = element.attribute("id");
            Element name = element.element("name");
            System.out.println("id:"+id.getText());
            System.out.println("name:"+name.getText());
            Element age = element.element("age");
            String ageValue = age.getText();
            System.out.println("age:"+ageValue);

        }
    }
}
