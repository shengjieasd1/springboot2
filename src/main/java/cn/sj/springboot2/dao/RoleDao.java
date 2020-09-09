package cn.sj.springboot2.dao;

import cn.sj.springboot2.model.*;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

/**
 * @author shuzheng
 */
@Repository
public class RoleDao {
    @Resource
    private JdbcTemplate jdbcTemplate;
    @Resource
    private PermissionDao permissionDao;
    /**
     * 角色添加
     *
     * @param role 角色对象
     * @return 返回布尔型
     */
    
    public boolean addRole(Role role) {
        String sql = "insert into role(rolename,roleide) values(?,?)";
        int a = jdbcTemplate.update(sql,role.getRolename(),role.getRoleide());
        return a>0;
    }
    
    /**
     * 角色修改
     *
     * @param role 角色对象
     * @return 返回布尔型
     */
    public boolean updateRole(Role role) {
        String sql = "update role set rolename=?,roleide=? where id=?";
        int a = jdbcTemplate.update(sql,role.getRolename(),role.getRoleide(),role.getId());
        return a>0;
    }
    
    /**
     * 角色删除
     *
     * @param role 角色对象
     * @return 返回布尔型
     */
    public boolean deleteRole(Role role) {
        String sql = "delete form role where id=?";
        int a = jdbcTemplate.update(sql,role.getId());
        return false;
    }
    
    
    /**
     *  角色查询
     * @param id
     * @return
     */
    public Role selectRole(int id){
        String sql = "select * from role where id=?";
        Role role = jdbcTemplate.queryForObject(sql, new Object[]{id}, new RowMapper<Role>() {
            @Override
            public Role mapRow(ResultSet resultSet, int i) throws SQLException {
                Role role1 = new Role();
                role1.setId(resultSet.getInt(1));
                role1.setRolename(resultSet.getString(2));
                role1.setRoleide(resultSet.getString(3));
                return role1;
            }
        });
        return role;
    }
    
    public List<User> selectUser(int id){
        String sql = "select user.* from user,user_role where user_role.userID=user.id and roleID=?";
        return jdbcTemplate.query(sql, new Object[]{id}, new RowMapper<User>() {
            @Override
            public User mapRow(ResultSet resultSet, int i) throws SQLException {
                User user = new User();
                user.setId(resultSet.getInt(1));
                user.setUsername(resultSet.getString(2));
                user.setPassword(resultSet.getString(3));
                user.setBirthday(resultSet.getString(4));
                user.setSex(resultSet.getBoolean(5));
                user.setTel(resultSet.getLong(6));
                user.setEmail(resultSet.getString(7));
                return user;
            }
        });
    }
    
    public List<Permission> roleSelectPer(int id){
        String sql = "select permission.* from role_permission,permission where role_permission.permissionID=permission.id and role_permission.roleID=?";
        List<Permission> list = jdbcTemplate.query(sql, new Object[]{id}, new RowMapper<Permission>() {
            @Override
            public Permission mapRow(ResultSet resultSet, int i) throws SQLException {
                Permission permission = new Permission();
                permission.setId(resultSet.getInt(1));
                permission.setPername(resultSet.getString(2));
                permission.setPerids(resultSet.getString(3));
                permission.setFatherID(resultSet.getInt(4));
                permission.setPertype(resultSet.getString(5));
                return permission;
            }
        });
        return list;
    }
    
    
    public boolean roleAddPer(int roleid,int perid) {
        String sql = "insert into role_permission(roleID,rolename,permissionID,permission) select role.id,role.rolename,permission.id,permission.pername from role,permission where role.id=? and permission.id=?";
        int a = jdbcTemplate.update(sql,roleid,perid);
        return a>0;
    }
    
    public boolean roleAddUser(int roleid,int userid) {
        String sql = "insert into user_role(userID,username,roleID,rolename) select user.id,user.username,role.id,role.rolename from role,user where user.id=? and role.id=?";
        int a = jdbcTemplate.update(sql,userid,roleid);
        return a>0;
    }
}
