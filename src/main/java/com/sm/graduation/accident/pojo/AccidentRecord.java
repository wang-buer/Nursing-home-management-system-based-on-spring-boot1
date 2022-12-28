package com.sm.graduation.accident.pojo;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AccidentRecord {
	/** 编号 */
	private Long id;
	/** 事故 */
	private String accident;
	private String desc;
	/** 年月 */
	private String accTime;
	/** 损失 */
	private Long loss;

}
