package com.hyl.spock.demo.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

/**
 * @author huayuanlin
 * @date 2021/08/23 23:29
 * @desc the class desc
 */
@TableName("s_order")
public class OrderDO {

    @TableId(type = IdType.AUTO)
    private Integer id;

    private String orderNo;

    private String orderDesc;


    @Override
    public String toString() {
        return "OrderDO{" +
                "id=" + id +
                ", orderNo='" + orderNo + '\'' +
                ", orderDesc='" + orderDesc + '\'' +
                '}';
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getOrderNo() {
        return orderNo;
    }

    public void setOrderNo(String orderNo) {
        this.orderNo = orderNo;
    }

    public String getOrderDesc() {
        return orderDesc;
    }

    public void setOrderDesc(String orderDesc) {
        this.orderDesc = orderDesc;
    }
}
