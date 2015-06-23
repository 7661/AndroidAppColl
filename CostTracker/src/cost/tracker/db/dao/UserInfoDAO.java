package cost.tracker.db.dao;

import cost.tracker.data.bean.EntryData;
import cost.tracker.data.bean.UserInfoData;
import cost.tracker.db.helper.DBAdapter;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.widget.Toast;

public class UserInfoDAO {
	
	private DBAdapter dba;
	private SQLiteDatabase db;
	
	public UserInfoDAO(Context ctx){
		this.dba = new DBAdapter(ctx);
		this.db = dba.open();
	}
	
	//	return Code :  0 	- user info does not exist, new user
	// 	return Code :  1 	- user info exist and correct
	//  return Code	: -1	- user info incorrectly provided
	public int verifyUserInfo(UserInfoData userInfo)
	{	
		int retCd = 0;
		String email = userInfo.getUserEmail();
		String password = userInfo.getUserPass();
		
		String table_name = "user_info_data";
		String selectionArg1 = "'"+email+"'";
		String selectionArg2 = "'"+password+"'";
		String[] selectionArgs = {selectionArg1, selectionArg2};
		if(!checkUserInfoTableExist(table_name)){
			createTable(table_name);
		}
		//Cursor usrCursor = db.query(table_name, null, "email=? AND password=?", selectionArgs, null,null,null);
		String sql1 = "SELECT * FROM " +table_name+ " WHERE user_id = "+ selectionArg1+ " and password= "+ selectionArg2;
		//String sql1 = "SELECT user_id FROM " +table_name;
		Cursor usrCursor = db.rawQuery(sql1, null);
		
		if(usrCursor!= null){
			usrCursor.moveToFirst();
			for(int i=0; i< usrCursor.getCount();i++){
				retCd = 1;
			}
		}else{
			if(verifyUserId(email)){
				retCd = -1; 
			}
		}
		
		return retCd; 
	}
	
	public boolean verifyUserId(String userId)
	{	boolean retCd = false;
		String table_name = "user_info_data";
		String selectionArg1 = "'"+userId+"'";
		if(!checkUserInfoTableExist(table_name)){
			createTable(table_name);
		}
		String sql1 = "SELECT * FROM " +table_name+ " WHERE user_id = "+ selectionArg1; 
		Cursor userInfoCursor = db.rawQuery(sql1, null);
		if(userInfoCursor!=null){
			userInfoCursor.moveToFirst();
			for(int i=0; i<userInfoCursor.getCount();i++){
				retCd = true;
				break;
			}
		}
		return retCd; 
	}
	
	private boolean checkUserInfoTableExist(String tableName){
		
		boolean retCd = false;
		
		String sql1 = "SELECT name FROM sqlite_master WHERE type='table' AND name='"+tableName+"'"; 
		Cursor checkTable = db.rawQuery(sql1, null);
		int rowCount = 0;
		if(checkTable!= null){
			checkTable.moveToFirst();
			rowCount = checkTable.getCount();
			if(rowCount>0){
				retCd = true;
			}
		}
		return retCd;
	}

	private void createTable(String tableName){
	
		String DATABASE_new_CREATE = "create table " + tableName + "(id integer primary key autoincrement,"
			+"user_id text not null, email text not null, password text not null);";
		try{
			db.execSQL(DATABASE_new_CREATE);
		}catch(SQLException e){
			e.printStackTrace();
		}catch(Exception e){
			e.printStackTrace();
		}
	
}

	public boolean insertUsrData(UserInfoData usrData){
		
		boolean insertSuccess = true;
		
		String table_name = "user_info_data";
		if(!checkUserInfoTableExist(table_name)){
			createTable(table_name);
		}
		
		if(0== verifyUserInfo(usrData)){
			ContentValues insertValue = new ContentValues();
			insertValue.put("user_id", usrData.getUserEmail());
			insertValue.put("email", usrData.getUserEmail());
			insertValue.put("password", usrData.getUserPass());
			try{
				db.insert(table_name, null, insertValue);
			}catch(SQLException sqe){
				
			}
			
		}

		
		return insertSuccess;
	}
}
