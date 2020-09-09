package cn.sj.springboot2.model;


import com.fasterxml.jackson.annotation.JsonInclude;

import java.util.List;

/**
 * @author shuzheng
 */
public class User {
    private int id;
    private String username;
    private String password;
    private String birthday;
    private boolean sex;
    private Long tel;
    private String email;
    
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private List<Role> roles;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private List<Permission> permissions;
    
    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", birthday='" + birthday + '\'' +
                ", sex=" + sex +
                ", tel=" + tel +
                ", email='" + email + '\'' +
                ", roles=" + roles +
                ", permissions=" + permissions +
                '}';
    }
    
    public List<Permission> getPermissions() {
        return permissions;
    }
    
    public void setPermissions(List<Permission> permissions) {
        this.permissions = permissions;
    }
    
    public List<Role> getRoles() {
        return roles;
    }
    
    public void setRoles(List<Role> roles) {
        this.roles = roles;
    }
    
    public int getId() {
        return id;
    }
    
    public void setId(int id) {
        this.id = id;
    }
    
    public String getUsername() {
        return username;
    }
    
    public void setUsername(String username) {
        this.username = username;
    }
    
    public String getPassword() {
        return password;
    }
    
    public void setPassword(String password) {
        this.password = password;
    }
    
    public String getBirthday() {
        return birthday;
    }
    
    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }
    
    public boolean isSex() {
        return sex;
    }
    
    public void setSex(boolean sex) {
        this.sex = sex;
    }
    
    public Long getTel() {
        return tel;
    }
    
    public void setTel(Long tel) {
        this.tel = tel;
    }
    
    public String getEmail() {
        return email;
    }
    
    public void setEmail(String email) {
        this.email = email;
    }
}
