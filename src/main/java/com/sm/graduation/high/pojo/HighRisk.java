package com.sm.graduation.high.pojo;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class HighRisk {
	/** 档案编号 */
	private Long id;
	/** 姓名 */
	private String name;
	/** 电话 */
	private Long tel;
	/** 病例 */
	private String highCase;
	/** 亲属 */
	private String relatives;
	/** 亲属电话 */
	private Long reTel;

}
