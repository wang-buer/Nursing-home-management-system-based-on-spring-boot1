package com.sm.graduation.nurse.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.*;
import com.sm.graduation.nurse.pojo.Nursing;

@Mapper
public interface NursingMapper {

	List<Nursing> listAll(Map map);

	@Select("select id,nurse_rank,cost from nursing where id=#{id}")
	Nursing getById(Long id);

	@Insert("insert into nursing(nurse_rank,cost) values(#{nurseRank},#{cost})")
	int insert(Nursing nursing);

	@Update("update nursing set nurse_rank=#{nurseRank}, cost=#{cost} where id=#{id}")
	int update(Nursing nursing);

	@Delete("delete from nursing where id=#{id}")
	int delete(Integer id);

}
