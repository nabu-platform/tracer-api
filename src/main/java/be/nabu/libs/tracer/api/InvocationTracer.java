package be.nabu.libs.tracer.api;

public interface InvocationTracer {
	/**
	 * @param artifactId The containing artifact (usually this _is_ the main service)
	 * @param type Some services have multiple subservices like security, caching,... (see REST)
	 * @return
	 */
	public InvocationTrace start(String artifactId, String type);
}
