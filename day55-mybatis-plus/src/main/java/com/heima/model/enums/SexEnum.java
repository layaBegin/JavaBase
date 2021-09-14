package com.heima.model.enums;

import com.baomidou.mybatisplus.annotation.IEnum;

//该枚举类则代表是性别
public enum SexEnum implements IEnum<Integer> { //IEnum这里的泛型就是指你插入到数据库的值类型
    //枚举值, 枚举值就是枚举类的对象 ,枚举值一定要是当前类的第一个语句
    MAN(1,"男"),WOMAN(2,"女");

    private Integer  value; //数据库真实存储的值  1表示男， 2 表示女

    private String desc; // 性别描述信息

    SexEnum(Integer value, String desc) {
        this.value = value;
        this.desc = desc;
    }


    //这个方法的返回值就是真实插入到数据库中的值
    @Override
    public Integer getValue() {
        return this.value;
    }

    @Override
    public String toString() {
        return this.desc;
    }
}
