package com.sm.graduation.older.pojo;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class OlderInfo {
	/** 编号 */
	private Long olderId;
	/** 姓名 */
	private String olderName;
	private String olderSex;
	/** 电话 */
	private Long olderTel;
	/** 住址 */
	private String olderAddr;
	/** 身份证号码 */
	private String olderIdcard;
	private String inTime;
	private String outTime;

}
