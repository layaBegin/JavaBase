package com.heima.controller;

import com.heima.dao.AddressDao;
import com.heima.entity.Address;
import com.heima.entity.PageBean;
import com.heima.entity.ResultInfo;
import com.heima.entity.User;
import com.heima.service.AddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/address")
public class AddressController {
    @Autowired
    private AddressService addressService;

    @RequestMapping("/find")
    public ResultInfo findAllAddress(@RequestBody Map<String, Object> map, HttpSession session){
        System.out.println("查询所有用户的地址:"+map);
        int current = (int) map.get("current");
        int size = (int) map.get("size");
        String sAddress= (String) map.get("address");
        String telephone = (String) map.get("telephone");
        User user = (User) session.getAttribute("user");
        int uid = user.getUid() ;
        PageBean<Address> address = addressService.findAddress(current, size, uid,sAddress,telephone);
        return new ResultInfo(true,"查询地址成功",address);
    }



    @RequestMapping("/save")
    public ResultInfo saveAddress(@RequestBody Address address,HttpSession session){
        System.out.println("地址的信息："+address);
        User user = (User) session.getAttribute("user");
        int uid = user.getUid();
        address.setUid(uid);

        addressService.save(address);
        return new ResultInfo(true,"添加地址成功");
    }

    @RequestMapping("/update")
    public ResultInfo updateAddress(@RequestBody Address address){
        addressService.update(address);
        return new ResultInfo(true,"更新地址成功");
    }

    @RequestMapping("/default")
    public ResultInfo changeDefault(Integer aid,HttpSession session){
        User user = (User) session.getAttribute("user");
        int uid = user.getUid();
        addressService.changeDefaultAddress(uid,aid);
        System.out.println("切换默认地址成功");
        return new ResultInfo(true,"切换默认地址成功");
    }

    @RequestMapping("/delete")
    public  ResultInfo delete(Integer aid){
        addressService.delete(aid);
        return new ResultInfo(true,"删除成功");
    }
}
