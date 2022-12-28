package com.sm.graduation.health.pojo;

import com.sm.graduation.dormitory.pojo.DormitoryAllocation;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;


@Data
@NoArgsConstructor
@AllArgsConstructor
public class HealthRecords {
	/** 编号记录 */
	private Long id;
	/** 姓名 */
	private String name;
	/** 性别 */
	private String sex;
	/** 出生 */
	private String born;
	/** 身高 */
	private Double height;
	/** 体重 */
	private Double weight;
	/** 血型 */
	private String bloodType;
	/** 过敏 */
	private String allergy;
	/** 心率 60～100次/分 */
	private Double heartRate;
	/** 血压 90～139mmHg */
	private Double bloodPressure;
	/** 血糖 3.92～7.0mmol/L */
	private Double bloodSugar;
	/** 吸烟 */
	private String smoke;

	private String createTime;

	private DormitoryAllocation dorm;
}
