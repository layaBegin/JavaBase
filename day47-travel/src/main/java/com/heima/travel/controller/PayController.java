package com.heima.travel.controller;

import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import com.heima.travel.service.OrderService;
import com.heima.travel.utils.PayUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.ServletInputStream;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/pay")
public class PayController {
    @Autowired
    private OrderService orderService;

    @RequestMapping("/createUrl")
    public String createUrl(String oid,double total){
        String url = PayUtils.createOrder(oid, (int) 2);//金额先写死，2 表示0.02元
        return url;
    }

    /**
     * 微信的回调函数，通知我们订单号和支付状态
     * @param request
     * @return
     */
    @RequestMapping("/payNotify")
    public Map<String,String> payNotify(HttpServletRequest request) throws IOException {
        ServletInputStream inputStream = request.getInputStream();
        XmlMapper xmlMapper = new XmlMapper();
        Map map = xmlMapper.readValue(inputStream, Map.class);
        orderService.updateState(map);


        //4,通知微信支付 已经调用了我的函数
        Map<String,String> resultMap = new HashMap<>();
        resultMap.put("return_code","SUCCESS");
        resultMap.put("return_msg","OK");
        //返回给微信 成功
        return  resultMap;
    }

    @RequestMapping("/findStatus")
    public boolean findStatus(String oid){
        boolean pay = orderService.isPay(oid);
        return pay;
    }
}
