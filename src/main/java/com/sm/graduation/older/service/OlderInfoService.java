package com.sm.graduation.older.service;

import com.sm.graduation.older.pojo.OlderInfo;
import com.sm.graduation.older.dao.OlderInfoMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class OlderInfoService {

    @Autowired
    private OlderInfoMapper olderInfoMapper;

    public List<OlderInfo> listAll(Map map) {
    	return olderInfoMapper.listAll(map);
    }

    public OlderInfo getById(Long olderId) {
    	return olderInfoMapper.getById(olderId);
    }

    public int insert(OlderInfo olderInfo) {
    	return olderInfoMapper.insert(olderInfo);
    }

    public int update(OlderInfo olderInfo) {
    	return olderInfoMapper.update(olderInfo);
    }

    public int delete(Integer id) {
    	return olderInfoMapper.delete(id);
    }

}
