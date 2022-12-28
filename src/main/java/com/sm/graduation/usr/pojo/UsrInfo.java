package com.sm.graduation.usr.pojo;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UsrInfo {
	/** 编号 */
	private Long usrId;
	/** 登录名 */
	private String usrLogin;
	/** 用户名 */
	private String usrName;
	private String usrSex;
	/** 登录密码 */
	private String usrPwd;
	/** 电话 */
	private Long usrTel;
	/** 地址 */
	private String usrAddr;
	private String olderName;

}
