package com.sm.graduation.usr.dao;

import java.util.List;
import java.util.Map;

import com.sm.graduation.root.pojo.RootInfo;
import org.apache.ibatis.annotations.*;
import com.sm.graduation.usr.pojo.UsrInfo;

@Mapper
public interface UsrInfoMapper {


	@Select("select * from usr_info where usr_login=#{usrLogin}")
	UsrInfo sltName(UsrInfo usrInfo);


	@Select("select count(*)  from usr_info where usr_login=#{usrLogin} and usr_pwd=#{usrPwd}")
	boolean loginIn(UsrInfo usrInfo);

	List<UsrInfo> listAll(Map map);

	@Select("select usr_id,usr_login,usr_name,usr_sex,usr_tel,usr_addr,older_name from usr_info where usr_id=#{usrId}")
	UsrInfo getById(Long usrId);

	@Insert("insert into usr_info(usr_login,usr_name,usr_sex,usr_tel,usr_addr,older_name) values(#{usrLogin},#{usrName},#{usrSex},#{usrTel},#{usrAddr},#{olderName})")
	int insert(UsrInfo usrInfo);

	@Update("update usr_info set usr_login=#{usrLogin}, usr_name=#{usrName}, usr_sex=#{usrSex},usr_tel=#{usrTel},usr_addr=#{usrAddr},older_name=#{olderName} where usr_id=#{usrId}")
	int update(UsrInfo usrInfo);

	@Delete("delete from usr_info where usr_id=#{usrId}")
	int delete(Integer usrId);

	@Update("update usr_info set usr_pwd=#{pwd} where usr_id=#{id}")
	int altPwd(Map map);

}
