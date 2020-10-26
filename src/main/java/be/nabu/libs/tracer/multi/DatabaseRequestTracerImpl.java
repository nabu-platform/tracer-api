package be.nabu.libs.tracer.multi;

import java.util.ArrayList;
import java.util.List;

import be.nabu.libs.tracer.api.DatabaseRequestTrace;
import be.nabu.libs.tracer.api.DatabaseRequestTracer;

public class DatabaseRequestTracerImpl implements DatabaseRequestTracer {

	private List<DatabaseRequestTracer> tracers;
	
	public DatabaseRequestTracerImpl(List<DatabaseRequestTracer> tracers) {
		this.tracers = tracers;
	}
	
	@Override
	public DatabaseRequestTrace newTrace(String artifactId, String type, String sql) {
		List<DatabaseRequestTrace> traces = new ArrayList<DatabaseRequestTrace>();
		for (DatabaseRequestTracer tracer : tracers) {
			traces.add(tracer.newTrace(artifactId, type, sql));
		}
		return new DatabaseRequestTraceImpl(traces);
	}

	@Override
	public void close() throws Exception {
		for (DatabaseRequestTracer tracer : tracers) {
			try {
				tracer.close();
			}
			catch (Exception e) {
				// ignore
			}
		}
	}

}
