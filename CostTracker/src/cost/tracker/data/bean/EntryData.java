package cost.tracker.data.bean;

import java.io.Serializable;

public class EntryData extends TableData implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -8096098599061551033L;
	
	private String dataTableName;
	private String dataTableType;
	
	private String dataModType;
	
	private String primaryId;
	private String userId;
	private String item;
	private String amount;
	private String date;
	
	public EntryData(){
		this.dataTableType = "entry_table"; 
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

	public String getItem() {
		return item;
	}

	public void setItem(String item) {
		this.item = item;
	}

	public String getAmount() {
		return amount;
	}

	public void setAmount(String amount) {
		this.amount = amount;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public String getDataModType() {
		return dataModType;
	}

	public void setDataModType(String dataModType) {
		this.dataModType = dataModType;
	}

	@Override
	public String toString() {
		return "[item=" + item +"\t"+ ", amount=" + amount +"\t"+ ", date="
				+ date + "]";
	}
	
}
