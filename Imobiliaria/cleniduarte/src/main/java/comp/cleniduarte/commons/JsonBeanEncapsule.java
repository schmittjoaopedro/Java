package comp.cleniduarte.commons;

public class JsonBeanEncapsule {
	
	private Object records;
	private Integer count;
	private Boolean success;

	public JsonBeanEncapsule() {}

	public Object getRecords() {
		return records;
	}

	public void setRecords(Object records) {
		this.records = records;
	}

	public Integer getCount() {
		return count;
	}

	public void setCount(Integer count) {
		this.count = count;
	}

	public Boolean getSuccess() {
		return success;
	}

	public void setSuccess(Boolean success) {
		this.success = success;
	}
	
}
