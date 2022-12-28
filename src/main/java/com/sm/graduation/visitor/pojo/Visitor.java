package com.sm.graduation.visitor.pojo;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Visitor {
	/** 编号 */
	private Long id;
	/** 访客姓名 */
	private String name;
	/** 访问对象 */
	private String target;
	/** 日期 */
	private String viTime;

}
