package com.sm.graduation.nurse.pojo;


public class Nursing {
	/** 编号 */
	private Long id;
	/** 等级 */
	private String nurseRank;
	/** 费用 */
	private Integer cost;

	public void setId(Long id) {
		this.id = id;
	}
	
	public Long getId() {
		return this.id;
	}
	
	public void setNurseRank(String nurseRank) {
		this.nurseRank = nurseRank;
	}
	
	public String getNurseRank() {
		return this.nurseRank;
	}
	
	public void setCost(Integer cost) {
		this.cost = cost;
	}
	
	public Integer getCost() {
		return this.cost;
	}
	

	@Override
    public boolean equals(Object o) {
        if (this == o) { return true; }
        if (o == null || getClass() != o.getClass()) {return false;}
        Nursing that = (Nursing) o;
        return id.equals(that.id);
    }

    @Override
    public int hashCode() {
        return java.util.Objects.hash(id);
    }
    
    @Override
    public String toString() {
        return "Nursing{" +
				"id=" + id +
						",nurseRank='" + nurseRank + "'" + 
						",cost='" + cost + "'" + 
		                '}';
    }
	
}