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

import be.nabu.libs.tracer.api.Trace;

public class TraceImpl<T extends Trace> implements Trace {

	private List<T> traces;
	
	public TraceImpl(List<T> traces) {
		this.traces = traces;
	}
	
	@Override
	public void start() {
		for (Trace trace : traces) {
			trace.start();
		}
	}

	@Override
	public void addCustomAttribute(String key, Object value) {
		for (Trace trace : traces) {
			trace.addCustomAttribute(key, value);
		}
	}

	@Override
	public void stop() {
		for (Trace trace : traces) {
			trace.stop();
		}
	}

	@Override
	public void error(String code, Exception e) {
		for (Trace trace : traces) {
			trace.error(code, e);
		}
	}

	public List<T> getTraces() {
		return traces;
	}
}
