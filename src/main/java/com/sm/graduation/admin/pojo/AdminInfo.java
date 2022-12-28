package com.sm.graduation.admin.pojo;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AdminInfo {
	/** 管理员编号 */
	private Long adminId;
	/** 登录名 */
	private String adminLogin;
	/** 密码 */
	private String adminPwd;
	/** 用户名 */
	private String adminName;
	private long adminTel;

	private String adminSex;
	private short power;

}
