package cn.sj.springboot2.dao;

import cn.sj.springboot2.model.Permission;
import cn.sj.springboot2.model.Role;
import cn.sj.springboot2.model.User;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author shuzheng
 */
@Repository
public class UserDao {
    @Resource
    private RoleDao roleDao;
    
    @Resource
    private JdbcTemplate jdbcTemplate;
    /**
     * 用户添加
     *
     * @param user 用户对象
     * @return 返回布尔型
     */
    
    public boolean add(User user) {
        String sql = "insert into user(username,password,birthday,sex,tel,email) values(?,?,?,?,?,?)";
        int a = jdbcTemplate.update(sql,user.getUsername(),user.getPassword(),user.getBirthday(),user.isSex(),user.getTel(),user.getEmail());
        return a>0;
    }
    
    /**
     * 用户修改
     *
     * @param user 用户id和用户姓名
     * @return 返回布尔型
     */
    public boolean update(User user) {
        String sql = "update user set username=?,password=?,birthday=?,sex=?,tel=?,email=? where id=? ";
        int a = jdbcTemplate.update(sql,user.getUsername(),user.getPassword(),user.getBirthday(),user.isSex(),user.getTel(),user.getEmail(),user.getId());
        return a>0;
    }
    
    /**
     * 用户删除
     *
     * @param user 用户对象
     * @return 返回布尔型
     */
    public boolean delete(User user) {
        String sql = "delete from user where id=?";
        int a = jdbcTemplate.update(sql,user.getId());
        return a>0;
    }
    
    public User select(int id){
        String sql = "select * from user where id=?";
        User user = jdbcTemplate.queryForObject(sql,new Object[]{id}, (rs, rowNum) -> {
            User user1 = new User();
            user1.setId(rs.getInt(1));
            user1.setUsername(rs.getString(2));
            user1.setPassword(rs.getString(3));
            user1.setBirthday(rs.getString(4));
            user1.setSex(rs.getBoolean(5));
            user1.setTel(rs.getLong(6));
            user1.setEmail(rs.getString(7));
            return user1;
        });
        return user;
    }
    
    /**
     * 用户名模糊查询
     * @param username
     * @return
     */
    public List<User> select(String username){
        String sql = "select * from user where username like ?";
        String sql1 = "%"+username+"%";
        List<User> users = jdbcTemplate.query(sql, new String[]{sql1}, (resultSet, i) -> {
            User user = new User();
            user.setId(resultSet.getInt(1));
            user.setUsername(resultSet.getString(2));
            user.setPassword(resultSet.getString(3));
            user.setBirthday(resultSet.getString(4));
            user.setSex(resultSet.getBoolean(5));
            user.setTel(resultSet.getLong(6));
            user.setEmail(resultSet.getString(7));
            return user;
        });
        return users;
    }
    
    /**
     * 用户与角色关系表查询 通过userID查询
     * @param id
     * @return
     */
    public List<Role> selectRole(int id){
        String sql = "select role.* from user_role,role where user_role.rolename=role.rolename and user_role.userID=? ";
        List<Role> list = jdbcTemplate.query(sql, new Object[]{id}, (resultSet, i) -> {
            Role Role = new Role();
            System.out.println(resultSet.getInt(1));
            Role.setId(resultSet.getInt(1));
            Role.setRolename(resultSet.getString(2));
            Role.setRoleide(resultSet.getString(3));
            return Role;
        });
        return list;
    }
    
    /**
     *  用户与角色关系表+角色与权限关系表 查询输出权限
     * @param id
     * @return
     */
    public List<Permission> selectRolePer(int id){
        String sql = "select permission.* from user_role,role_permission,permission where user_role.roleID=role_permission.roleID AND role_permission.permissionID=permission.id and user_role.userID=? ";
        return jdbcTemplate.query(sql, new Object[]{id}, (resultSet, i) -> {
            Permission permission = new Permission();
            permission.setId(resultSet.getInt(1));
            permission.setPername(resultSet.getString(2));
            permission.setPerids(resultSet.getString(3));
            permission.setFatherID(resultSet.getInt(4));
            permission.setPertype(resultSet.getString(5));
            return permission;
        });
    }
    
    /**
     * 给用户添加角色
     * @param userid
     * @param roleid
     * @return
     */
    public boolean userAddRole(int userid,int roleid) {
        String sql = "insert into user_role(userID,username,roleID,rolename) select user.id,user.username,role.id,role.rolename from user,role where user.id=? and role.id=?";
        int a = jdbcTemplate.update(sql,userid,roleid);
        return a>0;
    }
}
