package com.hyl.spock.demo.service;

import com.hyl.spock.demo.param.CreateOrderParam;

/**
 * @author huayuanlin
 * @date 2021/08/22 17:31
 * @desc the interface desc
 */
public interface OrderService {

    public Integer createOrder(CreateOrderParam param);

}
