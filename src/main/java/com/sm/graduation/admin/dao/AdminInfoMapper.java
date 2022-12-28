package com.sm.graduation.admin.dao;

import java.util.List;
import java.util.Map;

import com.sm.graduation.root.pojo.RootInfo;
import org.apache.ibatis.annotations.*;
import com.sm.graduation.admin.pojo.AdminInfo;

@Mapper
public interface AdminInfoMapper {

	@Select("select * from admin_info where admin_login=#{adminLogin}")
	AdminInfo sltName(AdminInfo adminInfo);


	@Select("select count(*)  from admin_info where admin_login=#{adminLogin} and admin_pwd=#{adminPwd}")
	boolean loginIn(AdminInfo adminInfo);


	List<AdminInfo> listAll(Map map);

	@Select("select * from admin_info where admin_id=#{adminID}")
	AdminInfo getById(Long adminId);

	@Insert("insert into admin_info(admin_login,admin_name,admin_sex,admin_tel) values(#{adminLogin},#{adminName},#{adminSex},#{adminTel}) ")
	int insert(AdminInfo adminInfo);

	@Update("update admin_info set admin_login=#{adminLogin}, admin_name=#{adminName},admin_sex=#{adminSex},admin_tel=#{adminTel} where admin_id=#{adminId}")
	int update(AdminInfo adminInfo);

	@Delete("delete from admin_info where admin_id=#{adminId}")
	int delAdmin(Integer adminId);

	@Update("update admin_info set admin_pwd=#{pwd} where admin_id=#{id}")
	int altPwd(Map map);

}
