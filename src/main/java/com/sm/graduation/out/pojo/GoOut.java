package com.sm.graduation.out.pojo;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class GoOut {
	/** 编号记录 */
	private Long id;
	/** 外出事件 */
	private String event;
	/** 日期 */
	private String eventTime;
	/** 姓名 */
	private String name;
	private String backTime;


}
