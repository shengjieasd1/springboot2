package cn.sj.springboot2.services;

import cn.sj.springboot2.model.Role;
import org.springframework.stereotype.Service;

/**
 * @author shuzheng
 */
@Service
public interface IRoleServices {
    
    /**
     * 角色添加
     * @param role
     * @return
     */
    public String addRole(Role role);
    
    /**
     * 角色修改
     * @param role
     * @return
     */
    public String updateRole(Role role);
    
    /**
     * 角色删除
     * @param id
     * @param pername
     * @return
     */
    public String deleteRole(int id,String pername);
    
    /**
     * 角色查询
     * @param id
     * @return
     */
    public Role selectRole(int id);
    
    /**
     * 角色查询用户
     * @param id
     * @return
     */
    public Role selectUser(int id);
    
    /**
     * 角色查询权限
     * @param id
     * @return
     */
    public Role roleSelectPer(int id);
    
    /**
     * 角色添加权限
     * @param roleid
     * @param perid
     * @return
     */
    String roleAddPer(int roleid,int perid);
    
    /**
     * 角色添加用户
     * @param roleid
     * @param userid
     * @return
     */
    String roleAddUser(int roleid,int userid);
}
