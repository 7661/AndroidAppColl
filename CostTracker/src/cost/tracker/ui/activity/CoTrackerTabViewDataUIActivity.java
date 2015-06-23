package cost.tracker.ui.activity;

import java.util.List;

import tracker.ui.activity.R;

import cost.tracker.data.bean.EntryData;
import cost.tracker.data.bean.EntryDataBulk;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.AdapterView.OnItemClickListener;

public class CoTrackerTabViewDataUIActivity extends Activity {
	public void onCreate(Bundle savedInstanceState) {
	    super.onCreate(savedInstanceState);
	    setContentView(R.layout.activity_tracker_view_data_tableformat_screen);
	    //Retrieve data
	    //TableRow tabRowFirst = (TableRow)findViewById(R.id.tableRow1);
	    TableLayout ll = (TableLayout) findViewById(R.id.mainTable);
	    TableRow.LayoutParams llParams= new TableRow.LayoutParams(TableRow.LayoutParams.WRAP_CONTENT, TableRow.LayoutParams.WRAP_CONTENT);
	    TableRow tabRowFirst = new TableRow(this);
	    TextView tv1 = new TextView(this);
	    TextView tv2 = new TextView(this);
	    TextView tv3 = new TextView(this);
	    tv1.setText("Date");
	    tv1.setWidth(100);
	    tv2.setText("Item");
	    tv2.setWidth(100);
	    tv3.setText("Amount");
	    tv3.setWidth(100);
	    tabRowFirst.addView(tv1, 0);
	    tabRowFirst.addView(tv2, 01);
	    tabRowFirst.addView(tv3, 02);
	    tabRowFirst.setLayoutParams(llParams);
	    ll.addView(tabRowFirst, 00);
	    EntryDataBulk viewData;
	    viewData = (EntryDataBulk) getIntent().getSerializableExtra("viewData");
	    //EntryData[] entryData = viewData.getEntryDataColl();
	    List<EntryData> dataString = viewData.getEntryDataColl();

	    
	    //EntryData viewData2 = new EntryData();
	    //viewData2.setItem("Pant");
	    //viewData2.setAmount("100");
	    //dataString.add(viewData2);
	    if(null!=dataString){
	    	for(int i=0;i<dataString.size();i++){
	    		TableRow tabRow = new TableRow(this);
	    		TextView t1 = new TextView(this);
	    	    TextView t2 = new TextView(this);
	    	    TextView t3 = new TextView(this);
	    	    t1.setText(dataString.get(i).getDate().toString());
	    	    t2.setText(dataString.get(i).getItem().toString());
	    	    t3.setText(dataString.get(i).getAmount().toString());
	    	    tabRow.addView(t1, 0);
	    	    tabRow.addView(t2, 01);
	    	    tabRow.addView(t3, 02);
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
