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

import java.net.URI;
import java.util.ArrayList;
import java.util.List;

import be.nabu.libs.tracer.api.DatabaseRequestTracer;
import be.nabu.libs.tracer.api.IncomingWebRequestTracer;
import be.nabu.libs.tracer.api.TracerProvider;

public class TracerProviderImpl implements TracerProvider {

	private List<TracerProvider> tracerProviders;
	private String correlationId;
	
	public TracerProviderImpl(List<TracerProvider> tracerProviders) {
		this.tracerProviders = tracerProviders;
	}
	
	@Override
	public DatabaseRequestTracer newDatabaseRequestTracer(String databaseId, String vendor, URI endpoint) {
		List<DatabaseRequestTracer> tracers = new ArrayList<DatabaseRequestTracer>();
		for (TracerProvider tracerProvider : tracerProviders) {
			tracers.add(tracerProvider.newDatabaseRequestTracer(databaseId, vendor, endpoint));
		}
		return new DatabaseRequestTracerImpl(tracers);
	}

	@Override
	public IncomingWebRequestTracer newIncomingWebRequestTracer(String applicationId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void setCorrelationId(String correlationId) {
		this.correlationId = correlationId;
		for (TracerProvider provider : tracerProviders) {
			provider.setCorrelationId(correlationId);
		}
	}

	@Override
	public String getCorrelationId() {
		return correlationId;
	}

}
