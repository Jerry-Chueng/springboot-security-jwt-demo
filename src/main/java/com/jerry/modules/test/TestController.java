package com.jerry.modules.test;

import com.jerry.modules.test.vo.TestVO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;

@Api(value = "测试",tags = "测试操作操作相关接口")
@Slf4j
@RestController
@RequestMapping("/test")
public class TestController {

	/**
	 * 获取
	 * @param id
	 * @return
	 */
	@ApiOperation(value = "测试",notes = "GetMapping测试接口id")
	@GetMapping("/menu/{id}")
	@PreAuthorize("hasPermission('test','test1')")
	public HashMap menu(@PathVariable Long id) {
		return new HashMap<String,String>(){{put("test","GetMapping id");}};
	}

	/**
	 * 获取
	 * @return
	 */
	@ApiOperation(value = "测试",notes = "GetMapping测试接口")
	@GetMapping("/menu1")
	@PreAuthorize("hasRole('ROLE_ADMIN')")
	public HashMap menu1() {
		return new HashMap<String,String>(){{put("test","GetMapping");}};
	}

	/**
	 * 新建
	 * @return
	 */
	@ApiOperation(value = "测试",notes = "PostMapping测试接口")
	@PostMapping("/menu")
	public HashMap menu2(@RequestBody @ApiParam(name = "查询参数",value = "传入json格式")
									 TestVO testVO) {
		log.info("{}",testVO.toString());
		return new HashMap<String,String>(){{put("test","PostMapping");}};
	}

	/**
	 * 更新
	 * @return
	 */
	@ApiOperation(value = "测试",notes = "PutMapping测试接口")
	@PutMapping("/menu")
	public HashMap menu3() {
		return new HashMap<String,String>(){{put("test","PutMapping");}};
	}

	/**
	 * 部分更新
	 * @return
	 */
	@ApiOperation(value = "测试",notes = "PatchMapping测试接口")
	@PatchMapping("/menu")
	public HashMap menu5() {
		return new HashMap<String,String>(){{put("test","PatchMapping");}};
	}

	/**
	 * 删除
	 * @param id
	 * @return
	 */
	@ApiOperation(value = "测试",notes = "DeleteMapping测试接口")
	@DeleteMapping("/menu/{id}")
	public HashMap menu4(@PathVariable Long id) {
		log.info("{}",id);
		return new HashMap<String,String>(){{put("test","DeleteMapping");}};
	}

}
