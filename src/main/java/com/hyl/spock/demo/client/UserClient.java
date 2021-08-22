package com.hyl.spock.demo.client;

import com.hyl.spock.demo.dto.UserDTO;
import org.springframework.stereotype.Component;

/**
 * @author huayuanlin
 * @date 2021/08/22 17:35
 * @desc the class desc
 */
@Component
public class UserClient {

    public UserDTO getUserById(Integer id) {
        // rpc...
        UserDTO user = new UserDTO();
        user.setId(111);
        user.setName("测试用户");
        return user;
    }

}
