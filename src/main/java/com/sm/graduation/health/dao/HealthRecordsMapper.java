package com.sm.graduation.health.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.*;
import com.sm.graduation.health.pojo.HealthRecords;

@Mapper
public interface HealthRecordsMapper {


    List<HealthRecords> listAll(Map map);

	@Select("select id,name,sex,born,height,weight,blood_type,allergy,heart_rate,blood_pressure,blood_sugar,smoke,create_time from health_records where id=#{id}")
	HealthRecords getById(Long id);


	HealthRecords older_dorm(String olderName);

	@Insert("insert into health_records(name,sex,born,height,weight,blood_type,allergy,heart_rate,blood_pressure,blood_sugar,smoke,create_time) " +
			"values(#{name},#{sex},#{born},#{height},#{weight},#{bloodType},#{allergy},#{heartRate},#{bloodPressure},#{bloodSugar},#{smoke},#{createTime})")
	int insert(HealthRecords healthRecords);


	@Update("update health_records set name=#{name}, sex=#{sex}, born=#{born},height=#{height},weight=#{weight},blood_type=#{bloodType},allergy=#{allergy},heart_rate=#{heartRate},blood_pressure=#{bloodPressure},blood_sugar=#{bloodSugar},smoke=#{smoke},create_time=#{createTime} where id=#{id}")
	int update(HealthRecords healthRecords);


	@Delete("delete from health_records where id=#{id}")
	int delete(Integer id);

}
