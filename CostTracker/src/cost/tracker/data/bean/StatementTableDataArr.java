package cost.tracker.data.bean;

import java.io.Serializable;
import java.util.List;

public class StatementTableDataArr extends TableBulkData implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 7962813860022950552L;
	public List<StatementTableData> statementTableDataColl;
	
	

	public StatementTableDataArr(List<StatementTableData> statementTableDataColl) {
		this.statementTableDataColl = statementTableDataColl;
	}

	public List<StatementTableData> getStatementTableDataColl() {
		return statementTableDataColl;
	}

	public void setStatementTableDataColl(
			List<StatementTableData> statementTableDataColl) {
		this.statementTableDataColl = statementTableDataColl;
	}
}
