package com.jerry.base.security.service;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.jerry.base.authority.dao.UserMapper;
import com.jerry.base.authority.entity.User;
import com.jerry.base.authority.manager.UserManager;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import java.util.Date;

@Slf4j
public class AuthUserDetailService implements UserDetailsService {

	private UserManager userManager;

	private BCryptPasswordEncoder bCryptPasswordEncoder;

	public AuthUserDetailService(UserManager userManager) {
		this.userManager = userManager;
		//默认使用 Bcrypt， strength=10
		this.bCryptPasswordEncoder = new BCryptPasswordEncoder();
	}

	/**
	 * 登录成功后生成token
	 * @param authUserDetail
	 * @return
	 */
	public String createJwtToken(AuthUserDetail authUserDetail) {
		String salt = BCrypt.gensalt();
		User user = authUserDetail.getUser();
		userManager.updateUserTokenSalt(user.getId(),salt);
		Algorithm algorithm = Algorithm.HMAC256(salt);
        return "Bearer " + JWT.create()
				//主题
        		.withSubject(user.getUsername())
				//设置1小时后过期
                .withExpiresAt(new Date(System.currentTimeMillis()+3600*1000))
				//发布时间
                .withIssuedAt(new Date())
                .sign(algorithm);
	}

	/**
	 * 登录验证
	 * @param username
	 * @return
	 * @throws UsernameNotFoundException
	 */
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

		User user = userManager.findByUsername(username);
		if (user == null) {
			throw new UsernameNotFoundException("用户不存在");
		}
		return new AuthUserDetail(user);
	}

	public void createUser(String username, String password) {
		String encryptPwd = bCryptPasswordEncoder.encode(password);
		/**
		 * @todo 保存用户名和加密后密码到数据库
		 */
	}

	public void deleteUserLoginInfo(String username) {
		/**
		 * @todo 清除数据库或者缓存中登录salt
		 */
	}
}
