package cost.tracker.ui.activity;

import tracker.ui.activity.R;
import cost.tracker.data.bean.EntryDataBulk;
import cost.tracker.data.bean.StatementTableData;
import cost.tracker.data.bean.StatementTableDataArr;
import cost.tracker.db.dao.EntryDataDAO;
import cost.tracker.db.dao.StatementDAO;
import cost.tracker.db.dao.UserInfoDAO;
import cost.tracker.db.helper.DBAdapter;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.Toast;

public class CoTrackerUsrHomeUIActivity extends Activity {
	static String USER_SESSION_EMAIL;
	static String USER_SESSION_PASS;
	static String USER_SESSION_RUN;
	
	@Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_tracker_user_home_ui);
        USER_SESSION_EMAIL = getIntent().getStringExtra("email");
        USER_SESSION_PASS = getIntent().getStringExtra("pass");
        //Deligate different button click to different activity
        Button costBtn = (Button)findViewById(R.id.create_new_user_btn);
        costBtn.setOnClickListener(costActivity);
        Button incomeBtn = (Button)findViewById(R.id.button_income);
        incomeBtn.setOnClickListener(incomeActivity);
        Button debtBtn = (Button)findViewById(R.id.button_debt);
        debtBtn.setOnClickListener(debtActivity);
        Button loanBtn = (Button)findViewById(R.id.button_loan);
        loanBtn.setOnClickListener(loanActivity);
        Button sharedCostBtn = (Button)findViewById(R.id.shared_cost_btn);
        sharedCostBtn.setOnClickListener(sharedCostActivity);
        loanBtn.setOnClickListener(loanActivity);
        Button statementBtn = (Button)findViewById(R.id.statement);
        statementBtn.setOnClickListener(statementActivity);
    }
	
	private OnClickListener costActivity = new OnClickListener() {
		
		@Override
		public void onClick(View v) {
			Intent iCost = new Intent("cost.tracker.ui.activity.CoTrackerRecActivity");
			iCost.putExtra("email",USER_SESSION_EMAIL);
			iCost.putExtra("pass", USER_SESSION_PASS);
			iCost.putExtra("database_table_name", "user_cost_data");
	    	startActivity(iCost);
		}
	};
	
private OnClickListener incomeActivity = new OnClickListener() {
		
		@Override
		public void onClick(View v) {
			Intent iIncome = new Intent("cost.tracker.ui.activity.CoTrackerRecActivity");
			iIncome.putExtra("email",USER_SESSION_EMAIL);
			iIncome.putExtra("pass", USER_SESSION_PASS);
			iIncome.putExtra("database_table_name", "user_income_data");
	    	startActivity(iIncome);
			
		}
	};
	
private OnClickListener debtActivity = new OnClickListener() {
		
		@Override
		public void onClick(View v) {
			Intent iDebt = new Intent("cost.tracker.ui.activity.CoTrackerRecActivity");
			iDebt.putExtra("email",USER_SESSION_EMAIL);
			iDebt.putExtra("pass", USER_SESSION_PASS);
			iDebt.putExtra("database_table_name", "user_debt_data");
	    	startActivity(iDebt);
			
		}
	};
	
private OnClickListener loanActivity = new OnClickListener() {
		
		@Override
		public void onClick(View v) {
			Intent iLoan = new Intent("cost.tracker.ui.activity.CoTrackerRecActivity");
			iLoan.putExtra("email",USER_SESSION_EMAIL);
			iLoan.putExtra("pass", USER_SESSION_PASS);
			iLoan.putExtra("database_table_name", "user_loan_data");
	    	startActivity(iLoan);
			
		}
	};
	
private OnClickListener sharedCostActivity = new OnClickListener() {
		
		@Override
		public void onClick(View v) {
			Intent iCost = new Intent("cost.tracker.ui.activity.CoTrackerRecActivity");
			iCost.putExtra("email",USER_SESSION_EMAIL);
			iCost.putExtra("pass", USER_SESSION_PASS);
			iCost.putExtra("database_table_name", "user_shared_cost_data");
	    	startActivity(iCost);
		}
	};
	
private OnClickListener statementActivity = new OnClickListener() {
		
		@Override
		public void onClick(View v) {
			Intent iStat = new Intent("cost.tracker.ui.activity.CoTrackerStatmentRecActivity");
			iStat.putExtra("email",USER_SESSION_EMAIL);
			iStat.putExtra("pass", USER_SESSION_PASS);
			iStat.putExtra("database_table_name", "user_statement_rec_data");
			startActivity(iStat);
		}
	};
	
}
