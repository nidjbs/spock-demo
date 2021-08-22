package com.hyl.spock.demo.param;

/**
 * @author huayuanlin
 * @date 2021/08/22 17:34
 * @desc the class desc
 */
public class CreateOrderParam {

    private Integer userId;

    private Integer productTypeId;

    private Integer count;

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getProductTypeId() {
        return productTypeId;
    }

    public void setProductTypeId(Integer productTypeId) {
        this.productTypeId = productTypeId;
    }
}
