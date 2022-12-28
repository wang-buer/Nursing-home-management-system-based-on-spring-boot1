package com.sm.graduation.admin.service;

import com.sm.graduation.admin.pojo.AdminInfo;
import com.sm.graduation.admin.dao.AdminInfoMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class AdminInfoService {

    @Autowired
    private AdminInfoMapper adminInfoMapper;

    public AdminInfo sltName(AdminInfo adminInfo){
        return adminInfoMapper.sltName(adminInfo);
    }

    public boolean loginIn(AdminInfo adminInfo){
        return adminInfoMapper.loginIn(adminInfo);
    }

    public List<AdminInfo> listAll(Map map) {
    	return adminInfoMapper.listAll(map);
    }

    public AdminInfo getById(Long adminId) {
    	return adminInfoMapper.getById(adminId);
    }

    public int insert(AdminInfo adminInfo) {
    	return adminInfoMapper.insert(adminInfo);
    }

    public int update(AdminInfo adminInfo) {
    	return adminInfoMapper.update(adminInfo);
    }

    public int delAdmin(Integer adminId) {
    	return adminInfoMapper.delAdmin(adminId);
    }

    public int altPwd(Map map) {
        return adminInfoMapper.altPwd(map);
    }

}
