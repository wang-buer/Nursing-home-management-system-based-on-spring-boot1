package com.sm.graduation.root.pojo;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class RootInfo {
	/** 超级管理员 */
	private Short id;
	/** 登录名 */
	private String name;
	/** 密码 */
	private String pwd;
	/** 绰号 */
	private String nickName;
	/** 权限 */
	private short power;

}
