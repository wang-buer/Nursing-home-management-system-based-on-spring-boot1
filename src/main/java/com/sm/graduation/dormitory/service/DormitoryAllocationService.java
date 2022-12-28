package com.sm.graduation.dormitory.service;

import com.sm.graduation.dormitory.pojo.DormitoryAllocation;
import com.sm.graduation.dormitory.dao.DormitoryAllocationMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class DormitoryAllocationService {

    @Autowired
    private DormitoryAllocationMapper dormitoryAllocationMapper;

    public List<DormitoryAllocation> listAll(Map map) {
    	return dormitoryAllocationMapper.listAll(map);
    }

    public DormitoryAllocation getById(Long id) {
    	return dormitoryAllocationMapper.getById(id);
    }

    public int insert(DormitoryAllocation dormitoryAllocation) {
    	return dormitoryAllocationMapper.insert(dormitoryAllocation);
    }

    public int update(DormitoryAllocation dormitoryAllocation) {
    	return dormitoryAllocationMapper.update(dormitoryAllocation);
    }

    public int delete(Integer id) {
    	return dormitoryAllocationMapper.delete(id);
    }

}
