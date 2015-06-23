package cost.tracker.ui.activity;


import tracker.ui.activity.R;

import cost.tracker.data.bean.EntryData;
import cost.tracker.data.bean.EntryDataBulk;
import cost.tracker.data.bean.StatementTableDataArr;
import cost.tracker.db.dao.EntryDataDAO;
import cost.tracker.db.dao.StatementDAO;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;

public class CoTrackerStatmentRecActivity extends Activity {
	
	private static Context ctx;
	
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		ctx = this;
		setContentView(R.layout.activity_tracker_statement_ui);
		Button accOne = (Button) findViewById(R.id.stat_acc_one_bt);
		accOne.setOnClickListener(accInfoRecAct);
		Button accTwo = (Button) findViewById(R.id.stat_acc_two_bt);
		accTwo.setOnClickListener(accInfoRecAct);
		Button accThree = (Button) findViewById(R.id.stat_acc_three_bt);
		accThree.setOnClickListener(accInfoRecAct);
		Button statView = (Button) findViewById(R.id.stat_view_statement_bt);
		statView.setOnClickListener(viewStatAct);	
	}

	private OnClickListener accInfoRecAct= new OnClickListener() {
		
		@Override
		public void onClick(View v) {
			Intent insertBnakInfo = new Intent("cost.tracker.ui.activity.CoTrackerBankRecSaveUIActivity");
	    	EntryData userInfo = new EntryData();
	    	userInfo.setUserId(getIntent().getStringExtra("email"));
	    	userInfo.setDataTableName(getIntent().getStringExtra("user_bank_data"));
			userInfo.setDataModType("insert");
			insertBnakInfo.putExtra("recUserInfo", userInfo);
			startActivity(insertBnakInfo);
			
		}
	};
	
	
private OnClickListener viewStatAct= new OnClickListener() {
		
		@Override
		public void onClick(View v) {
			StatementDAO dbread = new StatementDAO(getApplicationContext());
			//user will input bank balance and dates
			//we will give the statement
			//for time being we are creating one statement
			EditText startDate = (EditText)findViewById(R.id.stat_start_date);
			EditText endDate = (EditText)findViewById(R.id.stat_end_date);
			dbread.createStatment(getIntent().getStringExtra("email"),startDate.getText().toString(),endDate.getText().toString());
			//statement has been created
			//now pull the data from statement table and display
			StatementTableDataArr statementRecDisp = dbread.getStatementData(getIntent().getStringExtra("email"),"01/20/2015","02/20/2015");
			Intent statementViewData = new Intent("cost.tracker.ui.activity.CoTrackerStatementActivity");
			statementViewData.putExtra("statementData", statementRecDisp);
			startActivity(statementViewData);
			
		}
	};
	
}
