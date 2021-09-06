package com.heima.test;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;

public class TestXml {

    @Test
    public void test1() throws IOException {
        XmlMapper xmlMapper = new XmlMapper();
        InputStream resourceAsStream = TestXml.class.getResourceAsStream("/user.xml");
        Map map = xmlMapper.readValue(resourceAsStream, Map.class);//第二个参数可以是要封装成的对象
        System.out.println(map);
    }

    // map 结构生成 xml
    @Test
    public void writeXmlTest() throws JsonProcessingException {
        Map<String,Object> map = new HashMap();
        map.put("name","zhangshan");
        map.put("age",20);
        map.put("sex","male");
        XmlMapper xmlMapper = new XmlMapper();
        String s = xmlMapper.writer().withRootName("student").writeValueAsString(map);
        System.out.println(s);
    }
}
