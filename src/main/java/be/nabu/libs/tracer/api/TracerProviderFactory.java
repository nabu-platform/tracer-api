package be.nabu.libs.tracer.api;

public interface TracerProviderFactory {
	public TracerProvider newTracerProvider(String correlationId);
}
