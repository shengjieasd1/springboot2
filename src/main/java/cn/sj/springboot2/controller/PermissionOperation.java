package cn.sj.springboot2.controller;

import cn.sj.springboot2.model.Permission;
import cn.sj.springboot2.services.IPermissonServices;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author shuzheng
 */
@RestController
public class PermissionOperation {
    
    @Resource
    private IPermissonServices permissonServices;
    
    //添加权限
    @RequestMapping("/addPer")
    public String addPermission(Permission permission){
        return permissonServices.addPer(permission);
    }
    
    //修改权限
    @RequestMapping("/updatePer")
    public String updatePermission(Permission permission){
        return permissonServices.updatePer(permission);
    }
    
    //删除权限
    @RequestMapping("/deletePer")
    public String deletePermission(Permission permission){
        return permissonServices.deletePer(permission);
    }
    
}
