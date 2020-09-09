package cn.sj.springboot2.services;

import cn.sj.springboot2.model.Permission;
import org.springframework.stereotype.Service;

/**
 * @author shuzheng
 */
@Service
public interface IPermissonServices {
    /**
     * 添加权限
     * @param per
     * @return
     */
    public String addPer(Permission per);
    
    /**
     * 修改权限
     * @param per
     * @return
     */
    public String updatePer(Permission per);
    
    /**
     * 删除权限
     * @param per
     * @return
     */
    public String deletePer(Permission per);
    
    /**
     * 查询权限
     * @param id
     * @return
     */
    public Permission selectPer(int id);
}
