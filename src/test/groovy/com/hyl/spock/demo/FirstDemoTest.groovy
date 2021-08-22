package com.hyl.spock.demo

import spock.lang.Specification
import spock.lang.Unroll

@Unroll
class FirstDemoTest extends Specification {


    static class Person{
        private Integer id
        private String name
    }

    def "第一个简单demo 简单模式"() {
        // 预制数据，mock对象等等
        given:
        // 这种方式创建对象，很简洁 不用各种set
        def p = new Person(id: 11,name: "12312")
        // with语法 直接可以操作对象的方法
        p.with {
            println(id) // 访问属性
            println(it.name) // it代表当前对象引用，可以省略
            println(hashCode()) // 访问方法
        }
        // 对上一个标签的补充，可选，可写一些mock的返回值。
        and:
        println("and，可选")
        // 执行你的测试逻辑
        when:
        // 这里简单设置一下属性，一般来说这里写你需要测试的方法的调用。
        p.id = 999
        p.name = "hhh"
        // 校验你的逻辑是否成功（断言）
        then:
        with(p){
            // 测试断言
            id == 999
            name == "hhh"
        }
    }


}
