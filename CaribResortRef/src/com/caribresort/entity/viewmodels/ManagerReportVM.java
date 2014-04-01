package com.caribresort.entity.viewmodels;

import java.io.Serializable;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

public class ManagerReportVM implements Serializable{

	private static final long serialVersionUID = 1L;
	private List<FrequencyReportRecord> frequencyReport = new ArrayList<FrequencyReportRecord>();
	private List<FrequencyDrinkRecord> frequencyDrink = new ArrayList<FrequencyDrinkRecord>();
	
	
	public ManagerReportVM() {
		super();
	}

	/**
	 * @param frequencyReport
	 * @param frequencyDrink
	 */
	public ManagerReportVM(List<FrequencyReportRecord> frequencyReport,
			List<FrequencyDrinkRecord> frequencyDrink) {
		super();
		this.frequencyReport = frequencyReport;
		this.frequencyDrink = frequencyDrink;
	}

	public List<FrequencyReportRecord> getFrequencyReport() {
		return frequencyReport;
	}
	
	public void addFrequencyReportRecord(FrequencyReportRecord record){
		frequencyReport.add(record);
	}

	public void setFrequencyReport(List<FrequencyReportRecord> frequencyReport) {
		this.frequencyReport = frequencyReport;
	}

	public List<FrequencyDrinkRecord> getFrequencyDrink() {
		return frequencyDrink;
	}
	
	public void addFrequencyDrinkRecord(FrequencyDrinkRecord record){
		frequencyDrink.add(record);
	}

	public void setFrequencyDrink(List<FrequencyDrinkRecord> frequencyDrink) {
		this.frequencyDrink = frequencyDrink;
	}

	public class FrequencyReportRecord implements Serializable{
	    
		private static final long serialVersionUID = 1L;
		private Integer drinkId;
		private String drinkName;
		private Integer quantitySum;
		private java.sql.Date orderDate;
		
		public FrequencyReportRecord(){
			this(0,"",0,null);
		}
		
		public FrequencyReportRecord(Object[] record) throws Exception{
			this(Integer.parseInt(String.valueOf(record[0])),    String.valueOf(record[1]),Integer.parseInt(String.valueOf(record[2])),java.sql.Date.valueOf(String.valueOf(record[3])))    ;
		}
		
		/**
		 * @param drinkId
		 * @param drinkName
		 * @param quantitySum
		 * @param orderDate
		 */
		public FrequencyReportRecord(Integer drinkId, String drinkName,
				Integer quantitySum, Date orderDate) {
			super();
			this.drinkId = drinkId;
			this.drinkName = drinkName;
			this.quantitySum = quantitySum;
			this.orderDate = orderDate;
		}
		public Integer getDrinkId() {
			return drinkId;
		}
		public void setDrinkId(Integer drinkId) {
			this.drinkId = drinkId;
		}
		public String getDrinkName() {
			return drinkName;
		}
		public void setDrinkName(String drinkName) {
			this.drinkName = drinkName;
		}
		public Integer getQuantitySum() {
			return quantitySum;
		}
		public void setQuantitySum(Integer quantitySum) {
			this.quantitySum = quantitySum;
		}
		public java.sql.Date getOrderDate() {
			return orderDate;
		}
		public void setOrderDate(java.sql.Date orderDate) {
			this.orderDate = orderDate;
		}

		@Override
		public String toString() {
			return "FrequencyReportRecord [drinkId=" + drinkId + ", drinkName="
					+ drinkName + ", quantitySum=" + quantitySum
					+ ", orderDate=" + orderDate + "]";
		}
		
		
		
	}

    public class FrequencyDrinkRecord implements Serializable{
	    
		private static final long serialVersionUID = 1L;
		private Integer drinkId;
		private String drinkName;
		private Integer quantitySum;
		
		public FrequencyDrinkRecord(){
			this(0,"",0);
		}
		
		public FrequencyDrinkRecord(Object[] record) throws Exception{
			this(Integer.parseInt(String.valueOf(record[0])),    String.valueOf(record[1]),Integer.parseInt(String.valueOf(record[2])))    ;
		}
		
		/**
		 * @param drinkId
		 * @param drinkName
		 * @param quantitySum
		 */
		public FrequencyDrinkRecord(Integer drinkId, String drinkName,
				Integer quantitySum) {
			super();
			this.drinkId = drinkId;
			this.drinkName = drinkName;
			this.quantitySum = quantitySum;
		}
		public Integer getDrinkId() {
			return drinkId;
		}
		public void setDrinkId(Integer drinkId) {
			this.drinkId = drinkId;
		}
		public String getDrinkName() {
			return drinkName;
		}
		public void setDrinkName(String drinkName) {
			this.drinkName = drinkName;
		}
		public Integer getQuantitySum() {
			return quantitySum;
		}
		public void setQuantitySum(Integer quantitySum) {
			this.quantitySum = quantitySum;
		}


		@Override
		public String toString() {
			return "FrequencyReportRecord [drinkId=" + drinkId + ", drinkName="
					+ drinkName + ", quantitySum=" + quantitySum
					+  "]";
		}
		
		
		
	}

}
