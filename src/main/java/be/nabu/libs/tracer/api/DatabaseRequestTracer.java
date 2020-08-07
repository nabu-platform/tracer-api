package be.nabu.libs.tracer.api;

public interface DatabaseRequestTracer {
	/**
	 * @param artifactId The id of the jdbc service running (or nothing if dynamic)
	 * @param type The type (optional), for example a jdbc service instance might do multiple calls (for historization, total count selection,...), we want to differentiate
	 * @param sql
	 * @return
	 */
	public DatabaseRequestTrace start(String artifactId, String type, String sql);
}
