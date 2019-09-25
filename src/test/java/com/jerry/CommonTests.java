package com.jerry;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.jerry.base.authority.entity.Menu;
import com.jerry.base.common.entity.Constant;
import com.jerry.base.common.entity.Response;
import com.jerry.base.authority.entity.User;
import com.jerry.base.authority.manager.MenuManager;
import org.junit.Test;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.util.AntPathMatcher;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.*;
import java.util.function.Consumer;


public class CommonTests {

	@Test
	public void testPasswordEncoder() {
		String pwd = "1qaz2wsx";
		BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
		String password = encoder.encode(pwd);
		System.out.println(password);
		System.out.println(encoder.matches(pwd,password));

//		String salt = BCrypt.gensalt();
//		System.out.println(salt);

//		PasswordEncoder passwordEncoder = PasswordEncoderFactories.createDelegatingPasswordEncoder();
//		String encryptPwd = passwordEncoder.encode(pwd);
//		System.out.println(encryptPwd);

	}

	@Test
	public void test1() {
		String requestUrl = "/path/jjjj";
		AntPathMatcher antPathMatcher = new AntPathMatcher();
		System.out.println(antPathMatcher.match("/path/**",requestUrl));
	}

	@Test
	public void test2() {
		User user = new User();
		user.setAge(10);
		Response<User> response = new Response<>(user,0,"janasidnf","asdf");
		System.out.println(response.toString());
	}

	@Test
	public void test3(){
//		Function<Integer,Integer> A= i->i+1;
//		Function<Integer,Integer> B=i->i*i;
//		System.out.println("F1:"+B.apply(A.apply(5)));
//		System.out.println("F1:"+B.compose(A).apply(5));
//		System.out.println("F2:"+A.apply(B.apply(5)));
//		System.out.println("F2:"+B.andThen(A).apply(5));
//		System.out.println("F3:"+B.compose(A).compose(A).andThen(A).apply(5));

		List<String> list = Arrays.asList("1","2","3");
		String ss = "asdf";
		Consumer<String> cu = s -> s += "qw";
		cu.accept(ss);
//		list.forEach(cu);

//		System.out.println(JSON.toJSONString(list));
		System.out.println(ss);

	}

