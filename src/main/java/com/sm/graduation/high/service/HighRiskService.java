package com.sm.graduation.high.service;

import com.sm.graduation.high.pojo.HighRisk;
import com.sm.graduation.high.dao.HighRiskMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class HighRiskService {

    @Autowired
    private HighRiskMapper highRiskMapper;

    /**
     * 查询所有记录
     *
     * @return 返回集合，没有返回空List
     */
    public List<HighRisk> listAll(Map map) {
    	return highRiskMapper.listAll(map);
    }


    /**
     * 根据主键查询
     *
     * @param id 主键
     * @return 返回记录，没有返回null
     */
    public HighRisk getById(Long id) {
    	return highRiskMapper.getById(id);
    }

    /**
     * 新增，插入所有字段
     *
     * @param highRisk 新增的记录
     * @return 返回影响行数
     */
    public int insert(HighRisk highRisk) {
    	return highRiskMapper.insert(highRisk);
    }



    /**
     * 修改，修改所有字段
     *
     * @param highRisk 修改的记录
     * @return 返回影响行数
     */
    public int update(HighRisk highRisk) {
    	return highRiskMapper.update(highRisk);
    }


    /**
     * 删除记录
     *
     * @param highRisk 待删除的记录
     * @return 返回影响行数
     */
    public int delete(Integer id) {
    	return highRiskMapper.delete(id);
    }

}
