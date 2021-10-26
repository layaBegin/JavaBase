package com.heima.model;

import lombok.Data;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.CompoundIndex;
import org.springframework.data.mongodb.core.index.IndexDirection;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

@Data
@Document("user")//如果实体类与表名不对应我们需要使用@Document注解去指定
@CompoundIndex(def = "{age:1,username:1}")  //@CompoundIndex 创建复合索引的注解,如果没用则创建，有就不做任何的操作
/* 创建多个复合索引
@CompoundIndexes({
        @CompoundIndex(def = "{age:1,username:1}"),
        @CompoundIndex(def = )
})*/
public class User {

    @Id //代表该列是主键列，列名与属性名不需要对应
    private ObjectId objectId;//主键，主键列的类型ObjectId

    //如果属性名与列表没有对应.,需要使用@Filed注解去指定列名
    @Field("id")
    private Integer id;

    private String username;

    @Indexed(direction = IndexDirection.DESCENDING) //该注解用于创建单例索引的，每次在使用到该实体类的时候都会去检查
    //该实体类对应集合（表）是否存在该索引，如果不存在那么就会创建
    private Integer age;
}

