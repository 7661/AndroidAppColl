package cost.tracker.ui.activity;

import cost.tracker.data.bean.UserInfoData;
import cost.tracker.db.dao.UserInfoDAO;
import tracker.ui.activity.R;
import android.support.v7.app.ActionBarActivity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class CoTrackerLogInActivity extends ActionBarActivity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_tracker_log_in);
		Button createNewUser = (Button)findViewById(R.id.create_new_user_btn);
		createNewUser.setOnClickListener(createUsrActivity);
	}

	private OnClickListener createUsrActivity = new OnClickListener() {
		
		@Override
		public void onClick(View v) {
		  	String email = ((EditText)findViewById(R.id.bankdateData)).getText().toString();
	    	String pass = ((EditText)findViewById(R.id.bankBalanceAmt)).getText().toString();
	    	UserInfoData userInfo = new UserInfoData();
	    	userInfo.setUserEmail(email);
	    	userInfo.setUserPass(pass);
	    	Context ctx = getApplicationContext();
	    	UserInfoDAO usrDao = new UserInfoDAO(ctx);
	    	if(usrDao.insertUsrData(userInfo)){
	    		Toast.makeText(ctx, "User Data inserted", Toast.LENGTH_LONG).show();
	    	}
		}
	};
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.tracker_log_in, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();
		if (id == R.id.action_settings) {
			return true;
		}
		return super.onOptionsItemSelected(item);
	}
	
	public void onClick(View view){
    	Intent iSecond = new Intent("cost.tracker.ui.activity.CoTrackerUsrHomeUIActivity");
    	String email = ((EditText)findViewById(R.id.bankdateData)).getText().toString();
    	String pass = ((EditText)findViewById(R.id.bankBalanceAmt)).getText().toString();
    	UserInfoData userInfo = new UserInfoData();
    	userInfo.setUserEmail(email);
    	userInfo.setUserPass(pass);
    	UserInfoDAO userDao = new UserInfoDAO(this);
    	int userInfoCode = userDao.verifyUserInfo(userInfo);
    	if(1 == userInfoCode){
    		iSecond.putExtra("email",email);
        	iSecond.putExtra("pass", pass);
        	startActivity(iSecond);
    	}else if(-1 == userInfoCode){
    		Toast.makeText(this, "Incorrect Id/Password", Toast.LENGTH_LONG).show();    		
    	}
    	else {
    		Toast.makeText(this, "User Does not Exist. Please Create a New User", Toast.LENGTH_LONG).show();
    	}
    	
    }
	
}
