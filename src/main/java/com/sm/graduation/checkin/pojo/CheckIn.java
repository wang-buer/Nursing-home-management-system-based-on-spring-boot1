package com.sm.graduation.checkin.pojo;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CheckIn {
	/** 编号 */
	private Long id;
	/** 入住费用 */
	private Double cost;
	/** 年份 */
	private String year;

}
