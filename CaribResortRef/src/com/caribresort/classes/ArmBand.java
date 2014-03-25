package com.caribresort.classes;

public class ArmBand {
     private int armBandId;
     private String armBandName;
     
     
	/**
	 * @param armBandId - int
	 * @param armBandName - String
	 */
	public ArmBand(int armBandId, String armBandName) {
		super();
		this.armBandId = armBandId;
		this.armBandName = armBandName;
	}
	
	public ArmBand(){
		this(0,"");
	}
	public int getArmBandId() {
		return armBandId;
	}
	public void setArmBandId(int armBandId) {
		this.armBandId = armBandId;
	}
	public String getArmBandName() {
		return armBandName;
	}
	public void setArmBandName(String armBandName) {
		this.armBandName = armBandName;
	}

	@Override
	public String toString() {
		return "{ armBandId:" + armBandId + ", armBandName:"
				+ armBandName + "}";
	}
	
	
}
