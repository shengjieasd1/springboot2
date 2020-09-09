package cn.sj.springboot2.controller;

import cn.sj.springboot2.model.Role;
import cn.sj.springboot2.services.IRoleServices;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author shuzheng
 */
@RestController
public class RoleOperation {
    
    @Resource
    private IRoleServices roleServices;
    
    /**
     * 添加角色
     * @param role
     * @return
     */
    @RequestMapping("/addRole")
    public String addRole(Role role){
        return roleServices.addRole(role);
    }
    
    /**
     * 修改角色
     * @param role
     * @return
     */
    @RequestMapping("/updateRole")
    public String updateRole(Role role){
        return roleServices.updateRole(role);
    }
    
    /**
     * 删除角色
     * @param id
     * @param pername
     * @return
     */
    @RequestMapping("/deleteRole")
    public String deleteRole(int id,String pername){
        return roleServices.deleteRole(id,pername);
    }
    
    /**
     * 根据角色id查询有哪些用户拥有此角色
     * @param id
     * @return
     */
    @RequestMapping(value = "/RoleSelectUser",method = RequestMethod.GET)
    public Role roleSelectUser(int id){
        return roleServices.selectUser(id);
    }
    
    /**
     * 根据角色id查询此角色关联了哪些权限
     * @param id
     * @return
     */
    @RequestMapping(value = "/RoleSelectPer",method = RequestMethod.GET)
    public Role roleSelectPer(int id){
        return roleServices.roleSelectPer(id);
    }
    
    /**
     * 通过角色添加权限
     * @param roleid
     * @param perid
     * @return
     */
    @RequestMapping(value = "/RoleAddPer",method = RequestMethod.GET)
    public String roleAddPer(int roleid,int perid){
        return roleServices.roleAddPer(roleid,perid);
    }
    
    
    /**
     * 通过角色添加用户
     * @param roleid
     * @param userid
     * @return
     */
    @RequestMapping(value = "/RoleAddUser",method = RequestMethod.GET)
    public String roleAddUser(int roleid,int userid){
        return roleServices.roleAddUser(roleid,userid);
    }
    
}
