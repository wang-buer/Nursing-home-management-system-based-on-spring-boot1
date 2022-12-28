package com.sm.graduation.out.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.*;
import com.sm.graduation.out.pojo.GoOut;

@Mapper
public interface GoOutMapper {

	List<GoOut> listAll(Map map);

	List<GoOut> go_listAll(Map map);

	@Select("select id,event,event_time,name,back_time from go_out where id=#{id}")
	GoOut getById(Long id);

	@Insert("insert into go_out(event,event_time,back_time,name) values(#{event},#{eventTime},#{name},back_time=#{backTime})")
	int insert(GoOut goOut);

	@Update("update go_out set event=#{event}, event_time=#{eventTime}, name=#{name}, back_time=#{backTime} where id=#{id}")
	int update(GoOut goOut);

	@Delete("delete from go_out where id=#{id}")
	int delete(Integer id);

}
