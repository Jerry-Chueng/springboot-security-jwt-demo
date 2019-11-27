package com.jerry.base.authority.manager;

import com.jerry.base.authority.dao.MenuMapper;
import com.jerry.base.authority.dao.RoleMapper;
import com.jerry.base.authority.entity.Menu;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by on 2019-08-18 14:22
 *
 * @Maintainance: jerryzshiyan@163.com
 * @author: Jerry
 * @Project: demo
 */
@Service
@RequiredArgsConstructor
public class MenuManager {

    private final MenuMapper menuMapper;

    private final RoleMapper roleMapper;

    public List<Menu> getMenuList(List<Long> ids){
        return menuMapper.list(ids,null);
    }

    public List<Menu> getMenuList(String keyword){
        return menuMapper.list(null,keyword);
    }

    public void handleForEach(Menu menu,List<Menu> menus){
//        List<Menu> menus = new ArrayList<>();
//        for (Menu menu : menuList) {
//            handleForEach(menu,menus);
//        }
        if (menu.getParentId() != 0) {
            for (Menu m : menus) {
                if (m.getId() == menu.getParentId()) {
                    if (m.getChildren() == null) {
                        List<Menu> list = new ArrayList<>();
                        list.add(menu);
                        m.setChildren(list);
                    }else{
                        m.getChildren().add(menu);
                    }
                    break;
                }else if (m.getChildren() != null && m.getChildren().size() > 0){
                    handleForEach(menu, m.getChildren());
                }
            }
        }else{
            menus.add(menu);
        }
    }

    public Menu findById(Long id){
        return menuMapper.findById(id);
    }

    public Menu findByName(String name){
        return menuMapper.findByName(name);
    }

    public Menu findByPath(String path){
        return menuMapper.findByPath(path);
    }

    public int save(Menu menu){
        return menuMapper.save(menu);
    }

    public int update(Menu menu){
        return menuMapper.update(menu);
    }

    @Transactional(rollbackFor = Exception.class)
    public int delete(List<Long> ids) {
        menuMapper.deleteRelationshipPrivilegeWithRole(ids);
        return menuMapper.deleteById(ids);
    }

    @Transactional(rollbackFor = Exception.class)
    public void saveRelationshipWithRole(List<Long> menuIds,Long roleId){
        menuMapper.deleteRoleRelationship(roleId);
        if (!menuIds.isEmpty()){
            menuMapper.saveRelationshipWithRole(menuIds, roleId);
        }
    }
}
