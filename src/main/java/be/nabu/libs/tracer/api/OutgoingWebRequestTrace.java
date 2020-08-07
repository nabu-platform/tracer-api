package be.nabu.libs.tracer.api;

public interface OutgoingWebRequestTrace extends Trace {
	public void setResponseCode(int code);
}
