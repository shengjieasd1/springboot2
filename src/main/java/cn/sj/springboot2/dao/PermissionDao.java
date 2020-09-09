package cn.sj.springboot2.dao;

import cn.sj.springboot2.model.Permission;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * @author shuzheng
 */
@Repository
public class PermissionDao {
    @Resource
    private JdbcTemplate jdbcTemplate;
    /**
     * 权限添加
     *
     * @param permission 权限对象
     * @return 返回布尔型
     */
    
    public boolean addPer(Permission permission) {
        String sql = "insert into permission(pername,perids,fatherID,pertype) values(?,?,?,?)";
        int a = jdbcTemplate.update(sql,permission.getPername(),permission.getPerids(),permission.getFatherID(),permission.getPertype());
        return a>0;
    }
    
    /**
     * 权限修改
     *
     * @param permission 权限对象
     * @return 返回布尔型
     */
    public boolean updatePer(Permission permission) {
        String sql = "update permission set pername=?,perids=?,fatherID=?,pertype=? where id=?";
        int a = jdbcTemplate.update(sql,permission.getPername(),permission.getPerids(),permission.getFatherID(),permission.getPertype(),permission.getId());
        return a>0;
    }
    
    /**
     * 权限删除
     *
     * @param permission 权限对象
     * @return 返回布尔型
     */
    public boolean deletePer(Permission permission) {
        String sql = "delete from permission where id=?";
        int a = jdbcTemplate.update(sql,permission.getId());
        return a>0;
    }
    
    /**
     * 权限查询
     * @param id
     * @return
     */
    public Permission selectPer(int id){
        String sql = "select * from permission where id=?";
        Permission per = jdbcTemplate.queryForObject(sql, new Object[]{id}, new RowMapper<Permission>() {
            @Override
            public Permission mapRow(ResultSet resultSet, int i) throws SQLException {
                Permission per = new Permission();
                per.setId(resultSet.getInt(1));
                per.setPername(resultSet.getString(2));
                per.setPerids(resultSet.getString(3));
                per.setFatherID(resultSet.getInt(4));
                per.setPertype(resultSet.getString(5));
                return per;
            }
        });
        return per;
    }
    
}
