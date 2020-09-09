package cn.sj.springboot2.model;

import com.fasterxml.jackson.annotation.JsonInclude;

import java.util.List;

/**
 * @author shuzheng
 */
public class Role {
    private int id;
    private String rolename;
    private String roleide;
    
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private List<User> user;
    
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private List<Permission> permissions;
    
    @Override
    public String toString() {
        return "Role{" +
                "id=" + id +
                ", rolename='" + rolename + '\'' +
                ", roleide='" + roleide + '\'' +
                ", user=" + user +
                ", permissions=" + permissions +
                '}';
    }
    
    public List<Permission> getPermissions() {
        return permissions;
    }
    
    public void setPermissions(List<Permission> permissions) {
        this.permissions = permissions;
    }
    
    public List<User> getUser() {
        return user;
    }
    
    public void setUser(List<User> user) {
        this.user = user;
    }
    
    public int getId() {
        return id;
    }
    
    public void setId(int id) {
        this.id = id;
    }
    
    public String getRolename() {
        return rolename;
    }
    
    public void setRolename(String rolename) {
        this.rolename = rolename;
    }
    
    public String getRoleide() {
        return roleide;
    }
    
    public void setRoleide(String roleide) {
        this.roleide = roleide;
    }
}
