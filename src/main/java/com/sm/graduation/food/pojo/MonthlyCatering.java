package com.sm.graduation.food.pojo;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class MonthlyCatering {
	/** 编号 */
	private Long id;
	/** 菜肴 */
	private String monName;
	/** 费用 */
	private Integer cost;
	/** 日期 */
	private String monTime;
}
