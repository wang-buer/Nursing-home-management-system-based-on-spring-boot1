package com.sm.graduation.visitor.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.*;
import com.sm.graduation.visitor.pojo.Visitor;

@Mapper
public interface VisitorMapper {

	List<Visitor> listAll(Map map);

	@Select("select id,name,target,vi_time from visitor where id=#{id}")
	Visitor getById(Long id);

	@Insert("insert into visitor(name,target,vi_time) values(#{name},#{target},#{viTime})")
	int insert(Visitor visitor);

	@Update("update visitor set name=#{name}, target=#{target}, vi_time=#{viTime} where id=#{id}")
	int update(Visitor visitor);

	@Delete("delete from visitor where id=#{id}")
	int delete(Integer id);

}
