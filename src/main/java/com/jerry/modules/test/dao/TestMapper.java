package com.jerry.modules.test.dao;

import com.jerry.base.authority.entity.User;
import com.jerry.modules.test.vo.TestVO;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * Created by on 2019-08-22 00:03
 *
 * @Maintainance: jerryzshiyan@163.com
 * @author: Jerry
 * @Project: springboot-security-jwt-demo
 */
public interface TestMapper {

    User findById(@Param("id") long id);

    User findByUsername(String username);

    List<Map> listTest(TestVO testVO);

}
