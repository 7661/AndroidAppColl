package cost.tracker.ui.activity;


import tracker.ui.activity.R;

import cost.tracker.data.bean.EntryData;
import cost.tracker.data.bean.EntryDataBulk;
import cost.tracker.db.dao.EntryDataDAO;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class CoTrackerRecActivity extends Activity {
	
	private static Context ctx;
	
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		ctx = this;
		setContentView(R.layout.activity_tracker_record_ui);
		Button insertButton = (Button) findViewById(R.id.stat_acc_one_bt);
		insertButton.setOnClickListener(insertRecAct);
		Button deleteButton = (Button) findViewById(R.id.stat_acc_two_bt);
		deleteButton.setOnClickListener(deleteRecAct);
		Button viewButton = (Button) findViewById(R.id.stat_acc_three_bt);
		viewButton.setOnClickListener(viewRecAct);
		Button updateButton = (Button) findViewById(R.id.stat_view_statement_bt);
		updateButton.setOnClickListener(updateRecAct);	
	}

	private OnClickListener insertRecAct= new OnClickListener() {
		
		@Override
		public void onClick(View v) {
			Intent insertCost = new Intent("cost.tracker.ui.activity.CoTrackerDataModUIActivity");
	    	EntryData userInfo = new EntryData();
	    	userInfo.setUserId(getIntent().getStringExtra("email"));
	    	userInfo.setDataTableName(getIntent().getStringExtra("database_table_name"));
			userInfo.setDataModType("insert");
	    	insertCost.putExtra("recUserInfo", userInfo);
			startActivity(insertCost);
			
		}
	};
	
	private OnClickListener deleteRecAct= new OnClickListener() {
		
		@Override
		public void onClick(View v) {
			Intent deleteCost = new Intent("cost.tracker.ui.activity.CoTrackerDataModUIActivity");
	    	EntryData userInfo = new EntryData();
	    	userInfo.setUserId(getIntent().getStringExtra("email"));
	    	userInfo.setUserId(getIntent().getStringExtra("pass"));
	    	userInfo.setDataTableName(getIntent().getStringExtra("database_table_name"));
	    	userInfo.setDataModType("delete");
	    	deleteCost.putExtra("recUserInfo", userInfo);
			startActivity(deleteCost);
			
		}
	};
		
	private OnClickListener viewRecAct = new OnClickListener() {
		
		@Override
		public void onClick(View v) {
			EntryDataDAO dbread = new EntryDataDAO(getApplicationContext());
			String test = getIntent().getStringExtra("database_table_name");
			EntryDataBulk costEntryBulkRec = dbread.readAllEntryData("tapas", getIntent().getStringExtra("database_table_name").toString());
			//List<EntryData> dataString = new ArrayList<EntryData>();
			//costEntryRec.setItem("Shirt");
			//costEntryRec.setAmount("15");
			//dataString.add(costEntryRec);
			//Intent viewCost = new Intent("com.example.costtracker_version_02.UserViewCostActivity");
			//Intent viewCost = new Intent("com.example.costtracker_version_02.UserListViewCostActivity");
			Intent tableViewData = new Intent("cost.tracker.ui.activity.CoTrackerTabViewDataUIActivity");
			tableViewData.putExtra("viewData", costEntryBulkRec);
			startActivity(tableViewData);
		}
	};
	
private OnClickListener updateRecAct= new OnClickListener() {
		
		@Override
		public void onClick(View v) {
			Intent updateCost = new Intent("cost.tracker.ui.activity.CoTrackerDataModUIActivity");
	    	EntryData userInfo = new EntryData();
	    	userInfo.setUserId(getIntent().getStringExtra("email"));
	    	userInfo.setUserId(getIntent().getStringExtra("pass"));
	    	userInfo.setDataTableName(getIntent().getStringExtra("database_table_name"));
	    	userInfo.setDataModType("update");
	    	updateCost.putExtra("recUserInfo", userInfo);
			startActivity(updateCost);
			
		}
	};
	
}
