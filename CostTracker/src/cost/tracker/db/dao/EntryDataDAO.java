package cost.tracker.db.dao;

import java.util.ArrayList;
import java.util.List;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import cost.tracker.data.bean.EntryData;
import cost.tracker.data.bean.EntryDataBulk;
import cost.tracker.db.helper.DBAdapter;

public class EntryDataDAO {
	
	private DBAdapter dba;
	private SQLiteDatabase db;
	
	public EntryDataDAO(Context ctx){
		this.dba = new DBAdapter(ctx);
		this.db = dba.open();
	}  

	public boolean insertEntryData(EntryData data, String tableName){
		boolean insertSuccess = false;
		
		if(!checkTableExist(tableName)){
			createTable(tableName);
		}
		ContentValues insertValue = new ContentValues();
		insertValue.put("user_id", data.getUserId());
		insertValue.put("item", data.getItem());
		insertValue.put("amount", data.getAmount());
		insertValue.put("date", data.getDate());
		try{
			db.insert(tableName, null, insertValue);
			insertSuccess = true;
		}catch(Exception e){
			
		}
		return insertSuccess;
	}
	
	public EntryDataBulk readAllEntryData(String userName, String tableName){
		EntryData dataRead = new EntryData();
		dataRead.setUserId(userName);
		List<EntryData> entryDataColl=new ArrayList<EntryData>();
		EntryDataBulk readAllData = null;
		
		//if(!checkTableExist(tableName)){
			createTable(tableName);
		//}
		String DATABASE_TABLE = tableName;
		String selectionArg1 = "'"+userName+"'";
		String selectionArg2 = "'"+""+"'";
		String[] selectionArgs = {selectionArg1};
		//Cursor costCursor = db.query(DATABASE_TABLE, null, "user_id=? AND password=?", selectionArgs, null,null,null);
		//Cursor costCursor = db.query(DATABASE_TABLE, null, "user_id = tapas", selectionArgs, null,null,null);
		String sql1 = "SELECT * FROM " +tableName+ " WHERE user_id = "+ selectionArg1; 
		Cursor costCursor = db.rawQuery(sql1, null);
		if(costCursor!=null){
			costCursor.moveToFirst();
			for(int i=0; i<costCursor.getCount();i++){
				EntryData entryData = new EntryData();
				int userIdIdx = costCursor.getColumnIndex("user_id");
				int dateIdx = costCursor.getColumnIndex("date");
				int itemIdx = costCursor.getColumnIndex("item");
				int amountIdx = costCursor.getColumnIndex("amount");
				entryData.setUserId(costCursor.getString(userIdIdx));
				entryData.setDate(costCursor.getString(dateIdx));
				entryData.setItem(costCursor.getString(itemIdx));
				entryData.setAmount(costCursor.getString(amountIdx));
				costCursor.moveToNext();
				entryDataColl.add(entryData);
				entryData = null;
			}
			readAllData = new EntryDataBulk(entryDataColl);
		}
		
		return readAllData;
	}
	
	public EntryDataBulk pullStatment(String userName, String tableName, String dateRange){
		EntryData dataRead = new EntryData();
		dataRead.setUserId(userName);
		List<EntryData> entryDataColl=new ArrayList<EntryData>();
		EntryDataBulk readAllData = null;
		
		if(!checkTableExist(tableName)){
			createTable(tableName);
		}
		String DATABASE_TABLE = tableName;
		String selectionArg1 = "'"+userName+"'";
		String selectionArg2 = "'"+""+"'";
		String[] selectionArgs = {selectionArg1};
		double incomeData = 0.0;
		incomeData = getTotIncome(userName,dateRange);
		//Cursor costCursor = db.query(DATABASE_TABLE, null, "user_id=? AND password=?", selectionArgs, null,null,null);
		//Cursor costCursor = db.query(DATABASE_TABLE, null, "user_id = tapas", selectionArgs, null,null,null);
		String sql1 = "SELECT * FROM " +tableName+ " WHERE user_id = "+ selectionArg1; 
		Cursor costCursor = db.rawQuery(sql1, null);
		if(costCursor!=null){
			costCursor.moveToFirst();
			for(int i=0; i<costCursor.getCount();i++){
				EntryData entryData = new EntryData();
				int userIdIdx = costCursor.getColumnIndex("user_id");
				int dateIdx = costCursor.getColumnIndex("date");
				int itemIdx = costCursor.getColumnIndex("item");
				int amountIdx = costCursor.getColumnIndex("amount");
				entryData.setUserId(costCursor.getString(userIdIdx));
				entryData.setDate(costCursor.getString(dateIdx));
				entryData.setItem(costCursor.getString(itemIdx));
				entryData.setAmount(costCursor.getString(amountIdx));
				costCursor.moveToNext();
				entryDataColl.add(entryData);
				entryData = null;
			}
			readAllData = new EntryDataBulk(entryDataColl);
		}
		
		return readAllData;
	}
	
