package com.sm.graduation.medication.service;

import com.sm.graduation.medication.pojo.Medication;
import com.sm.graduation.medication.dao.MedicationMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class MedicationService {

    @Autowired
    private MedicationMapper medicationMapper;

    public List<Medication> listAll(Map map) {
    	return medicationMapper.listAll(map);
    }

    public Medication getById(Long id) {
    	return medicationMapper.getById(id);
    }

    public int insert(Medication medication) {
    	return medicationMapper.insert(medication);
    }

    public int update(Medication medication) {
    	return medicationMapper.update(medication);
    }

    public int delete(Integer id) {
    	return medicationMapper.delete(id);
    }

}
