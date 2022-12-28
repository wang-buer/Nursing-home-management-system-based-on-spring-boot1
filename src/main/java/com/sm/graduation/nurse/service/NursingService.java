package com.sm.graduation.nurse.service;

import com.sm.graduation.nurse.pojo.Nursing;
import com.sm.graduation.nurse.dao.NursingMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class NursingService {

    @Autowired
    private NursingMapper nursingMapper;


    public List<Nursing> listAll(Map map) {
    	return nursingMapper.listAll(map);
    }


    public Nursing getById(Long id) {
    	return nursingMapper.getById(id);
    }

    public int insert(Nursing nursing) {
    	return nursingMapper.insert(nursing);
    }

    public int update(Nursing nursing) {
    	return nursingMapper.update(nursing);
    }

    public int delete(Integer id) {
    	return nursingMapper.delete(id);
    }

}