	public double getTotIncome(String userName, String dateRange){
		double totIncome = 0.0;
		EntryData dataRead = new EntryData();
		dataRead.setUserId(userName);
		
		if(!checkTableExist("user_income_data")){
			createTable("user_income_data");
		}
		
		String DATABASE_TABLE = "user_income_data";
		String selectionArg1 = "'"+userName+"'";
		String selectionArg2 = "'"+""+"'";
		String[] selectionArgs = {selectionArg1};
		//Cursor costCursor = db.query(DATABASE_TABLE, null, "user_id=? AND password=?", selectionArgs, null,null,null);
		//Cursor costCursor = db.query(DATABASE_TABLE, null, "user_id = tapas", selectionArgs, null,null,null);
		String sql1 = "SELECT * FROM " +"user_income_data"+ " WHERE user_id = "+ selectionArg1; 
		Cursor costCursor = db.rawQuery(sql1, null);
		if(costCursor!=null){
			costCursor.moveToFirst();
			for(int i=0; i<costCursor.getCount();i++){
				double amount = 0.0;
				amount = costCursor.getColumnIndex("amount");
				totIncome = totIncome+amount;
				costCursor.moveToNext();
			}
		}
		return totIncome;
	}
	public double getTotExpense(String userName, String dateRange){
		double totExpense = 0.0;
		EntryData dataRead = new EntryData();
		dataRead.setUserId(userName);
		
		if(!checkTableExist("user_income_data")){
			createTable("user_income_data");
		}
		
		String DATABASE_TABLE = "user_income_data";
		String selectionArg1 = "'"+userName+"'";
		String selectionArg2 = "'"+""+"'";
		String[] selectionArgs = {selectionArg1};
		//Cursor costCursor = db.query(DATABASE_TABLE, null, "user_id=? AND password=?", selectionArgs, null,null,null);
		//Cursor costCursor = db.query(DATABASE_TABLE, null, "user_id = tapas", selectionArgs, null,null,null);
		String sql1 = "SELECT * FROM " +"user_income_data"+ " WHERE user_id = "+ selectionArg1; 
		Cursor costCursor = db.rawQuery(sql1, null);
		if(costCursor!=null){
			costCursor.moveToFirst();
			for(int i=0; i<costCursor.getCount();i++){
				double amount = 0.0;
				amount = costCursor.getColumnIndex("amount");
				totExpense = totExpense+amount;
				costCursor.moveToNext();
			}
		}
		return totExpense;
	}
	public double getBankBalance(String userName){
		double totBalance=0.0;
		EntryData dataRead = new EntryData();
		dataRead.setUserId(userName);
		
		if(!checkTableExist("user_income_data")){
			createTable("user_income_data");
		}
		
		String DATABASE_TABLE = "user_income_data";
		String selectionArg1 = "'"+userName+"'";
		String selectionArg2 = "'"+""+"'";
		String[] selectionArgs = {selectionArg1};
		//Cursor costCursor = db.query(DATABASE_TABLE, null, "user_id=? AND password=?", selectionArgs, null,null,null);
		//Cursor costCursor = db.query(DATABASE_TABLE, null, "user_id = tapas", selectionArgs, null,null,null);
		String sql1 = "SELECT * FROM " +"user_income_data"+ " WHERE user_id = "+ selectionArg1; 
		Cursor costCursor = db.rawQuery(sql1, null);
		if(costCursor!=null){
			costCursor.moveToFirst();
			for(int i=0; i<costCursor.getCount();i++){
				double amount = 0.0;
				amount = costCursor.getColumnIndex("amount");
				totBalance = totBalance+amount;
				costCursor.moveToNext();
			}
		}
		return totBalance;
	}
 	public boolean updateEntryData(EntryData data, String tableName){
		boolean updateSuccess = false;
		int conflictAlgorithm = 0; 
		
		if(checkTableExist(tableName)){
			ContentValues updateValue = new ContentValues();
			updateValue.put("user_id", data.getUserId());
			updateValue.put("item", data.getItem());
			updateValue.put("amount", data.getAmount());
			updateValue.put("date", data.getDate());
			String whereClause = "user_id"+"="+"'"+ data.getUserId()+"'"+" AND "
					+"item"+"="+"'"+ data.getItem()+"'"+" AND "
					+"date"+"="+"'"+ data.getDate()+"'";
			
			try{
				db.updateWithOnConflict(tableName, updateValue, whereClause, null, conflictAlgorithm);
				updateSuccess = true;
			}catch (Exception e){
				
			}
		}
		return updateSuccess;
	}
	
	public boolean deleteEntryData(EntryData data, String tableName){
		boolean deleteSuccess = false;
		
		if(checkTableExist(tableName)){
			String whereClause = "user_id"+"="+"'"+ data.getUserId()+"'"+" AND "
					+"item"+"="+"'"+ data.getItem()+"'"+" AND "
					+"amount"+"="+"'"+ data.getAmount()+"'"+" AND "
					+"date"+"="+"'"+ data.getDate()+"'";
			try{
				db.delete(tableName, whereClause, null);
				deleteSuccess = true;
			}catch(Exception e){
				
			}	
		}
		
		return deleteSuccess;
	}
	
	private boolean checkTableExist(String tableName){
		
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
				+"user_id text not null, date text not null, item text not null, amount text not null);";
		try{
			db.execSQL(DATABASE_new_CREATE);
		}catch(SQLException e){
			e.printStackTrace();
		}catch(Exception e){
			e.printStackTrace();
		}
		
	}
	
}
