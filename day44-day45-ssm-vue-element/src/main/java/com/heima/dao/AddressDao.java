package com.heima.dao;

import com.heima.entity.Address;
import com.heima.entity.PageBean;
import org.apache.ibatis.annotations.*;

import java.util.List;

public interface AddressDao {

    /**
     通过uid分页查询某个用户的地址
     */
    @Select("select * FROM tab_address WHERE uid=#{uid} LIMIT #{begin},#{size}")
    List<Address> findByUid(@Param("uid") int uid, @Param("begin") int begin, @Param("size") int size);

    /**
     * 通过uid查询某个用户收货地址总数
     * @param uid
     * @return
     */
    @Select("SELECT COUNT(*) FROM tab_address WHERE uid = #{uid}")
    int findCount(int uid);

    /**
     通过aid查询一个地址
     */
    Address findByAid(int aid);

    /**
     保存地址
     */
    @Insert("INSERT INTO tab_address VALUES(NULL,#{uid},#{contact},#{address},#{telephone},#{isdefault})")
    int save(Address address);

    /**
     * 更新当前用户所有的默认地址为0
     */
    @Update("UPDATE tab_address SET isdefault=0 WHERE uid=#{uid}")
    int updateAddressIsNotDefault(int uid);

    /**
     * 更新当前地址为默认1
     */
    @Update("UPDATE tab_address SET isdefault=1 WHERE aid=#{aid}")
    int updateAddressIsDefault(int aid);

    /**
     * 更新地址信息
     */
    @Update("UPDATE tab_address SET contact=#{contact},address=#{address},telephone=#{telephone} WHERE aid=#{aid}")
    int update(Address address);

    /**
     * 删除操作
     */
    @Delete("DELETE FROM tab_address WHERE aid=#{aid}")
    int delete(Integer aid);

    @Select("SELECT * FROM tab_address WHERE uid=#{uid} AND address LIKE CONCAT('%',#{address},'%') AND telephone LIKE CONCAT('%',#{telephone},'%')")
    List<Address> findLikeAddress(@Param("address") String address, @Param("telephone") String telephone,@Param("uid") int uid);
}
