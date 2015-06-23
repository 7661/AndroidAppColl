package cost.tracker.data.bean;

import java.io.Serializable;
import java.util.Collections;

public class TableBulkData implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 8849753028932682079L;
	public TableData[] tableColl;
	
	public TableBulkData() { 
	}
	public TableBulkData(TableData[] tableDataColl) {
		this.tableColl = tableDataColl;
	}
	
}
