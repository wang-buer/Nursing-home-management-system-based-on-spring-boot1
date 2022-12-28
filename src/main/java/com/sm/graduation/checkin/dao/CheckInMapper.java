package com.sm.graduation.checkin.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.*;
import com.sm.graduation.checkin.pojo.CheckIn;

@Mapper
public interface CheckInMapper {


	List<CheckIn> listAll(Map map);

	@Select("select id,cost,year from check_in where id=#{id}")
	CheckIn getById(Long id);

	@Insert("insert into check_in(cost,year) values(#{cost},#{year})")
	int insert(CheckIn checkIn);

	@Update("update check_in set cost=#{cost}, year=#{year} where id=#{id}")
	int update(CheckIn checkIn);

	@Delete("delete from check_in where id=#{id}")
	int delete(Integer id);

}
