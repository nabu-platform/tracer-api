package be.nabu.libs.tracer.api;

import java.net.URI;

public interface TracerProvider {
	/**
	 * @param databaseId The id of the database (e.g. jdbc connection id)
	 * @param vendor The vendor of the database (Oracle, MySQL, PostgreSQL,...)
	 * @param endpoint The endpoint of the database which can be used for grouping (this can be the jdbc connection string if relevant or the host, the file...)
	 * @return
	 */
	public DatabaseRequestTracer newDatabaseRequestTracer(String databaseId, String vendor, URI endpoint);
	
	/**
	 * This is to track low level web requests, before they are dispatched to preprocessors, rest services,...
	 * @param applicationId The application this is in
	 * @param uri The uri that was requested
	 */
	public IncomingWebRequestTracer newIncomingWebRequestTracer(String applicationId);
}
