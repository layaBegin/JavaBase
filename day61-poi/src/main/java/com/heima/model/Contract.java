package com.heima.model;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Date;

/**
 * <p>
 * 
 * </p>
 *
 * @author itheima
 * @since 2021-06-26
 */
@Data
@TableName("co_contract")
public class Contract implements Serializable {

    private static final long serialVersionUID = 1L;

    private String id;  //主键

    private String contractNo;  //合同号

    private Date signingDate; //签约时间

    private String checkBy;  //审核人

    private double totalAmount; //总金额

    private String customName; //客户名称

    private Date shipTime; //船期

    private String companyName; //企业名称

    private String remark; //备注



}
