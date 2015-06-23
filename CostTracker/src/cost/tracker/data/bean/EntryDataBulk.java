package cost.tracker.data.bean;

import java.io.Serializable;
import java.util.List;

public class EntryDataBulk extends TableBulkData implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -5307050727800714326L;
	
	public List<EntryData> entryDataColl;
	
	public EntryDataBulk(List<EntryData> entryDataColl) {
		this.entryDataColl = entryDataColl;
	}

	public List<EntryData> getEntryDataColl() {
		return entryDataColl;
	}

	public void setEntryDataColl(List<EntryData> entryDataColl) {
		this.entryDataColl = entryDataColl;
	}

	
}
