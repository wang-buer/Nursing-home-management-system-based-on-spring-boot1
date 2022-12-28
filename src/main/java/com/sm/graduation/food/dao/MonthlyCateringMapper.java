package com.sm.graduation.food.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.*;
import com.sm.graduation.food.pojo.MonthlyCatering;

@Mapper
public interface MonthlyCateringMapper {

	List<MonthlyCatering> listAll(Map map);



	@Select("select id,mon_name,cost,mon_time from monthly_catering where id=#{id}")
	MonthlyCatering getById(Long id);


	@Insert("insert into monthly_catering(mon_name,cost,mon_time) values(#{monName},#{cost},#{monTime})")
	int insert(MonthlyCatering monthlyCatering);


	@Update("update monthly_catering set mon_name=#{monName}, cost=#{cost}, mon_time=#{monTime} where id=#{id}")
	int update(MonthlyCatering monthlyCatering);


	@Delete("delete from monthly_catering where id=#{id}")
	int delete(Integer id);

}
