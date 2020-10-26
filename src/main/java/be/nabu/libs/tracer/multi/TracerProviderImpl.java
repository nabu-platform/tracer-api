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
