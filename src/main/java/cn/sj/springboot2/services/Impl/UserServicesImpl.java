package cn.sj.springboot2.services.Impl;

import cn.sj.springboot2.dao.RoleDao;
import cn.sj.springboot2.dao.UserDao;
import cn.sj.springboot2.model.Permission;
import cn.sj.springboot2.model.User;
import cn.sj.springboot2.services.IUserServices;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author shuzheng
 */
@Service
public class UserServicesImpl implements IUserServices {
    @Resource
    private UserDao userDao;
    @Resource
    private RoleDao roleDao;
    
    @Override
    public String addUser(User user) {
        boolean a = userDao.add(user);
        if(a){
            return "添加成功";
        }else {
            return "添加失败";
        }
    }
    
    @Override
    public String delete(int id, String username){
        User user = userDao.select(id);
        if(user.getUsername().equals(username)){
            boolean boon = userDao.delete(user);
            if(boon){
                return "删除id为："+user.getId()+",用户名为:"+user.getUsername()+"的数据成功";
            }else {
                return "删除id为："+user.getId()+",用户名为:"+user.getUsername()+"的数据失败";
            }
        }else {
            return "用户名不正确";
        }
    }
    
    @Override
    public String update(User user){
        User user1 = userDao.select(user.getId());
        if(user1.getUsername().equals(user.getUsername())){
            boolean boon = userDao.update(user);
            if(boon){
                return "修改用户id为:"+user.getId()+",用户名为:"+user.getUsername()+"数据成功";
            }else {
                return "修改用户id为:"+user.getId()+",用户名为:"+user.getUsername()+"数据失败";
            }
        }else {
            return "用户名不一致";
        }
    }
    
    @Override
    public User select(int id) {
        return userDao.select(id);
    }
    
    
    @Override
    public List<User> select(String username) {
        return userDao.select(username);
    }
    
    
    @Override
    public User selectRole(int id) {
        User user = userDao.select(id);
        user.setRoles(userDao.selectRole(id));
        return user;
    }
    
    @Override
    public User selectRolePer(int id) {
        User user = userDao.select(id);
        user.setPermissions(userDao.selectRolePer(id));
         return user;
    }
    
    @Override
    public String userAddRole(int userid,int roleid) {
        boolean boon = userDao.userAddRole(userid,roleid);
        if(boon){
            return "给用户添加角色成功";
        }else {
            return "给用户添加角色失败";
        }
    }
    
}
