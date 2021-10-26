package com.heima.test;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.client.RestTemplate;

@RunWith(SpringRunner.class)
@SpringBootTest
public class RestTemplateTest {
    @Autowired
    private RestTemplate restTemplate;

    /** 发送get请求 */
    @Test
    public void testSendGet() {
        String content = restTemplate.getForObject("https://www.jd.com",
                String.class);
        System.out.println("content = " + content);
    }

    @Test
    public void testSendGet2(){
        ResponseEntity<String> responseEntity = restTemplate.getForEntity("https://www.jd.com", String.class);
        String body = responseEntity.getBody();
        System.out.println("body=="+body);
        responseEntity.getStatusCode();
    }
    /** 发送post请求 */
    @Test
    public void testSendPost() {
        String content = restTemplate.postForObject("https://www.jd.com",
                HttpEntity.EMPTY, String.class);
        System.out.println("content = " + content);
    }
}
