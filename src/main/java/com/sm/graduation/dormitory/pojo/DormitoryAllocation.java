package com.sm.graduation.dormitory.pojo;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class DormitoryAllocation {
	/** 编号 */
	private Long id;
	/** 宿舍 */
	private String dormitory;
	/** 0无人居住 1有人居住 */
	private Short living;
	private String name;
}
