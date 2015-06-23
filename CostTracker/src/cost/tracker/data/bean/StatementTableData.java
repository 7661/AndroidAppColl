package cost.tracker.data.bean;

import java.io.Serializable;

public class StatementTableData extends TableData implements Serializable {

	private String dataTableName;
	private String dataTableType;
	
	private String recordType;
	
	private String primaryId;
	private String userId;
	private String income_amt;
	private String debt_amt;
	private String loan_amt;
	private String expense_amt;
	private String bank_amt;
	private String shared_amt;
	private String balance_amt;
	private String statementName;
	private String startDate;
	private String endDate;
	
	public StatementTableData() {
		this.dataTableType = "statement_table";
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
	public String getIncome_amt() {
		return income_amt;
	}
	public void setIncome_amt(String income_amt) {
		this.income_amt = income_amt;
	}
	public String getDebt_amt() {
		return debt_amt;
	}
	public void setDebt_amt(String debt_amt) {
		this.debt_amt = debt_amt;
	}
	public String getLoan_amt() {
		return loan_amt;
	}
	public void setLoan_amt(String loan_amt) {
		this.loan_amt = loan_amt;
	}
	public String getExpense_amt() {
		return expense_amt;
	}
	public void setExpense_amt(String expense_amt) {
		this.expense_amt = expense_amt;
	}
	public String getBank_amt() {
		return bank_amt;
	}
	public void setBank_amt(String bank_amt) {
		this.bank_amt = bank_amt;
	}
	public String getBalance_amt() {
		return balance_amt;
	}
	public void setBalance_amt(String balance_amt) {
		this.balance_amt = balance_amt;
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
	public String getShared_amt() {
		return shared_amt;
	}
	public void setShared_amt(String shared_amt) {
		this.shared_amt = shared_amt;
	}
}
