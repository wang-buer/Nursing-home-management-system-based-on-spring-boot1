package com.sm.graduation.dormitory.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.*;
import com.sm.graduation.dormitory.pojo.DormitoryAllocation;

@Mapper
public interface DormitoryAllocationMapper {

	List<DormitoryAllocation> listAll(Map map);


	@Select("select id,dormitory,living,name from dormitory_allocation where id=#{id}")
	DormitoryAllocation getById(Long id);


	@Insert("insert into dormitory_allocation(dormitory,living,name) values(#{dormitory},#{living},#{name})")
	int insert(DormitoryAllocation dormitoryAllocation);

	@Update("update dormitory_allocation set dormitory=#{dormitory}, living=#{living}, name=#{name} where id=#{id}")
	int update(DormitoryAllocation dormitoryAllocation);


	@Delete("delete from dormitory_allocation where id=#{id}")
	int delete(Integer id);

}
