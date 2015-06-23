package cost.tracker.data.bean;

import java.io.Serializable;

public class UserInfoData extends TableData implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -6819263709040747452L;

	private String dataTableName;
	private String dataTableType;
	
	private String primaryId;
	private String userEmail;
	private String userPass;
	private String firstName;
	private String lastName;
	
	public UserInfoData(){
		this.dataTableName = "user_info_data";
		this.dataTableType = "Not yet defined";
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

	public String getUserEmail() {
		return userEmail;
	}

	public void setUserEmail(String userEmail) {
		this.userEmail = userEmail;
	}

	public String getUserPass() {
		return userPass;
	}

	public void setUserPass(String userPass) {
		this.userPass = userPass;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	
}
