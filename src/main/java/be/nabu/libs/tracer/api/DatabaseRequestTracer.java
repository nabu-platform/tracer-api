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

public interface DatabaseRequestTracer extends AutoCloseable {
	/**
	 * @param artifactId The id of the jdbc service running (or nothing if dynamic)
	 * @param type The type (optional), for example a jdbc service instance might do multiple calls (for historization, total count selection,...), we want to differentiate
	 * @param sql
	 * @return
	 */
	public DatabaseRequestTrace newTrace(String artifactId, String type, String sql);
}
