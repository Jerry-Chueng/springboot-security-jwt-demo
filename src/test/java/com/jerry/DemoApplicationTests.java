package com.jerry;

import com.alibaba.fastjson.JSON;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.jerry.base.authority.dao.MenuMapper;
import com.jerry.base.authority.dao.RoleMapper;
import com.jerry.base.authority.dao.UserMapper;
import com.jerry.base.authority.entity.User;
import com.jerry.base.common.entity.PageResult;
import com.jerry.modules.test.dao.TestMapper;
import com.jerry.modules.test.vo.TestVO;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Map;

@RunWith(SpringRunner.class)
@SpringBootTest
@Slf4j
public class DemoApplicationTests {

	@Autowired
	private UserMapper userMapper;

	@Autowired
	private RoleMapper roleMapper;

	@Autowired
	private MenuMapper privilegeMapper;

	@Autowired
	private TestMapper testMapper;

	@Test
	public void contextLoad(){

		TestVO testVO = new TestVO();
		int currentPage = 2;
		int pageSize = 20;
		testVO.setCurrentPage(currentPage);
		testVO.setPageSize(pageSize);
		//利用分页工具开始分页
		PageInfo<Map> pageInfo = PageHelper.startPage(currentPage, pageSize).doSelectPageInfo(()->testMapper.listTest(testVO));
		Page<Map> page = PageHelper.startPage(currentPage, pageSize).doSelectPage(()-> testMapper.listTest(testVO));
//		List<Map> list = testMapper.listTest(testVO);
//		PageInfo<Map> pageInfo = new PageInfo<>(list);
		//创建分页对象
		PageResult pageResult = new PageResult(pageInfo.getTotal(), pageInfo.getList(), currentPage, pageSize);
		PageResult pageResult2 = new PageResult(page.getTotal(), page.getResult(), currentPage, pageSize);
		log.info(JSON.toJSONString(pageResult));
		log.info(JSON.toJSONString(pageResult2));

//		User user = userMapper.findById(1L);
//		System.out.println(user.toString());
//
//		User user1 = testMapper.findById(1);
//		System.out.println(user1.toString());
	}

	@Test
	public void select(){
		User user = userMapper.findById(1l);
		System.out.println(JSON.toJSONString(user));
	}
}
