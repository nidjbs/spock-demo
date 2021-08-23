package com.hyl.spock.demo

import com.baomidou.mybatisplus.autoconfigure.MybatisPlusAutoConfiguration
import com.hyl.spock.demo.dao.OrderDAO
import com.hyl.spock.demo.entity.OrderDO
import com.hyl.spock.demo.service.impl.OrderServiceImpl
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.test.context.jdbc.Sql
import spock.lang.Specification

@SpringBootTest
class H2WithSpringTest extends Specification{

    @Autowired
    OrderServiceImpl orderService

    @Autowired
    OrderDAO orderDAO

    @Sql("classpath:ut-sql/test.sql")
    def "测试"() {
        when:
        orderService.updateOrder(1,"hhh")
        OrderDO selectById = orderDAO.selectById(1)
        then:
        selectById.with {
            orderNo == "hhhh"
        }
    }


}
