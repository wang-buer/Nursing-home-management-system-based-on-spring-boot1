package com.sm.graduation.older.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.*;
import com.sm.graduation.older.pojo.OlderInfo;

@Mapper
public interface OlderInfoMapper {

	List<OlderInfo> listAll(Map map);


	@Select("select older_id,older_name,older_sex,older_tel,older_addr,older_idcard,in_time,out_time from older_info where older_id=#{olderId}")
	OlderInfo getById(Long olderId);

	@Insert("insert into older_info(older_name,older_sex,older_tel,older_addr,older_idcard,in_time,out_time) values(#{olderName},#{olderSex},#{olderTel},#{olderAddr},#{olderIdcard}),#{inTime},#{outTime}")
	int insert(OlderInfo olderInfo);


	@Update("update older_info set older_name=#{olderName}, older_sex=#{olderSex}, older_tel=#{olderTel},older_addr=#{olderAddr},older_idcard=#{olderIdcard},in_time=#{inTime},out_time=#{outTime} where older_id=#{olderId}")
	int update(OlderInfo olderInfo);


	@Delete("delete from older_info where older_id=#{id}")
	int delete(Integer id);

}
