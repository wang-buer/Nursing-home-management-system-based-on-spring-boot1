package com.sm.graduation.medication.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.*;
import com.sm.graduation.medication.pojo.Medication;

@Mapper
public interface MedicationMapper {


    List<Medication> listAll(Map map);


	@Select("select id,medication,create_time,expiration_time,cost from medication where id=#{id}")
	Medication getById(Long id);


	@Insert("insert into medication(medication,create_time,expiration_time,cost) values(#{medication},#{createTime},#{expirationTime},#{cost})")
	int insert(Medication medication);


	@Update("update medication set medication=#{medication}, create_time=#{createTime}, expiration_time=#{expirationTime},cost=#{cost} where id=#{id}")
	int update(Medication medication);

	@Delete("delete from medication where id=#{id}")
	int delete(Integer id);

}
