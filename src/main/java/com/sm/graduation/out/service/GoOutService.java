package com.sm.graduation.out.service;

import com.sm.graduation.out.pojo.GoOut;
import com.sm.graduation.out.dao.GoOutMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class GoOutService {

    @Autowired
    private GoOutMapper goOutMapper;

    /**
     * 查询所有记录
     *
     * @return 返回集合，没有返回空List
     */
    public List<GoOut> listAll(Map map) {
    	return goOutMapper.listAll(map);
    }

    public List<GoOut> go_listAll(Map map) {
        return goOutMapper.go_listAll(map);
    }


    /**
     * 根据主键查询
     *
     * @param id 主键
     * @return 返回记录，没有返回null
     */
    public GoOut getById(Long id) {
    	return goOutMapper.getById(id);
    }

    /**
     * 新增，插入所有字段
     *
     * @param goOut 新增的记录
     * @return 返回影响行数
     */
    public int insert(GoOut goOut) {
    	return goOutMapper.insert(goOut);
    }



    /**
     * 修改，修改所有字段
     *
     * @param goOut 修改的记录
     * @return 返回影响行数
     */
    public int update(GoOut goOut) {
    	return goOutMapper.update(goOut);
    }


    /**
     * 删除记录
     *
     * @param goOut 待删除的记录
     * @return 返回影响行数
     */
    public int delete(Integer id) {
    	return goOutMapper.delete(id);
    }

}
