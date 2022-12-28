package com.sm.graduation.food.service;

import com.sm.graduation.food.pojo.MonthlyCatering;
import com.sm.graduation.food.dao.MonthlyCateringMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class MonthlyCateringService {

    @Autowired
    private MonthlyCateringMapper monthlyCateringMapper;


    public List<MonthlyCatering> listAll(Map map) {
    	return monthlyCateringMapper.listAll(map);
    }


    public MonthlyCatering getById(Long id) {
    	return monthlyCateringMapper.getById(id);
    }


    public int insert(MonthlyCatering monthlyCatering) {
    	return monthlyCateringMapper.insert(monthlyCatering);
    }


    public int update(MonthlyCatering monthlyCatering) {
    	return monthlyCateringMapper.update(monthlyCatering);
    }


    public int delete(Integer id) {
    	return monthlyCateringMapper.delete(id);
    }

}
