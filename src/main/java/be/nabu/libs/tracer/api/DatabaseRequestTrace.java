package be.nabu.libs.tracer.api;

public interface DatabaseRequestTrace extends Trace {
	// if it's a batch request, how many
	public void setBatchSize(int size);
	// the resulting row count
	public void setRowCount(int count);
	public void setLazy(boolean lazy);
	public void setLimit(int limit);
	public void setOffset(long offset);
}
