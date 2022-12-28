package com.sm.graduation.health.service;

import com.sm.graduation.health.pojo.HealthRecords;
import com.sm.graduation.health.dao.HealthRecordsMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class HealthRecordsService {

    @Autowired
    private HealthRecordsMapper healthRecordsMapper;

    public List<HealthRecords> listAll(Map map) {
    	return healthRecordsMapper.listAll(map);
    }

    public HealthRecords getById(Long id) {
    	return healthRecordsMapper.getById(id);
    }

    public HealthRecords older_dorm(String olderName) {
        return healthRecordsMapper.older_dorm(olderName);
    }

    public int insert(HealthRecords healthRecords) {
    	return healthRecordsMapper.insert(healthRecords);
    }


    public int update(HealthRecords healthRecords) {
    	return healthRecordsMapper.update(healthRecords);
    }
    public int delete(Integer id) {
    	return healthRecordsMapper.delete(id);
    }

}
