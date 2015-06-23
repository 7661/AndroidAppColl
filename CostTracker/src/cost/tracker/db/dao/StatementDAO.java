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
import cost.tracker.data.bean.StatementData;
import cost.tracker.data.bean.StatementTableData;
import cost.tracker.data.bean.StatementTableDataArr;
import cost.tracker.db.helper.DBAdapter;

public class StatementDAO {
	
	private DBAdapter dba;
	private SQLiteDatabase db;
	
	public StatementDAO(Context ctx){
		this.dba = new DBAdapter(ctx);
		this.db = dba.open();
	}  

	public boolean insertStatementRec(StatementData statementData, String tableName)
	{
		boolean insertStatus = false;
		if(!checkStatTableExist(tableName)){
			createTotRecTable(tableName);
		}
		ContentValues insertValue = new ContentValues();
		insertValue.put("user_id", statementData.getUserId());
		insertValue.put("record_type", statementData.getRecordType());
		insertValue.put("amount", statementData.getAmount());
		insertValue.put("start_date", statementData.getStartDate());
		insertValue.put("end_date", statementData.getEndDate());
		try{
			db.insert(tableName, null, insertValue);
			insertStatus = true;
		}catch(Exception e){
			
		}
		return insertStatus;
	}
	public boolean insertStatementTableRec(StatementTableData statementTabData, String tableName)
	{
		boolean insertStatus = false;
		if(!checkStatTableExist(tableName)){
			createStatementTable(tableName);
		}
		ContentValues insertValue = new ContentValues();
		insertValue.put("user_id", statementTabData.getUserId());
		insertValue.put("start_date", statementTabData.getStartDate());
		insertValue.put("end_date", statementTabData.getEndDate());
		insertValue.put("tot_income", statementTabData.getIncome_amt());
		insertValue.put("tot_expense", statementTabData.getExpense_amt());
		insertValue.put("tot_debt", statementTabData.getDebt_amt());
		insertValue.put("tot_loan", statementTabData.getLoan_amt());
		insertValue.put("tot_bank_amt", statementTabData.getBank_amt());
		insertValue.put("tot_shared_amt", statementTabData.getBank_amt());
		insertValue.put("current_balance", statementTabData.getBank_amt());
		try {  
		       db.beginTransaction();
		       db.insert(tableName, null, insertValue);
		       db.setTransactionSuccessful();
		       insertStatus = true;
		       }
catch(Exception e){
			
		}
		   finally {
		       db.endTransaction();
		       }
		return insertStatus;
	}
	public boolean createStatment(String userName, String startDate, String endDate){
		boolean statementCreate = false;
		
		double incomeAmount = 0.0;
		double expenseAmount = 0.0;
		double balanceAmount = 0.0;
		StatementTableData statColData = new StatementTableData();
		
		statColData.setUserId(userName);
		statColData.setStartDate(startDate);
		statColData.setEndDate(endDate);
		
		incomeAmount = getSumOfRec(userName, startDate, endDate,"user_income_data");
		statColData.setIncome_amt(Double.toString(incomeAmount));
		expenseAmount = getSumOfRec(userName, startDate, endDate,"user_cost_data");
		statColData.setExpense_amt(Double.toString(expenseAmount));
		//balanceAmount = getSumOfRec(userName, startDate, endDate, "user_balance_data");
		balanceAmount = 20.0;
		statColData.setBalance_amt(Double.toString(balanceAmount));
		statColData.setBank_amt(Double.toString(12.0));
		statColData.setLoan_amt(Double.toString(0.0));
		statColData.setDebt_amt(Double.toString(0.0));
		statColData.setShared_amt(Double.toString(0.0));
		statColData.setStatementName("test");
		insertStatementTableRec(statColData,"user_table_em");
		//createStatementTable();
		//insertStatementRec(statData, "sum_income_stat_table");
		//insertStatementRec(statData, "sum_expense_stat_table");
		//insertStatementRec(statData, "sum_balance_stat_table");
		
		return statementCreate;
	}
	public StatementTableDataArr getStatementData(String userName, String startDate, String endDate){
		
		List<StatementTableData> statColl = new ArrayList<StatementTableData>();
		StatementTableDataArr statDataArr = null;new StatementTableDataArr(statColl);
		
		String DATABASE_TABLE = "user_table_em";
		String selectionArg1 = "'"+userName+"'";
		String selectionArg2 = "'"+startDate+"'";
		String selectionArg3 = "'"+endDate+"'";
		//Cursor costCursor = db.query(DATABASE_TABLE, null, "user_id=? AND password=?", selectionArgs, null,null,null);
		//Cursor costCursor = db.query(DATABASE_TABLE, null, "user_id = tapas", selectionArgs, null,null,null);
		String sql1 = "SELECT * FROM "+DATABASE_TABLE+" WHERE user_id ="+ selectionArg1
				+ " AND start_date ="+selectionArg2+" AND end_date="+selectionArg3; 
		Cursor dbCursor = db.rawQuery(sql1, null);
		if(dbCursor!=null){
			dbCursor.moveToFirst();
			for(int i=0; i<dbCursor.getCount();i++){
				StatementTableData statData = new StatementTableData();
				
				int userIdIdx = dbCursor.getColumnIndex("user_id");
				int startDateIdx = dbCursor.getColumnIndex("start_date");
				int endDateIdx = dbCursor.getColumnIndex("end_date");
				int incomeIdx = dbCursor.getColumnIndex("tot_income");
				int expenseIdx = dbCursor.getColumnIndex("tot_expense");
				int debtIdx = dbCursor.getColumnIndex("tot_debt");
				int loanIdx = dbCursor.getColumnIndex("tot_loan");
				int bankIdx = dbCursor.getColumnIndex("tot_bank_amt");
				int sharedIdx = dbCursor.getColumnIndex("tot_shared_amt");
				int statbalanceIdx = dbCursor.getColumnIndex("current_balance");
				
				statData.setUserId(dbCursor.getString(userIdIdx));
				statData.setStartDate(dbCursor.getString(startDateIdx));
				statData.setEndDate(dbCursor.getString(endDateIdx));
				statData.setIncome_amt(dbCursor.getString(incomeIdx));
				statData.setExpense_amt(dbCursor.getString(expenseIdx));
				statData.setDebt_amt(dbCursor.getString(debtIdx));
				statData.setLoan_amt(dbCursor.getString(loanIdx));
				statData.setShared_amt(dbCursor.getString(sharedIdx));
				statData.setStatementName("test");
				statData.setBank_amt(dbCursor.getString(bankIdx));
				statData.setBalance_amt(dbCursor.getString(statbalanceIdx));
				dbCursor.moveToNext();
				statColl.add(statData);
				statData = null;
			}
			statDataArr = new StatementTableDataArr(statColl);
		}
		return statDataArr;
	}
	public double getSumOfRec(String userName, String startDate, String endDate,String dataTableName){
		double totRec = 0.0;
		EntryData dataRead = new EntryData();
		dataRead.setUserId(userName);
		String DATABASE_TABLE = dataTableName;
		String selectionArg1 = "'"+userName+"'";
		String selectionArg2 = "'"+"startDate"+"'";
		String selectionArg3 = "'"+"endDate"+"'";
		String sql1 = "SELECT * FROM " +DATABASE_TABLE+ " WHERE user_id = "+ selectionArg1+" AND "
				+"date >= "+selectionArg2+" AND " +"date <= "+selectionArg3; 
		Cursor costCursor = db.rawQuery(sql1, null);
		if(costCursor!=null){
			costCursor.moveToFirst();
			for(int i=0; i<costCursor.getCount();i++){
				double amount = 0.0;
				amount = costCursor.getColumnIndex("amount");
				totRec = totRec+amount;
				costCursor.moveToNext();
			}
		}
		return totRec;
	}
	private boolean checkStatTableExist(String tableName){
		
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
	
	private void createTotRecTable(String tableName){
		
		String DATABASE_new_CREATE = "create table " +tableName+ "(id integer primary key autoincrement,"
				+"user_id text not null, record_type text not null, start_date text not null, end_date text not null, amount text not null);";
		try{
			db.execSQL(DATABASE_new_CREATE);
			db.setTransactionSuccessful();
		}catch(SQLException e){
			e.printStackTrace();
		}catch(Exception e){
			e.printStackTrace();
		}
		
	}
	
	private void createStatementTable(String tableName){
		
		String DATABASE_new_CREATE = "create table "+ tableName +" (id integer primary key autoincrement,"
				+"user_id text not null, start_date text not null, end_date text not null,"
				+" tot_income text not null, tot_expense text not null,"
				+" tot_debt text not null, tot_loan text not null," 
				+" tot_bank_amt text not null, tot_shared_amt text not null,"
				+" current_balance text not null);";
		try{
			db.execSQL(DATABASE_new_CREATE);
			//db.setTransactionSuccessful();
		}catch(SQLException e){
			e.printStackTrace();
		}catch(Exception e){
			e.printStackTrace();
		}
		
	}
	
}
