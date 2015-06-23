package cost.tracker.db.helper;


import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;


public class DBAdapter {
	
	static final String DATABASE_NAME = "CostTrackerNewDB";
	static String DATABASE_TABLE = "cost_tracker_clients";
	static final int DATABASE_VERSION = 1;
	static final String DATABASE_CREATE = "create table cost_tracker_clients (id integer primary key autoincrement,"
			+"user_id text not null, email text not null, password text not null);";
		
	final Context context;
	DatabaseHelper DBHelper;
	SQLiteDatabase db;
	
	public DBAdapter(Context ctx)
	{
		this.context = ctx;
		DBHelper = DatabaseHelper.getInstance(context);
	}
	
	private static class DatabaseHelper extends SQLiteOpenHelper
	{
		private static DatabaseHelper databaseInstance;
		public static DatabaseHelper getInstance(Context context) {
		    if (databaseInstance == null) {
		    	databaseInstance = new DatabaseHelper(context.getApplicationContext());
		    }
		    return databaseInstance;
		  }
		
		private DatabaseHelper(Context context)
		{
			super(context, DATABASE_NAME, null, DATABASE_VERSION);
		}

		@Override
		public void onCreate(SQLiteDatabase db) {
			try{
				db.execSQL(DATABASE_CREATE);
			}catch(SQLException e){
				e.printStackTrace();
			}
			
		}

		@Override
		public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
			
		}
	}
	
	public SQLiteDatabase open() throws SQLException
	{
		db = DBHelper.getWritableDatabase();
		return db;
	}
	
	public void close()
	{
		DBHelper.close();
	}
	
	public boolean verifyContact(String email, String password)
	{	boolean retCd = false;
		//String[] columns = new String[] {KEY_EMAIL, KEY_PASSWORD};
		String selectionArg1 = "'"+email+"'";
		String selectionArg2 = "'"+password+"'";
		//String[] selectionArgs = new String [] {KEY_EMAIL + "=" +"'"+email+"'", KEY_PASSWORD + "=" +"'"+ password+ "'"};
		String[] selectionArgs = {selectionArg1, selectionArg2};
		//Below is some tried out steps
		//String selectionArg = KEY_EMAIL +"="+"'"+email+"'";
		//Cursor mCursor = db.query(DATABASE_TABLE,columns, null,selectionArgs,null, null, null);
		Cursor mCursor = db.query(DATABASE_TABLE, null, "email=? AND password=?", selectionArgs, null,null,null);
		if(mCursor!= null){
			mCursor.moveToFirst();
			retCd = true;
		}
		return retCd; 
	}
	
	public long insertContact(String tableName, ContentValues initValue){
		DATABASE_TABLE = tableName;
		return db.insert(DATABASE_TABLE, null, initValue);
	}
	
/*	public boolean insertCostData(String str){
		
		boolean retCd =false;
		if(!checkTableExist()){
			createCostTable();
		}
		
		retCd = insertCostDataTable(str);
		
		return retCd;
	}

	private boolean checkTableExist(){
		
		boolean retCd = false;
		String DATABASE_TABLE = "clients_cost_details";
		String DATABASE_new_CREATE = "create table clients_cost_details (id integer primary key autoincrement,"
				+"cost text not null, date text not null);";
		
		String sql1 = "SELECT name FROM sqlite_master WHERE type='table' AND name='clients_cost_details'"; 
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
	private void createCostTable(){
		String DATABASE_new_CREATE = "create table clients_cost_details (id integer primary key autoincrement,"
				+"cost text not null, date text not null);";
		try{
			db.execSQL(DATABASE_new_CREATE);
		}catch(SQLException e){
			e.printStackTrace();
		}catch(Exception e){
			e.printStackTrace();
		}
		
	}
	
	private boolean insertCostDataTable(String str){
		long dataEntrySuccess = 0;
		boolean data = false;
		ContentValues initValue = new ContentValues();
		initValue.put(KEY_EMAIL, str);
		initValue.put(KEY_PASSWORD,str);
		dataEntrySuccess = db.insert(DATABASE_TABLE, null, initValue);
		
		return data;
	} 
	public void viewCostData(){*/
		
/*		String DATABASE_TABLE = "clients_cost_data";
		String selectionArg1 = "'"+""+"'";
		String selectionArg2 = "'"+""+"'";
		//String[] selectionArgs = new String [] {KEY_EMAIL + "=" +"'"+email+"'", KEY_PASSWORD + "=" +"'"+ password+ "'"};
		String[] selectionArgs = {selectionArg1, selectionArg2};
		Cursor costCursor = db.query(DATABASE_TABLE, null, "email=? AND password=?", selectionArgs, null,null,null);
		if(costCursor!=null){
			costCursor.moveToFirst();
		}
		
	}*/

}
