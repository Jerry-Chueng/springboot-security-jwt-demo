package com.jerry.base.common.service;

import com.jerry.base.common.dao.SysSettingMapper;
import com.jerry.base.common.entity.SysSetting;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

/**
 * Created by on 2019-11-27 10:37
 *
 * @Maintainance: jerryzshiyan@163.com
 * @author: Jerry
 * @Project: springboot-security-jwt-demo
 */
@Component
@AllArgsConstructor
public class SysSettingService {

    public static SysSetting sysSetting;

    private SysSettingMapper sysSettingMapper;

    @PostConstruct
    public void initSysSimpleSetting(){
        sysSetting = sysSettingMapper.selectSysSetting();
    }

}
