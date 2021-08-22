package com.hyl.spock.demo.service.impl

import com.hyl.spock.demo.client.ProductClient
import com.hyl.spock.demo.client.UserClient
import com.hyl.spock.demo.dao.OrderDAO
import com.hyl.spock.demo.dto.ProductDTO
import com.hyl.spock.demo.dto.UserDTO
import com.hyl.spock.demo.param.CreateOrderParam
import org.spockframework.spring.SpringBean
import org.spockframework.spring.SpringSpy
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import spock.lang.Specification
import spock.lang.Unroll

@SpringBootTest
class OrderServiceImplTest extends Specification {

    @Autowired
    private OrderServiceImpl orderService

    // 该注解是spock提供的，使用后ProductClient会变成mock的bean，这样就可以预制返回的数据，并不会真实调用
    @SpringBean
    ProductClient productClient = Mock()

    // 该注解是spock提供的，使用后如果你没有去为该bean预制返回数据，它会走真实的bean的逻辑，
    // 如果预制了 则会跟SpringBean效果一致
    @SpringSpy
    OrderDAO orderDAO

    @SpringBean
    UserClient userClient = Mock()
    /**
     * 该方法在本类的测试用例执行之前都会调用
     */
    void setup() {
        userClient.getUserById(_ as Integer) >> new UserDTO(id: 000, status: 1)
    }


    def "测试正常创建订单"() {
        given:
        def createOrderParam = new CreateOrderParam(userId: 11, productTypeId: 1)
        // mock返回值  _ 表示匹配任意Integer参数
        productClient.getProductById(_ as Integer) >> new ProductDTO(remain: 100)
        // 预制多次调用的返回值，可用集合表示（如果将该行注释，orderDAO.create()会走真实逻辑，也就是返回1）
        orderDAO.create() >> 100 >> 101
        when:
        def result1 = orderService.createOrder(createOrderParam)
        def result2 = orderService.createOrder(createOrderParam)
        then:
        result1 == 100
        result2 == 101
    }

    def "测试创建订单发生异常"() {
        given:
        def createOrderParam = new CreateOrderParam(userId: 11, productTypeId: 1)
        // mock返回值  _ 表示匹配任意Integer参数
        productClient.getProductById(_ as Integer) >> new ProductDTO(remain: -1)
        when:
        orderService.createOrder(createOrderParam)
        then:
        thrown(RuntimeException)
    }

    @Unroll
    def "where 模式测试#caseName"() {
        given:
        def createOrderParam = new CreateOrderParam(userId: userId, productTypeId: productTypeId, count: count)
        when:
        orderService.checkParam(createOrderParam)
        then:
        def exception = thrown(expectedException)
        expectedCode == exception.code
        where:
        caseName  | userId | productTypeId | count | expectedException                  | expectedCode
        "用户id为空"  | null   | 1             | 1     | OrderServiceImpl.BusinessException | "10001"
        "产品id为空"  | 1      | null          | 1     | OrderServiceImpl.BusinessException | "10002"
        "产品数量为负数" | 1      | 1             | -1    | OrderServiceImpl.BusinessException | "10003"
    }
}
