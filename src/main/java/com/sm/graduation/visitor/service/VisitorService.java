package com.sm.graduation.visitor.service;

import com.sm.graduation.visitor.pojo.Visitor;
import com.sm.graduation.visitor.dao.VisitorMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class VisitorService {

    @Autowired
    private VisitorMapper visitorMapper;

    public List<Visitor> listAll(Map map) {
    	return visitorMapper.listAll(map);
    }

    public Visitor getById(Long id) {
    	return visitorMapper.getById(id);
    }

    public int insert(Visitor visitor) {
    	return visitorMapper.insert(visitor);
    }

    public int update(Visitor visitor) {
    	return visitorMapper.update(visitor);
    }

    public int delete(Integer id) {
    	return visitorMapper.delete(id);
    }

}
