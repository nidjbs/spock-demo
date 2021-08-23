package com.hyl.spock.demo.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.hyl.spock.demo.entity.OrderDO;
import org.springframework.stereotype.Component;

/**
 * @author huayuanlin
 * @date 2021/08/22 17:30
 * @desc the class desc
 */
@Component
public interface OrderDAO extends BaseMapper<OrderDO> {


    default Integer create() {
        // db...
        return 1;
    }




}
