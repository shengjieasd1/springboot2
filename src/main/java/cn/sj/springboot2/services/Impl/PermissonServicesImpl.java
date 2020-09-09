package cn.sj.springboot2.services.Impl;

import cn.sj.springboot2.dao.PermissionDao;
import cn.sj.springboot2.model.Permission;
import cn.sj.springboot2.services.IPermissonServices;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @author shuzheng
 */
@Service
public class PermissonServicesImpl implements IPermissonServices {
    @Resource
    private PermissionDao perDao;
    
    @Override
    public String addPer(Permission per) {
        boolean boon =  perDao.addPer(per);
        if(boon){
            return "添加权限名称:"+per.getPername()+"成功";
        }else {
            return "添加权限名称:"+per.getPername()+"失败";
        }
    }
    
    @Override
    public String updatePer(Permission per) {
        Permission per1 = perDao.selectPer(per.getId());
        if(per1.getPername().equals(per.getPername())){
            boolean boon = perDao.updatePer(per);
            if(boon){
                return "修改权限名为："+per.getPername()+"成功";
            }else {
                return "修改权限名为："+per.getPername()+"失败";
            }
        }else {
            return "权限名不一致，修改失败";
        }
    }
    
    @Override
    public String deletePer(Permission per) {
        Permission per1 = perDao.selectPer(per.getId());
        if(per1.getPername().equals(per.getPername())){
            boolean boon = perDao.deletePer(per);
            if(boon){
                return "删除权限:"+per.getPername()+"成功";
            }else {
                return "删除权限:"+per.getPername()+"失败";
            }
        }else {
            return "权限名不一致，删除失败";
        }
    }
    
    @Override
    public Permission selectPer(int id) {
        return perDao.selectPer(id);
    }
}
