package com.hyl.spock.demo.service.impl;

import com.hyl.spock.demo.client.ProductClient;
import com.hyl.spock.demo.client.UserClient;
import com.hyl.spock.demo.dao.OrderDAO;
import com.hyl.spock.demo.dto.ProductDTO;
import com.hyl.spock.demo.dto.UserDTO;
import com.hyl.spock.demo.param.CreateOrderParam;
import com.hyl.spock.demo.service.OrderService;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import javax.annotation.Resource;

/**
 * @author huayuanlin
 * @date 2021/08/22 17:37
 * @desc the class desc
 */
@Service
public class OrderServiceImpl implements OrderService {

    @Resource
    private OrderDAO orderDAO;

    @Resource
    private ProductClient productClient;

    @Resource
    private UserClient userClient;

    @Override
    public Integer createOrder(CreateOrderParam param) {
        checkParam(param);
        // 拿产品信息，做处理。。。 rpc
        ProductDTO productById = productClient.getProductById(param.getProductTypeId());
        if (productById.getRemain() <= 0) {
            throw new RuntimeException("库存不足");
        }
        // 拿用户信息，做处理。。。 rpc
        UserDTO userById = userClient.getUserById(param.getUserId());
        if (userById.getStatus() == -1) {
            // 测试异常情况
            throw new RuntimeException("用户在黑名单");
        }
        // 创建订单。。。 db
        Integer orderId = orderDAO.create();
        // 扣除库存。。。 todo
        return orderId;
    }


    public void checkParam(CreateOrderParam param) {
        if (param.getUserId() == null) {
            throw new BusinessException("10001","用户id参数错误");
        }
        if (param.getProductTypeId() == null) {
            throw new BusinessException("10002","产品id参数错误");
        }
        if (param.getCount()== null || param.getCount() <= 0) {
            throw new BusinessException("10003","产品数量参数错误");
        }
    }

    public static class BusinessException extends RuntimeException{

        private String code;

        public String getCode() {
            return code;
        }

        public void setCode(String code) {
            this.code = code;
        }

        public BusinessException() {
            super();
        }

        public BusinessException(String code,String message) {
            super(message);
            this.code = code;
        }

        public BusinessException(String message) {
            super(message);
        }

        public BusinessException(String message, Throwable cause) {
            super(message, cause);
        }

        public BusinessException(Throwable cause) {
            super(cause);
        }

        protected BusinessException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
            super(message, cause, enableSuppression, writableStackTrace);
        }
    }
}
