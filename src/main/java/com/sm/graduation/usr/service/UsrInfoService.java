package com.sm.graduation.usr.service;

import com.sm.graduation.usr.pojo.UsrInfo;
import com.sm.graduation.usr.dao.UsrInfoMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class UsrInfoService {

    @Autowired
    private UsrInfoMapper usrInfoMapper;

    public UsrInfo sltName(UsrInfo usrInfo) {
        return usrInfoMapper.sltName(usrInfo);
    }

    public boolean loginIn(UsrInfo usrInfo) {
        return usrInfoMapper.loginIn(usrInfo);
    }


    public List<UsrInfo> listAll(Map map) {
    	return usrInfoMapper.listAll(map);
    }

    public UsrInfo getById(Long usrId) {
    	return usrInfoMapper.getById(usrId);
    }

    public int insert(UsrInfo usrInfo) {
    	return usrInfoMapper.insert(usrInfo);
    }

    public int update(UsrInfo usrInfo) {
    	return usrInfoMapper.update(usrInfo);
    }

    public int delete(Integer usrId) {
    	return usrInfoMapper.delete(usrId);
    }

    public int altPwd(Map map) {
        return usrInfoMapper.altPwd(map);
    }


}
