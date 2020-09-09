package cn.sj.springboot2.services.Impl;

import cn.sj.springboot2.dao.RoleDao;
import cn.sj.springboot2.model.Role;
import cn.sj.springboot2.services.IRoleServices;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author shuzheng
 */
@Service
public class RoleServicesImpl implements IRoleServices {
    @Resource
    private RoleDao roleDao;
    
    @Override
    public String addRole(Role role) {
        Boolean boon =  roleDao.addRole(role);
        if(boon){
            return "添加角色名称:"+role.getRolename()+"成功";
        }else {
            return "添加角色名称:"+role.getRolename()+"失败";
        }
    }
    
    @Override
    public String updateRole(Role role) {
        Role role1 = roleDao.selectRole(role.getId());
        if(role1.getRolename().equals(role.getRolename())){
            boolean boon = roleDao.updateRole(role);
            if(boon){
                return "修改角色："+role.getRolename()+"成功";
            }else {
                return "修改角色："+role.getRolename()+"失败";
            }
        }else {
            return "角色名不一致，修改角色失败";
        }
    }
    
    @Override
    public String deleteRole(int id, String pername) {
        Role role = roleDao.selectRole(id);
        if(role.getRolename().equals(pername)){
            boolean boon = roleDao.deleteRole(role);
            if (boon){
                return "删除角色:"+role.getRolename()+"成功";
            }else {
                return "删除角色:"+role.getRolename()+"失败";
            }
        }else {
            return "角色名不一致,删除角色:"+role.getRolename()+"失败";
        }
    }
    
    @Override
    public Role selectRole(int id) {
        Role role = roleDao.selectRole(id);
        return role;
    }
    
    @Override
    public Role selectUser(int id) {
        Role role = roleDao.selectRole(id);
        role.setUser(roleDao.selectUser(id));
        return role;
    }
    
    @Override
    public Role roleSelectPer(int id) {
        Role role = roleDao.selectRole(id);
        role.setPermissions(roleDao.roleSelectPer(id));
        return role;
    }
    
    @Override
    public String roleAddPer(int roleid,int perid) {
        boolean boon = roleDao.roleAddPer(roleid,perid);
        if(boon){
            return "给角色添加权限成功";
        }else {
            return "给角色添加权限失败";
    
        }
    }
    
    @Override
    public String roleAddUser(int roleid, int userid) {
        boolean boon = roleDao.roleAddUser(roleid,userid);
        if(boon){
            return "给角色添加用户成功";
        }else {
            return "给角色添加用户失败";
        
        }
    }
}
