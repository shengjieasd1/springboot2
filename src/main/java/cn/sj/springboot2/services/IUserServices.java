package cn.sj.springboot2.services;

import cn.sj.springboot2.model.Permission;
import cn.sj.springboot2.model.User;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author shuzheng
 */
@Service
public interface IUserServices {
    
    /**
     * 用户添加
     * @param user
     * @return
     */
    String addUser(User user);
    
    /**
     *  删除用户
     * @param id
     * @param username
     * @return
     */
    String delete(int id, String username);
    
    /**
     * 修改用户
     * @param user
     * @return
     */
    String update(User user);
    
    /**
     * 用户查询
     * @param id
     * @return
     */
    User select(int id);
    
    /**
     * 用户模糊查询
     * @param username
     * @return
     */
    List<User> select(String username);
    
    /**
     * 用户查询角色
     * @param id
     * @return
     */
    User selectRole(int id);
    
    /**
     * 角色查询权限
     * @param id
     * @return
     */
    public User selectRolePer(int id);
    
    /**
     * 给用户添加角色
     * @param userid
     * @param roleid
     * @return
     */
    String userAddRole(int userid,int roleid);
}
