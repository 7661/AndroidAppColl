package cost.tracker.data.bean;

import java.io.Serializable;

public class StatementData extends TableData implements Serializable{

	private String dataTableName;
	private String dataTableType;
	
	private String recordType;
	
	private String primaryId;
	private String userId;
	private String amount;
	private String statementName;
	private String startDate;
	private String endDate;
	public StatementData(){
		this.dataTableType = "statement_rec"; 
	}
	public String getDataTableName() {
		return dataTableName;
	}
	public void setDataTableName(String dataTableName) {
		this.dataTableName = dataTableName;
	}
	public String getDataTableType() {
		return dataTableType;
	}
	public void setDataTableType(String dataTableType) {
		this.dataTableType = dataTableType;
	}
	public String getRecordType() {
		return recordType;
	}
	public void setRecordType(String recordType) {
		this.recordType = recordType;
	}
	public String getPrimaryId() {
		return primaryId;
	}
	public void setPrimaryId(String primaryId) {
		this.primaryId = primaryId;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getAmount() {
		return amount;
	}
	public void setAmount(String amount) {
		this.amount = amount;
	}
	public String getStatementName() {
		return statementName;
	}
	public void setStatementName(String statementName) {
		this.statementName = statementName;
	}
	public String getStartDate() {
		return startDate;
	}
	public void setStartDate(String startDate) {
		this.startDate = startDate;
	}
	public String getEndDate() {
		return endDate;
	}
	public void setEndDate(String endDate) {
		this.endDate = endDate;
	}
	
}
