package com.sm.graduation.accident.service;

import com.sm.graduation.accident.pojo.AccidentRecord;
import com.sm.graduation.accident.dao.AccidentRecordMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class AccidentRecordService {

    @Autowired
    private AccidentRecordMapper accidentRecordMapper;

    public List<AccidentRecord> listAll(Map map) {
    	return accidentRecordMapper.listAll(map);
    }

    public AccidentRecord getById(Long id) {
    	return accidentRecordMapper.getById(id);
    }

    public int insert(AccidentRecord accidentRecord) {
    	return accidentRecordMapper.insert(accidentRecord);
    }

    public int update(AccidentRecord accidentRecord) {
    	return accidentRecordMapper.update(accidentRecord);
    }

    public int delete(Integer id) {
    	return accidentRecordMapper.delete(id);
    }

}
