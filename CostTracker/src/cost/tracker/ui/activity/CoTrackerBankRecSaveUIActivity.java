package cost.tracker.ui.activity;

import tracker.ui.activity.R;
import cost.tracker.data.bean.EntryData;
import cost.tracker.db.dao.EntryDataDAO;
import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class CoTrackerBankRecSaveUIActivity extends Activity {

	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_tracker_bank_info_ui);
		Button saveRecord = (Button) findViewById(R.id.record_save_button);
		saveRecord.setOnClickListener(recordEntry);
		
	}

	private OnClickListener recordEntry = new OnClickListener() {
		
		@Override
		public void onClick(View v) {
			if(processRecord()){
				Toast.makeText(getApplicationContext(), "Record successfully inserted", Toast.LENGTH_LONG).show();
			}else{
				Toast.makeText(getApplicationContext(), "Record insertion failed", Toast.LENGTH_LONG).show();
			}
			
		}
	};
	
	private boolean processRecord(){
		boolean retCd = false;
					
		EditText dateData = (EditText)findViewById(R.id.bankdateData);
		EditText amountData = (EditText)findViewById(R.id.bankBalanceAmt);
		
		EntryDataDAO dbEntry = new EntryDataDAO(getApplicationContext());
		EntryData recordEntry = new EntryData();
		
		
		EntryData userSessionInfo = (EntryData) getIntent().getSerializableExtra("recUserInfo");
		recordEntry.setUserId(userSessionInfo.getUserId());
		recordEntry.setDataTableName("user_bank_data");
		recordEntry.setDate(dateData.getText().toString());
		recordEntry.setAmount(amountData.getText().toString());
		recordEntry.setItem("bank_info");
		
		if(dbEntry.insertEntryData(recordEntry,"user_bank_data")){			
			retCd = true;
		}
		
		/*switch (dbModType.toLowerCase()) {
		
		case "insert":
        	
        	if(dbEntry.insertEntryData(recordEntry,userSessionInfo.getDataTableName().toString())){			
    			retCd = true;
    			break;
    		}	
        	
		case "delete":
        	
        	if(dbEntry.deleteEntryData(recordEntry,userSessionInfo.getDataTableName().toString())){			
    			retCd = true;
    			break;
    		}	
		
		case "update":
        	
        	if(dbEntry.updateEntryData(recordEntry,userSessionInfo.getDataTableName().toString())){			
    			retCd = true;
    			break;
    		}
        	
		}		*/
		
		return retCd;
	}
	
}
