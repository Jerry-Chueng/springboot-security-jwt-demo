package com.jerry.base.authority.manager;

import com.jerry.base.authority.dao.MenuMapper;
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

    public List<Menu> findAll(){
        List<Menu> menuList = menuMapper.findAll();
        List<Menu> menus = new ArrayList<>();
        for (Menu menu : menuList) {
            handleForEach(menu,menus);
        }
        return menus;
    }

    public void handleForEach(Menu menu,List<Menu> menus){
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

    public int saveRelationshipWithRole(Integer menuId,Integer roleId){
        return menuMapper.saveRelationshipWithRole(menuId, roleId);
    }

    public int update(Menu menu){
        return menuMapper.updateById(menu);
    }

    public int updateByIdSelective(Menu menu){
        return menuMapper.updateByIdSelective(menu);
    }

    @Transactional
    public int delete(List<Long> ids) {
        menuMapper.deleteRelationshipPrivilegeWithRole(ids);
        return menuMapper.deleteById(ids);
    }

    public int deleteRoleRelationship(int menuId,int roleId) {
        return menuMapper.deleteRoleRelationship(menuId, roleId);
    }
}
