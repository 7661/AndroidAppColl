package cost.tracker.ui.activity;

import java.util.List;

import tracker.ui.activity.R;
import cost.tracker.data.bean.EntryData;
import cost.tracker.data.bean.EntryDataBulk;
import cost.tracker.data.bean.StatementTableData;
import cost.tracker.data.bean.StatementTableDataArr;
import android.app.Activity;
import android.os.Bundle;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;

public class CoTrackerStatementActivity extends Activity {

	public void onCreate(Bundle savedInstanceState) {
	    super.onCreate(savedInstanceState);
	    setContentView(R.layout.activity_tracker_view_statement_ui);
	    //Retrieve data
	    //TableRow tabRowFirst = (TableRow)findViewById(R.id.tableRow1);
	    TableLayout ll = (TableLayout) findViewById(R.id.mainTable);
	    TableRow.LayoutParams llParams= new TableRow.LayoutParams(TableRow.LayoutParams.WRAP_CONTENT, TableRow.LayoutParams.WRAP_CONTENT);
	    TableRow tabRowFirst = new TableRow(this);
	    TextView tv1 = new TextView(this);
	    TextView tv2 = new TextView(this);
	    TextView tv3 = new TextView(this);
	    TextView tv4 = new TextView(this);
	    TextView tv5 = new TextView(this);
	    TextView tv6 = new TextView(this);
	    TextView tv7 = new TextView(this);
	    TextView tv8 = new TextView(this);
	    tv1.setText("Start Date");
	    tv1.setWidth(100);
	    tv2.setText("Total Income");
	    tv2.setWidth(100);
	    tv3.setText("Total Expense");
	    tv3.setWidth(100);
	    tv4.setText("Total Debt");
	    tv4.setWidth(100);
	    tv5.setText("Total Loan");
	    tv5.setWidth(100);
	    tv6.setText("Total Bank Amount");
	    tv6.setWidth(100);
	    tv7.setText("Balance");
	    tv7.setWidth(100);
	    tv8.setText("End Date");
	    tv8.setWidth(100);
	    tabRowFirst.addView(tv1, 0);
	    tabRowFirst.addView(tv2, 01);
	    tabRowFirst.addView(tv3, 02);
	    tabRowFirst.addView(tv4, 0);
	    tabRowFirst.addView(tv5, 0);
	    tabRowFirst.addView(tv6, 0);
	    tabRowFirst.setLayoutParams(llParams);
	    ll.addView(tabRowFirst, 00);
	    StatementTableDataArr viewData;
	    viewData = (StatementTableDataArr) getIntent().getSerializableExtra("statementData");
	    //StatementTableData[] statViewData = viewData.getStatementTableDataColl();
	    List<StatementTableData> dataString = viewData.getStatementTableDataColl();

	    if(null!=viewData){
	    	for(int i=0;i<dataString.size();i++){
	    		TableRow tabRow = new TableRow(this);
	    		TextView t1 = new TextView(this);
	    	    TextView t2 = new TextView(this);
	    	    TextView t3 = new TextView(this);
	    	    TextView t4 = new TextView(this);
	    	    TextView t5 = new TextView(this);
	    	    TextView t6 = new TextView(this);
	    	    TextView t7 = new TextView(this);
	    	    TextView t8 = new TextView(this);
	    	    t1.setText(dataString.get(i).getStartDate().toString());
	    	    t2.setText(dataString.get(i).getIncome_amt().toString());
	    	    t3.setText(dataString.get(i).getExpense_amt().toString());
	    	    t4.setText(dataString.get(i).getDebt_amt().toString());
	    	    t5.setText(dataString.get(i).getLoan_amt().toString());
	    	    t6.setText(dataString.get(i).getBank_amt().toString());
	    	    t7.setText(dataString.get(i).getBalance_amt().toString());
	    	    t8.setText(dataString.get(i).getEndDate().toString());
	    	    tabRow.addView(t1, 0);
	    	    tabRow.addView(t2, 01);
	    	    tabRow.addView(t3, 02);
	    	    tabRow.addView(t4, 03);
	    	    tabRow.addView(t5, 04);
	    	    tabRow.addView(t6, 05);
	    	    tabRow.addView(t7, 06);
	    	    tabRow.addView(t8, 07);
	    	    ll.addView(tabRow, i+1);
	    	}
	    }
	    //String[] viewDataStr = new String[] {viewData.getItem(),viewData.getAmount()};
/*	    ListView listView = (ListView) findViewById(R.id.listView1);
	    //gridview.setAdapter(new ViewCostAdapter(this,viewData));
	    //TableLayout tableLayout = new T
	    ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
				android.R.layout.simple_list_item_1, viewDataStr);
	    List<EntryData> putList = new ArrayList<EntryData>();
	    EntryData viewData2 = new EntryData();
	    viewData2.setItem("secodn");
	    viewData2.setAmount("17");
	    
	    putList.add(viewData);
	    putList.add(viewData2);
	    ArrayAdapter<EntryData>listAdapter = new ArrayAdapter<EntryData>(this, android.R.layout.simple_list_item_1, putList);
	    ListAdapter printList = new ArrayAdapter<EntryData>(this, android.R.layout.simple_list_item_1, putList);
	    listView.setAdapter(adapter);*/
	    //gridview.setAdapter(adapter);
	    
	    /*listView.setOnItemClickListener(new OnItemClickListener() {
	        public void onItemClick(AdapterView<?> parent, View v, int position, long id) {
	            Toast.makeText(CoTrackerTabViewExpnUIActivity.this, "" + position, Toast.LENGTH_SHORT).show();
	        }
	    });*/
	}
}
