/*
* Copyright (C) 2020 Alexander Verbruggen
*
* This program is free software: you can redistribute it and/or modify
* it under the terms of the GNU Lesser General Public License as published by
* the Free Software Foundation, either version 3 of the License, or
* (at your option) any later version.
*
* This program is distributed in the hope that it will be useful,
* but WITHOUT ANY WARRANTY; without even the implied warranty of
* MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the
* GNU Lesser General Public License for more details.
*
* You should have received a copy of the GNU Lesser General Public License
* along with this program. If not, see <https://www.gnu.org/licenses/>.
*/

package be.nabu.libs.tracer.api;

import java.net.URI;

public interface TracerProvider {
	/**
	 * Correlate this tracer provider to another trace
	 * @param correlationId
	 */
	public void setCorrelationId(String correlationId);
	public String getCorrelationId();
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
