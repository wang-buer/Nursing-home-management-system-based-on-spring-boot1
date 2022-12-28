package com.sm.graduation.high.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.*;
import com.sm.graduation.high.pojo.HighRisk;

@Mapper
public interface HighRiskMapper {


    List<HighRisk> listAll(Map map);

	@Select("select id,name,tel,high_case,relatives,re_tel from high_risk where id=#{id}")
	HighRisk getById(Long id);

	@Insert("insert into high_risk(name,tel,high_case,relatives,re_tel) values(#{name},#{tel},#{highCase},#{relatives},#{reTel})")
	int insert(HighRisk highRisk);

	@Update("update high_risk set name=#{name}, tel=#{tel}, high_case=#{highCase},relatives=#{relatives},re_tel=#{reTel} where id=#{id}")
	int update(HighRisk highRisk);

	@Delete("delete from high_risk where id=#{id}")
	int delete(Integer id);

}