	@Test
	public void test4(){
		String json = "[{\"path\":\"/\",\"name\":\"otherRouter\",\"redirect\":\"/home\",\"component\":{\"components\":{\"shrinkableMenu\":{\"name\":\"shrinkableMenu\",\"components\":{\"sidebarMenu\":{\"name\":\"sidebarMenu\",\"props\":{\"menuList\":{},\"iconSize\":{},\"menuTheme\":{\"default\":\"dark\"},\"openNames\":{}},\"methods\":{},\"watch\":{},\"staticRenderFns\":[],\"_compiled\":true,\"beforeCreate\":[null],\"beforeDestroy\":[null],\"__file\":\"src/views/main-components/shrinkable-menu/components/sidebarMenu.vue\",\"_Ctor\":{}},\"sidebarMenuShrink\":{\"name\":\"sidebarMenuShrink\",\"props\":{\"menuList\":{},\"iconColor\":{\"default\":\"white\"},\"menuTheme\":{\"default\":\"dark\"}},\"methods\":{},\"staticRenderFns\":[],\"_compiled\":true,\"beforeCreate\":[null],\"beforeDestroy\":[null],\"__file\":\"src/views/main-components/shrinkable-menu/components/sidebarMenuShrink.vue\",\"_Ctor\":{}}},\"props\":{\"shrink\":{\"default\":false},\"menuList\":{\"required\":true},\"theme\":{\"default\":\"dark\"},\"beforePush\":{},\"openNames\":{}},\"computed\":{},\"methods\":{},\"staticRenderFns\":[],\"_compiled\":true,\"beforeCreate\":[null],\"beforeDestroy\":[null],\"__file\":\"src/views/main-components/shrinkable-menu/shrinkable-menu.vue\",\"_Ctor\":{}},\"tagsPageOpened\":{\"name\":\"tagsPageOpened\",\"props\":{\"pageTagsList\":{},\"beforePush\":{}},\"computed\":{},\"methods\":{},\"watch\":{},\"staticRenderFns\":[],\"_compiled\":true,\"beforeCreate\":[null],\"beforeDestroy\":[null],\"__file\":\"src/views/main-components/tags-page-opened.vue\",\"_Ctor\":{}},\"breadcrumbNav\":{\"name\":\"breadcrumbNav\",\"props\":{\"currentPath\":{}},\"methods\":{},\"staticRenderFns\":[],\"_compiled\":true,\"beforeCreate\":[null],\"beforeDestroy\":[null],\"__file\":\"src/views/main-components/breadcrumb-nav.vue\",\"_Ctor\":{}},\"fullScreen\":{\"name\":\"fullScreen\",\"props\":{\"value\":{\"default\":false}},\"computed\":{},\"methods\":{},\"staticRenderFns\":[],\"_compiled\":true,\"beforeCreate\":[null],\"beforeDestroy\":[null],\"__file\":\"src/views/main-components/fullscreen.vue\",\"_Ctor\":{}},\"lockScreen\":{\"name\":\"lockScreen\",\"props\":{\"value\":{\"default\":false}},\"methods\":{},\"staticRenderFns\":[],\"_compiled\":true,\"beforeCreate\":[null],\"beforeDestroy\":[null],\"__file\":\"src/views/main-components/lockscreen/lockscreen.vue\",\"_Ctor\":{}},\"scrollBar\":{\"name\":\"scrollBar\",\"props\":{\"speed\":{\"default\":20},\"scrollXStyle\":{},\"disScrollX\":{\"default\":false},\"disScrollY\":{\"default\":false},\"scrollYStyle\":{},\"scrollXType\":{\"default\":\"cover\"},\"scrollYType\":{\"default\":\"cover\"},\"showAll\":{\"default\":false}},\"computed\":{},\"methods\":{},\"staticRenderFns\":[],\"_compiled\":true,\"beforeCreate\":[null],\"beforeDestroy\":[null],\"__file\":\"src/views/my-components/scroll-bar/vue-scroller-bars/scroll-bar.vue\",\"_Ctor\":{}}},\"computed\":{},\"stompClient\":{\"monitorIntervalTime\":100,\"stompReconnect\":true},\"methods\":{},\"watch\":{},\"staticRenderFns\":[],\"_compiled\":true,\"beforeCreate\":[null],\"beforeDestroy\":[null],\"__file\":\"src/views/Main.vue\",\"_Ctor\":{}},\"children\":[{\"path\":\"home\",\"title\":\"作业结果管理\",\"name\":\"home_index\"},{\"path\":\"ownspace\",\"title\":\"个人中心\",\"name\":\"ownspace_index\"},{\"path\":\"test\",\"title\":\"测试\",\"name\":\"test\"},{\"path\":\"reportNeResult\",\"title\":\"执行结果查询\",\"name\":\"reportNeResult\"},{\"path\":\"reportCheck\",\"title\":\"检查结果查询\",\"name\":\"reportCheck\"},{\"path\":\"reportParse\",\"title\":\"解析数据查询\",\"name\":\"reportParse\"},{\"path\":\"change-pass\",\"title\":\"修改密码\",\"name\":\"change_pass\"}]},{\"id\":81,\"createTime\":\"2019-01-08 17:48:37\",\"updateTime\":\"2019-05-17 10:13:38\",\"name\":\"job\",\"level\":1,\"type\":0,\"title\":\"例行作业\",\"path\":\"/job\",\"icon\":\"md-copy\",\"buttonType\":\"\",\"parentId\":null,\"description\":\"\",\"sortOrder\":100,\"status\":0,\"children\":[{\"id\":90,\"createTime\":\"2019-01-08 18:01:33\",\"updateTime\":\"2019-01-08 18:01:33\",\"name\":\"whiteList\",\"level\":2,\"type\":0,\"title\":\"指令白名单\",\"path\":\"whiteList\",\"icon\":\"md-calculator\",\"buttonType\":\"\",\"parentId\":81,\"description\":null,\"sortOrder\":1.6,\"status\":0,\"children\":null,\"permTypes\":[\"add\",\"delete\"],\"expand\":true,\"checked\":false,\"selected\":false,\"meta\":{\"permTypes\":[\"add\",\"delete\"],\"title\":\"指令白名单\",\"url\":null}},{\"id\":89,\"createTime\":\"2019-01-08 18:01:17\",\"updateTime\":\"2019-05-17 10:21:16\",\"name\":\"orderAnalysis\",\"level\":2,\"type\":0,\"title\":\"指令解析定义\",\"path\":\"orderAnalysis\",\"icon\":\"md-attach\",\"buttonType\":\"\",\"parentId\":81,\"description\":\"\",\"sortOrder\":1.5,\"status\":0,\"children\":null,\"permTypes\":[\"copy\",\"add\",\"edit\",\"view\",\"delete\",\"stop\",\"input\",\"output\"],\"expand\":true,\"checked\":false,\"selected\":false,\"meta\":{\"permTypes\":[\"copy\",\"add\",\"edit\",\"view\",\"delete\",\"stop\",\"input\",\"output\"],\"title\":\"指令解析定义\",\"url\":null}},{\"id\":88,\"createTime\":\"2019-01-08 18:01:03\",\"updateTime\":\"2019-05-17 10:20:59\",\"name\":\"orderSet\",\"level\":2,\"type\":0,\"title\":\"指令集定义\",\"path\":\"orderSet\",\"icon\":\"ios-build-outline\",\"buttonType\":\"\",\"parentId\":81,\"description\":\"\",\"sortOrder\":1.4,\"status\":0,\"children\":null,\"permTypes\":[\"check\",\"add\",\"edit\",\"copy\",\"view\",\"delete\",\"stop\",\"input\",\"output\"],\"expand\":true,\"checked\":false,\"selected\":false,\"meta\":{\"permTypes\":[\"check\",\"add\",\"edit\",\"copy\",\"view\",\"delete\",\"stop\",\"input\",\"output\"],\"title\":\"指令集定义\",\"url\":null}},{\"id\":87,\"createTime\":\"2019-01-08 18:00:49\",\"updateTime\":\"2019-05-17 10:17:08\",\"name\":\"routineJob\",\"level\":2,\"type\":0,\"title\":\"例行作业定义\",\"path\":\"routineJob\",\"icon\":\"ios-book-outline\",\"buttonType\":\"\",\"parentId\":81,\"description\":\"\",\"sortOrder\":1.3,\"status\":0,\"children\":null,\"permTypes\":[\"add\",\"view\",\"edit\",\"enable\",\"stop\",\"runTask\",\"delete\"],\"expand\":true,\"checked\":false,\"selected\":false,\"meta\":{\"permTypes\":[\"add\",\"view\",\"edit\",\"enable\",\"stop\",\"runTask\",\"delete\"],\"title\":\"例行作业定义\",\"url\":null}},{\"id\":86,\"createTime\":\"2019-01-08 18:00:22\",\"updateTime\":\"2019-05-17 10:22:40\",\"name\":\"realTime\",\"level\":2,\"type\":0,\"title\":\"实时作业管理\",\"path\":\"realTime\",\"icon\":\"md-clipboard\",\"buttonType\":\"\",\"parentId\":81,\"description\":\"\",\"sortOrder\":1.2,\"status\":0,\"children\":null,\"permTypes\":[\"view\",\"stop\"],\"expand\":true,\"checked\":false,\"selected\":false,\"meta\":{\"permTypes\":[\"view\",\"stop\"],\"title\":\"实时作业管理\",\"url\":null}},{\"id\":84,\"createTime\":\"2019-01-08 17:49:54\",\"updateTime\":\"2019-05-17 10:16:56\",\"name\":\"jobResult\",\"level\":2,\"type\":0,\"title\":\"作业结果管理\",\"path\":\"jobResult\",\"icon\":\"ios-beer-outline\",\"buttonType\":\"\",\"parentId\":81,\"description\":\"\",\"sortOrder\":1.1,\"status\":0,\"children\":null,\"permTypes\":[\"view\",\"taskDetail\"],\"expand\":true,\"checked\":false,\"selected\":false,\"meta\":{\"permTypes\":[\"view\",\"taskDetail\"],\"title\":\"作业结果管理\",\"url\":null}},{\"id\":92,\"createTime\":\"2019-01-17 16:16:19\",\"updateTime\":\"2019-05-17 10:21:46\",\"name\":\"report\",\"level\":2,\"type\":0,\"title\":\"例行作业报表\",\"path\":\"report\",\"icon\":\"ios-barcode-outline\",\"buttonType\":\"\",\"parentId\":81,\"description\":\"\",\"sortOrder\":1,\"status\":0,\"children\":null,\"permTypes\":[\"executeAsk\",\"checkAsk\",\"analysisAsk\"],\"expand\":true,\"checked\":false,\"selected\":false,\"meta\":{\"permTypes\":[\"executeAsk\",\"checkAsk\",\"analysisAsk\"],\"title\":\"例行作业报表\",\"url\":null}},{\"id\":125,\"createTime\":\"2019-08-28 15:05:59\",\"updateTime\":\"2019-08-28 15:05:59\",\"name\":\"blackList\",\"level\":2,\"type\":0,\"title\":\"指令黑名单\",\"path\":\"blackList\",\"icon\":\"ios-body\",\"buttonType\":\"\",\"parentId\":81,\"description\":null,\"sortOrder\":0.99,\"status\":0,\"children\":null,\"permTypes\":[\"add\",\"delete\"],\"expand\":true,\"checked\":false,\"selected\":false,\"meta\":{\"permTypes\":[\"add\",\"delete\"],\"title\":\"指令黑名单\",\"url\":null}},{\"id\":108,\"createTime\":\"2019-07-31 17:45:37\",\"updateTime\":\"2019-08-28 11:03:10\",\"name\":\"customStatistic\",\"level\":2,\"type\":0,\"title\":\"定制统计分析\",\"path\":\"customStatistic\",\"icon\":\"ios-stats\",\"buttonType\":\"\",\"parentId\":81,\"description\":\"\",\"sortOrder\":0.2,\"status\":0,\"children\":null,\"permTypes\":[\"edit\",\"view\",\"delete\",\"add\",\"download\"],\"expand\":true,\"checked\":false,\"selected\":false,\"meta\":{\"permTypes\":[\"edit\",\"view\",\"delete\",\"add\",\"download\"],\"title\":\"定制统计分析\",\"url\":null}}],\"permTypes\":null,\"expand\":true,\"checked\":false,\"selected\":false,\"meta\":{\"permTypes\":null,\"title\":\"例行作业\",\"url\":null}},{\"id\":94,\"createTime\":\"2019-02-21 16:09:01\",\"updateTime\":\"2019-05-17 10:27:15\",\"name\":\"devops\",\"level\":1,\"type\":0,\"title\":\"智能流程\",\"path\":\"/devops\",\"icon\":\"ios-boat-outline\",\"buttonType\":\"\",\"parentId\":null,\"description\":\"\",\"sortOrder\":99.5,\"status\":0,\"children\":[{\"id\":95,\"createTime\":\"2019-02-21 16:10:20\",\"updateTime\":\"2019-07-04 15:12:45\",\"name\":\"flow\",\"level\":2,\"type\":0,\"title\":\"流程定义\",\"path\":\"flow\",\"icon\":\"ios-cloudy-outline\",\"buttonType\":\"\",\"parentId\":94,\"description\":\"\",\"sortOrder\":3,\"status\":0,\"children\":null,\"permTypes\":[\"view\",\"check\",\"add\",\"copy\",\"flow\",\"stop\",\"delete\"],\"expand\":true,\"checked\":false,\"selected\":false,\"meta\":{\"permTypes\":[\"view\",\"check\",\"add\",\"copy\",\"flow\",\"stop\",\"delete\"],\"title\":\"流程定义\",\"url\":null}},{\"id\":101,\"createTime\":\"2019-05-16 14:35:46\",\"updateTime\":\"2019-05-17 10:23:40\",\"name\":\"procedure\",\"level\":2,\"type\":0,\"title\":\"流程结果\",\"path\":\"procedure\",\"icon\":\"logo-codepen\",\"buttonType\":\"\",\"parentId\":94,\"description\":\"\",\"sortOrder\":2,\"status\":0,\"children\":null,\"permTypes\":[],\"expand\":true,\"checked\":false,\"selected\":false,\"meta\":{\"permTypes\":[],\"title\":\"流程结果\",\"url\":null}},{\"id\":128,\"createTime\":\"2019-08-30 14:53:21\",\"updateTime\":\"2019-08-30 16:29:43\",\"name\":\"procetask\",\"level\":2,\"type\":0,\"title\":\"流程任务\",\"path\":\"procetask\",\"icon\":\"ios-list-box\",\"buttonType\":\"\",\"parentId\":94,\"description\":\"\",\"sortOrder\":1,\"status\":0,\"children\":null,\"permTypes\":[],\"expand\":true,\"checked\":false,\"selected\":false,\"meta\":{\"permTypes\":[],\"title\":\"流程任务\",\"url\":null}}],\"permTypes\":null,\"expand\":true,\"checked\":false,\"selected\":false,\"meta\":{\"permTypes\":null,\"title\":\"智能流程\",\"url\":null}},{\"id\":35,\"createTime\":\"2018-09-13 13:44:13\",\"updateTime\":\"2019-05-17 10:18:36\",\"name\":\"backupConfig\",\"level\":1,\"type\":0,\"title\":\"备份管理\",\"path\":\"/backup\",\"icon\":\"ios-basket-outline\",\"buttonType\":\"\",\"parentId\":null,\"description\":\"\",\"sortOrder\":99,\"status\":0,\"children\":[{\"id\":78,\"createTime\":\"2018-11-09 15:38:53\",\"updateTime\":\"2018-11-09 15:38:54\",\"name\":\"backup-backpass\",\"level\":2,\"type\":0,\"title\":\"备份回传管理\",\"path\":\"backup-backpass\",\"icon\":\"md-arrow-round-back\",\"buttonType\":\"\",\"parentId\":35,\"description\":null,\"sortOrder\":2.4,\"status\":0,\"children\":null,\"permTypes\":[],\"expand\":true,\"checked\":false,\"selected\":false,\"meta\":{\"permTypes\":[],\"title\":\"备份回传管理\",\"url\":null}},{\"id\":77,\"createTime\":\"2018-11-06 16:45:57\",\"updateTime\":\"2018-11-06 16:45:59\",\"name\":\"backup-job-detail-config\",\"level\":2,\"type\":0,\"title\":\"备份策略配置\",\"path\":\"backup-job-detail-config\",\"icon\":\"ios-locate\",\"buttonType\":\"\",\"parentId\":35,\"description\":null,\"sortOrder\":2.3,\"status\":0,\"children\":null,\"permTypes\":[],\"expand\":true,\"checked\":false,\"selected\":false,\"meta\":{\"permTypes\":[],\"title\":\"备份策略配置\",\"url\":null}},{\"id\":76,\"createTime\":\"2018-11-01 16:30:13\",\"updateTime\":\"2018-11-01 16:30:15\",\"name\":\"connection-log-detail\",\"level\":2,\"type\":0,\"title\":\"网元日志详情\",\"path\":\"connection-log-detail\",\"icon\":\"ios-list-box\",\"buttonType\":\"\",\"parentId\":35,\"description\":null,\"sortOrder\":2.2,\"status\":0,\"children\":null,\"permTypes\":[],\"expand\":true,\"checked\":false,\"selected\":false,\"meta\":{\"permTypes\":[],\"title\":\"网元日志详情\",\"url\":null}},{\"id\":75,\"createTime\":\"2018-11-01 16:28:59\",\"updateTime\":\"2018-11-01 16:29:01\",\"name\":\"connection-detail\",\"level\":2,\"type\":0,\"title\":\"网元列表详情\",\"path\":\"connection-detail\",\"icon\":\"md-git-network\",\"buttonType\":\"\",\"parentId\":35,\"description\":null,\"sortOrder\":2.1,\"status\":0,\"children\":null,\"permTypes\":[],\"expand\":true,\"checked\":false,\"selected\":false,\"meta\":{\"permTypes\":[],\"title\":\"网元列表详情\",\"url\":null}},{\"id\":74,\"createTime\":\"2018-10-30 17:03:58\",\"updateTime\":\"2018-10-30 17:04:00\",\"name\":\"backup-strange-log\",\"level\":2,\"type\":0,\"title\":\"异地备份日志\",\"path\":\"backup-strange-log\",\"icon\":\"ios-barcode\",\"buttonType\":\"\",\"parentId\":35,\"description\":null,\"sortOrder\":2,\"status\":0,\"children\":null,\"permTypes\":[],\"expand\":true,\"checked\":false,\"selected\":false,\"meta\":{\"permTypes\":[],\"title\":\"异地备份日志\",\"url\":null}},{\"id\":73,\"createTime\":\"2018-10-30 14:06:31\",\"updateTime\":\"2018-10-30 14:06:32\",\"name\":\"backup-connection\",\"level\":2,\"type\":0,\"title\":\"备份网元管理\",\"path\":\"backup-connection\",\"icon\":\"md-crop\",\"buttonType\":\"\",\"parentId\":35,\"description\":null,\"sortOrder\":1.9,\"status\":0,\"children\":null,\"permTypes\":[],\"expand\":true,\"checked\":false,\"selected\":false,\"meta\":{\"permTypes\":[],\"title\":\"备份网元管理\",\"url\":null}},{\"id\":57,\"createTime\":\"2018-10-23 10:05:16\",\"updateTime\":\"2018-10-23 10:05:16\",\"name\":\"backup-strange\",\"level\":2,\"type\":0,\"title\":\"异地备份管理\",\"path\":\"backup-strange\",\"icon\":\"md-egg\",\"buttonType\":\"\",\"parentId\":35,\"description\":null,\"sortOrder\":1.8,\"status\":0,\"children\":null,\"permTypes\":[],\"expand\":true,\"checked\":false,\"selected\":false,\"meta\":{\"permTypes\":[],\"title\":\"异地备份管理\",\"url\":null}},{\"id\":42,\"createTime\":\"2018-10-11 17:20:22\",\"updateTime\":\"2018-10-11 17:20:22\",\"name\":\"backup-command-list\",\"level\":2,\"type\":0,\"title\":\"备份指令管理\",\"path\":\"backup-command-list\",\"icon\":\"md-list\",\"buttonType\":\"\",\"parentId\":35,\"description\":null,\"sortOrder\":1.7,\"status\":0,\"children\":null,\"permTypes\":[],\"expand\":true,\"checked\":false,\"selected\":false,\"meta\":{\"permTypes\":[],\"title\":\"备份指令管理\",\"url\":null}},{\"id\":41,\"createTime\":\"2018-10-09 14:49:51\",\"updateTime\":\"2018-10-09 14:49:51\",\"name\":\"backup-command\",\"level\":2,\"type\":0,\"title\":\"备份指令配置\",\"path\":\"backup-command\",\"icon\":\"md-return-right\",\"buttonType\":\"\",\"parentId\":35,\"description\":null,\"sortOrder\":1.6,\"status\":0,\"children\":null,\"permTypes\":[],\"expand\":true,\"checked\":false,\"selected\":false,\"meta\":{\"permTypes\":[],\"title\":\"备份指令配置\",\"url\":null}},{\"id\":40,\"createTime\":\"2018-09-30 10:20:09\",\"updateTime\":\"2018-09-30 10:20:09\",\"name\":\"backup-log\",\"level\":2,\"type\":0,\"title\":\"备份日志管理\",\"path\":\"backup-log\",\"icon\":\"md-document\",\"buttonType\":\"\",\"parentId\":35,\"description\":null,\"sortOrder\":1.5,\"status\":0,\"children\":null,\"permTypes\":[],\"expand\":true,\"checked\":false,\"selected\":false,\"meta\":{\"permTypes\":[],\"title\":\"备份日志管理\",\"url\":null}},{\"id\":39,\"createTime\":\"2018-09-26 17:13:57\",\"updateTime\":\"2018-09-26 17:13:57\",\"name\":\"backup-job-detail\",\"level\":2,\"type\":0,\"title\":\"备份策略管理\",\"path\":\"backup-job-detail\",\"icon\":\"ios-cog\",\"buttonType\":\"\",\"parentId\":35,\"description\":null,\"sortOrder\":1.4,\"status\":0,\"children\":null,\"permTypes\":[],\"expand\":true,\"checked\":false,\"selected\":false,\"meta\":{\"permTypes\":[],\"title\":\"备份策略管理\",\"url\":null}},{\"id\":38,\"createTime\":\"2018-09-26 17:11:04\",\"updateTime\":\"2018-09-26 17:11:04\",\"name\":\"backup-scheduler\",\"level\":2,\"type\":0,\"title\":\"备份作业管理\",\"path\":\"backup-scheduler\",\"icon\":\"md-code-working\",\"buttonType\":\"\",\"parentId\":35,\"description\":null,\"sortOrder\":1.3,\"status\":0,\"children\":null,\"permTypes\":[],\"expand\":true,\"checked\":false,\"selected\":false,\"meta\":{\"permTypes\":[],\"title\":\"备份作业管理\",\"url\":null}},{\"id\":37,\"createTime\":\"2018-09-26 09:55:35\",\"updateTime\":\"2018-09-26 10:00:24\",\"name\":\"backup-server\",\"level\":2,\"type\":0,\"title\":\"备份机器管理\",\"path\":\"backup-server\",\"icon\":\"md-browsers\",\"buttonType\":\"\",\"parentId\":35,\"description\":\"\",\"sortOrder\":1.2,\"status\":0,\"children\":null,\"permTypes\":[],\"expand\":true,\"checked\":false,\"selected\":false,\"meta\":{\"permTypes\":[],\"title\":\"备份机器管理\",\"url\":null}},{\"id\":36,\"createTime\":\"2018-09-13 13:51:20\",\"updateTime\":\"2018-09-26 17:14:41\",\"name\":\"backup-device-type\",\"level\":2,\"type\":0,\"title\":\"备份类型管理\",\"path\":\"backup-device-type\",\"icon\":\"logo-buffer\",\"buttonType\":\"\",\"parentId\":35,\"description\":\"\",\"sortOrder\":1.1,\"status\":0,\"children\":null,\"permTypes\":[],\"expand\":true,\"checked\":false,\"selected\":false,\"meta\":{\"permTypes\":[],\"title\":\"备份类型管理\",\"url\":null}}],\"permTypes\":null,\"expand\":true,\"checked\":false,\"selected\":false,\"meta\":{\"permTypes\":null,\"title\":\"备份管理\",\"url\":null}},{\"id\":96,\"createTime\":\"2019-03-08 15:35:55\",\"updateTime\":\"2019-05-17 09:40:59\",\"name\":\"basic\",\"level\":1,\"type\":0,\"title\":\"基础数据\",\"path\":\"/basic\",\"icon\":\"ios-briefcase-outline\",\"buttonType\":\"\",\"parentId\":null,\"description\":\"\",\"sortOrder\":98,\"status\":0,\"children\":[{\"id\":97,\"createTime\":\"2019-03-08 15:36:50\",\"updateTime\":\"2019-05-17 10:11:19\",\"name\":\"net\",\"level\":2,\"type\":0,\"title\":\"网元管理\",\"path\":\"net\",\"icon\":\"logo-dropbox\",\"buttonType\":\"\",\"parentId\":96,\"description\":\"\",\"sortOrder\":2,\"status\":0,\"children\":null,\"permTypes\":[\"edit\",\"add\",\"input\",\"output\",\"batchEdit\"],\"expand\":true,\"checked\":false,\"selected\":false,\"meta\":{\"permTypes\":[\"edit\",\"add\",\"input\",\"output\",\"batchEdit\"],\"title\":\"网元管理\",\"url\":null}},{\"id\":98,\"createTime\":\"2019-03-20 18:24:37\",\"updateTime\":\"2019-05-17 10:11:34\",\"name\":\"subnet\",\"level\":2,\"type\":0,\"title\":\"子网元管理\",\"path\":\"subnet\",\"icon\":\"md-disc\",\"buttonType\":\"\",\"parentId\":96,\"description\":\"\",\"sortOrder\":1,\"status\":0,\"children\":null,\"permTypes\":[\"input\",\"output\",\"edit\",\"batchEdit\",\"add\"],\"expand\":true,\"checked\":false,\"selected\":false,\"meta\":{\"permTypes\":[\"input\",\"output\",\"edit\",\"batchEdit\",\"add\"],\"title\":\"子网元管理\",\"url\":null}},{\"id\":124,\"createTime\":\"2019-08-28 11:02:27\",\"updateTime\":\"2019-08-28 11:04:39\",\"name\":\"netManager\",\"level\":2,\"type\":0,\"title\":\"工程网元设置\",\"path\":\"netManager\",\"icon\":\"ios-cog-outline\",\"buttonType\":\"\",\"parentId\":96,\"description\":\"\",\"sortOrder\":0.99,\"status\":0,\"children\":null,\"permTypes\":[],\"expand\":true,\"checked\":false,\"selected\":false,\"meta\":{\"permTypes\":[],\"title\":\"工程网元设置\",\"url\":null}}],\"permTypes\":null,\"expand\":true,\"checked\":false,\"selected\":false,\"meta\":{\"permTypes\":null,\"title\":\"基础数据\",\"url\":null}},{\"id\":102,\"createTime\":\"2019-05-17 09:52:22\",\"updateTime\":\"2019-08-16 09:59:10\",\"name\":\"/basic\",\"level\":1,\"type\":0,\"title\":\"工单处理\",\"path\":\"/basic\",\"icon\":\"ios-analytics\",\"buttonType\":\"\",\"parentId\":null,\"description\":\"\",\"sortOrder\":96,\"status\":0,\"children\":[{\"id\":103,\"createTime\":\"2019-05-17 10:03:15\",\"updateTime\":\"2019-05-31 14:38:00\",\"name\":\"jobList\",\"level\":2,\"type\":0,\"title\":\"工单列表\",\"path\":\"jobList\",\"icon\":\"md-bookmarks\",\"buttonType\":\"\",\"parentId\":102,\"description\":\"\",\"sortOrder\":4,\"status\":0,\"children\":null,\"permTypes\":[],\"expand\":true,\"checked\":false,\"selected\":false,\"meta\":{\"permTypes\":[],\"title\":\"工单列表\",\"url\":null}},{\"id\":105,\"createTime\":\"2019-05-27 14:30:01\",\"updateTime\":\"2019-06-27 09:50:35\",\"name\":\"orderManagement\",\"level\":2,\"type\":0,\"title\":\"接单受理\",\"path\":\"orderManagement\",\"icon\":\"logo-bitcoin\",\"buttonType\":\"\",\"parentId\":102,\"description\":\"\",\"sortOrder\":3,\"status\":0,\"children\":null,\"permTypes\":[],\"expand\":true,\"checked\":false,\"selected\":false,\"meta\":{\"permTypes\":[],\"title\":\"接单受理\",\"url\":null}},{\"id\":107,\"createTime\":\"2019-06-03 17:31:03\",\"updateTime\":\"2019-06-04 10:04:00\",\"name\":\"flow1\",\"level\":2,\"type\":0,\"title\":\"处理流程\",\"path\":\"flow1\",\"icon\":\"md-barcode\",\"buttonType\":\"\",\"parentId\":102,\"description\":\"\",\"sortOrder\":2,\"status\":0,\"children\":null,\"permTypes\":[],\"expand\":true,\"checked\":false,\"selected\":false,\"meta\":{\"permTypes\":[],\"title\":\"处理流程\",\"url\":null}},{\"id\":106,\"createTime\":\"2019-05-27 17:13:30\",\"updateTime\":\"2019-06-27 15:07:49\",\"name\":\"processingLog\",\"level\":2,\"type\":0,\"title\":\"处理记录\",\"path\":\"processingLog\",\"icon\":\"md-american-football\",\"buttonType\":\"\",\"parentId\":102,\"description\":\"\",\"sortOrder\":1,\"status\":0,\"children\":null,\"permTypes\":[],\"expand\":true,\"checked\":false,\"selected\":false,\"meta\":{\"permTypes\":[],\"title\":\"处理记录\",\"url\":null}}],\"permTypes\":null,\"expand\":true,\"checked\":false,\"selected\":false,\"meta\":{\"permTypes\":null,\"title\":\"工单处理\",\"url\":null}},{\"id\":43,\"createTime\":\"2018-10-17 10:00:53\",\"updateTime\":\"2019-05-17 09:40:53\",\"name\":\"Config\",\"level\":1,\"type\":0,\"title\":\"配置管理\",\"path\":\"/config\",\"icon\":\"ios-settings\",\"buttonType\":\"\",\"parentId\":null,\"description\":\"\",\"sortOrder\":92,\"status\":0,\"children\":[{\"id\":45,\"createTime\":\"2018-10-17 10:31:54\",\"updateTime\":\"2018-10-17 10:31:56\",\"name\":\"dictionary\",\"level\":2,\"type\":0,\"title\":\"字典管理\",\"path\":\"dictionary\",\"icon\":\"ios-map\",\"buttonType\":null,\"parentId\":43,\"description\":null,\"sortOrder\":3.2,\"status\":0,\"children\":null,\"permTypes\":[],\"expand\":true,\"checked\":false,\"selected\":false,\"meta\":{\"permTypes\":[],\"title\":\"字典管理\",\"url\":null}},{\"id\":44,\"createTime\":\"2018-10-17 10:29:18\",\"updateTime\":\"2018-10-17 10:29:20\",\"name\":\"area\",\"level\":2,\"type\":0,\"title\":\"地区管理\",\"path\":\"area\",\"icon\":\"ios-globe\",\"buttonType\":null,\"parentId\":43,\"description\":null,\"sortOrder\":3.1,\"status\":0,\"children\":null,\"permTypes\":[],\"expand\":true,\"checked\":false,\"selected\":false,\"meta\":{\"permTypes\":[],\"title\":\"地区管理\",\"url\":null}}],\"permTypes\":null,\"expand\":true,\"checked\":false,\"selected\":false,\"meta\":{\"permTypes\":null,\"title\":\"配置管理\",\"url\":null}},{\"id\":47,\"createTime\":\"2018-10-18 10:41:31\",\"updateTime\":\"2019-05-17 10:09:12\",\"name\":\"smsManage\",\"level\":1,\"type\":0,\"title\":\"短信管理\",\"path\":\"/common\",\"icon\":\"ios-aperture\",\"buttonType\":\"\",\"parentId\":null,\"description\":\"\",\"sortOrder\":90,\"status\":0,\"children\":[{\"id\":48,\"createTime\":\"2018-10-18 10:43:01\",\"updateTime\":\"2018-10-18 10:43:01\",\"name\":\"common-sms-list\",\"level\":2,\"type\":0,\"title\":\"短信列表\",\"path\":\"common-sms-list\",\"icon\":\"md-list\",\"buttonType\":\"\",\"parentId\":47,\"description\":null,\"sortOrder\":1,\"status\":0,\"children\":null,\"permTypes\":[],\"expand\":true,\"checked\":false,\"selected\":false,\"meta\":{\"permTypes\":[],\"title\":\"短信列表\",\"url\":null}}],\"permTypes\":null,\"expand\":true,\"checked\":false,\"selected\":false,\"meta\":{\"permTypes\":null,\"title\":\"短信管理\",\"url\":null}},{\"id\":49,\"createTime\":\"2018-10-22 10:15:59\",\"updateTime\":\"2019-05-17 10:25:09\",\"name\":\"alarm-monitor\",\"level\":1,\"type\":0,\"title\":\"监控管理\",\"path\":\"/alarm-monitor\",\"icon\":\"ios-disc-outline\",\"buttonType\":\"\",\"parentId\":null,\"description\":\"\",\"sortOrder\":5,\"status\":0,\"children\":[{\"id\":50,\"createTime\":\"2018-10-22 10:19:30\",\"updateTime\":\"2018-10-22 16:54:03\",\"name\":\"health-monitor\",\"level\":2,\"type\":0,\"title\":\"健康监控管理\",\"path\":\"health-monitor\",\"icon\":\"md-eye\",\"buttonType\":\"\",\"parentId\":49,\"description\":\"\",\"sortOrder\":1.3,\"status\":0,\"children\":null,\"permTypes\":[],\"expand\":true,\"checked\":false,\"selected\":false,\"meta\":{\"permTypes\":[],\"title\":\"健康监控管理\",\"url\":null}},{\"id\":55,\"createTime\":\"2018-10-22 10:26:36\",\"updateTime\":\"2018-10-23 12:25:14\",\"name\":\"store-server-alarm\",\"level\":2,\"type\":0,\"title\":\"存储告警管理\",\"path\":\"store-server-alarm\",\"icon\":\"ios-appstore\",\"buttonType\":\"\",\"parentId\":49,\"description\":\"\",\"sortOrder\":1.2,\"status\":0,\"children\":null,\"permTypes\":[],\"expand\":true,\"checked\":false,\"selected\":false,\"meta\":{\"permTypes\":[],\"title\":\"存储告警管理\",\"url\":null}},{\"id\":56,\"createTime\":\"2018-10-22 10:28:24\",\"updateTime\":\"2018-10-23 12:24:53\",\"name\":\"backup-alarm\",\"level\":2,\"type\":0,\"title\":\"备份告警管理\",\"path\":\"backup-alarm\",\"icon\":\"md-chatbubbles\",\"buttonType\":\"\",\"parentId\":49,\"description\":\"\",\"sortOrder\":1.1,\"status\":0,\"children\":null,\"permTypes\":[],\"expand\":true,\"checked\":false,\"selected\":false,\"meta\":{\"permTypes\":[],\"title\":\"备份告警管理\",\"url\":null}}],\"permTypes\":null,\"expand\":true,\"checked\":false,\"selected\":false,\"meta\":{\"permTypes\":null,\"title\":\"监控管理\",\"url\":null}},{\"id\":1,\"createTime\":\"2018-06-04 19:02:29\",\"updateTime\":\"2019-05-17 10:28:07\",\"name\":\"sys\",\"level\":1,\"type\":0,\"title\":\"系统管理\",\"path\":\"/form\",\"icon\":\"md-laptop\",\"buttonType\":\"\",\"parentId\":0,\"description\":\"\",\"sortOrder\":1,\"status\":0,\"children\":[{\"id\":66,\"createTime\":\"2018-10-25 15:03:46\",\"updateTime\":\"2018-10-25 15:03:46\",\"name\":\"back-manage\",\"level\":2,\"type\":0,\"title\":\"后台管理\",\"path\":\"back-manage\",\"icon\":\"md-alarm\",\"buttonType\":\"\",\"parentId\":1,\"description\":null,\"sortOrder\":1.6,\"status\":0,\"children\":null,\"permTypes\":[\"view\"],\"expand\":true,\"checked\":false,\"selected\":false,\"meta\":{\"permTypes\":[\"view\"],\"title\":\"后台管理\",\"url\":null}},{\"id\":5,\"createTime\":\"2018-06-04 19:02:40\",\"updateTime\":\"2018-06-04 19:02:53\",\"name\":\"log-manage\",\"level\":2,\"type\":0,\"title\":\"日志管理\",\"path\":\"log-manage\",\"icon\":\"ios-list-box-outline\",\"buttonType\":null,\"parentId\":1,\"description\":null,\"sortOrder\":1.4,\"status\":0,\"children\":null,\"permTypes\":[\"clearAll\",\"delete\"],\"expand\":true,\"checked\":false,\"selected\":false,\"meta\":{\"permTypes\":[\"clearAll\",\"delete\"],\"title\":\"日志管理\",\"url\":null}},{\"id\":4,\"createTime\":\"2018-06-04 19:02:37\",\"updateTime\":\"2018-06-04 19:02:49\",\"name\":\"menu-manage\",\"level\":2,\"type\":0,\"title\":\"权限管理\",\"path\":\"menu-manage\",\"icon\":\"ios-ribbon\",\"buttonType\":null,\"parentId\":1,\"description\":null,\"sortOrder\":1.3,\"status\":0,\"children\":null,\"permTypes\":[\"delete\",\"edit\",\"add\"],\"expand\":true,\"checked\":false,\"selected\":false,\"meta\":{\"permTypes\":[\"delete\",\"edit\",\"add\"],\"title\":\"权限管理\",\"url\":null}},{\"id\":3,\"createTime\":\"2018-06-04 19:02:35\",\"updateTime\":\"2018-06-04 19:02:45\",\"name\":\"role-manage\",\"level\":2,\"type\":0,\"title\":\"角色管理\",\"path\":\"role-manage\",\"icon\":\"ios-contacts\",\"buttonType\":null,\"parentId\":1,\"description\":null,\"sortOrder\":1.2,\"status\":0,\"children\":null,\"permTypes\":[\"setDefault\",\"editPerm\",\"delete\",\"edit\",\"add\"],\"expand\":true,\"checked\":false,\"selected\":false,\"meta\":{\"permTypes\":[\"setDefault\",\"editPerm\",\"delete\",\"edit\",\"add\"],\"title\":\"角色管理\",\"url\":null}},{\"id\":2,\"createTime\":\"2018-06-04 19:02:32\",\"updateTime\":\"2018-06-04 19:02:43\",\"name\":\"user-manage\",\"level\":2,\"type\":0,\"title\":\"用户管理\",\"path\":\"user-manage\",\"icon\":\"ios-contact-outline\",\"buttonType\":null,\"parentId\":1,\"description\":null,\"sortOrder\":1.1,\"status\":0,\"children\":null,\"permTypes\":[\"delete\",\"undefined\",\"disable\",\"edit\",\"add\"],\"expand\":true,\"checked\":false,\"selected\":false,\"meta\":{\"permTypes\":[\"delete\",\"undefined\",\"disable\",\"edit\",\"add\"],\"title\":\"用户管理\",\"url\":null}}],\"permTypes\":null,\"expand\":true,\"checked\":false,\"selected\":false,\"meta\":{\"permTypes\":null,\"title\":\"系统管理\",\"url\":null}}]";
		String json2 = "[{\"title\":\"作业结果管理\",\"path\":\"\",\"name\":\"home_index\"}]";

		JSONArray array1 = JSON.parseArray(json);
		JSONArray array2 = JSON.parseArray(json2);

		JSONObject object = handleForEach(array1, array2.getJSONObject(0));
		if (object == null) {
			System.out.println("object is null");
		}else {
			System.out.println(object.toJSONString());
		}

//		System.out.println(array1.size());
//		System.out.println(array2.size());
	}

