package be.nabu.libs.tracer.multi;

import java.util.List;

import be.nabu.libs.tracer.api.Trace;

public class TraceImpl<T extends Trace> implements Trace {

	private List<T> traces;
	
	public TraceImpl(List<T> traces) {
		this.traces = traces;
	}
	
	@Override
	public void start() {
		for (Trace trace : traces) {
			trace.start();
		}
	}

	@Override
	public void addCustomAttribute(String key, Object value) {
		for (Trace trace : traces) {
			trace.addCustomAttribute(key, value);
		}
	}

	@Override
	public void stop() {
		for (Trace trace : traces) {
			trace.stop();
		}
	}

	@Override
	public void error(String code, Exception e) {
		for (Trace trace : traces) {
			trace.error(code, e);
		}
	}

	public List<T> getTraces() {
		return traces;
	}
}
