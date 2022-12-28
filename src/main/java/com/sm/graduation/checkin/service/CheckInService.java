package com.sm.graduation.checkin.service;

import com.sm.graduation.checkin.pojo.CheckIn;
import com.sm.graduation.checkin.dao.CheckInMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class CheckInService {

    @Autowired
    private CheckInMapper checkInMapper;

    public List<CheckIn> listAll(Map map) {
    	return checkInMapper.listAll(map);
    }

    public CheckIn getById(Long id) {
    	return checkInMapper.getById(id);
    }

    public int insert(CheckIn checkIn) {
    	return checkInMapper.insert(checkIn);
    }

    public int update(CheckIn checkIn) {
    	return checkInMapper.update(checkIn);
    }

    public int delete(Integer id) {
    	return checkInMapper.delete(id);
    }

}