	public JSONObject handleForEach(JSONArray array, JSONObject obj2){
		JSONObject object = null;
		List<JSONObject> list = array.toJavaList(JSONObject.class);
		for (JSONObject obj1 : list) {
			JSONArray arr = obj1.getJSONArray("children");
			if (arr != null) {
				object = handleForEach(arr,obj2);
				if (object != null){
					return object;
				}
			}else{
				if (obj1.getString("title").equals(obj2.get("title"))
						&& obj1.getString("path").equals("jobResult1")) {
					return obj1.getJSONObject("meta");
				}
			}
		}
		return object;
	}

	/**
	 * 模拟 外面同步，内里同步场景
	 */
	@Test
	public void test5() throws ExecutionException, InterruptedException {
		ExecutorService executor = Executors.newCachedThreadPool();
		//同步锁
		CountDownLatch cdl = new CountDownLatch(2);
		Future<List<String>> future1 = executor.submit(()->{
			System.out.println("futureTask1");
			Thread.sleep(5000);
			System.out.println("开始执行futureTask1");
			return Arrays.asList("1", "2", "3");
		});
		System.out.println("主线程在执行任务");
		Future<List<String>> future2 = executor.submit(()->{
			System.out.println("futureTask2");
			Thread.sleep(1000);
			System.out.println("开始执行futureTask2");
			return Arrays.asList("A", "B", "C");
		});
		System.out.println("主线程在执行任务2");

		List<String> list = new ArrayList<>();
		List<String> _list2 = future2.get();
		list.addAll(_list2);
		System.out.println(JSON.toJSONString(_list2));

		List<String> _list = future1.get();
		list.addAll(_list);
		System.out.println(JSON.toJSONString(_list));

		if (future1.isDone()) {
			System.out.println("执行futureTask1完成");
			cdl.countDown();
		}
		if (future2.isDone()){
			System.out.println("执行futureTask2完成");
			cdl.countDown();
		}


		try {
			//线程等待，当计数为0时，可继续执行
			cdl.await();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("继续一下步骤");
		System.out.println(JSON.toJSONString(list));
		executor.shutdown();
	}

	@Test
	public void test6() {
		MenuManager menuManager = new MenuManager(null);
		List<Menu> menuList = new ArrayList<>();
		Menu menu1 = new Menu(1L, 0L, "menu1", "/menu1", 1, "icon1", 1);
		menuList.add(menu1);

		Menu menu2 = new Menu(2L, 0L, "menu2", "/menu2", 1, "icon2", 1);
		menuList.add(menu2);

		Menu menu3 = new Menu(3L, 1L, "menu3", "/menu3", 1, "icon1", 1);
		menuList.add(menu3);

		Menu menu4 = new Menu(4L, 2L, "menu4", "/menu4", 1, "icon1", 1);
		menuList.add(menu4);

		Menu menu5 = new Menu(5L, 1L, "menu5", "/menu5", 1, "icon1", 1);
		menuList.add(menu5);

		Menu menu6 = new Menu(6L, 3L, "menu6", "/menu6", 2, "icon1", 1);
		menuList.add(menu6);

		Menu menu7 = new Menu(7L, 3L, "menu7", "/menu7", 2, "icon1", 1);
		menuList.add(menu7);

		List<Menu> menus = new ArrayList<>();
		for (Menu menu : menuList) {
			menuManager.handleForEach(menu,menus);
		}
		System.out.println(JSON.toJSONStringWithDateFormat(menus,Constant.DATE_FORMAT, SerializerFeature.WriteMapNullValue));
	}
}
