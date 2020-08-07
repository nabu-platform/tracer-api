package be.nabu.libs.tracer.api;

public interface Trace {
	public void start();
	public void addCustomAttribute(String key, Object value);
	public void stop();
	public void error(String code, Exception e);
}
