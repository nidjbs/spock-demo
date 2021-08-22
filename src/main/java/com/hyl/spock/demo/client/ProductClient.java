package com.hyl.spock.demo.client;

import com.hyl.spock.demo.dto.ProductDTO;
import org.springframework.stereotype.Component;

/**
 * @author huayuanlin
 * @date 2021/08/22 17:36
 * @desc the class desc
 */
@Component
public class ProductClient {

    public ProductDTO getProductById(Integer id){
        // rpc。。。
        ProductDTO product = new ProductDTO();
        product.setId(111);
        product.setName("测试产品");
        product.setRemain(100);
        return product;
    }

}
