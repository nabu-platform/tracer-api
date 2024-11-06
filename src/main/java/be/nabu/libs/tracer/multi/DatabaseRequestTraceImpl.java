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

import java.util.List;

import be.nabu.libs.tracer.api.DatabaseRequestTrace;

public class DatabaseRequestTraceImpl extends TraceImpl<DatabaseRequestTrace> implements DatabaseRequestTrace {

	public DatabaseRequestTraceImpl(List<DatabaseRequestTrace> traces) {
		super(traces);
	}

	@Override
	public void setBatchSize(int size) {
		for (DatabaseRequestTrace trace : getTraces()) {
			trace.setBatchSize(size);
		}		
	}

	@Override
	public void setRowCount(int count) {
		for (DatabaseRequestTrace trace : getTraces()) {
			trace.setRowCount(count);
		}	
	}

	@Override
	public void setLazy(boolean lazy) {
		for (DatabaseRequestTrace trace : getTraces()) {
			trace.setLazy(lazy);
		}	
	}

	@Override
	public void setLimit(int limit) {
		for (DatabaseRequestTrace trace : getTraces()) {
			trace.setLimit(limit);
		}	
	}

	@Override
	public void setOffset(long offset) {
		for (DatabaseRequestTrace trace : getTraces()) {
			trace.setOffset(offset);
		}	
	}

}
