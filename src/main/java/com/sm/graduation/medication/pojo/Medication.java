package com.sm.graduation.medication.pojo;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Medication {
	/** 药品编号 */
	private Long id;
	/** 药名 */
	private String medication;

	private String createTime;

	private  String expirationTime;
	/** 价格 */
	private Double cost;
}
