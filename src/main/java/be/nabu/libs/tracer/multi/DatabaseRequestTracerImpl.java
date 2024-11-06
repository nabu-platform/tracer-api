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
