package be.nabu.libs.tracer.multi;

import java.util.List;

import be.nabu.libs.tracer.api.DatabaseRequestTrace;

public class DatabaseRequestTraceImpl extends TraceImpl<DatabaseRequestTrace> implements DatabaseRequestTrace {

	public DatabaseRequestTraceImpl(List<DatabaseRequestTrace> traces) {
		super(traces);
	}

	@Override
	public void setBatchSize(int size) {
		for (DatabaseRequestTrace trace : getTraces()) {
			trace.setBatchSize(size);
		}		
	}

	@Override
	public void setRowCount(int count) {
		for (DatabaseRequestTrace trace : getTraces()) {
			trace.setRowCount(count);
		}	
	}

	@Override
	public void setLazy(boolean lazy) {
		for (DatabaseRequestTrace trace : getTraces()) {
			trace.setLazy(lazy);
		}	
	}

	@Override
	public void setLimit(int limit) {
		for (DatabaseRequestTrace trace : getTraces()) {
			trace.setLimit(limit);
		}	
	}

	@Override
	public void setOffset(long offset) {
		for (DatabaseRequestTrace trace : getTraces()) {
			trace.setOffset(offset);
		}	
	}

}
