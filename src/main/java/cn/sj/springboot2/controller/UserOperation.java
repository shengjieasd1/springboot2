package cn.sj.springboot2.controller;

import cn.sj.springboot2.model.User;
import cn.sj.springboot2.services.IUserServices;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author shuzheng
 */
@RestController
public class UserOperation {

    @Resource
    private IUserServices userServices;
    
    /**用户添加*/
    @RequestMapping(value = "/addUser",method = RequestMethod.POST)
    public String addUser(User user1) {
        return userServices.addUser(user1);
        
    }

    /**用户删除*/
    @RequestMapping(value = "/deleteUser",method = RequestMethod.GET)
    public String deleteUser(Integer id,String username){
        return userServices.delete(id,username);
    }

    /**用户查询*/
    @RequestMapping(value = "/selectUser",method = RequestMethod.GET)
    public User selectUser(Integer id){
        return userServices.select(id);
    }

    /**用户修改*/
    @RequestMapping(value = "/updateUser",method = RequestMethod.POST)
    public String updateUser(User user1){
        return userServices.update(user1);
    }

    /**用名户模糊查询（根据用户名模糊查询用户列表）*/
    @RequestMapping(value = "/selectUsername",method = RequestMethod.GET)
    public List<User> selectUsername(String username){
        return userServices.select(username);
    }

    /**根据用户id查询此用户拥有的角色*/
    @RequestMapping(value = "/selectUserRole",method = RequestMethod.GET)
    public User selectUserRole(int id){
        return userServices.selectRole(id);
    }


    /**根据用户id查询此用户拥有的权限*/
    @RequestMapping(value = "/UserPer",method = RequestMethod.GET)
    public User userPer(int id){
        return userServices.selectRolePer(id);
    }

    /**给用户添加角色*/
    @RequestMapping(value = "/UserAddRole",method = RequestMethod.GET)
    public String userAddRole(int userid,int roleid){
        return userServices.userAddRole(userid,roleid);
    }
    
}
