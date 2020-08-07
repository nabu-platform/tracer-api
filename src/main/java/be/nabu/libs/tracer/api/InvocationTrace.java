package be.nabu.libs.tracer.api;

public interface InvocationTrace extends Trace {
	// whether or not we had a cache hit
	public void setCacheHit(boolean cached);
	// whether or not an auditer was active
	public void setAudit(boolean audit);
}
